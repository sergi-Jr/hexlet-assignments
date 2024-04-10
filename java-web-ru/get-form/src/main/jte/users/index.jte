@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<html>
<body>
<form action="/users" method="get">
    <input type="search" required name="term" value="${usersPage.getTerm()}">
    <input type="submit" value="Search">
</form>
@if(!usersPage.getUsers().isEmpty())
    <table>
        @for(var user : usersPage.getUsers())
            <tr>${user.getFirstName()} ${user.getLastName()}</tr>
        @endfor
    </table>
@endif
</body>
</html>
