<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/communitywrite.css">
</head>
<body>
<section>
    <form action="/community/write" method="POST">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="textarea" id="content" name="content" placeholder="글을 작성해 주세요."></td>
            </tr>
            <tr>
                <td><input type="submit" id="addwrite" value="등록" onclick="communityWrite(form)"></td>
                <td><input type="button" value="작성취소" onclick="location.href='community'"></td>
            </tr>
        </table>
    </form>
</section>
<sciprt src="/script/communityWrite.js"></sciprt>
</body>
</html>
