<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h1>CHECK</h1>
<div class="owner-register-container">
    <form method="post" action="/regist/owner">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="text" name="password" id="password"></td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td><input type="text" name="nickname" id="nickname"></td>
            </tr>
            <tr>
                <th>계좌번호</th>
                <td><input type="text" name="account" id="account"></td>
            </tr>
        </table>
        <div>
            <input id="join-button" type="button" value="회원가입" onclick="checkValue(form)">
        </div>
        <script src="/script/ownerRegister.js"></script>
    </form>

</div>

</body>
</html>