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
            <td>${community.content}</td>
        </tr>

    </table>
    <div>
        <input type="button" value="글목록" onclick="location.href='community'">
        <input type="hidden" id="writeCode" value="${community.writeCode}">

    <c:choose>
    <c:when test="${sessionScope.usertype eq 'owner' && sessionScope.log.ownerNickname eq community.writerNickname}">
        <input type="button" value="수정" onclick="location.href='/community/editowner?writeCode=${community.writeCode}'">
           <input type="button" value="삭제" onclick="deleteWrite()">
     </c:when>
        <c:when test="${sessionScope.usertype eq 'client' && sessionScope.log.clientNickname eq community.writerNickname}">
            <input type="button" value="수정" onclick="location.href='/community/editclient?writeCode=${community.writeCode}'">
            <input type="button" value="삭제" onclick="deleteWrite()">
        </c:when>
        <c:when test="${sessionScope.usertype eq 'admin' && sessionScope.log.adminNickname eq community.writerNickname}">
             <input type="button" value="수정" onclick="location.href='community/edit?writeCode=${community.writeCode}'">
            <input type="button" value="삭제" onclick="deleteWrite()">
        </c:when>
        </c:choose>
    </div>



<%--    댓글작성폼 --%>
    <c:if test="${empty sessionScope}">
        <input type="text" placeholder="로그인 후 작성가능합니다." readonly>
    </c:if>
    <c:if test="${!empty sessionScope}">
        <form id="comment">
            <input type="hidden" id="writeCode" value="${community.writeCode}">
            <c:choose>
                <c:when test="${sessionScope.usertype eq 'owner'}">
                    <input type="hidden" id="nickname" value="${sessionScope.log.ownerNickname}" placeholder="작성자">
                </c:when>
                <c:when test="${sessionScope.usertype eq 'client'}">t 69ok6
                    <input type="hidden" id="nickname" value="${sessionScope.log.clientNickname}" placeholder="작성자">
                </c:when>
                <c:when test="${sessionScope.usertype eq 'admin'}">
                    <input type="hidden" id="nickname" value="${sessionScope.log.adminNickname}" placeholder="작성자">
                </c:when>
            </c:choose>
            <input typ="text" id="replyContent" placeholder="댓글내용">
            <input type="submit" value="등록" onclick="replyWrite(form)">
        </form>

<%--    댓글 리스트--%>
    <div id="replyList">

    </div>
</section>
<script src="/script/community/deleteWrite.js"></script>
<script src="/script/community/replyWrite.js"></script>
</body>
</html>
