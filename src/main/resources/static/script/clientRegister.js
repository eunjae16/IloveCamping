function pop() {
    new daum.Postcode({
        oncomplete: function (data) {
            document.getElementById("address_number").value = data.zonecode;
            document.getElementById("address").value = data.address;
        },
    }).open();
}

function checkValue(htmlForm) {
    let url = "clientregister?";

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

    if (clientId === "") {
        alert("아이디를 입력해주세요.");
        check = false;
    } else if (clientPassword === "") {
        alert("비밀번호를 입력해주세요.");
        check = false;
    } else if (clientNickname === "") {
        alert("별명을 입력해주세요.");
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

    if (check === false) {
        location.href = url;
    } else {
        const data = {
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

function submit(data) {
    $.ajax({
        url: "/regist/client",
        method: "POST",
        timeout: 0,
        headers: {
            "Content-Type": "application/json",
        },
        data: JSON.stringify(data),
    })
        .done((response) => {
            location.href = "joinsuccess";
        })
        .fail((error) => {
            location.href = "error";
        });
}

$('#checkId').click(function () {
    if ($('#id').val() != '') {
        $.ajax({
            type: 'GET',
            url: '/regist/idcheck.action',
            data: 'id=' + $('#id').val(),
            dataType: 'json',
            success: function (result) {
                if (result == '0') {
                    $('#messageId').text('사용가능한 아이디입니다.');
                    location.replace("/clientregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&phone=" + $('#phone').val()
                        + "&email=" + $('#email').val()
                        + "&addressCode=" + $('#address_number').val()
                        + "&address=" + $('#address').val());
                } else {
                    $('#messageId').text('이미 사용중인 아이디입니다.');
                    location.replace("/clientregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&phone=" + $('#phone').val()
                        + "&email=" + $('#email').val()
                        + "&addressCode=" + $('#address_number').val()
                        + "&address=" + $('#address').val());
                }
            },
            error: function (a, b, c) {
                console.log(a, b, c);
            }
        });
    } else {
        alert('아이디를 입력하세요.');
        $('#id').focus();
    }
});

$('#checkNickname').click(function () {
    if ($('#nickname').val() != '') {
        $.ajax({
            type: 'GET',
            url: '/regist/nicknamecheck.action',
            data: 'nickname=' + $('#nickname').val(),
            dataType: 'json',
            success: function (result) {
                if (result == '0') {
                    $('#messageId').text('사용가능한 아이디입니다.');
                    location.replace("/clientregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&phone=" + $('#phone').val()
                        + "&email=" + $('#email').val()
                        + "&addressCode=" + $('#address_number').val()
                        + "&address=" + $('#address').val());
                } else {
                    $('#messageId').text('이미 사용중인 아이디입니다.');
                    location.replace("/clientregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&phone=" + $('#phone').val()
                        + "&email=" + $('#email').val()
                        + "&addressCode=" + $('#address_number').val()
                        + "&address=" + $('#address').val());
                }
            },
            error: function (a, b, c) {
                console.log(a, b, c);
            }
        });
    } else {
        alert('닉네임을 입력하세요.');
        $('#nickname').focus();
    }
});
