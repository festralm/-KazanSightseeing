<%--
  Created by IntelliJ IDEA.
  User: katty
  Date: 05.11.2020
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="sight" items="${sights}">
    <div class="f1">
        <div class="ph">
            <img src="<c:out value="${sight.getPhotoPath()}"/>" class="f1">
        </div>

        <a href="http://localhost:8080/ks/sight?id=<c:out value="${sight.getId()}" />"><c:out value="${sight.getName()}" /> </a>
    </div>
</c:forEach>
