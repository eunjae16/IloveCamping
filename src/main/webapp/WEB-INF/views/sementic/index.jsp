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
        <form method="GET" action="/camp/search">
            <select id="region" name="region">
                <option value="" selected>전체보기</option>
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
            <input type="text" name="content" placeholder="검색어를 입력해 주세요." id="searchBox">
            <button id="btnSearch"><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i></button>
        </form>
    </div>
    <div id="percent"></div>
</section>
<c:import url="/footer"/>
<script src="/script/index.js"></script>
</body>
</html>
