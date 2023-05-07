<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/community.css">
</head>
<body>
    <div class="community-bg"><h2>캠핑이야기</h2></div>
<section>
    <table id="notice">
        <tr>
            <th></th>
            <th></th>
            <th>공지사항</th>
            <th>닉네임</th>
            <th>등록일</th>
        </tr>
    </table>
    <table id="list">
        <tr>
            <th></th>
            <th>카테고리</th>
            <th>제목</th>
            <th>닉네임</th>
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
            <c:when test="${sessionScope.admin eq 'admin'}">
                <input type="button" value="글쓰기" onclick="location.href='communityadmintwrite'">
            </c:when>
            <c:when test="${empty sessionScope}">
                <input type="button" value="로그인 후 작성가능" onclick="location.href='#'">
            </c:when>
        </c:choose>

    </div>
</section>
<script src="script/community.js"></script>
<c:import url="/footer"/>
</body>
</html>