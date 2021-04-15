
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
<%--        <%@ include file="/css/sign_up.css" %>--%>
        <%@ include file="/css/style.css" %>
    </style>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
<%--    <link rel="stylesheet" href="css/style.css">--%>
</head>
<body>

<%--<div class="container">--%>
<%--    <h2>SIGN IN!</h2>--%>
<%--    <form action="#" method="post" class="was-validated">--%>
<%--        <div class="form-group">--%>
<%--            <label>Input your login</label>--%>
<%--            <input name="login" class="form-control" placeholder="login" required>--%>
<%--            <div class="invalid-feedback">${LoginIsNotUnique}</div>--%>

<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label>Input your password</label>--%>
<%--            <input type="password" class="form-control" name="password" placeholder="password" required>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label>Repeat your password</label>--%>
<%--            <input type="password" class="form-control" name="repeatPassword" placeholder="repeat password" required>--%>
<%--            <div class="invalid-feedback">${RepeatPasswordIsNotUnique}</div>--%>
<%--        </div>--%>

<%--        <button type="submit" class="btn btn-primary">Enter</button>--%>
<%--    </form>--%>
<%--</div>--%>
<div class="best_burgers_area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section_title text-center mb-80">
                    <span>Sign Up</span>
                </div>
            </div>
        </div>
    </div>
    <div class="sign_up_form">
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="sign_up">
            <div class="form-group" >
                <div class="alert alert-danger" role="alert">
                    ${errorEmailMessage}
                </div>
                <label for="email">Email address</label>
                <input type="text" name="email" class="form-control" id="email" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group" >
                <div class="alert alert-danger" role="alert">
                    ${errorUsernameMessage}
                </div>
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group" >
                <div class="alert alert-danger" role="alert">
                    ${errorFirstnameMessage}
                </div>
                <label for="firstname">Firstname</label>
                <input type="text" name="firstname" id="firstname" class="form-control">
            </div>
            <div class="form-group" >
                <div class="alert alert-danger" role="alert">
                    ${errorLastnameMessage}
                </div>
                <label for="lastname">Lastname</label>
                <input type="text" name=lastname" id="lastname" class="form-control">
            </div>
            <div class="form-group">
                <div class="alert alert-danger" role="alert">
                    ${errorPasswordMessage}
                </div>
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password">
            </div>
            <div class="form-group">
                <label for="repeatPassword">Repeat password</label>
                <input type="password" class="form-control" id="repeatPassword">
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" value="sign up" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>



<%--<div class="user">--%>
<%--    <div class="form">--%>
<%--        <form class="signup-form" action="/controller" method="post">--%>
<%--            <input type="hidden" name="command" value="sign_up">--%>
<%--            <input type="text" id="email" name="email" placeholder="Email">--%>
<%--                <h4>${errorEmailMessage}</h4>--%>
<%--            <input type="text" id="username" name="username" placeholder="Username">--%>
<%--                <h4>${errorUsernameMessage}</h4>--%>
<%--            <input type="text" id="firstname" name="firstname" placeholder="Имя">--%>
<%--                <h4> ${errorFirstnameMessage}</h4>--%>
<%--            <input type="text" id="lastname" name="lastname" placeholder="Фамилия">--%>
<%--                <h4>${errorLastnameMessage}</h4>--%>
<%--            <input type="password" id="password" name="password" placeholder="password">--%>
<%--            <input type="password" id="repeat_password" name="repeat_password" placeholder="Повтор пароля">--%>
<%--                <h4>${errorPasswordMessage}</h4>--%>
<%--            <button type="submit">Зарегистрироваться</button>--%>
<%--&lt;%&ndash;            <input type="submit" value="sign up">&ndash;%&gt;--%>
<%--            <p class="message"><a href="/index.jsp">Назад</a></p>--%>
<%--        </form>--%>
<%--    </div>--%>


<%--    <div class="sign_in">--%>
<%--        <form action="/controller" method="get">--%>
<%--            <input type="hidden" name="command" value="sign_in">--%>
<%--            <input type="submit" value="sign in">--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
