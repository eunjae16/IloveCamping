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
  <link rel="stylesheet" href="../../style/bookingList.css">
</head>
<body>
<section>
  <c:if test="${empty bookingList}">
    <p>예약리스트가 비어있어요.</p>
  </c:if>
  <c:if test="${not empty bookingList}">
    <table>
      <thead>
      <tr>
        <th colspan="4">예약정보</th>
        <th>예약일정</th>
        <th>결제금액</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${bookingList}" var="list" varStatus="status">
        <c:set var="camp" value="${campList[status.index]}"/>
        <c:set var="campSite" value="${siteList[status.index]}"/>
        <tr>
          <td>예약번호: ${list.bookingCode}</td>
          <td><img src="${camp.campImage}"></td>
          <td>${camp.campName}</td>
          <td>${campSite.siteName}</td>
          <td>${list.startDate.substring(0,11)} ~  ${list.endDate.substring(0,11)}</td>
          <td>${list.totalPrice}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</section>
</body>
</html>
