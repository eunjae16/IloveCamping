<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <c:import url="../sementic/header.jsp"/>
        <link rel="stylesheet" href="style/viewCampsite.css">
        <link rel="stylesheet" href="style/map.css">
    </head>
<%--    js key 넣어줌 --%>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5670ccd025e23c03c5a4887d46695c55&libraries=services,clusterer,drawing"></script>
    <body>
    <section>
    <div id="camplist">
        <c:if test="${not empty camp}">
            <h2>${camp.campName}</h2>
            <p>${camp.campAddress1} ${camp.campAddress2}</p>
            <img src="${camp.campImage}" alt="campsite-image">
            <p>${camp.campInfo}</p>
        </c:if>
    </div>
    </section>
    <c:import url="/footer"/>
    <script src="script/viewCampsite.js"></script>
    <script src="script/camp/map.js"></script>
    </body>
    </html>
