<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 클릭했어용</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
<section>
    <h4>커뮤니티</h4>
    <table>
        <tr>
            <td>${community.writeCode}</td>
        </tr>
        <tr>
            <td>${community.title}</td>
        </tr>
        <tr>
            <td>${community.writerNickname}</td>
            <td>${community.registeredDate}</td>
        </tr>
        <tr>
            <td><p>
                ${sessionse.log.usertype} / ${session.log.clientNickname}
            </p>
            </td>
        </tr>
    </table>
    <div>
        <input type="button" value="글목록" onclick="location.href='community'">

<c:choose>
    <c:when test="${session.log.usertype == 'owner' && session.log.ownerNickname == community.writerNickname}">
        <input type="button" value="수정" onclick="location.href='community/edit?writeCode=${community.writeCode}'">
        <input type="button" value="삭제" onclick="location.href='community/delete?writeCode=${community.writeCode}'">
    </c:when>
        <c:when test="${session.log.usertype == 'client' && session.log.clientNickname == community.writerNickname}">
        <input type="button" value="수정" onclick="location.href='community/edit?writeCode=${community.writeCode}'">
        <input type="button" value="삭제" onclick="location.href='community/delete?writeCode=${community.writeCode}'">
        </c:when>
        <c:when test="${session.log.usertype == 'admin' && session.log.adminNickname == community.writerNickname}">
        <input type="button" value="수정" onclick="location.href='community/edit?writeCode=${community.writeCode}'">
        <input type="button" value="삭제" onclick="location.href='community/delete?writeCode=${community.writeCode}'">
        </c:when>

        </c:choose>


        <table>
            <tr>
                <th>댓글</th>
            </tr>
            <tr>
                <td><input type="textarea"></td>
                <td><input type="submit" value="저장"></td>
            </tr>
        </table>
</section>
</body>
</html>
