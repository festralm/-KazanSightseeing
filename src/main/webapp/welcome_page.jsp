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
    <meta name="description" content="">
    <title>KS</title>
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
    <link rel="stylesheet" type="text/css" href="styles/authorisation_menu.css">
    <link rel="stylesheet" type="text/css" href="styles/welcome_page.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<jsp:include page="includes/non_authorized_menu.jsp"/>

<div class="area1" id="area1">
    <!--    <h1>1005 ЛЕТ И ВСЕ ДЛЯ ТЕБЯ</h1>-->
    <!--    <h2>Окунись в историю своих любимых мест вместе с нами!</h2>-->
</div>

<div class="area2" id="area2">
    <h3>Выбери место на карте</h3>

    <jsp:include page="includes/map.jsp"/>
</div>
<jsp:include page="includes/footer.jsp"/>

</body>
</html>
