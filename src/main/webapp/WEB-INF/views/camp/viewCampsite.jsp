<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/viewCampsite.css">
    <link rel="stylesheet" href="style/map.css">
</head>
<body>
<section>
    <div class="campList">
        <c:forEach var="camp" items="${campList}">
            <div class="campItem">

            </div>
        </c:forEach>
    </div>
</section>

<c:import url="../sementic/footer.jsp"/>
<script src="/script/map.js"></script>
<script src="/script/viewCampsite.js"></script>
</body>
</html>
