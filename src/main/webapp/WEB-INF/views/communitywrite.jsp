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
    <form action="/community/add">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td><input type="textarea" id="content" name="content" placeholder="글을 작성해주세요."></td>
            </tr>
        </table>
        <input type="button" id="addwrite" value="등록" onclick="communityWrite(form)">
        <button onclick="location.href='/community'">작성취소</button>
        <sciprt src="/script/communityWrite.js"></sciprt>
    </form>
</section>
</body>
</html>