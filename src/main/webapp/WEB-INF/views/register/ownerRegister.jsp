<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/ownerRegister.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<section>
    <c:if test="${!empty log}">
        <c:redirect url="/"></c:redirect>
    </c:if>
    <c:if test="${usertype eq 'owner'}">
        <c:redirect url="/"></c:redirect>
    </c:if>
    <div class="owner-register-container">
        <h2>사업자 회원가입</h2>
        <form method="post" action="/regist/owner">
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
                    <td><input type="text" name="password" id="password" placeholder="비밀번호" value="${not empty param.password ? param.password : ''}"></td>
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
                    <td><input type="text" name="account" id="account" placeholder="계좌번호" value="${not empty param.account ? param.account : ''}"></td>
                </tr>
            </table>
            <div class="button-container">
                <input id="join-button" type="button" value="회원가입" onclick="checkValue(form)">
            </div>
            <script src="/script/ownerRegister.js"></script>
        </form>
    </div>
</section>
<c:import url="/footer"/>
</body>
</html>