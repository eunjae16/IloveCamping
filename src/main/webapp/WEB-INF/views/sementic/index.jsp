<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="../image/favicon.png">

    <meta property="og:title" content="iLuvCamping">
    <meta property="og:description" content="캠핑예약사이트">
    <meta property="og:image" content="https://post-phinf.pstatic.net/MjAyMDA3MDhfMjc1/MDAxNTk0MTczMjk3NTgx.HESbIHOx_nRR3cT1T29So3kiJ1CmYoZuI49Z9lF7Oj4g.JagQP2wpFGiKi5PyJOmMgbZo_nu-gg3oHV6Q3Nv5B34g.JPEG/%EC%97%B0%EA%B3%A1%EC%86%94%ED%96%A5%EA%B8%B0%EC%BA%A0%ED%95%91%EC%9E%A5_1.jpg?type=w1200">
    <c:import url="/header"/>
    <link rel="stylesheet" href="../style/index.css">
    <script src="https://kit.fontawesome.com/412ff5bbec.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<section>
    <div id="percent"></div>
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
</section>
<c:import url="/footer"/>
<script src="/script/index.js"></script>
</body>
</html>
