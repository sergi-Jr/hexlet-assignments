@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(!page.getPosts().isEmpty())
        @for(var post : page.getPosts())
            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
        @endfor
    @endif
`
)