
function checkValue(htmlForm) {
    let url = "ownerregister?"

    const ownerId = $('#id').val();
    const ownerPassword = $('#password').val();
    const ownerNickname = $('#nickname').val();
    const account = $('#account').val();

    let check = false;

    if(ownerId !== "") url += "&ownerId=" + ownerId;
    if(ownerPassword !== "") url += "&ownerPassword=" + ownerPassword;
    if(ownerNickname !== "") url += "&ownerNickname=" + ownerNickname;
    if(account !== "") url += "&account=" + account;

    if(ownerId === ""){
        alert("아이디를 입력해주세요.");
        check = true;
    } else if(ownerPassword === ""){
        alert("비밀번호를 입력해주세요.");
        check = true;
    } else if(ownerNickname === ""){
        alert("닉네임을 입력해주세요.");
        check = true;
    } else if(account === "") {
        alert("계좌번호를 입력해주세요.");
        check = true;
    }

    if(check === true){
        location.href = url;
    } else {
        const data =  {
            "ownerId" : ownerId,
            "ownerPassword" : ownerPassword,
            "ownerNickname" : ownerNickname,
            "account" : account
        };
        submit(data);
    }
}

function submit(data){
    $.ajax({
        url: "/regist/owner",
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

$('#checkId').click(function (){
    if($('#id').val != ''){
        $.ajax({
            type: 'GET',
            url: '/regist/idcheck/owner.action',
            data: 'id=' + $('#id').val(),
            dataType:'json',
            success: function (result){
                if(result == '0'){
                    $('#messageId').text('사용가능한 아이디입니다.');
                    location.replace("/ownerregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&account=" +$('#account').val());
                }
                else{
                    $('#messageId').text('사용가능한 아이디입니다.');
                    location.replace("/ownerregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&account=" +$('#account').val());
                }
            },
            error: function (a,b,c){
                console.log(a,b,c);
            }
        });
    }
    else {
        alert('아이디를 입력하세요.');
        $('#id').focus();
    }
});

$('#checkNickname').click(function (){
    if($('#nickname').val != ''){
        $.ajax({
            type: 'GET',
            url: '/regist/nicknamecheck/owner.action',
            data: 'id=' + $('#id').val(),
            dataType:'json',
            success: function (result){
                if(result == '0'){
                    $('#messageNickname').text('사용가능한 닉네임입니다.');
                    location.replace("/ownerregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&account=" +$('#account').val());
                }
                else{
                    $('#messageNickname').text('사용가능한 닉네임입니다.');
                    location.replace("/ownerregister?id=" + $('#id').val()
                        + "&password=" + $('#password').val()
                        + "&nickname=" + $('#nickname').val()
                        + "&account=" +$('#account').val());
                }
            },
            error: function (a,b,c){
                console.log(a,b,c);
            }
        });
    }
    else {
        alert('닉네임을 입력하세요.');
        $('#nickname').focus();
    }
});