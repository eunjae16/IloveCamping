const settings = {
    "url": "community/readall",
    "method": "GET",
    "timeout": 0
};

$.ajax(settings).done(function (response) {
    response.forEach(content => {
        $('table').append(`
        <tr id="${content.writeCode}">
        <td>${content.writeCode}</td>
        <td>${content.writeCategoryCode}</td>
        <td>${content.writerNickname}</td>
        <td><span class="title">${content.title}</span></td>
        <td>${content.registeredDate}</td>
        </tr>
        `);

    });

    $('.title').on('click', e => {
        const id = e.target.parentNode.parentNode.id;

        $.ajax({
            "url": `/community/readone?writeCode=${id}`,
            "method": "GET",
            "timeout": 0
        }).done(function (response) {
            if(response === 'communityRead') {
                location.href = '/communityread';
            }
            else {

            }
        });
    });
});


function pick() {

    var settings = {
        "url": "http://localhost:8080/community/readone?writeCode=CO100004",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
