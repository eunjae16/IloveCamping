let campCode;
let siteName;
let siteExtraPersonPrice;
let siteExtraCarabanPrice;
let siteMinPerson;
let siteMaxPerson;
let campsiteImage;
let sitePrice;

function checkValue(htmlForm) {
    let url = "ownercampsiteregist?";

    campCode = $('#campCode').val();
    siteName = $('#siteName').val();
    siteExtraPersonPrice = $('#siteExtraPersonPrice').val();
    siteExtraCarabanPrice = $('#siteExtraCarabanPrice').val();
    siteMinPerson = $('#siteMinPerson').val();
    siteMaxPerson = $('#siteMaxPerson').val();
    campsiteImage = $('#campsiteImage').val();
    sitePrice = $('#sitePrice').val();

    let check = true;

    if (campCode !== "") url += "&campCode=" + campCode;
    if (siteName !== "") url += "&siteName=" + siteName;
    if (siteExtraPersonPrice !== "") url += "&siteExtraPersonPrice=" + siteExtraPersonPrice;
    if (siteExtraCarabanPrice !== "") url += "&siteExtraCarabanPrice=" + siteExtraCarabanPrice;
    if (siteMinPerson !== "") url += "&siteMinPerson=" + siteMinPerson;
    if (siteMaxPerson !== "") url += "&siteMaxPerson=" + siteMaxPerson;
    if (campsiteImage !== "") url += "&campsiteImage=" + campsiteImage;
    if (sitePrice !== "") url += "&sitePrice=" + sitePrice;

    if (siteName === "") {
        alert("이름을 입력해 주세요.");
        check = false;
    } else if (siteMinPerson === "") {
        alert("최소 인원을 입력해 주세요.");
        check = false;
    } else if (siteMaxPerson === "") {
        alert("최대 인원을 입력해 주세요.");
        check = false;
    } else if (sitePrice === "") {
        alert("가격을 입력해 주세요.");
        check = false;
    }

    if (check === false) {
        location.href = url;
    } else {
        const data = {
            "campCode": campCode,
            "siteName": siteName,
            "siteMinPerson": siteMinPerson,
            "siteMaxPerson": siteMaxPerson,
            "sitePrice": sitePrice,
            "siteExtraPersonPrice": siteExtraPersonPrice,
            "siteExtraCarabanPrice": siteExtraCarabanPrice,
            "campsiteImage": campsiteImage,
        };
        submit(data);
    }
}

function submit(data) {
    $.ajax({
        url: "/campsite/regist",
        method: "POST",
        timeout: 0,
        headers: {
            "Content-Type": "application/json",
        },
        dataType: "json",
        data: JSON.stringify(data),
    })
        .done((response) => {
            location.href = "/registsuccess";
        })
        .fail((error) => {
            location.href = "/error";
            console.log(error);
        });

}