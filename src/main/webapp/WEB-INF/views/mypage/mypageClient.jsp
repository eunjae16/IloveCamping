<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/mypageClient.css">
</head>
<body>

<!--
 1. 내 정보 출력
 2. 회원정보 수정
 3. 회원탈퇴
 -->

<div class="mypage-box">
    <h2>${sessionScope.log.clientNickname}님의 마이페이지</h2>
    <div>
        <button onclick="location.href='modifyclient'">회원정보 수정</button>
        <input type="button" onclick="leave()" value="탈퇴하기">
        <input type="hidden" id="clientCode" value="${sessionScope.log.clientCode}">
    </div>
</div>
<c:import url="/footer"/>
<script src="/script/mypage.js"></script>
</body>
</html>