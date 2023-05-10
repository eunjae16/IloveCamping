const settings = {
    "url": "camp/readall",
    "method": "GET",
    "timeout": 0
};

$.ajax(settings).done(function (response) {
    console.log(response);

    response.forEach((listTheme) => {
        $('#camp-card').append(`
            <div id="${listTheme.campCode}">
            <img class="camp-img" src="${listTheme.campImage}">
            <p>${listTheme.campName}</p>
            <p>${listTheme.campCategoryName}</p>
            </div>
        `);
    });

    $('.camp-img').on('click', e => {
        const id = e.target.parentNode.id;

        console.log("camp ' Id : " + id);
        location.href = `/get/campinfo?campCode=${id}`;
    });


});

