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
<!--    <link rel="stylesheet" href="photos.js">-->
    <script src="photos.js"></script>
</head>
<body>
<jsp:include page="includes/header.jsp"/>

<div class="sight" id="sight">
    <h1>Название достопримечательности</h1>

    <div class="photo" id="photo"></div>

    <div class="info" id="info">
        <p>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
        </p>

        <p>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
            *интересная информация о достопримечательности*<br>
        </p>
    </div>
</div>

<!--&lt;!&ndash; Slideshow container &ndash;&gt;-->
<!--<div class="slideshow-container">-->

<!--    &lt;!&ndash; Full-width images with number and caption text &ndash;&gt;-->
<!--    <div class="mySlides fade">-->
<!--        <div class="numbertext">1 / 3</div>-->
<!--        <img src="/photo_2020-06-08_09-28-15.jpg" style="width:100%">-->
<!--        <div class="text">Caption Text</div>-->
<!--    </div>-->

<!--    <div class="mySlides fade">-->
<!--        <div class="numbertext">2 / 3</div>-->
<!--        <img src="/photo_2020-06-28_08-39-17.jpg" style="width:100%">-->
<!--        <div class="text">Caption Two</div>-->
<!--    </div>-->

<!--    <div class="mySlides fade">-->
<!--        <div class="numbertext">3 / 3</div>-->
<!--        <img src="/photo_2020-07-05_08-23-54.jpg" style="width:100%">-->
<!--        <div class="text">Caption Three</div>-->
<!--    </div>-->

<!--    &lt;!&ndash; Next and previous buttons &ndash;&gt;-->
<!--    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>-->
<!--    <a class="next" onclick="plusSlides(1)">&#10095;</a>-->
<!--</div>-->
<!--<br>-->

<!--&lt;!&ndash; The dots/circles &ndash;&gt;-->
<!--<div style="text-align:center">-->
<!--    <span class="dot" onclick="currentSlide(1)"></span>-->
<!--    <span class="dot" onclick="currentSlide(2)"></span>-->
<!--    <span class="dot" onclick="currentSlide(3)"></span>-->
<!--</div>-->

<!--Here's our main wrapper.
Since our carousel items get their size from their parent,
we have to specify its height.-->
<div class="carousel-wrapper" style="height: 400px;">
    <!--The carousel uses regular links to cycle through each item.
    The links actually target these display: none; spans so our page doesn't
    jump like it normally would when using jump links.-->
    <span id="target-item-1"></span>
    <span id="target-item-2"></span>
    <span id="target-item-3"></span>
    <!--Here are our carousel items.
    Each has a 'carousel-item' class, which we use for shared styling
    and an item-# class, which we use to control its opacity
    depending on which target-item-# is currently targeted-->
    <div class="carousel-item item-1">
        <!--We can add any content in here, just make sure that
        your .carousel-wrapper is big enough to hold all the content.-->
        <img src="https://sun9-11.userapi.com/jl_0F4HP2DzRUsA92VKIuELlSWwyFPAceQzrIg/z11rZvdK8_Y.jpg" height="380px" width="500px">
        <!--Here are the links that control the carousel! Make sure
        the href of each one is pointing to the right target-item-#
        so that the carousel cycles in sequence.-->
        <a class="arrow arrow-prev" href="#target-item-3"></a>
        <a class="arrow arrow-next" href="#target-item-2"></a>
    </div>
    <!--And here are a couple more carousel items so that
    we have some content to scroll to. Notice the 'light' class?
    Royal blue is a pretty dark background color, so we'll add a CSS
    rule to make the text white if a carousel item has this class-->
    <div class="carousel-item item-2 light" style="background-color: royalblue;">
        <img src="https://sun9-62.userapi.com/vQIKd3MlALvao-IJkQ5BQD2PrTOm-OhFsSi8Qg/7_FWWYiPPss.jpg" height="380px" width="500px">
        <a class="arrow arrow-prev" href="#target-item-1"></a>
        <a class="arrow arrow-next" href="#target-item-3"></a>
    </div>
    <div class="carousel-item item-3">
        <img src="https://sun9-11.userapi.com/F03901cjwI06BLPUl0_50Lzgclhz1odinaqSCQ/s7RuHYa6a3c.jpg" height="380px" width="500px">
        <a class="arrow arrow-prev" href="#target-item-2"></a>
        <a class="arrow arrow-next" href="#target-item-1"></a>
    </div>
</div>

<div class="buttons" id="buttons">
    <input type="button" id="b1" value="Отметить как пройденное">
    <input type="button" id="b2" value="Хочу посетить!"><br>
    <input type="button" id="b3" value="✩ Избранное">
</div>

<div class="other" id="other">
    <form>
        <p><b>Поделиться впечатлениями :</b></p>

        <p><textarea name="comment" id="comment"></textarea></p>
        <p><input type="submit"></p>
    </form>


    <a href="#" id="allComments">Посмотреть другие комментарии</a>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>