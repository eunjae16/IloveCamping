
$(document).on("keyup", "input[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );});

$(document).ready(function() {
    $(".check-btn").click(function() {

        var campCode = $(this).attr("id");
        $.ajax({
            url: "/get/campsite/list",
            type: "GET",
            data: {
                campCode: campCode
            },
            success: function(result) {
                $(".campsite-card").empty();
                console.log(result.length);

                result.forEach(campsite => {
                    let carabanPrice = (campsite.siteExtraCarabanPrice !== "") ? campsite.siteExtraCarabanPrice + "원" : "0원";
                    $(".campsite-card").append(
                        `<div class='campsite'>
            <label>
                <input type='radio' name='selectedCampsite' value='${campsite.siteCode}'
                    data-min-people='${campsite.siteMinPerson}' data-max-people='${campsite.siteMaxPerson}'>
                <br>
                <div class="img-wrapper"><img src='${campsite.campsiteImage}'></div>
                <p>${campsite.siteName}</p>
                <p>추가 인원 금액: ${campsite.siteExtraPersonPrice}원</p>
                <p>추가 카라반 금액: ${carabanPrice}원</p>
                <p>최소 인원: ${campsite.siteMinPerson} 인</p>
                <p>최대 인원: ${campsite.siteMaxPerson} 인</p>
            </label>
        </div>`
                    );
                });

                // 스크롤
                $(".campsite-card")[0].scrollIntoView();
            },
            error: function(xhr, status, error) {
                console.log(error);
            }


        });
    });

    document.getElementById("checkCampSite").style.display = "block";
});



// 확인 클릭
$('#checkCampSite').click(function () {
    document.getElementById("checkExtraPeople").style.display = "block";
    // 스크롤
    $("#checkExtraPeople")[0].scrollIntoView();
})

// 추가인원 네 클릭
$('#existExtraPeople').click(function (){
    document.getElementById("inputExtraPeopleNum").style.display = "block";
    // 스크롤
    $("#inputExtraPeopleNum")[0].scrollIntoView();
})

// 추가인원 아니오 클릭
$('#noExtraPeople').click(function (){
    document.getElementById("checkExtraCaraban").style.display = "block";
    document.getElementById("inputExtraPeopleNum").style.display = "none";
    // 스크롤
    $("#checkExtraCaraban")[0].scrollIntoView();
})

// 추가인원 입력 후 확인
$('.checkPeople').click(function () {
    let selectedCampsite = $('input[name="selectedCampsite"]:checked');
    let minPeople = parseInt(selectedCampsite.data('min-people'));
    let maxPeople = parseInt(selectedCampsite.data('max-people'));
    let extraPeople = parseInt($('#extraPeople').val());
    let messageElement = $('#messageForExtraPerson');

    if (extraPeople > maxPeople - minPeople) {
        messageElement.text("총 인원은 최대 인원을 넘길 수 없습니다!");
        return;
    } else {
        messageElement.text("");
    }

    document.getElementById("checkExtraCaraban").style.display = "block";

    // 스크롤
    $("#checkExtraCaraban")[0].scrollIntoView();
});


// 추가 카라반 네 클릭
$('#existExtraCaraban').click(function () {
    document.getElementById("inputExtraCaraban").style.display = "block";

    // 스크롤
    $("#inputExtraCaraban")[0].scrollIntoView();
})

// 추가 카라반 아니오 클릭
$('.checkCaraban').click(function () {
    document.getElementById("booking-button").style.display = "block";

    // 스크롤
    $("#booking-button")[0].scrollIntoView();
})

$('#noExtraCaraban').click(function () {
    document.getElementById("booking-button").style.display = "block";
    document.getElementById("inputExtraCaraban").style.display = "none";

    // 스크롤
    $("#booking-button")[0].scrollIntoView();
})

// 예약확인하기! 클릭 시 스크롤
$(".campCodeChecker").click(function() {
    $("html, body").animate({ scrollTop: $(".campsite-card").offset().top }, 800);
});

// 예약확인하기! 클릭 시 스크롤
$("#checkCampSite").click(function() {
    $("html, body").animate({ scrollTop: $("#checkExtraPeople").offset().top }, 800);
});

// 추가인원 네 클릭 시 스크롤
$("#existExtraPeople").click(function() {
    $("html, body").animate({ scrollTop: $("#inputExtraPeopleNum").offset().top }, 800);
});

// 추가인원 아니오 클릭 시 스크롤
$("#noExtraPeople").click(function() {
    $("html, body").animate({ scrollTop: $("#checkExtraCaraban").offset().top }, 800);
});

// 추가인원 입력 후 확인 시 스크롤
$(".checkPeople").click(function() {
    $("html, body").animate({ scrollTop: $("#checkExtraCaraban").offset().top }, 800);
});

// 추가 카라반 네 클릭 시 스크롤
$("#existExtraCaraban").click(function() {
    $("html, body").animate({ scrollTop: $("#inputExtraCaraban").offset().top }, 800);
});

// 추가 카라반 아니오 클릭 시 스크롤
$(".checkCaraban").click(function() {
    $("html, body").animate({ scrollTop: $("#booking-button").offset().top }, 800);
});

$("#noExtraCaraban").click(function() {
    $("html, body").animate({ scrollTop: $("#booking-button").offset().top }, 800);
});

