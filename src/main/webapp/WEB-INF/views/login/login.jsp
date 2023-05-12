<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>
<section>
<h2>로그인</h2>
<h3>회원 유형을 선택 후 로그인을 진행해 주세요.</h3>
<div class="login-choice">
    <button type="button" onclick="location.href='<c:url value='/clientlogin'/>'">일반유저 로그인</button>
    <button type="button" onclick="location.href='<c:url value='/ownerlogin'/>'">사업자 로그인</button>
</div>
</section>
<c:import url="/footer"/>
</body>
</html>