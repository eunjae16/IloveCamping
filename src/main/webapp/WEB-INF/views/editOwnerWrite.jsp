<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/3/23
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>[업체] 글수정하기</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
    <section>
        <form>
            <table>
                <td><input type="hidden" id="writeCode" name="writeCode" value="${community.writeCode}">${community.writeCode}</td>
                <tr>
                    <td>
                        <select id="category" name="category">
                            <option value="">카테고리선택</option>
                            <option value="CC100003">질문</option>
                            <option value="CC100004">자유게시판</option>
                            <option value="CC100005">캠핑팁</option>
                        </select>
                    </td>
                    <td>작성자 : </td>
                    <td id="nickname" name="nickname" value="${sessionScope.log.ownerNickname}">${sessionScope.log.ownerNickname}</td>
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
            <input type="button" value="수정취소" onclick="location.href='community'">
        </form>
    </section>
<script src="/script/communityUpdate.js"></script>
</body>
</html>
