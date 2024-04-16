@import exercise.dto.posts.PostPage
@param PostPage page

    <article>
        <section>
            <label>Title "${page.getPost().getName()}"</label>
        </section>
        <section>
            ${page.getPost().getBody()}
        </section>
    </article>
    <a href="/posts">Все посты</a>

