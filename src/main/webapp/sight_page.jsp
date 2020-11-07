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
    <title>Достопримечательность</title>

    <link rel="stylesheet" type="text/css" href="styles/sight_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
    <link rel="stylesheet" type="text/css" href="styles/authorisation_menu.css">
    <script src="js/photos.js"></script>
    <script src="js/carousel.js"></script>
</head>
<body>
<%
    Object user = session.getAttribute("user_id");

    String path;

    if (user != null) {
        path = "includes/authorized_menu.jsp";
    } else {
        path = "includes/non_authorized_menu.jsp";
    }

%>
<jsp:include page="<%=path%>"/>;

<div class="sight" id="sight">
    <h1>${sight.getName()}</h1>

    <div class="photo" id="photo">
        <img class="sight_photo" src="${sight.getPhotoPath()}"/>
    </div>

    <div class="info" id="info">
        <p>${sight.getDescription()}</p>
    </div>
</div>

<div id="carousel" class="carousel">
    <button class="arrow prev">⇦</button>
    <div class="gallery">
        <ul class="images">
            <li><img src="photo/sight/1/1.jpg"></li>
            <li><img src="photo/sight/1/2.jpg"></li>
            <li><img src="photo/sight/1/3.jpg"></li>
<%--            <li><img src="https://ru.js.cx/carousel/4.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/5.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/6.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/7.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/8.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/9.png"></li>--%>
<%--            <li><img src="https://ru.js.cx/carousel/10.png"></li>--%>
        </ul>
    </div>
    <button class="arrow next">⇨</button>
</div>

<div class="buttons" id="buttons">
    <input type="button" id="b1" value="Отметить как пройденное" onclick="window.location.href = '/ks/save-as-visited?id=${sight.getId()}';">
    <input type="button" id="b2" value="Хочу посетить!" onclick="window.location.href = '/ks/save-as-wanted?id=${sight.getId()}';"><br>
    <input type="button" id="b3" value="✩ Избранное" onclick="window.location.href = '/ks/save-as-favorite?id=${sight.getId()}';">
<%--    <input type="button" id="b3" value="Добавлено в избранное" onclick="window.location.href = '/ks/save-as-favorite?id=${sight.getId()}';">--%>
</div>

<div class="other" id="other">
    <form method="post" action="comment?id=${sight.getId()}">
        <p><b>Поделиться впечатлениями :</b></p>

        <p><textarea name="comment" id="comment" required></textarea></p>
        <p><input type="submit"></p>
    </form>


    <a href="http://localhost:8080/ks/comments?id=${sight.getId()}" id="allComments">Посмотреть другие комментарии</a>
</div>

<div class="user_comment" id="user_comment">
    <div class="cm" id="cm">
        <p id="user_name">Имя пользователя</p>
        <p>*комментарий комментарий комментарий комментарий комментарий*</p>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>