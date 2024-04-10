@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<html>
<head>
    <title>Users list</title>
</head>
<body>
<h1>USERS</h1>
@if(usersPage.getUsers().isEmpty())
    <p>No users added yet</p>
@else
    @for(var user : usersPage.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.getLastName()}</p>
        </div>
    @endfor
@endif
</body>
</html>