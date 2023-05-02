<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/joinSuccess.css">
<script src="https://tistory4.daumcdn.net/tistory/3134841/skin/images/confetti_v2.js"></script>
<body>
<div class="rainbow">
    <h2>회원가입을 축하합니다!</h2>
    <c:if test="${logtype eq 'client'}"><a href="/">예약하러 가기!</a></c:if>
    <c:if test="${logtype eq 'owner'}"><a href="/">캠핑장 등록하러 가기!</a></c:if>
</div>
<div class="success-box">
    <h2>회원가입을 축하합니다!</h2>
    <a href="<c:url value='/'/>">예약하러 가기!</a>
</div>
<div class="buttonContainer">
    <button class="canvasBtn" id="stopButton">한 번 더!</button>
    <button class="canvasBtn" id="startButton">그만!</button>
</div>
<canvas id="canvas"></canvas>
<c:import url="footer.jsp"/>
<script type="text/javascript" src="script/joinSuccess.js"></script>
</body>
</html>