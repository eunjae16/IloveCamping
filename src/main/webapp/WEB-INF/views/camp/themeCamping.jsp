<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>캠핑</title>
</head>
<body>
<h1>캠핑 테마</h1>
<table>
    <thead>
    <tr>
        <th>캠핑장 이름</th>
        <th>캠핑장 이미지</th>
        <th>전화번호</th>
        <th>테마</th>
        <th>캠핑장 주소</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theme" items="${campingThemes}">
        <tr>
            <td>${theme.campName}</td>
            <td><img src="${theme.campImage}"></td>
            <td>${theme.campPhone}</td>
            <td>${theme.themeName}</td>
            <td>${theme.campAddress}</td>
            <form method="POST" action="/get/campinfo">
                <input type="hidden" name="campCode" id="campCode" value="${theme.campCode}"</td>
                <input type="submit" value="예약">
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
