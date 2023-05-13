
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/ownerCampModify.css">
    <link rel="stylesheet" href="../../style/mypageOwner.css">
</head>
<body>
<section>
    <div>
        <c:if test="${empty campList}">
            <div>
                <p>캠핑장 목록이 비어 있어요...</p>
            </div>
        </c:if>
        <c:if test="${!empty campList}">
            <div>
                <c:forEach var="camp" items="${campList}">
                    <img src="${camp.campImage}">
                    <p>${camp.campName}</p>
                    <p>${camp.campAddress1}</p>
                    <form method="POST" action="/campsite/registcampcode">
                        <input type="hidden" class="campCode" name="campCode" value="${camp.campCode}">
                        <button type="submit">캠프 사이트 추가</button>
                    </form>
                    <form method="POST" action="/campsite/modify">
                        <input type="hidden" class="campCode" name="campCode" value="${camp.campCode}">
                        <button type="submit">이름 변경</button>
                    </form>
                    <form method="POST" action="">
                        <input type="hidden" class="campCode" name="campCode" value="${camp.campCode}">
                        <button type="submit">폐업 신청</button>
                    </form>
                </c:forEach>
            </div>
        </c:if>
    </div>
</section>
<c:import url="/footer"/>
<script src="../../script/ownerCampSiteModify.js"></script>
</body>
</html>
