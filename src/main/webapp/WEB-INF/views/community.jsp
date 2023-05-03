<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>커뮤니티</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
<section>
    <h4>커뮤니티</h4>
    <table>
        <tr>
            <th>작성자코드</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>등록일</th>
        </tr>
    </table>
    <div>
        <c:choose>
            <c:when test="${sessionScope.usertype eq 'owner'}">
                <input type="button" value="글쓰기" onclick="location.href='communityownerwrite'">
            </c:when>
            <c:when test="${sessionScope.usertype eq 'client'}">
                <input type="button" value="글쓰기" onclick="location.href='communityclientwrite'">
            </c:when>
            <c:otherwise>
                <input type="button" value="글쓰기" onclick="location.href='communityadmintwrite'">
            </c:otherwise>
        </c:choose>

    </div>
</section>
<script src="script/community.js"></script>
</body>
</html>