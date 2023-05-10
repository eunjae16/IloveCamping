<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/viewCampsite.css">
    <link rel="stylesheet" href="style/map.css">
</head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5670ccd025e23c03c5a4887d46695c55&libraries=services,clusterer,drawing"></script>
<body>
<section>
    <div class="campList">

    </div>
</section>

<c:import url="../sementic/footer.jsp"/>
<script src="map.js"></script>
</body>
</html>