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
            <a href="http://localhost:8080/ks">Kazan <span class="colortext">Sightseeing</span></a>
        </div>
    </menu>
</header>

<div class="all" id="all">
<%--    <div class="ph" id="ph">--%>
<%--        <div class="photo" id="photo">--%>
<%--            <img src="${photo_path}" alt="Avatar"--%>
<%--                 class="avatar">--%>
<%--        </div>--%>

<%--        <div class="refactorImg">--%>
<%--            <a class="rimg" href="http://localhost:8080/ks/change-photo">Сменить фото профиля</a>--%>
<%--        </div>--%>
<%--    </div>--%>


    <div class="area1" id="area1">
        <div class="box">
            <form action="edit-profile" method="post">
                <h2>Имя и фамилия:</h2>
                <input name="fullname" type="text" class="input" value="${fullname}">

                <h2>Имя пользователя: </h2>
                <input name="username" type="text" class="input" value="${username}" required>

                <h2>E-mail:</h2>
                <input name="email" type="text" class="input" value="${email}" required>

                <h2>Дата рождения:</h2>
                <input name="birthdate" type="date" class="input" value="${birthdate}">

                <h2>Пароль</h2>
                <input name="password" type="password" class="input" value="********" required>

                <div class="button">
                    <button class="btn">Сохранить</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="includes/deployed_menu.jsp"/>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>