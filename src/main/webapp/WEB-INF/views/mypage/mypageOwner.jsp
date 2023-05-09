<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-02
  Time: 오후 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/mypageOwner.css">
</head>
<body>

<c:if test="${empty usertype}">
    <c:redirect url="/login"></c:redirect>
</c:if>
<c:if test="${usertype eq 'client'}">
    <c:redirect url="/error"></c:redirect>
</c:if>

<section>
    <div class="mypage-box">
        <h2>${sessionScope.log.ownerNickname}님의 마이페이지</h2>
        <div>
            <button onclick="location.href='ownerSales'">매출 통계</button>
            <button onclick="location.href='ownerCampRegist'">캠핑장 등록</button>
            <button onclick="location.href='modifyowner'">회원정보 수정</button>
            <input type="hidden" id="ownerCode" value="${sessionScope.log.ownerCode}">
            <input type="button" onclick="leaveOwner()" value="탈퇴하기">
        </div>
    </div>
</section>
<c:import url="/footer"/>
<script src="/script/mypage/mypage.js"></script>
</body>
</html>
