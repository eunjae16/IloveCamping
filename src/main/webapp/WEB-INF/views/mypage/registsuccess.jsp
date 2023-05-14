<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="../sementic/header.jsp"/>
<link rel="stylesheet" href="style/joinSuccess.css">
<script src="https://tistory4.daumcdn.net/tistory/3134841/skin/images/confetti_v2.js"></script>
<body>
<section>
  <c:if test="${empty log}">
    <c:redirect url="/"></c:redirect>
  </c:if>
  <c:if test="${usertype eq 'client'}">
    <c:redirect url="/"></c:redirect>
  </c:if>

  <div class="success-box">
    <h2>캠핑장 등록이 완료되었습니다!</h2>
  </div>
  <div class="buttonContainer">
    <button class="canvasBtn" id="stopButton">그만!</button>
    <button class="canvasBtn" id="startButton">한 번 더!</button>
  </div>
  <canvas id="canvas"></canvas>
</section>
<c:import url="../sementic/footer.jsp"/>
<script type="text/javascript" src="script/joinSuccess.js"></script>
</body>
</html>