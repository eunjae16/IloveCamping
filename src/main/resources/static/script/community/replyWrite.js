const replyWrite = () => {
    const writeCode = $('#writeCode').val();
    const replywriter = $('#replywriter').val();
    const replycontent = $('#replycontent').val();

    console.log("js writeCode" + writeCode);
    console.log("js replywriter" + replywriter);
    console.log("js replycontent" + replycontent);

    $.ajax({
        "url": "/reply/write",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json",
        },
        "data": JSON.stringify({
            "writeCode": writeCode,
            "comment": replycontent,
            "replierNickname": replywriter
        }),
        }).done(function (url) {
        location.href = url + writeCode;
    });

}
