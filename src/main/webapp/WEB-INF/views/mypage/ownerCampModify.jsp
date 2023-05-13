<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/12/23
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="../../style/mypageOwner.css">
</head>
<body>
  <section>
      <div>
        <c:if test="${empty campList}">
            <div>
                <p>캠핑장 목록이 비어 있어요 .. </p>
            </div>
        </c:if>
          <c:if test="${!empty campList}">
              <div>
                  <c:forEach var="camp" items="${campList}">
                      <input type="hidden" id="campOwner" value="${camp.campOwner}">
                      <img src="${camp.campImage}">
                      <p id="campName-${camp.campName}">${camp.campName}</p>
                      <%--                   수정내용 입력할 박스--%>
                      <textarea id="edit-campName-${camp.campName}" style="display: none;"></textarea>
                      <p>${camp.campAddress1}</p>
                      <input type="button" value="캠핑사이트추가">
                      <input type="button" id="editname" name="editname" value="이름변경" onclick="editName('${camp.campCode}', '${camp.campName}')">
                      <input type="button" value="폐업신청">
                  </c:forEach>
              </div>
          </c:if>
      </div>
  </section>
  <c:import url="/footer"/>
  <script src="/script/camp/editCampName.js"></script>
</body>
</html>
