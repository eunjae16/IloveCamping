function leaveOwner(){
    if(window.confirm("탈퇴하시겠습니까?")){
        leaveReqOwner();
    }
}

function leaveReqOwner(){
    const ownerCode = $('#ownerCode').val();

    $.ajax({
        url: '/register/leave/owner',
        type: 'POST',
        data: {ownerCode : ownerCode},
        success: function (response){
            location.href = '/byebye';
        },
        error: function (xhr, status, error){
            location.href = '/error';
        }
    });

}

function leaveClient(){
    if(window.confirm("탈퇴하시겠습니까?")){
        leaveReqClient();
    }
}

function leaveReqClient(){
    const clientCode = $('#clientCode').val();

    $.ajax({
        url: '/register/leave/client',
        type: 'POST',
        data: {clientCode : clientCode},
        success: function (response){
            location.href = '/byebye';
        },
        error: function (xhr, status, error){
            console.log(error);
        }
    })
}