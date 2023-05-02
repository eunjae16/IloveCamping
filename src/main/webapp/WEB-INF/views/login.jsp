<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="/header"/>
<body>
<h1>로그인하기</h1>
<form method="POST" action="login">
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
<script src="script/login.js"></script>
</body>
</html>