
$(document).on("keyup", "input[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );});

$(document).ready(function() {
    $(".check-btn").click(function() {
        console.log('click');

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
                            <label><input type='radio' name='selectedCampsite' value='${campsite.id}'>
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

function submitValue() {
    // Get the values from the form inputs
    var campCode = "${camp.campCode}"; // Replace with the appropriate value
    var extraPeople = document.getElementById("extraPeople").value;
    var extraCaraban = document.getElementById("extraCaraban").value;

    // Get the selected campsite radio button value
    var selectedCampsite = document.querySelector('input[name="selectedCampsite"]:checked').value;

    // Create an object to store the data
    var data = {
        campCode: campCode,
        extraPeople: extraPeople,
        extraCaraban: extraCaraban,
        selectedCampsite: selectedCampsite
        // Add more properties if needed
    };

    // Send the data via AJAX
    $.ajax({
        type: "POST",
        url: "/your-controller-url",
        data: data,
        success: function(response) {
            console.log("Data submitted successfully!");
        },
        error: function(xhr, status, error) {
            console.log("Error submitting data: " + error);
        }
    });
}
