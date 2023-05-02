<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/ownerSales.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<body>
<section>
    <h3>매출 현황</h3>
    <div class="tab">
        <ul class="tabnav">
            <li><a href="#">일별</a></li>
            <li><a href="#">월별</a></li>
        </ul>
        <div class="tabcontent">
            <div id="tab01"><div id="columnchart_material" style="width: 900px; height: 300px;"></div></div>
            <div id="tab02"></div>
        </div>
    </div>
</section>
<script type="text/javascript" src="script/ownerSales.js"></script>
<c:import url="footer.jsp"/>
</body>
</html>