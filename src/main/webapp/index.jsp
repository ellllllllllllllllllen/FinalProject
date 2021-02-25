<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <style>
        <%@ include file="/css/main.css" %>
    </style>
    <script>
        <%@ include file="/js/main.js" %>
        var d = new Date();

        var day=new Array("Воскресенье","Понедельник","Вторник", "Среда","Четверг","Пятница","Суббота");

        var time = null;
        if(day[d.getDay()] == "Пятница" || day[d.getDay()] == "Суббота" || day[d.getDay()] == "Воскресенье"){
            time = "с 10:00 до 23:00";
        } else{
            time = "с 10:00 до 22:00";
        }
    </script>
</head>
<body>
<section class="header">
    <div class="logo">
        <img src="img/logo.png" height="100" width="200">
    </div>
    <div class="time">
        <h2>Сегодня работаем</h2>
        <h2><script>document.write(time);</script></h2>
        <div class="time-child">
            <h3>Понедельник		с 10:00 до 22:00</h3>
            <h3>Вторник			с 10:00 до 22:00</h3>
            <h3>Среда			с 10:00 до 22:00</h3>
            <h3>Четверг			с 10:00 до 22:00</h3>
            <h3>Пятница			с 10:00 до 23:00</h3>
            <h3>Суббота			с 10:00 до 23:00</h3>
            <h3>Воскресенье		с 10:00 до 23:00</h3>
        </div>

    </div>
    <div class="phone">
        <h2>Контактный телефон</h2>
        <h2>+375-44-721-33-59</h2>
    </div>
    <div class="user">

        <input type="button" id="authorize" value="Вход/Регистрация" onclick="display(document.getElementById('sign_form'))" />
        <div class="form" id="sign_form" style="display: none;">
            <form class="login-form" action="/controller" method="post">
                <input type="hidden" name="command" value="sign_in">
                <input type="text" name="username" placeholder="username">
                <input type="password" name="password" placeholder="password">
                <button>Войти</button>
                <h4>${errorUserMessage}</h4>
                <p class="message">Not registered? <a href="pages/sign_up.jsp">Create an account</a></p>
            </form>
        </div>


<%--        <input type="button" id="authorize" value="Вход/Регистрация" onclick="display(document.getElementById('sign_form'))" />--%>
<%--        <div id="sign_form" style="display: none;">--%>
<%--            <form id="sign_in"  action="/controller" method="post">--%>
<%--                <input type="hidden" name="command" value="sign_in">--%>
<%--                <input type="text" id="username" name="username" placeholder="username">--%>
<%--                <input type="password" id="password" name="password" placeholder="password">--%>
<%--                <p><input type="submit" value="Войти"></p>--%>
<%--            </form>--%>
<%--            ${errorUserMessage}--%>
<%--            <p>Нет аккаунта? <a href="pages/sign_up.jsp">Зарегистрироваться</a></p>--%>
<%--        </div>--%>

    </div>
    <div class="basket">

    </div>
    <div class="internationalization">

    </div>
</section>
<section class="menu">
    <div class="buttons">
        <button>Лапша</button>
        <button>Роллы</button>
        <button>Супы</button>
        <button>Обед</button>
        <button>Десерты</button>
        <button>Напитки</button>
        <button>Закуски</button>
    </div>

</section>
<section class="slide">
    <button>previous</button>
    <button>next</button>
</section>

<%--<script src="/js/main.js"></script>--%>
</body>
</html>
