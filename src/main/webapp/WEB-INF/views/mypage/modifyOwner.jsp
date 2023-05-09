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
    <form method="post" action="">
        <table>
            <tr>
                <th>아이디</th>
                <td>${sessionScope.log.ownerId}</td>
            </tr>
            <tr>
                <th></th>
            </tr>
        </table>
    </form>
</section>
<c:import url="/footer"/>
</html>
