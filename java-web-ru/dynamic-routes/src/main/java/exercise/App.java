package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// BEGIN
import io.javalin.http.NotFoundResponse;
import org.eclipse.jetty.http.HttpStatus;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");
            Optional<Map<String, String>> first = COMPANIES.stream()
                    .filter(e -> e.get("id").equals(id))
                    .findFirst();
            if (first.isPresent()) {
                ctx.json(first.get());
            } else {
                ctx.status(HttpStatus.NOT_FOUND_404);
                throw new NotFoundResponse("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
