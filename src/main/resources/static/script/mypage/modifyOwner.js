let checkNickname = false;

function checkValue(htmlForm){
    let url = "modifyowner?";

    const ownerId = $('id').val();
    const ownerPassword = $('#password').val();
    const ownerNickname = $('nickname').val();
    const account = $('#account').val();

    let check = true;

    if(ownerId !== "") url += "&ownerId=" + ownerId;
    if(ownerPassword !== "") url += "&ownerPassword=" + ownerPassword;
    if(ownerNickname !== "") url += "&ownerNickname=" + ownerNickname;
    if(account !== "") url += "&account=" + account;

    if(ownerId === ""){
        alert("아이디를 입력해주세요.");
        check = false;
    } else if(ownerPassword === ""){
        alert("비밀번호를 입력해주세요.");
        check = false;
    } else if(ownerNickname === ""){
        alert("닉네임을 입력해주세요.");
        check = false;
    } else if(account === "") {
        alert("계좌번호를 입력해주세요.");
        check = false;
    }

    if(check === false || checkNickname === false){
        location.href = url;
    } else{
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
        url: "/modify/owner",
        method: "POST",
        timeout: 0,
        headers: {
            "Content-Type": "application/json",
        },
        data: JSON.stringify(data),
    })
        .done((response) => {
            location.href = "/mypageowner";
        })
        .fail((error) => {
            console.log(error);
        });
}


$('#checkNickname').click(checkNicknameReq);
$('#nickname').change(checkNicknameReq);

function checkNicknameReq(){
    if($('#nickname').val !== ''){
        $.ajax({
            type: 'GET',
            url: `/regist/nicknamecheck/owner?nickname=${$('#nickname').val()}`,
            success: function (result){
                if(result === '0'){
                    $('#messageNickname').text('사용가능한 닉네임입니다.');
                    checkNickname = true;
                }
                else{
                    $('#messageNickname').text('사용가능한 닉네임입니다.');
                    checkNickname = false;
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    else {
        alert('닉네임을 입력하세요.');
        $('#nickname').focus();
    }
}