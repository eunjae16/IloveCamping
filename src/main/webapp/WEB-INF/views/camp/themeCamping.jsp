<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/map.css">
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5670ccd025e23c03c5a4887d46695c55&libraries=services,clusterer,drawing"></script>
</head>
<body>
<section>
    <div class="right">
        <div id="map">
        </div>
    </div>
    <div class="left">
        <div id="camp-card">
            <c:forEach var="theme" items="${campingThemes}">
                <div id="${theme.campCode}">
                    <img class="camp-img" src="${theme.campImage}">
                    <div class="list-text-box">
                        <p>${theme.campName}</p>
                        <p>${theme.themeName}</p>
                    </div>
                    <form method="POST" action="/get/campinfo">
                        <input type="hidden" name="campCode" id="campCode" value="${theme.campCode}">
                        <input type="submit" value="예약">
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<c:import url="/footer"/>
<%--<script src="script/camp/map.js"></script>--%>
<%--<script src="script/camp/campList.js"></script>--%>
<script src="script/camp/campingMap.js"></script>
</body>
</html>
