<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <style>
        <%@ include file="/css/main.css" %>
    </style>
    <script>
        function display(form) {
            if (form.style.display == "none") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
    </script>
</head>
<body>
<section class="header">
    <div class="logo">

    </div>
    <div class="time">

    </div>
    <div class="phone">

    </div>
    <div class="user">

        <input type="button" id="authorize" value="Sign in" onclick="display(document.getElementById('sign_form'))" />
        <div id="sign_form" style="display: none;">
            <form id="sign_in"  action="/controller" method="post">
                <input type="hidden" name="command" value="sign_in">
                <input type="text" id="username" name="username" placeholder="username">
                <input type="password" id="password" name="password" placeholder="password">
                <input type="submit" value="sign in">
            </form>
            ${errorUserMessage}

<%--            <form id="sign_up"  action="/controller" method="get">--%>
<%--                <input type="hidden" name="command" value="sign_up">--%>
<%--                <input type="submit" id="registration" value="click here">--%>
<%--                --%>

<%--            </form>--%>
            <a href="pages/sign_up.jsp">signup</a>
        </div>

    </div>
    <div class="basket">

    </div>
    <div class="internationalization">

    </div>
</section>
<section class="menu">
    <button>Лапша</button>
    <button>Роллы</button>
    <button>Супы</button>
    <button>Обед</button>
    <button>Десерты</button>
    <button>Напитки</button>
    <button>Закуски</button>
</section>
<section class="slide">
    <button>previous</button>
    <button>next</button>
</section>
</body>
</html>
