function leaveOwner(){
    if(window.confirm("탈퇴하시겠습니까?")){
        location.href="/regist/leave/owner";
    }
}

function leave(){
    const clientCode = document.querySelector("#clientCode").value;
    if(window.confirm("탈퇴하시겠습니까?")){
        location.href=`/regist/leave/client?clientCode=${clientCode}`;
    }
}