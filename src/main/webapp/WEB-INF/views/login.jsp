<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <title>login</title>
</head>
<body>
<h1>로그인하기</h1>
<div class="regist-choice">
    <button type="button" onclick="location.href='<c:url value='/clientlogin'/>'">일반유저 로그인</button>
    <button type="button" onclick="location.href='<c:url value='/ownerlogin'/>'">사업자 로그인</button>
</div>

<c:import url="/footer"/>
</body>
</html>