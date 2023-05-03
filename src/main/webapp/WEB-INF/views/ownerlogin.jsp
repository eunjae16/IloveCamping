<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/header"/>
    <title>사업자 로그인</title>
</head>
<body>
<h1>사업자 로그인</h1>
<form method="POST" action="ownerlogin">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" id="id" name="id" placeholder="아이디" required></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="password" id="password" name="password" placeholder="비밀번호" required onkeydown="if (event.keyCode == 13) checkValues(this.form)"></td>
            <td><input type="button" value="로그인" onclick="checkValues(form)"></td>
        </tr>
    </table>
</form>
<c:import url="/footer"/>
<script src="script/ownerlogin.js"></script>
</body>
</html>
