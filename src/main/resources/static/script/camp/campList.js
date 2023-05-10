const settings = {
    "url": "camp/readall",
    "method": "GET",
    "timeout": 0
};

$.ajax(settings).done(function (response) {
    console.log(response);

    response.forEach((listTheme) => {
        $('#camp-card').append(`
            <img class="camp-img" src="${listTheme.campImage}">
            <p>${listTheme.campName}</p>
            <p>${listTheme.campCategoryName}</p>
            <input type="hidden" class="camp-code" value="${listTheme.campCode}">
        `);
    });

    $('.camp-img').on('click', e => {
        const id = e.currentTarget.previousElementSibling.value;

        console.log("camp ' Id : " + id);
        location.href = `/get/campinfo?campCode=${id}`;
    });


});

