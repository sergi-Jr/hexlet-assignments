@import exercise.dto.users.UserPage
@param UserPage userPage

<html>
<head>
    <title>User</title>
</head>
<body>
<h1>USER</h1>
    <div>
        <p>${userPage.getUser().getEmail()}</p>
    </div>
</body>
</html>