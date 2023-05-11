<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>캠핑</title>
</head>
<body>
<h1>캠핑 테마</h1>
<table>
    <thead>
    <tr>
        <th>캠핑장 코드</th>
        <th>캠핑장 이름</th>
        <th>캠핑장 이미지</th>
        <th>캠핑장 전화번호</th>
        <th>테마</th>
        <th>캠핑장 주소</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theme" items="${campingThemes}">
        <tr>
            <td>${theme.campCode}</td>
            <td>${theme.campName}</td>
            <td>${theme.campImage}</td>
            <td>${theme.campPhone}</td>
            <td>${theme.themeName}</td>
            <td>${theme.campAddress}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
