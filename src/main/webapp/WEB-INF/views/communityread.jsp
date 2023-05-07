<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시글 상세페이지</title>
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


    <%-- 댓글 작성 --%>
    <div id="reply-write">
        <c:if test="${empty sessionScope}">
            <input type="text" placeholder="로그인 후 작성가능합니다." readonly>
        </c:if>
        <c:if test="${!empty sessionScope}">
            <input type="hidden" id="replywriter"
                   value="${sessionScope.usertype eq 'client' ? sessionScope.log.clientNickname
                   : sessionScope.usertype eq 'owner' ? sessionScope.log.ownerNickname
                   : sessionScope.log.adminNickname}">
            <input type="text" id="replycontent" placeholder="댓글내용">
            <button id="reply-btn" onclick="replyWrite()">등록</button>
        </c:if>
    </div>

    <%-- 댓글 리스트 --%>
    <table>
        <c:forEach var="reply" items="${reply}">
        <tr>
            <input type="hidden" id="replyCode" value="${reply.replyCode}">
            <td>${reply.replierNickname}</td>
            <td>
                <span id="comment-${reply.replyCode}">${reply.comment}</span>
                <textarea id="edit-comment-${reply.replyCode}" style="display: none;"></textarea>
            </td>
            <c:if test="${reply.modifiedCheck}">
                <td>[수정됨]</td>
            </c:if>
            <c:if test="${!reply.modifiedCheck}">
            <td></td>
            </c:if>
            <td>${reply.registeredDate}</td>
            <c:choose>
                <c:when test="${sessionScope.usertype eq 'owner' && sessionScope.log.ownerNickname eq reply.replierNickname}">
                    <td><input type="button" value="수정" onclick="editReply('${reply.replyCode}', '${reply.comment}')"></td>
                    <td><input type="button" value="삭제" onclick="deleteReply('${reply.replyCode}')"></td>
                </c:when>
                <c:when test="${sessionScope.usertype eq 'client' && sessionScope.log.clientNickname eq reply.replierNickname}">
                    <td><input type="button" value="수정" onclick="editReply('${reply.replyCode}', '${reply.comment}')"></td>
                    <td><input type="button" value="삭제" onclick="deleteReply('${reply.replyCode}')"></td>
                </c:when>
                <c:when test="${sessionScope.usertype eq 'admin' && sessionScope.log.adminNickname eq reply.replierNickname}">
                    <td><input type="button" value="수정" onclick="editReply('${reply.replyCode}', '${reply.comment}')"></td>
                    <td><input type="button" value="삭제" onclick="deleteReply('${reply.replyCode}')"></td>
                </c:when>
            </c:choose>
        </tr>
        </c:forEach>
    </table>

</section>
<script src="/script/community/deleteWrite.js"></script>
<script src="/script/community/replyWrite.js"></script>
<script src="/script/community/editReply.js"></script>
<script src="/script/community/deleteReply.js"></script>
</body>
</html>
