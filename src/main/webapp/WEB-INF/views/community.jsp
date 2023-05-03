<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/community.css">
</head>
<body>
<section>
    <div class="community-bg"><h2>캠핑 이야기</h2></div>
    <table>
        <tr>
            <th>작성자코드</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>등록일</th>
        </tr>
    </table>
    <div>
        <input type="button" value="글쓰기" onclick="location.href='communitywrite'">
    </div>
</section>
<script src="script/community.js"></script>
<c:import url="/footer"/>
</body>
</html>