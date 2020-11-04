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
    <script src="js/validation.js"></script>

</head>
<body>
<jsp:include page="includes/non_authorized_menu.jsp"/>

<div class="form">
    <div class="image">
    </div>

    <div class="authorization_form">
        <form method="post" action="register-in">
            <h1>Регистрация</h1>
            <div>
                <input type="text" name="username" id="username"
                       placeholder=" " required onblur="check_username()"/>
                <label for="username">Имя пользователя</label>

                <div class="requirements" id="username_error">
                    Имя пользователя занято
                </div>
            </div>

            <div>
                <input type="email" name="email" id="email" placeholder=" " required/>
                <label for="email">E-mail</label>

                <div class="requirements">
                    E-mail введён некорректно
                </div>
            </div>

            <div>
                <input type="password" name="password" id="password" placeholder=" "
                       minlength="8" maxlength="32" onblur="check_passwords()"
                       required/>
                <label for="password">Введите пароль</label>

                <div class="requirements">
                    Пароль должен содержать не менее 8 знаков
                </div>
            </div>

            <div>
                <input type="password" name="repeat_password" id="repeat_password"
                       placeholder=" " required onblur="check_passwords()"/>
                <label for="repeat_password">Повторите пароль</label>

                <div class="requirements" id="passwords_error">
                    Введённые пароли не совпадают
                </div>
            </div>

            <p>
                <label><input class="check" type="checkbox" name="remember_me">Запомнить меня</label>
            </p>

            <p>
                <input class="button" type="submit" name="submit" id="submit" value="Г О Т О В О !" disabled/>
            </p>
        </form>
    </div>
</div>

<jsp:include page="includes/footer.jsp"/>

</body>
</html>