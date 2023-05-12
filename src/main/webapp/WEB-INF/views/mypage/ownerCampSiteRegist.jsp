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
<section>
    <div class="camp-regist-box">
        <h2>캠프 사이트 등록</h2>
        <p>${campCode}</p>
        <form method="post">
            <table class="campsite-regist">
                <tr>
                    <td colspan="2"><input type="hidden" name="siteCode" id="siteCode" value="" readonly></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="hidden" name="campCode" id="campCode" value="${camp.campCode}" readonly></td>
                </tr>
                <tr>
                    <th>캠프 사이트 이름</th>
                    <td><input type="text" name="siteName" id="siteName" placeholder="캠프 사이트 이름"></td>
                </tr>
                <tr>
                    <th>캠핑 1인당 가격</th>
                    <td><input type="text" name="siteExtraPersonPrice" id="siteExtraPersonPrice" placeholder="캠핑 1인당 가격"></td>
                </tr>
                <tr>
                    <th>카라반 1인당 가격</th>
                    <td><input type="text" id="siteExtraCarabanPrice" name="siteExtraCarabanPrice" placeholder="카라반 1인당 가격"></td>
                </tr>
                <tr>
                    <th>최소 인원</th>
                    <td><input type="text" id="siteMinPerson" name="siteMinPerson" placeholder="최소 인원"></td>
                </tr>
                <tr>
                    <th>최대 인원</th>
                    <td><input type="text" id="siteMaxPerson" name="siteMaxPerson" placeholder="최대 인원"></td>
                </tr>
                <tr>
                    <td>사진 등록</td>
                    <td><input type="file" name="campsiteImage" id="campsiteImage" placeholder="사진 등록"></td>
                </tr>
                <tr>
                    <th>캠핑장 가격</th>
                    <td><input type="text" id="sitePrice" name="sitePrice" placeholder="캠핑장 가격"></td>
                </tr>
                <tr>
                    <th>캠핑장 가격</th>
                    <td colspan="2">
                        <input type="button" id="regist-button" value="캠핑장 등록" onclick="checkValue(form)">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</section>
<c:import url="../sementic/footer.jsp"/>
<script src="script/ownerCampSiteRegist.js"></script>
</body>
</html>
