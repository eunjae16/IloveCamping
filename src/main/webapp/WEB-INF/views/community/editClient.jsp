<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/5/23
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>[고객] 글수정하기</title>
</head>
<c:import url="../sementic/header.jsp"/>
<link rel="stylesheet" href="../style/header.css">
<link rel="stylesheet" href="../style/communityOwnerWrite.css">

<body>
<section>
    <form>
        <table>
            <input type="hidden" id="writeCode" name="writeCode" value="${community.writeCode}"></td>
            <tr>
            <tr>
                <td>
                    <select id="category" name="category" value="${community.writeCategoryCode}">
                        <option value="" ${community.writeCategoryCode == '' ? 'selected="selected"' : ''}>카테고리</option>
                        <option value="CC100003" ${community.writeCategoryCode == 'CC100003' ? 'selected="selected"' : ''}>질문</option>
                        <option value="CC100004" ${community.writeCategoryCode == 'CC100004' ? 'selected="selected"' : ''}>자유게시판</option>
                        <option value="CC100005" ${community.writeCategoryCode == 'CC100005' ? 'selected="selected"' : ''}>캠핑팁</option>
                    </select>
                </td>
            </tr>
            </tr>
            <tr>
                <td id="nickname" name="nickname" value="${sessionScope.log.clientNickname}">${sessionScope.log.clientNickname}</td>
            </tr>
            <tr>
                <td><textarea type="text" id="title" name="title">${community.title}
                </textarea>
                </td>
            </tr>
            <tr>
                <td><textarea id="content" name="content">${community.content}
                </textarea>
            </tr>
        </table>
        <input type="button" value="등록" onclick="updateCheck(form)">
        <input type="button" value="수정취소" onclick="location.href='../community'">
    </form>
</section>
<script src="/script/community/updateCheck.js"></script>
</body>
</html>
