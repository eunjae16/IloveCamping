<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/ownerCampRegist.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<section>
    <div>
        <h2>캠핑장 등록</h2>
        <form method="post" action="">
            <table class="camp-regist">
                <tr>
                    <th>캠핑장 분류</th>
                    <td>
                        <select>
                            <c:if test="${not empty list}">
                                <c:forEach items="${list}" var="theme">
                                        <option>${theme.themeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>캠핑장 이름</td>
                    <td><input type="text" name="name" id="name" placeholder="캠핑장 이름"></td>
                </tr>
                <%--                <tr>--%>
                <%--                    <td>캠핑장 사진</td>--%>
                <%--                    <td><input type="file" name="file" id="file" placeholder="캠핑장 사진"></td>--%>
                <%--                </tr>--%>
                <tr>
                    <td>우편번호 찾기</td>
                    <td><input type="button" onclick="pop()" value="우편번호 찾기"></td>
                </tr>
                <tr>
                    <td>우편번호</td>
                    <td><input type="text" id="address_number" name="addressCode" placeholder="우편번호"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" id="address" name="address" placeholder="주소" readonly></td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td><input type="text" id="phone" name="phone" placeholder="연락처"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="regist-button" type="button" value="캠핑장 등록" onclick="checkValue(form)">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</section>
<c:import url="../sementic/footer.jsp"/>
<script src="script/ownerCampRegist.js"></script>
</body>
</html>
