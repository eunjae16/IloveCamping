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
    <c:if test="${not empty camp}">
        <h2>${camp.campName}</h2>
        <p>${camp.campAddress1} ${camp.campAddress2}</p>
        <img src="${camp.campImage}" alt="campsite-image">
        <p>${camp.campInfo}</p>
    </c:if>
    <div>
        <h2>지역 선택</h2>
        <select id="selectSite" name="selectSite" required onchange="searchCamp()">
            <option value="none" selected hidden>선택</option>
            <option value="viewAll">전체보기</option>
            <option value="서울">서울</option>
            <option value="경기">경기도</option>
            <option value="강원">강원도</option>
            <option value="충북">충청북도</option>
            <option value="충남">충청남도</option>
            <option value="전북">전라북도</option>
            <option value="전남">전라남도</option>
            <option value="경북">경상북도</option>
            <option value="경남">경상남도</option>
        </select>

        <div id="campList"> <!-- 캠핑장 목록을 표시 -->

        </div>
        <div>
            <%-- 지도 담는 영역--%>
            <h2>지도에용</h2>
            <div id="map" >
            </div>
        </div>
    </div>
</section>
</div>
</section>
<c:import url="/footer"/>
<%--<script src="script/viewCampsite.js"></script>--%>
<script src="script/camp/map.js"></script>
</body>
</html>