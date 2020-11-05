
<%--
Created by IntelliJ IDEA.
User: katty
Date: 31.10.2020
Time: 7:43
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <menu class="menu" role="menu" id="menu">
        <div class="page_name" id="page_name">
            <a href="http://localhost:8080/ks">Kazan <span class="colortext">Sightseeing</span></a>
        </div>
        <div class="sub_nav">
            <a href="http://localhost:8080/ks/profile" class="sub_nav_main">Профиль</a>
            <div class="sub_nav_content">
                <ul>
                    <li><a href="http://localhost:8080/ks/achievements" id="my_archives">Мои достижения</a></li>
                    <li><a href="http://localhost:8080/ks/rating" id="my_rating">Мой рейтинг</a></li>
                    <li><a href="http://localhost:8080/ks/visited" id="visited">Посещенные</a></li>
                    <li><a href="http://localhost:8080/ks/favorite" id="highlighted">Любимые места</a></li>
                    <li><a href="http://localhost:8080/ks/wanted" id="will_visit">Желаю посетить</a></li>
                    <li><a href="http://localhost:8080/ks/logout" id="log_out">Выйти</a></li>
                </ul>
            </div>
        </div>
    </menu>
</header>