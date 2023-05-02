<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/regist.css">
</head>
<body>

<h2>회원가입</h2>
<h3>회원 유형을 선택 후 회원가입을 진행해 주세요.</h3>
<div class="regist-choice">
    <button type="button" onclick="location.href='<c:url value='/clientregister'/>'">일반유저 회원가입</button>
    <button type="button" onclick="location.href='<c:url value='/ownerregister'/>'">사업자 회원가입</button>
    <ul>
        <li><a href="clientregister">일반유저 회원가입</a></li>
        <li><a href="ownerregister">사업자 회원가입</a></li>
    </ul>
</div>

<c:import url="/footer"/>

</body>
</html>