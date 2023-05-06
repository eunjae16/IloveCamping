function deleteReply(){

    const writeCode = $('#writeCode').val();
    const settings = {
        "url": "reply/delete?replyCode="+$('#replyCode').val(),
        "method": "DELETE",
        "timeout": 0
    }

    $.ajax(settings).done(function (response) {
        location.href = "/communityread?writeCode=" + writeCode;
    });
}