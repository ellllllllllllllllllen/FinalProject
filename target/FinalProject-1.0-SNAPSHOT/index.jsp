<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <script>
        function disp(form) {
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
    <div class="authorization">

        <input type="button" value="Sign in" onclick="disp(document.getElementById('authorization'))" />
        <form id="authorization" style="display: none;" action="/controller" method="post">
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
