<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-15
  Time: 오전 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <c:import url="../sementic/header.jsp"/>
  <link rel="stylesheet" href="style/settingCampOptions.css">
</head>
<body>
<section>
  <h1>상세설정</h1>
  <table>
    <tr>
      <th>캠프 카테고리 [다중선택 가능]</th>
      <td>
        <c:forEach var="facility" items="${facilityCategoryList}">
          <label>
            <img src="${facility.facilityImgUrl}" alt="${facility.categoryName}">
            <input type="checkbox" value="${facility.categoryCode}">
              ${facility.categoryName}
          </label>
        </c:forEach>
      </td>
    </tr>
    <tr>
      <th>주변 환경</th>
      <td>
        <select>
          <c:if test="${not empty surroundCategoryList}">
            <c:forEach items="${surroundCategoryList}" var="surround">
              <option class="surroundCategory" value="${surround.surroundCategoryCode}">${surround.surroundCategoryName}</option>
            </c:forEach>
          </c:if>
        </select>
      </td>
    </tr>
  </table>
</section>
<c:import url="../sementic/footer.jsp"/>
</body>
</html>