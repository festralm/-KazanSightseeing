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
    <title>Мои достижения</title>

    <link rel="stylesheet" type="text/css" href="styles/achievements_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
</head>
<body>
<jsp:include page="includes/authorized_menu.jsp"/>

<div class="achieve" id="achieve">
    <div class="a" id="a1">
        <div class="photo" id="ph1">
            <img src="https://sun9-70.userapi.com/-zpC3aryoaM_RKXTqQXuk8fw8BvHAYqXcYbtJQ/8hpRK_am5fw.jpg">
        </div>
        <h2>"Турист"</h2>
        <h3>Краткое описание</h3>
    </div>

    <div class="a" id="a2">
        <div class="photo" id="ph2">
            <img src="https://sun9-72.userapi.com/TquwreW2Gn-wsIN4F5BCa7bymTwbgaPYLUdPnQ/1oWPfoJ1VSc.jpg">
        </div>
        <h2>"Коренной житель"</h2>
        <h3>Краткое описание</h3>
    </div>

    <div class="a" id="a3">
        <div class="photo" id="ph3">
            <img src="https://sun9-68.userapi.com/gQxhlDNdf5tmCTa0pzIWpDYVBagVg5SeG0mtVw/oot-yogpdIw.jpg">
        </div>
        <h2>"Колумб"</h2>
        <h3>Краткое описание</h3>
    </div>

    <div class="a" id="a4">
        <div class="photo" id="ph4">
            <img src="https://sun9-26.userapi.com/k6kZMq1TTUfUTd2589hrQ_THe-Ds9i44x-RGDg/zuU_ooKLGyQ.jpg">
        </div>
        <h2>"От края до края"</h2>
        <h3>Краткое описание</h3>
    </div>

    <div class="a" id="a5">
        <div class="photo" id="ph5"></div>
        <h2>" * * * "</h2>
        <h3>Краткое описание</h3>
    </div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>