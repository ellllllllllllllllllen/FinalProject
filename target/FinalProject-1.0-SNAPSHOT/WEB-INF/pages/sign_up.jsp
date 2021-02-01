<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<div class="sign_up">
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="sign_up">
        <input type="text" id="email" name="email" placeholder="email">
        ${errorEmailMessage}
        <input type="text" id="username" name="username" placeholder="username">
        ${errorUsernameMessage}
        <input type="text" id="firstname" name="firstname" placeholder="firstname">
        <input type="text" id="lastname" name="lastname" placeholder="lastname">
        ${errorFirstnameAndLastnameMessage}
        <input type="password" id="password" name="password" placeholder="password">
        <input type="password" id="repeat_password" name="repeat_password" placeholder="repeat password">
        ${errorPasswordMessage}
        <input type="submit" value="sign up">
    </form>

    <div>
        <form action="/controller" method="get">
            <input type="hidden" name="command" value="sign_in_page">
            <input type="submit" value="sign in">
        </form>
    </div>
</div>
</body>
</html>
