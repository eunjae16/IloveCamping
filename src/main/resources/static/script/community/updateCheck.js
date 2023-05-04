function updateCheck(htmlForm) {
    let url = "/community/update?";

    const writeCode = $('#writeCode').val();
    const category = $('#category').val();
    const nickname = $('#nickname').text();
    const title = $('#title').val();
    const content = $('#content').val();

    let check = false;

    if(title !== "")
        url += "&title=" + title;

    if(content !== "")
        url += "&content=" + content;

    if(title === "") {
        alert('제목을 입력해주세요');
        check = true;
        return;
    }

    else if(content === "") {
        alert('본문이 작성되지 않았습니다.');
        check = true;
        return;
    }

    if (check === true) {
        location.href = url;
    }

    else {
        const settings = {
            "url": "/community/update",
            "method": "PUT",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({
                "writeCode": writeCode,
                "writerNickname": nickname,
                "writeCategoryCode": category,
                "title": title,
                "content": content,
                "bookingCode": ""
            }),
        };

        $.ajax(settings).done(function (response) {
            location.href = "../community";
        });
    }
}