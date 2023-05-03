<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/joinSuccess.css">
<script src="https://tistory4.daumcdn.net/tistory/3134841/skin/images/confetti_v2.js"></script>
<body>
<div class="success-box">
    <h2>회원가입을 축하합니다!</h2>
</div>
<div class="buttonContainer">
    <button class="canvasBtn" id="stopButton">그만!</button>
    <button class="canvasBtn" id="startButton">한 번 더!</button>
</div>
<canvas id="canvas"></canvas>
<c:import url="footer.jsp"/>
<script type="text/javascript" src="script/joinSuccess.js"></script>
</body>
</html>