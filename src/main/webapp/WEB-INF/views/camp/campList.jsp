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
    <div class="left"><div id="camp-card"></div></div>
    <%-- 지도 --%>
    <div class="right"><div id="map"></div></div>
</section>
<c:import url="/footer"/>
<script src="script/camp/campList.js"></script>
<script src="script/camp/map.js"></script>
</body>
</html>

