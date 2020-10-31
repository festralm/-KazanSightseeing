<%--
Created by IntelliJ IDEA.
User: katty
Date: 31.10.2020
Time: 7:43
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="styles/registration_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
    <link rel="stylesheet" type="text/css" href="styles/authorisation_menu.css">

</head>
<body>
<header>
    <menu class="menu" role="menu" id="menu">
        <div class="page_name" id="page_name">
            <a href="home_page.jsp">Kazan <span class="colortext">Sightseeing</span></a>
        </div>
        <div class="authorization" id="authorization">
            <div class="sign_in" id="sign_in">
                <a href="sign_in_page.jsp">Войти</a>
            </div>
        </div>
    </menu>
</header>

<div class="form">
    <div class="image">
    </div>

    <div class="authorization_form">
        <form method="post" action="">
            <h1>Регистрация</h1>
            <div>
                <input type="text" name="username" id="username" placeholder=" " required/>
                <label for="username">Имя и фамилия</label>
            </div>

            <div>
                <input type="email" name="email" id="email" placeholder=" " required/>
                <label for="email">E-mail</label>

                <div class="requirements">
                    E-mail введён некорректно
                </div>
            </div>

            <div>
                <input type="password" name="password" id="password" placeholder=" " minlength="8" maxlength="32"
                       required/>
                <label for="password">Введите пароль</label>

                <div class="requirements">
                    Пароль должен содержать не менее 8 знаков
                </div>
            </div>

            <div>
                <input type="password" name="repeat_password" id="repeat_password" placeholder=" " minlength="8"
                       maxlength="32"
                       required/>
                <label for="repeat_password">Повторите пароль</label>

                <div class="requirements">
                    Введённые пароли не совпадают
                </div>
            </div>

            <p>
                <label><input type="checkbox" name="remember_me">Запомнить меня</label>
            </p>

            <p>
                <input class="button" type="submit" name="submit" id="submit" value="Г О Т О В О !"/>
            </p>

        </form>
    </div>
</div>

<jsp:include page="includes/footer.jsp"/>

</body>
</html>