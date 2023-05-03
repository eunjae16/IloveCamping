<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 작성하기</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
<section>
    <form action="/community/write" method="POST">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td><textarea id="content" name="content" placeholder="오너페이지에요."></textarea>
            </tr>
        </table>
        <input type="button" id="addwrite" value="등록" onclick="communityWrite(form)">
        <input type="button" value="작성취소" onclick="location.href='community'">
    </form>
</section>
<sciprt src="/script/communityWrite.js"></sciprt>
</body>
</html>