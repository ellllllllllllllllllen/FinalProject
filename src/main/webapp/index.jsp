<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Menu</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area">
            <div class="container-fluid p-0">
                <div class="row align-items-center no-gutters">
                    <div class="col-xl-5 col-lg-5">
                        <div class="main-menu  d-none d-lg-block">
                            <nav>
                                <ul id="navigation">
                                    <li><a class="active" href="index.html">Home</a></li>
                                    <li><a href="menu.jsp">Menu</a></li>
                                    <li><a href="about.html">About</a></li>
                                    <li><a href="contact.html">Contacts</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-xl-2 col-lg-2">
                        <div class="logo-img">
                            <a href=#>
                                <img src="img/logo.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-5 col-lg-5 d-none d-lg-block">
                        <div class="book_room">
                            <div class="book_btn d-none d-xl-block">
                                <div class="dropdown">
                                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Sign In
                                    </a>
                                    <div class="dropdown-menu">
                                        <form class="px-4 py-3" action="/controller" method="post">
                                            <input type="hidden" name="command" value="sign_in">
                                            <div class="form-group">
                                                <label for="exampleDropdownFormEmail1">Username</label>
                                                <input type="text" name="username" class="form-control" id="exampleDropdownFormEmail1" placeholder="Username">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleDropdownFormPassword1">Password</label>
                                                <input type="password" name="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                                            </div>
                                            <div class="invalid-feedback">${errorUserMessage}</div>
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input" id="dropdownCheck">
                                                <label class="form-check-label" for="dropdownCheck">
                                                    Remember me
                                                </label>
                                            </div>
                                            <button type="submit" class="btn btn-outline-warning">Sign In</button>
                                        </form>
                                        <div class="dropdown-divider"></div>
<%--                                        <button type="button" class="btn btn-outline-warning">New around here? Sign up</button>--%>
                                        <p class="message">Not registered? <a href="pages/sign_up.jsp">Create an account</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- header-end -->

<!-- slider_area_start -->
<div id="mySlider" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/banner/banner.png" alt="" class="d-block w-100">

        </div>
        <div class="carousel-item">
            <img src="img/banner/banner2.png" alt="" class="d-block w-100">
        </div>
        <a href="#mySlider" class="carousel-control-prev" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a href="#mySlider" class="carousel-control-next" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div class="best_burgers_area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section_title text-center mb-80">
                    <span>New menu</span>
                    <h3>BEST EVER</h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-6 col-md-6 col-lg-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/1.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Beefy Burgers</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$20,30</span>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/2.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Burger Boys</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$15,50</span>
                    </div>
                </div>

            </div>
            <div class="col-lg-6 col-md-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/3.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Burger Bizz</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$18,00</span>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-md-6 col-lg-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/4.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Crackles Burger</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$16,00</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/5.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Bull Burgers</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$20,80</span>
                    </div>
                </div>

            </div>
            <div class="col-lg-6 col-md-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/6.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Rocket Burgers</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$18,30</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/7.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Nigiri set 1</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$23,50</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="single_delicious d-flex align-items-center">
                    <div class="thumb">
                        <img src="img/sets/8.png" alt="">
                    </div>
                    <div class="info">
                        <h3>Nigiri set 2</h3>
                        <p>Great way to make your business appear trust and relevant.</p>
                        <span>$25,90</span>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- features_room_startt -->
<div class="Burger_President_area">
    <div class="Burger_President_here">
        <div class="single_Burger_President">
            <div class="room_thumb">
                <img src="img/banner/1.png" alt="">
                <div class="room_heading d-flex justify-content-between align-items-center">
                    <div class="room_heading_inner">
                        <span>$20</span>
                        <h3>The Burger President</h3>
                        <p>Great way to make your business appear trust <br> and relevant.</p>
                        <a href="#" class="boxed-btn3">Order Now</a>
                    </div>

                </div>
            </div>
        </div>
        <div class="single_Burger_President">
            <div class="room_thumb">
                <img src="img/banner/2.png" alt="">
                <div class="room_heading d-flex justify-content-between align-items-center">
                    <div class="room_heading_inner">
                        <span>$20</span>
                        <h3>The Burger President</h3>
                        <p>Great way to make your business appear trust <br> and relevant.</p>
                        <a href="#" class="boxed-btn3">Order Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- features_room_end -->
<!-- about_area_start -->
<div class="about_area">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-xl-6 col-lg-6 col-md-6">
                <div class="about_thumb2">
                    <div class="img_1">
                        <img src="img/about/1.png" alt="">
                    </div>
                    <div class="img_2">
                        <img src="img/about/2.png" alt="">
                    </div>
                </div>
            </div>
            <div class="col-xl-5 col-lg-5 offset-lg-1 col-md-6">
                <div class="about_info">
                    <div class="section_title mb-20px">
                        <span>About Us</span>
                        <h3>Best Asian food <br>
                            in your City</h3>
                    </div>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate</p>
                    <div class="img_thumb">
                        <img src="img/jessica-signature.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- about_area_end -->
<footer class="footer">
    <div class="footer_top">
        <div class="container">
            <div class="row">
                <div class="col-xl-4 col-md-6 col-lg-4">
                    <div class="footer_widget text-center ">
                        <h3 class="footer_title pos_margin">
                            New York
                        </h3>
                        <p>5th flora, 700/D kings road, <br>
                            green lane New York-1782 <br>
                            <a href="#">info@burger.com</a></p>
                        <a class="number" href="#">+10 378 483 6782</a>

                    </div>
                </div>
                <div class="col-xl-4 col-md-6 col-lg-4">
                    <div class="footer_widget text-center ">
                        <h3 class="footer_title pos_margin">
                            California
                        </h3>
                        <p>5th flora, 700/D kings road, <br>
                            green lane New York-1782 <br>
                            <a href="#">info@burger.com</a></p>
                        <a class="number" href="#">+10 378 483 6782</a>

                    </div>
                </div>
                <div class="col-xl-4 col-md-12 col-lg-4">
                    <div class="footer_widget">
                        <h3 class="footer_title">
                            Stay Connected
                        </h3>
                        <form action="#" class="newsletter_form">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit">Sign Up</button>
                        </form>
                        <p class="newsletter_text">Stay connect with us to get exclusive offer!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>



<%--<section class="header">--%>
<%--    <div class="logo">--%>
<%--        <img src="img/logo.png" height="100" width="200">--%>
<%--    </div>--%>
<%--    <div class="time">--%>
<%--        <h2>Сегодня работаем</h2>--%>
<%--        <h2><script>document.write(time);</script></h2>--%>
<%--        <div class="time-child">--%>
<%--            <h3>Понедельник		с 10:00 до 22:00</h3>--%>
<%--            <h3>Вторник			с 10:00 до 22:00</h3>--%>
<%--            <h3>Среда			с 10:00 до 22:00</h3>--%>
<%--            <h3>Четверг			с 10:00 до 22:00</h3>--%>
<%--            <h3>Пятница			с 10:00 до 23:00</h3>--%>
<%--            <h3>Суббота			с 10:00 до 23:00</h3>--%>
<%--            <h3>Воскресенье		с 10:00 до 23:00</h3>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--    <div class="phone">--%>
<%--        <h2>Контактный телефон</h2>--%>
<%--        <h2>+375-44-721-33-59</h2>--%>
<%--    </div>--%>
<%--    <div class="user">--%>

<%--        <input type="button" id="authorize" value="Вход/Регистрация" onclick="display(document.getElementById('sign_form'))" />--%>
<%--        <div class="form" id="sign_form" style="display: none;">--%>
<%--            <form class="login-form" action="/controller" method="post">--%>
<%--                <input type="hidden" name="command" value="sign_in">--%>
<%--                <input type="text" name="username" placeholder="username">--%>
<%--                <input type="password" name="password" placeholder="password">--%>
<%--                <button>Войти</button>--%>
<%--                <h4>${errorUserMessage}</h4>--%>
<%--                <p class="message">Not registered? <a href="pages/sign_up.jsp">Create an account</a></p>--%>
<%--            </form>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--    <div class="basket">--%>

<%--    </div>--%>
<%--    <div class="internationalization">--%>
<%--        <div class="ru">--%>
<%--            <button><img src="img/ru.jpg" height="50" width="50"></button>--%>
<%--        </div>--%>
<%--        <div class="en">--%>
<%--            <img src="img/en.jpg" height="50" width="50">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<%--<section class="menu">--%>
<%--    <div class="buttons">--%>
<%--        <button>Пирожные</button>--%>
<%--        <button>Торты</button>--%>
<%--        <button>Наборы</button>--%>
<%--        <button>Напитки</button>--%>
<%--    </div>--%>

<%--</section>--%>
<%--<section class="slide">--%>
<%--    <button>previous</button>--%>
<%--    <button>next</button>--%>
<%--</section>--%>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
