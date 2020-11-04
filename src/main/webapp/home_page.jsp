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
    <title>KS</title>
    <link rel="stylesheet" type="text/css" href="styles/home_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
    <link rel="stylesheet" type="text/css" href="styles/welcome_page.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="main.js"></script>
</head>
<body>

<jsp:include page="includes/authorized_menu.jsp"/>

<div class="info" id="info">
    <progress max="100" value="25">
        <span id="value"></span>%
    </progress>

    <h3>Куда отправимся дальше?</h3>


    <jsp:include page="includes/map.jsp"/>
</div>
    <jsp:include page="includes/footer.jsp"/>

</body>
</html>