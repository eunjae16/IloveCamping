
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
                    $(".campsite-card").append(
                        `<div class='campsite'>
                            <label><input type='radio' name='selectedCampsite' value='${campsite.siteCode}'>
                            <br>
                            <img src='${campsite.campsiteImage}'>
                            <p>${campsite.siteName}</p>
                            <p>추가 인원 금액: ${campsite.siteExtraPersonPrice}원</p>
                            <p>추가 카라반 금액: ${campsite.siteExtraCarabanPrice}원</p>
                            <p>최소 인원: ${campsite.siteMinPerson} </p>
                            <p>최대 인원: ${campsite.siteMaxPerson} </p>
                            </label></div>`)

                })
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
})

// 추가인원 네 클릭
$('#existExtraPeople').click(function (){
    document.getElementById("inputExtraPeopleNum").style.display = "block";
})

// 추가인원 아니오 클릭
$('#noExtraPeople').click(function (){
    document.getElementById("checkExtraCaraban").style.display = "block";
})

// 추가인원 입력 후 확인
$('.checkPeople').click(function () {
        document.getElementById("checkExtraCaraban").style.display = "block";
})

// 추가 카라반
$('#existExtraCaraban').click(function () {
    document.getElementById("inputExtraCaraban").style.display = "block";
})

$('.checkCaraban').click(function () {
    document.getElementById("booking-button").style.display = "block";
})

$('#noExtraCaraban').click(function () {
    document.getElementById("booking-button").style.display = "block";
})


