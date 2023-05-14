<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-02
  Time: 오후 8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/header"/>
    <link rel="stylesheet" href="style/modifyClient.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<c:if test="${empty log}">
    <c:redirect url="/"></c:redirect>
</c:if>

<section>
    <div>
        <form method="POST" action="">
            <input type="hidden" id="clientCode" value="${sessionScope.log.clientCode}">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" id="id" name="id" value="${sessionScope.log.clientId}" readonly> </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="text" id="password" name="password"></td>
                </tr>
                <tr>
                    <th>닉네임</th>
                    <td><input type="text" id="nickname" name="nickname" value="${sessionScope.log.clientNickname}"></td>
                </tr>
                <tr>
                    <td colspan="2"><span id="messageNickname"></span></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" id="checkNickname" value="닉네임 중복검사"></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" id="phone" name="phone" value="${sessionScope.log.clientPhone}"></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" id="email" name="email" value="${sessionScope.log.clientEmail}"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" onclick="pop()" value="우편번호 찾기"></td>
                </tr>
                <tr>
                    <th>우편번호</th>
                    <td><input type="text" id="address_number" name="addressCode" placeholder="우편번호" value="${sessionScope.log.addressCode}"></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" id="address" name="address" placeholder="주소" readonly value="${sessionScope.log.address}"></td>
                </tr>
            </table>
            <div>
                <input type="button" value="수정하기" onclick="checkValue(form)">
            </div>
        </form>
    </div>
</section>
<c:import url="/footer"/>
<script src="/script/mypage/modifyClient.js"></script>
</body>
</html>
