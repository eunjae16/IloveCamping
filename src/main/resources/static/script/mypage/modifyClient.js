
let checkNickname = false;
function pop() {
    new daum.Postcode({
        oncomplete: function (data) {
            document.getElementById("address_number").value = data.zonecode;
            document.getElementById("address").value = data.address;
        },
    }).open();
}

function checkValue(htmlForm) {
    let url = "modifyclient?";

    const clientCode = $('#clientCode').val();
    const clientId = $('#id').val();
    const clientPassword = $('#password').val();
    const clientNickname = $('#nickname').val();
    const clientPhone = $('#phone').val();
    const addressCode = $('#address_number').val();
    const address = $('#address').val();
    const clientEmail = $('#email').val();

    let check = true;

    if (clientId !== "") url += "&clientId=" + clientId;
    if (clientPassword !== "") url += "&clientPassword=" + clientPassword;
    if (clientNickname !== "") url += "&clientNickname=" + clientNickname;
    if (clientPhone !== "") url += "&clientPhone=" + clientPhone;
    if (addressCode !== "") url += "&addressCode=" + addressCode;
    if (address !== "") url += "&address=" + address;
    if (clientEmail !== "") url += "&clientEmail=" + clientEmail;

    if (clientPassword === "") {
        alert("비밀번호를 입력해주세요.");
        check = false;
    } else if (clientNickname === "") {
        alert("닉네임을 입력해주세요.");
        check = false;
    } else if (clientPhone === "") {
        alert("전화번호를 입력해주세요.");
        check = false;
    } else if (addressCode === "") {
        alert("우편번호를 입력해주세요.");
        check = false;
    } else if (address === "") {
        alert("주소를 입력해주세요.");
        check = false;
    }

    if (check === false || checkNickname === false) {
        location.href = url;
    } else {
        const data = {
            "clientCode" : clientCode,
            "clientId": clientId,
            "clientPassword": clientPassword,
            "clientNickname": clientNickname,
            "clientPhone": clientPhone,
            "addressCode": addressCode,
            "address": address,
            "clientEmail": clientEmail
        };
        submit(data);
    }
}

function submit(data){
    $.ajax({
        url: "/modify/client",
        method: "POST",
        timeout: 0,
        headers: {
            "Content-Type": "application/json",
        },
        data: JSON.stringify(data),
    })
        .done((response) => {
            location.href = "/mypageclient";
        })
        .fail((error) => {
            console.log(error);
        });
}

$('#checkNickname').click(checkNicknameReq);
$('#nickname').change(checkNicknameReq);

function checkNicknameReq() {
    if ($('#nickname').val() !== '') {
        $.ajax({
            type: 'GET',
            url: `/regist/nicknamecheck/client?nickname=${$('#nickname').val()}`,
            success: function (result) {
                if (result === '0') {
                    $('#messageNickname').text('사용가능한 닉네임입니다.');
                    checkNickname = true;
                } else {
                    $('#messageNickname').text('이미 사용중인 닉네임입니다');
                    checkNickname = false;
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    } else {
        alert('닉네임을 입력하세요.');
        $('#nickname').focus();
    }
}
