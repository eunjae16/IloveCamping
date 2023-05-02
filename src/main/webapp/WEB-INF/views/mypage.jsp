<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mypage</title>
</head>
<body>

<!--
 1. 내 정보 출력
 2. 회원정보 수정
 3. 회원탈퇴
 -->

<div>
    <c:if test="${usertype eq 'client'}"></c:if>
    <h2>${sessionScope.log.}</h2>

</div>



</body>
</html>