<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/14/23
  Time: 2:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
        integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx"
        crossOrigin="anonymous"></script>

<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/communityOwnerWrite.css">
</head>
<body>

<c:if test="${empty log}">
    <c:redirect url="/"></c:redirect>
</c:if>
<c:if test="${usertype eq 'client'}">
    <c:redirect url="/"></c:redirect>
</c:if>

<section>
    <h4>캠핑장 정보 수정</h4>
    <div class="camp-regist-box">
        <form method="POST">
            <table class="camp-regist">
                <tr>
                    <td colspan="2"><input type="hidden" name="campCode" id="campCode" value="${camp.campCode}" readonly></td>
                    <td colspan="2"><input type="hidden" name="campOwner" id="campOwner" value="${camp.campOwner}" readonly></td>
                </tr>
                <tr>
                    <th>캠핑장 분류</th>
                    <td>
                        <select id="campCategoryCOde" name="campCategoryName">
                            <c:if test="${not empty theme}">
                                <c:forEach items="${theme}" var="theme">
                                    <option class="campCategoryCode" value="${theme.themeCode}"
                                            <c:if test="${theme.themeCode eq selectedCode}">selected</c:if>
                                    >${theme.themeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>캠핑장 이름</th>
                    <td><input type="text" name="name" id="name" value="${camp.campName}"></td>
                </tr>
                <%--                <tr>--%>
                <%--                     <td>캠핑장 사진</td>--%>
                <%--                     <td><input type="file" name="file" id="file" placeholder="캠핑장 사진"></td>--%>
                <%--                </tr>--%>
                <tr>
                    <th>우편번호 찾기</th>
                    <td><input type="button" onclick="pop()" value="우편번호 찾기"></td>
                </tr>
                <tr>
                    <th>우편번호</th>
                    <td><input type="text" id="address_number" name="addressCode" value="${camp.campAddressCode}">
                       </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" id="address" name="address" value="${camp.campAddress1}">
                        </td>
                    <input type="hidden" id="x" name="x" value="${camp.x}">
                    <input type="hidden" id="y" name="y" value="${camp.y}">
                </tr>
                <tr>
                    <th>연락처</th>
                    <td><input type="text" id="phone" name="phone" value="${camp.campPhone}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" id="regist-button" value="수정완료" onclick="checkValue(form)">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</section>
</section>
<c:import url="/footer"/>
<script src="/script/mypage/campSiteModify.js"></script>
</body>
</html>
