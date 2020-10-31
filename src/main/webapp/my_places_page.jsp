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
    <title>Посещённые места</title>

    <link rel="stylesheet" type="text/css" href="styles/favorites_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
</head>
<body>
<jsp:include page="includes/header.jsp"/>

<div class="rec" id="rec">
    <h2>Здесь был Петя . . . </h2>

    <div class="f1" id="f1">
        <div class="ph" id="ph1"></div>
        <a href="sight_page.jsp">. . . </a>
    </div>
</div>

<jsp:include page="includes/footer.jsp"/>
</body>
</html>