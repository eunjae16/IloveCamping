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
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/campDetailPage.css">
</head>
<body>
<%--<c:if test="${empty camp}">--%>
<%--    <c:redirect url="/"></c:redirect>--%>
<%--</c:if>--%>

<section>
    <div>
        <h3>${camp.campName}</h3>
    </div>
    <div>
        <p>${camp.campAddress1}</p>
        <p>${camp.campPhone}</p>
    </div>
    <div>
        <a id="go-review">리뷰 보러가기!</a>
    </div>
    <div id="map">
        <p>여기는 지도입니당 // 뽀독이가 할거에용</p>
    </div>
    <div>
        <div id="theme">테마</div>
        <div id="theme-detail">테마 상세</div>
        <div id="surround">주변</div>
        <div id="surround-detail">주변 상세</div>
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
            <div id="facilities-list">
                <img src="">
                <p id="facility-name"></p>
            </div>
        </div>
    </div>
</section>
</body>
<c:import url="/footer"/>
</html>
