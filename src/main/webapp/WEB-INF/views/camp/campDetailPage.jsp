<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-09
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="../../style/campDetailPage.css">
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5670ccd025e23c03c5a4887d46695c55&libraries=services,drawing"></script>
</head>
<body>
<c:if test="${empty camp}">
    <c:redirect url="/"></c:redirect>
</c:if>

<section>
    <div>
        <h3 id="campName">${camp.campName}</h3>
    </div>
    <div>
        <p id="address">${camp.campAddress1}</p>
        <p>${camp.campPhone}</p>
    </div>
    <div>
        <form method="POST" action="/post/goreservation">
            <input type="hidden" value="${camp.campCode}" name="campCode" id="campCode">
            <input type="submit" value="예약하러 가기!">
        </form>
    </div>
    <%--    지도 --%>
    <div class="map" id="${camp.x}/${camp.y}" style="width:500px;height:400px;"></div>
    <div>
        <div><img src="${camp.campImage}"></div>
        <div id="theme">테마</div>
        <div id="theme-detail">${campThemeName.campCategoryName}</div>
        <div id="surround">주변</div>
        <div id="surround-detail">
            <c:forEach var="surround" items="${surroundList}">
                <p>${surround.surroundCategoryName}</p>
            </c:forEach>
        </div>
        <div id="ground-sun">
            <div id="sunhead"><p>오늘 : </p></div>
            <div id="sunrise">
                <span>일출시간</span>
            </div>
            <div id="sunset">
                <span>일몰시간</span>
            </div>
        </div>
        <div id="facilities-all">
            <c:forEach var="facility" items="${facilityList}">
                <img src="${facility.facilityImgUrl}">
                <p>${facility.categoryName}</p>
            </c:forEach>
        </div>
    </div>
</section>
<script src="../../script/camp/campDetail.js"></script>
<c:import url="/footer"/>
</body>
</html>