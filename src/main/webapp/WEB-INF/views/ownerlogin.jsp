<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/ownerlogin.css">
</head>
<body>
<div class="login-box">
    <h2>사업자 로그인</h2>
    <form method="POST" action="ownerlogin">
        <table>
            <tr>
                <td><input type="text" id="id" name="id" placeholder="아이디" required></td>
            </tr>
            <tr>
                <td><input type="password" id="password" name="password" placeholder="비밀번호" required onkeydown="if (event.keyCode == 13) checkValues(this.form)"></td>
            </tr>
            <tr>
                <td><input type="button" value="로그인" onclick="checkValues(form)"></td>
            </tr>
        </table>
    </form>
</div>
<c:import url="/footer"/>
<script src="script/ownerlogin.js"></script>
</body>
</html>
