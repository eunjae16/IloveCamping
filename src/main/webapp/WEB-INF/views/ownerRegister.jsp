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

<div class="owner-register-container">
    <h2>사업자 회원가입</h2>
    <form method="post" action="/regist/owner">
        <table>
            <tr>
                <td><input type="text" name="id" id="id" placeholder="아이디"></td>
            </tr>
            <tr>
                <td><input type="text" name="password" id="password" placeholder="비밀번호"></td>
            </tr>
            <tr>
                <td><input type="text" name="nickname" id="nickname" placeholder="닉네임"></td>
            </tr>
            <tr>
                <td><input type="text" name="account" id="account" placeholder="계좌번호"></td>
            </tr>
        </table>
        <div>
            <input id="join-button" type="button" value="회원가입" onclick="checkValue(form)">
        </div>
        <script src="/script/ownerRegister.js"></script>
    </form>
    <c:import url="/footer"/>
</div>

</body>
</html>