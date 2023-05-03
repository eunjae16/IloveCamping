function communityWrite(htmlForm) {
    let url = "communityclientwrite?"

    const category = $('#category').val();
    const nickname = $('#nickname').val();
    const title = $('#title').val();
    const content = $('#content').val();

    let check = false;

    if(title !== "")
        url += "&title=" + title;

    if(content !== "")
        url += "&content=" + content;

    if(title === ""){
        alert('제목을 입력해주세요');
        check = true;
    }

    else if(content === "") {
        alert('본문이 작성되지 않았습니다.');
        check = true;
    }

    if (check === true) {
        location.href = url;
    }
    else {
        $.ajax({
            "url": "/community/clientwrite",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json",
            },
            "data": JSON.stringify({
                "writeCode": "",
                "writerNickname": nickname,
                "writeCategoryCode": category,
                "title": title,
                "content": content
            }),
        }).done(function (url) {
            location.href = url;
        });

    }

}





