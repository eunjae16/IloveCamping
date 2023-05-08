function ownerWrite(htmlForm) {
    let url = "communityownerwrite?"

    const category = $('#category').val();
    const nickname = $('#nickname').text();
    const title = $('#title').val();
    const content = $('#content').val();

    let check = false;

    if(category !== "")
        url += "&category=" + category;

    if(title !== "")
        url += "&title=" + title;

    if(content !== "")
        url += "&content=" + content;

    if(category === ""){
        alert('카테고리가 선택되지 않았습니다.');
        check = true;
        return;
    }

    else if(title === ""){
        alert('제목을 입력해주세요');
        check = true;
        return;
    }

    else if(content === "") {
        alert('본문이 작성되지 않았습니다.');
        check = true;
        return;

    }

    console.log("nickname: "+nickname);
    console.log("category: "+category);
    console.log("title: "+title);

    if (check === true) {
        location.href = url;
    }
    else {
        $.ajax({
            "url": "/community/write",
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





