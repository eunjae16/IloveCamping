<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="../sementic/header.jsp"/>
<link rel="stylesheet" href="style/ownerSales.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<section>
    <h3>매출 통계</h3>
    <div class="container" id="${log.ownerCode}">
        <div class="button-container">
            <button type="button" id="btn">월별 매출</button>
            <button type="button" id="btn2">일별 매출</button>
        </div>
        <div id="column_chart_div1" style="width: 900px; height: 500px;"></div>
    </div>
</section>
<script src="script/mypage/ownerSales.js"></script>
<c:import url="../sementic/footer.jsp"/>
</body>
</html>