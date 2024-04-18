@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page = null

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <p>${page.getError()}</p>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <div>
            <label>
                Name
                <input type="text" name="name" value="${page.getName()}"/>
            </label>
        </div>
        <div>
            <label>
                Password
                <input type="password" name="password"/>
            </label>
        </div>
        <input type="submit" name="login-button" value="Войти">
    </form>
`
)
