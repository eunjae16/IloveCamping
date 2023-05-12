function checkValue(htmlForm) {
    let url = "ownercampsiteregist?";

    const siteCode = $('#siteCode').val();
    const campCode = $('#campCode').val();
    const siteName = $('#siteName').val();
    const siteExtraPersonPrice = $('#siteExtraPersonPrice').val();
    const siteExtraCarabanPrice = $('#siteExtraCarabanPrice').val();
    const siteMinPerson = $('#siteMinPerson').val();
    const siteMaxPerson = $('#siteMaxPerson').val();
    const campsiteImage = $('#campsiteImage').val();
    const sitePrice = $('#sitePrice').val();

    let check = true;

    if (siteCode !== "") url += "&siteCode=" + siteCode;
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
            "siteCode": siteCode,
            "campCode": campCode,
            "siteName": siteName,
            "siteMinPerson": siteMinPerson,
            "siteMaxPerson": siteMaxPerson,
            "sitePrice": sitePrice,
            "siteExtraPersonPrice": siteExtraPersonPrice,
            "siteExtraCarabanPrice": siteExtraCarabanPrice,
            "campsiteImage": campsiteImage,
            "booked" : "0"
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
        data: JSON.stringify(data),
    })
        .done((response) => {
            location.href = "registsuccess";
        })
        .fail((error) => {
            location.href = "error";
        });

}