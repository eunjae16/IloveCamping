
// 전체 캠핑장 목록 로드
const mapSettings = {
    "url": "camp/glampingcategory",
    "method": "GET",
    "timeout": 0
};


// 기본 지도생성
const mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        // 지도 중심좌표
        center: new kakao.maps.LatLng(36.537784, 127.999517),
        level: 12 // 지도의 확대 레벨
    };

// 지도를 생성합니다
const map = new kakao.maps.Map(mapContainer, mapOption);

const imageSrc = "image/tent.png";

let tmpArr = [];

$.ajax(mapSettings).done(function (response) {
    for (let i = 0; i < response.length; i ++) {
        console.log("map lengh: " + response.length);
        tmpArr.push(response[i]);
        console.log(response[i]);
        const imageSize = new kakao.maps.Size(24, 35);


        // 마커 이미지를 생성합니다
        const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);


        const latLng  = new kakao.maps.LatLng(response[i].y, response[i].x);
        const pick = i;
        const marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: latLng, // 마커를 표시할 위치
            title : response[i].campAddress1, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image : markerImage, // 마커 이미지
        });
        const campName = response[i].campName;
        const x = response[i].x;
        const y = response[i].y;

        const iwContent = '<div style="padding:5px;">'+campName+'</div>',
            //인포윈도우 표시 위치입니다
            iwPosition = new kakao.maps.LatLng(y, x);



        // 인포윈도우 생성
        const infowindow = new kakao.maps.InfoWindow({
            position : iwPosition,
            content : iwContent
        });

        // 마커를 생성합니다

        infowindow.open(map, marker);
    }
});


const settings = {
    "url": "camp/glampingcategory",
    "method": "GET",
    "timeout": 0
    // async 두개의 ajax 호출이 일어날때 꼭 순서를 주고 싶다면 설정할 수 잇음
    // 해당 ajax 의 활동이 끝나기전까지 다음 호출이 일어나지 않음 (순서제어)
};

$.ajax(settings).done(function (response) {
    console.log(response);

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
        const moveLatLon = new kakao.maps.LatLng(y, x);

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