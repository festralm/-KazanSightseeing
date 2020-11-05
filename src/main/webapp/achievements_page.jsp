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
    <title>Мои достижения</title>

    <link rel="stylesheet" type="text/css" href="styles/achievements_page.css">
    <link rel="stylesheet" type="text/css" href="styles/common_ks.css">
</head>
<body>
<jsp:include page="includes/authorized_menu.jsp"/>

<div class="achieve" id="achieve">
    <c:forEach var="achievement" items="${achievements}">
        <div class="a">
            <div class="photo">
                <img src="<c:out value="${achievement.getPhotoPath()}" />">
            </div>
            <h2>"<c:out value="${achievement.getName()}" />"</h2>
            <h3><c:out value="${achievement.getDescription()}" /></h3>
        </div>
    </c:forEach>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>