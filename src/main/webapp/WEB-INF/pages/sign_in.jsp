<html>
<head>
    <title>Sign In</title>
</head>
<body>
<div class="sign_in">

    <form action="/controller" method="post">
        <input type="hidden" name="command" value="sign_in">
        <input type="text" id="login" name="login" placeholder="login">
        <input type="password" id="password" name="password" placeholder="password">
        <input type="submit" value="sign in">
    </form>
    ${errorUserMessage}

    <div id="formFooter">
        <form action="/controller" method="get">
            <input type="hidden" name="command" value="sign_up_page">
            <input type="submit" value="sign up">
        </form>
    </div>
</div>
</body>
</html>
