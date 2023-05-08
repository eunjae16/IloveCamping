const settings = {
    "url": "community/readall",
    "method": "GET",
    "timeout": 0
};

$.ajax(settings).done(function (response) {
    // registeredDate 기준으로 내림차순 정렬
    response.sort((a, b) => new Date(b.registeredDate) - new Date(a.registeredDate));
    response.forEach((content, index) => {
        if (content.writeCategoryCode === 'CC100001') {
            $('#notice').append(`
      <tr id="${content.writeCode}">
        <td>${index + 1}</td>
        <td>공지사항</td>
        <td><span class="title">${content.title}</span></td>
        <td>${content.writerNickname}</td>
        <td>${content.registeredDate}</td>
      </tr>
    `);
        } else {
            let category = '';
            if (content.writeCategoryCode === 'CC100002') {
                category = '리뷰';
            } else if (content.writeCategoryCode === 'CC100003') {
                category = '질문';
            } else if (content.writeCategoryCode === 'CC100004') {
                category = '자유게시판';
            } else if (content.writeCategoryCode === 'CC100005') {
                category = '캠핑팁';
            }

            $('#list').append(`
      <tr id="${content.writeCode}">
        <td>${index + 1}</td>
        <td>${category}</td>
        <td><span class="title">${content.title}</span></td>
        <td>${content.writerNickname}</td>
        <td>${content.registeredDate}</td>
      </tr>
    `);
        }
    });



    $('.title').on('click', e => {
        const id = e.target.parentNode.parentNode.id;

        console.log("community ' Id : " + id);
        location.href = `/communityread?writeCode=${id}`;
    });
});

