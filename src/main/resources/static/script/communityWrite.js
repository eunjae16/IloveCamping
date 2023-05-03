function communityWrite(htmlForm) {
    let url = "communitywrite?"

    const title = $('#title').val();
    console.log("title : " + title);
    const content = $('#content').val();
    console.log("content : " + content);

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
        const settings = {
            "url": "http://localhost:8080/communitywrite",
            "method": "GET",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json",
                "Cookie": "JSESSIONID=1F44238C6BAA6322AC8056DD7B076709"
            },
            "data": JSON.stringify({
                "title": title,
                "content": content
            })
        };

        htmlForm.submit();

        // function submit(data) {
        //     $.ajax(settings).done(function (response) {
        //         console.log(response);
        //         location.href="/community/write";
        //     });
        // };

    }

}





