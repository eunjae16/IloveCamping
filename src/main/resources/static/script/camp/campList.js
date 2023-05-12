const settings = {
    "url": "camp/readall",
    "method": "GET",
    "timeout": 0
    // async 두개의 ajax 호출이 일어날때 꼭 순서를 주고 싶다면 설정할 수 잇음
    // 해당 ajax 의 활동이 끝나기전까지 다음 호출이 일어나지 않음 (순서제어)
};

$.ajax(settings).done(function (response) {
    console.log(response);

    // 카드를 js 에 append 시킨 이유 : 클릭이벤트 발생시 map 의 좌표를 계속해서 변경해서 보여줘야하기 때문
    response.forEach((listTheme) => {
        $('#camp-card').append(`
            <div id="${listTheme.campCode}">
                <img class="camp-img" src="${listTheme.campImage}">
                <div class="list-text-box">
                    <p>${listTheme.campName}</p>
                    <p><${listTheme.campCategoryName}></p>
                </div>
                <form method="post" action="/get/campinfo">
                    <input type="hidden" name="campCode" id="campCode" value="${listTheme.campCode}">
                    <input type="submit" value="예약">
                </form>
            </div>
        `);
    });
    // 엘리먼트가 있는 곳에서 클릭이벤트를 발생시켜야함

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


        const x = tmpArr[pick].x;
        const y = tmpArr[pick].y;
        console.log("pick: " + tmpArr[pick].campName);
        console.log("x: " + tmpArr[pick].x);
        console.log("y: " + tmpArr[pick].y);
        const moveLatLon = new kakao.maps.LatLng(x, y);

        const moveOption = {
            center: moveLatLon,
            level: 3
        };

        // 지도를 이동하면서 확대 레벨을 조절합니다
        map.setLevel(3, moveOption);
        map.panTo(moveLatLon);

        // map.panTo(moveLatLon);
    });


});