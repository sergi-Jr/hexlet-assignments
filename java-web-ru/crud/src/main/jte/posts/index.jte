@import exercise.dto.posts.PostsPage
@param PostsPage page


@if(!page.getPosts().isEmpty())
    <ul>
        @for(var post : page.getPosts())
            <li>
                <a href="/posts/${post.getId()}">${post.getName()}</a>
            </li>
        @endfor
    </ul>
@endif

<footer>
    @if(page.getPageNumber() > 1)
        <a href="/posts?page=${page.getPageNumber() - 1}">Назад</a>
    @endif
    <a href="/posts?page=${page.getPageNumber() + 1}">Вперед</a>
</footer>