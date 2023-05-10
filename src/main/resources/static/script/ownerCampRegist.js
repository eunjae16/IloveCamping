function pop() {
    new daum.Postcode({
        oncomplete: function (data) {
            document.getElementById("address_number").value = data.zonecode;
            document.getElementById("address").value = data.address;
        },
    }).open();
}

function checkValue(htmlForm) {
    let url = "ownercampregist?";

    const campCategoryCode = $('.campCategoryCode').val();
    const campName = $('#name').val();
    // const campImage = $('#file').val();
    const campAddressCode = $('#address_number').val();
    const campAddress1 = $('#address').val();
    const campPhone = $('#phone').val();

    let check = true;

    if (campCategoryCode !== "") url += "&campCategoryCode=" + campCategoryCode;
    if (campName !== "") url += "&campName=" + campName;
    // if (campImage !== "") url += "&campImage=" + campImage;
    if (campAddressCode !== "") url += "&campAddressCode=" + campAddressCode;
    if (campAddress1 !== "") url += "&campAddress1=" + campAddress1;
    if (campPhone !== "") url += "&campPhone=" + campPhone;

    if (campName === "") {
        alert("캠핑장 이름을 입력해 주세요.");
        check = false;
    // } else if (campImage === "") {
    //     alert("이미지를 등록해 주세요.");
    //     check = false;
    } else if (campAddressCode === "") {
        alert("우편번호를 입력해 주세요.");
        check = false;
    } else if (campAddress1 === "") {
        alert("주소를 입력해주세요.");
        check = false;
    } else if (campPhone === "") {
        alert("연락처 입력해주세요.");
        check = false;
    }

    if (check === false) {
        location.href = url;
    } else {
        const data = {
            "campCategoryCode": campCategoryCode,
            "campName": campName,
            // "campImage": campImage,
            "campAddressCode": campAddressCode,
            "campAddress1": campAddress1,
            "campPhone": campPhone
        };
        submit(data);
    }
}

function submit(data) {
    $.ajax({
        url: "/camp/regist",
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