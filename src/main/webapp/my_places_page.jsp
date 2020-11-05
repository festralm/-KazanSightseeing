<%--
Created by IntelliJ IDEA.
User: katty
Date: 31.10.2020
Time: 7:43
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Посещённые места</title>

    <link rel="stylesheet" type="text/css" href="styles/favorites_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
</head>
<body>
<jsp:include page="includes/authorized_menu.jsp"/>

<div class="rec" id="rec">
    <h2>Здесь был Петя . . . </h2>
    <jsp:include page="includes/sights.jsp"/>
</div>

<jsp:include page="includes/footer.jsp"/>
</body>
</html>