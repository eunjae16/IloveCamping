<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="/style/booking/checkBookingInfo.css">
</head>
<body>
<section>
    <c:if test="${empty usertype}">
        <c:redirect url="/login"></c:redirect>
    </c:if>

    <h3>예약 확인</h3>
    <div>
        <table>
            <tr>
                <th>캠핑장 이름</th>
                <td>${sessionScope.camp.campName}</td>
            </tr>
            <tr>
                <th>캠핑장 주소</th>
                <td>${sessionScope.camp.campAddress1}</td>
            </tr>
            <tr>
                <th>캠핑 입실일</th>
                <td>${sessionScope.booking.startDate}</td>
            </tr>
            <tr>
                <th>캠핑 퇴소일</th>
                <td>${sessionScope.booking.endDate}</td>
            </tr>
            <tr>
                <th>추가 인원</th>
                <td>${sessionScope.booking.extraPerson} 명</td>
            </tr>
            <tr>
                <th>추가 카라반</th>
                <td>${sessionScope.booking.extraCaraban} 대</td>
            </tr>
            <tr>
                <th>총 금액</th>
                <td>${sessionScope.booking.totalPrice} 원</td>
            </tr>
        </table>
        <form method="post" action="/regist/reservation">
            <input type="hidden" name="bookingCode" value="${sessionScope.booking.bookingCode}">
            <input type="hidden" name="userCode" value="${sessionScope.booking.userCode}">
            <input type="hidden" name="startDate" value="${sessionScope.booking.startDate}">
            <input type="hidden" name="endDate" value="${sessionScope.booking.endDate}">
            <input type="hidden" name="campCode" value="${sessionScope.camp.campCode}">
            <input type="hidden" name="campsiteCode" value="${sessionScope.booking.campsiteCode}">
            <input type="hidden" name="totalPrice" value="${sessionScope.booking.totalPrice}">
            <input type="hidden" name="extraPerson" value="${sessionScope.booking.extraPerson}">
            <input type="hidden" name="extraCaraban" value="${sessionScope.booking.extraCaraban}">
            <div>
                <input type="submit" value="예약하기">
                <input type="button" onclick="location.href='/booking/cancle'" value="취소하기">
            </div>
        </form>
    </div>
</section>
<c:import url="../sementic/footer.jsp"/>
</body>
</html>
