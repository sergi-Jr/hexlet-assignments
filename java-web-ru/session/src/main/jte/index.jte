@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(
content = @`
    @if(page != null)
        <div>
            <h1>Hello, ${page.getName().toString()}</h1>
        </div>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" name="logout-button" value="Выйти">
        </form>
    @else
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
`)
