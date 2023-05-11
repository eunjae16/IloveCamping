<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-09
  Time: 오후 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/map.css">
</head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5670ccd025e23c03c5a4887d46695c55&libraries=services,clusterer,drawing"></script>
<body>
<section>
    <div class="left"><div id="camp-card"></div></div>
    <%-- 지도 --%>
    <div class="right"><div id="map"></div></div>
</section>
<script src="script/camp/campList.js"></script>
<script src="script/camp/map.js"></script>
</body>
<c:import url="/footer"/>
</html>

