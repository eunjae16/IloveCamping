<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/index.css">
    <script src="https://kit.fontawesome.com/412ff5bbec.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<section>
    <div class="index-bg"></div>
    <div class="search-box">
        <p>오늘은 어디로 갈까?</p>
        <select>
            <option selected>지역</option>
        </select>
        <input type="text" placeholder="검색어를 입력해 주세요." id="searchBox">
        <button type="button" id="btnSearch"><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></button>
    </div>
</section>
<c:import url="/footer"/>
<script src="/script/index.js"></script>
</body>
</html>