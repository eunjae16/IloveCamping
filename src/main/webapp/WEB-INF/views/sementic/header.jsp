<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="shortcut icon" href="../image/favicon.png">
    <meta property="og:title" content="iLuvCamping">
    <meta property="og:description" content="캠핑예약사이트">
    <meta property="og:image" content="https://post-phinf.pstatic.net/MjAyMDA3MDhfMjc1/MDAxNTk0MTczMjk3NTgx.HESbIHOx_nRR3cT1T29So3kiJ1CmYoZuI49Z9lF7Oj4g.JagQP2wpFGiKi5PyJOmMgbZo_nu-gg3oHV6Q3Nv5B34g.JPEG/%EC%97%B0%EA%B3%A1%EC%86%94%ED%96%A5%EA%B8%B0%EC%BA%A0%ED%95%91%EC%9E%A5_1.jpg?type=w1200">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>I♡CAMPING</title>
    <link rel="stylesheet" href="../../style/sementic/header.css">
    <script src="../../script/menu.js" defer></script>
    <script src="https://kit.fontawesome.com/412ff5bbec.js" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <div class="wrap">
        <nav class="header-wrap">
            <div class="logo">
                <h1><a href="/">I♡CAMPING</a></h1>
            </div>
            <ul class="menu">
                <li><a href="/camplist">전체</a></li>
                <li><a href="/selectcamping">캠핑</a></li>
                <li><a href="/selectglampingandcaravan">글램핑/카라반</a></li>
                <li><a href="/community">캠핑 이야기</a></li>
            </ul>
            <ul class="side-menu">
                <c:if test="${sessionScope.usertype eq 'owner'}">
                    <li><a href="/mypageowner">마이페이지</a></li>
                </c:if>
                <c:if test="${sessionScope.usertype eq 'client'}">
                    <li><a href="/mypageclient">마이페이지</a></li>
                </c:if>
                <c:if test="${empty sessionScope.log}">
                    <li><a href="/login">로그인</a></li>
                    <li><a href="/regist">회원가입</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.log}">
                    <li><a id="logoutBtn">로그아웃</a></li>
                </c:if>
            </ul>
            <a href="#" class="navbar-toggleBtn">
                <i class="fa-solid fa-bars" style="color: #ffffff;"></i>
            </a>
        </nav>
    </div>
</header>

<script src="../../script/logout.js"></script>
</body>
</html>