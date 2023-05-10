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
            <input type="button" value="예약하기" onclick="location.href='/get/campinfo?campCode=${listTheme.campCode}';">
            </div>
        `);
    });

    // $('.camp-img').on('click', e => {
    //     // 클릭 발생시 해당장소의 위치로 지도 변경
    //     const id = e.target.parentNode.id;
    //
    //     console.log("camp ' Id : " + id);
    //     location.href = `/get/campinfo?campCode=${id}`;
    // });


});




