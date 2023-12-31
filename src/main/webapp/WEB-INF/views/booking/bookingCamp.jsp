<%--
  Created by IntelliJ IDEA.
  User: jieun
  Date: 2023-05-10
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="/style/booking/style.css">
    <script src="/script/booking/jquery.min.js"></script>
    <script src="/script/booking/popper.js"></script>
    <script src="/script/booking/bootstrap.min.js"></script>
    <c:import url="../sementic/header.jsp"/>
    <link rel="stylesheet" href="/style/booking/bookingCamp.css">
</head>
<body>
<%--
    1. 상세페이지 >> 예약하기 버튼을 통해 >> camp_code 받아오고
    2. 예약
--%>

<c:if test="${empty usertype}">
    <c:redirect url="/login"></c:redirect>
</c:if>

<c:if test="${usertype eq 'owner'}">
    <c:redirect url="/"></c:redirect>
</c:if>

<section>
    <div>
        <div class="camp-width-box">
            <div class="camp-img">
                <img src="${camp.campImage}">
            </div>
            <div class="camp-info">
                <div>
                    <p class="title">${camp.campName}</p>
                    <p>H.P : ${camp.campPhone}</p>
                    <p>${camp.campAddress1}</p>
                    <p>${camp.campAddress2}</p>
                    <p>${camp.campCategoryName}</p>
                </div>
            </div>
        </div>
        <%-- 이하 calendar --%>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="calendar-section">
                        <div class="row no-gutters">
                            <div class="col-md-6">
                                <div class="calendar calendar-first" id="calendar_first">
                                    <div class="calendar_header">
                                        <button class="switch-month switch-left">
                                            <i class="fa fa-chevron-left"></i>
                                        </button>
                                        <h2></h2>
                                        <button class="switch-month switch-right">
                                            <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                    <div class="calendar_weekdays"></div>
                                    <div class="calendar_content"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="calendar calendar-second" id="calendar_second">
                                    <div class="calendar_header">
                                        <button class="switch-month switch-left">
                                            <i class="fa fa-chevron-left"></i>
                                        </button>
                                        <h2></h2>
                                        <button class="switch-month switch-right">
                                            <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                    <div class="calendar_weekdays"></div>
                                    <div class="calendar_content"></div>
                                </div>
                            </div>
                        </div> <!-- End Row -->
                    </div> <!-- End Calendar -->
                </div>
            </div>
        </div>
        <div id="${camp.campCode}" class="check-btn campCodeChecker" style="cursor: pointer">예약 확인하기!</div>
        <%-- 이상 calendar --%>
        <%-- 이하 캠프사이트 리스트   --%>
        <div class="campsite-card">
        </div>
        <div id="checkCampSite" class="box-none" style="cursor: pointer">확인</div>
        <%--  이하 추가인원 확인  --%>
        <div id="checkExtraPeople" class="box-none">
            <p>추가 인원이 있나요?</p>
            <div class="flex-box">
                <div id="existExtraPeople">네</div>
                <div id="noExtraPeople">아니오</div>
            </div>
        </div>
        <%-- 네 클릭 시 --%>
        <div class="box-none" id="inputExtraPeopleNum">
            <p>추가 인원을 입력해 주세요 :</p>
            <input type="text" id="extraPeople" name="extraPeople" value="0" numberOnly>
            <p id="messageForExtraPerson"></p>
            <div id="${camp.campCategoryName}" class="checkPeople" style="cursor: pointer">확인</div>
        </div>
        <%--  이하 추가카라반 확인  --%>
        <div class="box-none" id="checkExtraCaraban">
            <p>추가 카라반이 있나요?</p>
            <div class="flex-box">
                <div id="existExtraCaraban">네</div>
                <div id="noExtraCaraban">아니오</div>
            </div>
        </div>
        <div class="box-none" id="inputExtraCaraban">
            <p>추가 카라반 수를 입력해 주세요 :</p>
            <input type="text" id="extraCaraban" name="extraCaraban" value="0" numberOnly>
            <div class="checkCaraban" style="cursor: pointer">확인</div>
        </div>
        <%-- 이하 제출버튼 --%>
        <div class="box-none" id="booking-button">
            <input type="hidden" id="userCode" value="${sessionScope.log.clientCode}">
            <input type="button" value="예약하기!" onclick="submitValue()">
        </div>
</section>
<c:import url="../sementic/footer.jsp"/>
<script src="/script/booking/main.js"></script>
<script src="/script/booking/bookingCamp.js"></script>
</body>
</html>
