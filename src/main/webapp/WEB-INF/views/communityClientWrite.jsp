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
    <c:import url="header.jsp"/>
<%--    <link rel="stylesheet" href="style/communityClientWrite.css">--%>
    <link rel="stylesheet" href="style/communityOwnerWrite.css">
</head>
<body>
<section>
    <form>
        <table>
            <tr>
                <td id="nickname" name="nickname" value="${sessionScope.log.clientNickname}">${sessionScope.log.clientNickname}</td>
            </tr>
            <tr>
                <td>
                    <select id="category" name="category">
                        <option value="">카테고리</option>
                        <option value="CC100002">리뷰</option>
                        <option value="CC100003">질문</option>
                        <option value="CC100004">자유게시판</option>
                        <option value="CC100005">캠핑팁</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td colspan="2"><textarea id="content" name="content" placeholder="[고객] 내용 작성]"></textarea>
            </tr>
            <tr>
                <td><input type="button" value="등록" onclick="clientWrite(form)"></td>
                <td><input type="button" value="작성취소" onclick="location.href='community'"></td>
            </tr>
        </table>
    </form>
</section>
<script src="/script/clientWriteCheck.js"></script>
</body>
</html>

