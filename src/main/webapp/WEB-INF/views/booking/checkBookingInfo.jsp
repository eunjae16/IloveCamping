<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-12
  Time: 오후 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<section>
    <h3>예약 확인</h3>
    <div>
        <table>
            <tr>
                <th>캠핑장 이름</th>
                <td>${camp.campName}</td>
            </tr>
            <tr>
                <th>캠핑장 주소</th>
                <td>${camp.campAddress1}</td>
            </tr>
            <tr>
                <th>캠핑 입실일</th>
                <td>${booking.startDate}</td>
            </tr>
            <tr>
                <th>캠핑 퇴소일</th>
                <td>${booking.endDate}</td>
            </tr>
            <tr>
                <th>추가 인원</th>
                <td>${booking.extraPerson} 명</td>
            </tr>
            <tr>
                <th>추가 카라반</th>
                <td>${booking.extraCaraban} 대</td>
            </tr>
            <tr>
                <th>총 금액</th>
                <td>${booking.totalPrice} 원</td>
            </tr>
        </table>
        <form method="post" action="/regist/reservation">
            <input type="hidden" value="${booking.bookingCode}">
            <input type="hidden" value="${booking.userCode}">
            <input type="hidden" value="${booking.startDate}">
            <input type="hidden" value="${booking.endDate}">
            <input type="hidden" value="${booking.campCode}">
            <input type="hidden" value="${booking.campsiteCode}">
            <input type="hidden" value="${booking.totalPrice}">
            <input type="hidden" value="${booking.extraPerson}">
            <input type="hidden" value="${booking.extraCaraban}">
            <div>
                <input type="submit" value="예약하기">
            </div>
            <input type="button" onclick="location.href='/'" value="취소하기">
        </form>
    </div>
</section>
</body>
</html>
