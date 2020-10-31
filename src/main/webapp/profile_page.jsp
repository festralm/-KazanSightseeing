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
    <title>Мой профиль</title>

    <link rel="stylesheet" type="text/css" href="styles/profile_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
    <link rel="stylesheet" type="text/css" href="styles/authorisation_menu.css">
</head>
<body>
<header>
    <menu class="menu" role="menu" id="menu">
        <div class="page_name" id="page_name">
            <a href="home_page.jsp">Kazan <span class="colortext">Sightseeing</span></a>
        </div>
    </menu>
</header>

<div class="all" id="all">
    <div class="ph" id="ph">
        <div class="photo" id="photo">
            <img src="https://sun9-57.userapi.com/gM6I4GcHzmNQX1IjvJcPgTxAQPvR8c2ZSFAm9A/ps9TYGpIuQk.jpg" alt="Avatar"
                 class="avatar">
        </div>

        <div class="refactorImg">
            <a class="rimg" href="Refactor.html">Сменить фото профиля</a>
        </div>
    </div>


    <div class="area1" id="area1">
        <div class="box">
            <h2>Имя и фамилия:</h2>
            <input type="text" class="input" value="Абрамский Михаил">

            <h2>Имя пользователя: </h2>
            <input type="text" class="input" value="@abramichael">

            <h2>E-mail:</h2>
            <input type="text" class="input" value="itis.example@gmail.com">

            <h2>Дата рождения:</h2>
            <input type="text" class="input" value="31 Авг 19**">

            <h2>Пароль</h2>
            <input type="password" class="input" value="iloveuitis">

            <div class="button">
                <button class="btn">Сохранить</button>
            </div>
        </div>
    </div>
</div>


<div class="rightbox">
    <nav>
        <a href="my_achieves.html" id="my_archives"> Мои достижения </a>
        <a href="my_rating.html" id="my_rating"> Мой рейтинг </a>
        <a href="visited.html" id="visited"> Посещенные </a>
        <a href="highlighted.html" id="highlighted"> Любимые места </a>
        <a href="will_visit.html" id="will_visit"> Желаю посетить </a>
    </nav>
</div>


<jsp:include page="includes/footer.jsp"/>
</body>
</html>