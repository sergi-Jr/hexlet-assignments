package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Optional;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var usersPage = new UsersPage(USERS);
            ctx.render("users/index.jte", model("usersPage", usersPage));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            Optional<User> concreteUser = USERS.stream()
                    .filter(u -> u.getId() == id)
                    .findFirst();
            concreteUser.ifPresentOrElse(c -> {
                        var userPage = new UserPage(c);
                        ctx.render("users/show.jte", model("userPage", userPage));
                    },
                    () -> {throw new NotFoundResponse("User not found");});
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
