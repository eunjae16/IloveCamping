<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-02
  Time: 오후 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/modifyOwner.css">
</head>
<body>
<c:if test="${empty log}">
    <c:redirect url="/"></c:redirect>
</c:if>
<section>
    <h3>회원수정</h3>
    <form method="post">
        <input type="hidden" id="ownerCode" value="${sessionScope.log.ownerCode}">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" id="id" value="${sessionScope.log.ownerId}" readonly></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="text" name="password" id="password" placeholder="비밀번호"></td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td><input type="text" name="nickname" id="nickname" placeholder="닉네임" value="${sessionScope.log.ownerNickname}"></td>
            </tr>
            <tr>
                <td colspan="2"><span id="messageNickname"></span></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" id="checkNickname" value="닉네임 중복검사"></td>
            </tr>
            <tr>
                <th>계좌번호</th>
                <td><input type="text" name="account" id="account" placeholder="계좌번호" value="${sessionScope.log.account}"></td>
            </tr>
        </table>
        <div>
            <input type="button" value="수정하기" onclick="checkValue(form)">
        </div>
        <script src="/script/mypage/modifyOwner.js"></script>
    </form>
</section>
<c:import url="/footer"/>
</html>
