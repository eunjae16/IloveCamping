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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:if test="${empty camp}">
    <c:redirect url="/"></c:redirect>
</c:if>
<section>
    <div class="left">
        <div class="info">
            <h3 id="campName">${camp.campName}</h3>
            <p id="address">${camp.campAddress1}</p>
            <p id="englishAddress">${camp.campAddress2}</p>
            <p>${camp.campPhone}</p>
            <form method="POST" action="/post/goreservation">
                <input type="hidden" value="${camp.campCode}" name="campCode" id="campCode">
                <input type="submit" value="예약하러 가기!">
            </form>
            <div>
                <div class="img-box"><img src="${camp.campImage}"></div>
                <div class="flex-box">
                    <div id="left-box">
                        <div id="theme"><span>테마</span></div>
                        <div id="theme-detail"><span>${campThemeName.campCategoryName}</span></div>
                        <div id="surround"><span>주변</span></div>
                        <div id="surround-detail">
                            <c:forEach var="surround" items="${surroundList}">
                                <span>${surround.surroundCategoryName}</span>
                            </c:forEach>
                        </div>
                    </div>
                    <div id="right-box">
                        <div id="sunhead"><span>오늘 날씨:</span></div>
                        <div id="sunrise">
                            <span>일출 시간</span>
                        </div>
                        <div id="sunset">
                            <span>일몰 시간</span>
                        </div>
                    </div>
                </div>
                <div id="facilities-all">
                    <c:forEach var="facility" items="${facilityList}">
                        <div>
                            <img src="${facility.facilityImgUrl}">
                            <span>${facility.categoryName}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <%-- 지도 --%>
    <div class="right"><div class="map" id="${camp.y}/${camp.x}"></div></div>
</section>
<c:import url="/footer"/>
<script src="../../script/camp/campDetail.js"></script>
<script src="../../script/weatherAPI.js"></script>
</body>
</html>