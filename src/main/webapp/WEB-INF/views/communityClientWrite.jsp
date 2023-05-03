<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/3/23
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>글 작성하기</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
<section>
    <form action="/community/clientwrite" method="POST">
        <table>
            <tr>
                <td>
                    <select id="category" name="category">
                        <option value=""></option>
                        <option value="CC100002">리뷰</option>
                        <option value="CC100003">질문</option>
                        <option value="CC100004">자유게시판</option>
                        <option value="CC100005">캠핑팁</option>
                    </select>
                </td>
                <td>작성자 : </td>
                <td id="nickname" name="nickname" value="${sessionScope.log.clientNickname}">${sessionScope.log.clientNickname}</td>
            </tr>
            <tr>
                <td><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td><textarea id="content" name="content" placeholder="클라이언트페이지에요."></textarea>
            </tr>
        </table>
        <input type="button" id="addwrite" value="등록" onclick="communityWrite(form)">
        <input type="button" value="작성취소" onclick="location.href='community'">
    </form>
</section>
<script src="/script/communityWrite.js"></script>
</body>
</html>

