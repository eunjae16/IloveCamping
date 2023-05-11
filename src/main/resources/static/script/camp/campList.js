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

    $('.camp-img').on('click', e => {
        let campCode = "";
        let pick = -1;
        const id = e.target.parentNode.id;

        for(let i=0; i<tmpArr.length; i++) {
            if(tmpArr[i].campCode === id) {
                campCode = id;
                pick = i;
            }
        }

        // const id = $(e.currentTarget).data('id');
        const x = tmpArr[pick].x;
        const y = tmpArr[pick].y;
        const moveLatLon = new kakao.maps.LatLng(x, y);
        map.panTo(moveLatLon);
    });


});