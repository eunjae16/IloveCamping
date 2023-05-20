<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="style/ownerCampRegist.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
            integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx"
            crossOrigin="anonymous"></script>

</head>
<body>

<c:if test="${empty usertype}">
    <c:redirect url="/login"></c:redirect>
</c:if>

<c:if test="${usertype eq 'client'}">
    <c:redirect url="/"></c:redirect>
</c:if>

<section>
    <div class="camp-regist-box">
        <h2>캠핑장 등록</h2>
        <form method="POST">
            <table class="camp-regist">
                <tr>
                    <td colspan="2"><input type="hidden" name="campOwner" id="campOwner" value="${sessionScope.log.ownerCode}" readonly></td>
                </tr>
                <tr>
                    <th>캠핑장 분류</th>
                    <td>
                        <select>
                            <c:if test="${not empty list}">
                                <c:forEach items="${list}" var="theme">
                                    <option class="campCategoryCode" value="${theme.themeCode}">${theme.themeName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>캠핑장 이름</th>
                    <td><input type="text" name="name" id="name" placeholder="캠핑장 이름"></td>
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
                    <td><input type="text" id="address_number" name="addressCode" placeholder="우편번호"></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" id="address" name="address" placeholder="주소" readonly></td>
                    <input type="hidden" id="x" name="x">
                    <input type="hidden" id="y" name="y">
                </tr>
                <tr>
                    <th>연락처</th>
                    <td><input type="text" id="phone" name="phone" placeholder="연락처"></td>
                </tr>
                <tr>
                    <th>캠프 지원 시설 [다중선택 가능]</th>
                    <td>
                        <c:forEach var="facility" items="${facilityCategoryList}">
                            <label>
                                <img src="${facility.facilityImgUrl}" alt="${facility.categoryName}">
                                <input type="checkbox" name="facility" value="${facility.categoryCode}">
                                    ${facility.categoryName}
                            </label>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th>주변 환경</th>
                    <td>
                        <select>
                            <c:if test="${not empty surroundCategoryList}">
                                <c:forEach items="${surroundCategoryList}" var="surround">
                                    <option class="surroundCategory" value="${surround.surroundCategoryCode}">${surround.surroundCategoryName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" id="regist-button" value="캠핑장 등록" onclick="checkValue(form)">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</section>
<c:import url="../sementic/footer.jsp"/>
<script src="script/mypage/ownerCampRegist.js"></script>
</body>
</html>
