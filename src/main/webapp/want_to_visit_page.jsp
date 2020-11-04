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
    <title>Хочу посетить</title>

    <link rel="stylesheet" type="text/css" href="styles/favorites_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
</head>
<body>
<jsp:include page="includes/authorized_menu.jsp"/>

<div class="rec" id="rec">
    <h2>Хочу посетить!</h2>

    <div class="f1" id="f1">
        <div class="ph" id="ph1"></div>
        <a href="http://localhost:8080/ks/sight?id=1">. . . </a>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>