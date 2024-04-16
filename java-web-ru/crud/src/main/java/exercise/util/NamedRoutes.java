package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(int pageNum) {
        return postsPath(String.valueOf(pageNum));
    }

    public static String postsPath(String pageNum) {
        return "/posts?page=" + pageNum;
    }

    public static String showPostPath(String id) {
        return "/posts/" + id;
    }

    public static String showPostPath(Long id) {
        return showPostPath(String.valueOf(id));
    }
    // END
}
