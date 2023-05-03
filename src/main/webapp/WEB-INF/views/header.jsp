<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>I♡CAMPING</title>
    <link rel="stylesheet" href="style/header.css">
</head>
<body>
<header>
    <div class="wrap">
        <nav class="header-wrap">
            <div class="logo">
                <h1><a href="/">I♡CAMPING</a></h1>
            </div>
            <ul class="menu">
                <li><a href="/">전체</a></li>
                <li><a href="/">캠핑</a></li>
                <li><a href="/">글램핑/카라반</a></li>
                <li><a href="/">검색</a></li>
                <li><a href="/community">캠핑 이야기</a></li>
            </ul>
            <ul>
                <c:if test="${sessionScope.usertype eq 'owner'}">
                    <li><a href="/mypageowner">내 정보</a></li>
                </c:if>
                <c:if test="${sessionScope.usertype eq 'client'}">
                    <li><a href="/mypageclient">내 정보</a></li>
                </c:if>
                <c:if test="${empty sessionScope.log}">
                    <li><a href="/login">로그인</a></li>
                    <li><a href="/regist">회원가입</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.log}">
                    <li><a id="logoutBtn">로그아웃</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</header>

<script src="script/logout.js"></script>
</body>
</html>