<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/14/23
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <c:import url="../sementic/header.jsp"/>
</head>
<body>
  <c:if test="${empty list}">
      <p>예약리스트가 비어있어요.</p>
  </c:if>
  <section>
    <c:if test="${not empty list}"></c:if>
    <table>
      <thead>
      <tr>
        <th colspan="4">예약정보</th>
        <th>예약일정</th>
        <th>결제금액</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="list">
        <tr>
          <td>예약번호: ${list.bookingCode}</td>
          <td>${list.campImage}</td>
          <td>${list.campName}</td>
          <td>${list.siteName}</td>
          <td>${list.startDate} ~  ${list.endDate}</td>
          <td>${list.totalPrice}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</body>
</html>
