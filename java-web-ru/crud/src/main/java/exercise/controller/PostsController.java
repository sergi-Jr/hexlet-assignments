package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {
    private static List<Post> allPosts = PostRepository.getEntities();

    // BEGIN
    public static void index(Context ctx) {
        var pageNumber = 1;
        if (ctx.queryString() != null) {
            pageNumber = ctx.queryParamAsClass("page", Integer.class).get();
        }
        int fromIndex = allPosts.size() - pageNumber * PostsPage.PER < 0 ? 0 : PostsPage.PER * (pageNumber - 1);
        int toIndex = fromIndex + PostsPage.PER;
        var posts = allPosts.subList(fromIndex, toIndex);
        PostsPage page = new PostsPage(posts, pageNumber);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
