<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/11/23
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>인덱스>검색결과 페이지 </title>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/map.css">
</head>
<body>
  <section>
    <table>
        <tr>
<%--            <p>empty result : ${empty result} ${result.size()}</p>--%>
    <c:forEach var="camp" items="${result}">
        <div>
            <img src="${camp.campImage}">
            <p>${camp.campName}</p>
            <p>${camp.campAddress1}</p>
        </div>

    </c:forEach>

        </tr>
    </table>
  </section>
</body>
<c:import url="/footer"/>
</html>
