<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/clientRegister.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<section>
<div class="client-register-container">
    <h2>일반유저 회원가입</h2>
    <form method="post" action="/regist/client">
        <table>
            <tr>
                <td><input type="text" name="id" id="id" placeholder="아이디" value="${not empty param.id ? param.id : ''}"></td>
            </tr>
            <tr>
                <td><span id="messageId"></span></td>
            </tr>
            <tr>
                <td><input type="button" id="checkId" value="아이디 중복검사"></td>
            </tr>
            <tr>
                <td><input type="password" name="password" id="password" placeholder="비밀번호" value="${not empty param.password ? param.password : ''}"></td>
            </tr>
            <tr>
                <td><input type="text" name="nickname" id="nickname" placeholder="닉네임" value="${not empty param.nickname ? param.nickname : ''}"></td>
            </tr>
            <tr>
                <td><span id="messageNickname"></span></td>
            </tr>
            <tr>
                <td><input type="button" id="checkNickname" value="닉네임 중복검사"></td>
            </tr>
            <tr>
                <td><input type="text" name="phone" id="phone" placeholder="연락처" value="${not empty param.phone ? param.phone : ''}"></td>
            </tr>
            <tr>
                <td><input type="text" name="email" id="email" placeholder="이메일" value="${not empty param.email ? param.email : ''}"></td>
            </tr>
            <tr>
                <td><input type="button" onclick="pop()" value="우편번호 찾기"></td>
            </tr>
            <tr>
                <td><input type="text" id="address_number" name="addressCode" placeholder="우편번호" value="${not empty param.addressCode ? param.addressCode : ''}"></td>
            </tr>
            <tr>
                <td><input type="text" id="address" name="address" placeholder="주소" readonly value="${not empty param.address ? param.address : ''}"></td>
            </tr>
        </table>
        <div class="button-container">
            <input id="join-button" type="button" value="회원가입" onclick="checkValue(form)">
        </div>
    </form>
</div>
</section>
<c:import url="/footer"/>
<script src="/script/member/clientRegister.js"></script>
</body>
</html>