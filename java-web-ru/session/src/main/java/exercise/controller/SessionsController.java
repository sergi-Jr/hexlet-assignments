package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void login(Context ctx) {
        String errStr = "Wrong username or password";
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> UsersRepository.findByName(value) != null, errStr)
                    .get();
            ctx.formParamAsClass("password", String.class)
                    .check(value -> UsersRepository.findByName(name).getPassword().equals(encrypt(value)), errStr)
                    .get();

            ctx.sessionAttribute("name", name);
            var page = new MainPage(name);
            ctx.render(NamedRoutes.rootPath(), model("page", page)).status(302);
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, errStr);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
