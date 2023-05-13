<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/12/23
  Time: 2:37 PM
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
                      <img src="${camp.campImage}">
                      <p>${camp.campName}</p>
                      <p>${camp.campAddress1}</p>
                      <input type="button" value="캠핑사이트추가">
                      <input type="button" value="이름변경" onclick="editName('${campList.campName}', '${cmapList.campCode}')">
                      <input id="edit-siteName-${campList.campName}" stype="display: none">
                      <input type="button" value="폐업신청">
                  </c:forEach>
              </div>
          </c:if>
      </div>
  </section>
  <script src="/script/camp/editCampName.js"></script>
  <c:import url="/footer"/>
</body>
</html>
