
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
                // 기존에 있는 요소들 제거
                console.log(result.length);

                var html = "";
                for (var i = 0; i < result.length; i++) {
                    var campsite = result[i];
                    html += "<div class='campsite'>" +
                        "<label><input type='radio' name='selectedCampsite' value='" + campsite.id + "'>" +
                        "<img src='" + campsite.campsiteImage + "'>" +
                        "<p>" + campsite.siteName + "</p>" +
                        "<p>추가 인원 금액: " + campsite.siteExtraPersonPrice + "원</p>" +
                        "<p>추가 카라반 금액: " + campsite.siteExtraCarabanPrice + "원</p>" +
                        "<p>최소 인원: " + campsite.siteMinPerson + "</p>" +
                        "<p>최대 인원: " + campsite.siteMaxPerson + "</p>" +
                        "</label></div>";
                }

                $(".campsite-card").empty();

                $(".campsite-card").html(html);
            },
            error: function(xhr, status, error) {
                console.log(error);
            }
        });
    });
});

$('#checkCampSite').click(function () {
    document.getElementById("checkExtraPeople").style.display = "block";
})

$('#existExtraPeople').click(function (){
    document.getElementById("inputExtraCaraban").style.display = "block";
})

$('.checkPeople').click(function () {
    let category = this.id;

    if(category === '캠핑'){
        document.getElementById("booking-button").style.display = "block";
    }
    else {
        document.getElementById("checkExtraCaraban").style.display = "block";
    }
})

$('#existExtraCaraban').click(function () {
    document.getElementById("inputExtraCaraban").style.display = "block";
})

$('.checkCaraban').click(function () {
    document.getElementById("booking-button").style.display = "block";
})

function submitValue(){}