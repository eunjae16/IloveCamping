
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