function deleteReply(replyCode){

    const writeCode = $('#writeCode').val();
    const settings = {
        "url": "reply/delete?replyCode="+replyCode,
        "method": "DELETE",
        "timeout": 0
    }

    $.ajax(settings).done(function (response) {
        location.href = "/communityread?writeCode=" + writeCode;
    });
}