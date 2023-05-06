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

        console.log("community ' Id : " + id);
        location.href = `/communityread?writeCode=${id}`;
    });
});



// $.ajax({
    //     url: `/community/readone?writeCode=${id}`,
    //     method: "GET",
    //     "headers": {
    //         "Content-Type": "application/json",
    //     }
    // }).done(function (response) {
    //         const community = JSON.stringify;
    //
    //         const url = `/community/readone?writeCode=${community.writeCode}`;
    //         console.log("writecode : " + community.writeCode);
    //         window.location.href = url;
    //     });
    // });


