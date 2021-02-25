
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        <%@ include file="/css/sign_up.css" %>
    </style>
</head>
<body>
<div class="user">
    <div class="form">
        <form class="signup-form" action="/controller" method="post">
            <input type="hidden" name="command" value="sign_up">
            <input type="text" id="email" name="email" placeholder="Email">
                <h4>${errorEmailMessage}</h4>
            <input type="text" id="username" name="username" placeholder="Username">
                <h4>${errorUsernameMessage}</h4>
            <input type="text" id="firstname" name="firstname" placeholder="Имя">
                <h4> ${errorFirstnameMessage}</h4>
            <input type="text" id="lastname" name="lastname" placeholder="Фамилия">
                <h4>${errorLastnameMessage}</h4>
            <input type="password" id="password" name="password" placeholder="password">
            <input type="password" id="repeat_password" name="repeat_password" placeholder="Повтор пароля">
                <h4>${errorPasswordMessage}</h4>
            <button type="submit">Зарегистрироваться</button>
<%--            <input type="submit" value="sign up">--%>
            <p class="message"><a href="pages/index.jsp">Назад</a></p>
        </form>
    </div>


<%--    <div class="sign_in">--%>
<%--        <form action="/controller" method="get">--%>
<%--            <input type="hidden" name="command" value="sign_in">--%>
<%--            <input type="submit" value="sign in">--%>
<%--        </form>--%>
<%--    </div>--%>
</div>
</body>
</html>
