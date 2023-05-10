
// 전체 캠핑장 목록 로드
const mapSettings = {
    "url": "camp/campall",
    "method": "GET",
    "timeout": 0
};


// 기본 지도생성
const mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        // 지도 중심좌표
        center: new kakao.maps.LatLng(36.537784, 127.999517),
        level: 13 // 지도의 확대 레벨
    };

// 지도를 생성합니다
const map = new kakao.maps.Map(mapContainer, mapOption);

const imageSrc = "image/tent.png";

$.ajax(mapSettings).done(function (response) {

    for (let i = 0; i < response.length; i ++) {
        const imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다
        const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        // 마커를 생성합니다

        const latLng  = new kakao.maps.LatLng(response[i].x, response[i].y);
        const pick = response[i];
        const marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: latLng, // 마커를 표시할 위치
            title : response[i].campName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image : markerImage // 마커 이미지
        });



        $('.camp-img').on('click', e => {
            // 클릭 발생시 해당장소의 위치로 지도 변경
            const id = e.target.parentNode.id;

            const x = pick.x;
            const y = pick.y;
            console.log("camp ' Id : " + id);

            const mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(36.537784, 127.999517), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

            const newMap = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

            console.log("move1 x : " + x);
            console.log("move1 y : " + y);
            function setCenter() {
                // 이동할 위도 경도 위치를 생성합니다
                console.log("move2 x : " + x);
                console.log("move2 y : " + y);
                const moveLatLon = new kakao.maps.LatLng(x, y);

                // 지도 중심을 이동 시킵니다
                map.setCenter(moveLatLon);
            }

            function panTo() {
                // 이동할 위도 경도 위치를 생성합니다
                const moveLatLon = new kakao.maps.LatLng(x, y);

                // 지도 중심을 부드럽게 이동시킵니다
                // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
                map.panTo(newMoveLatLon);
            }

            // // 마커 이미지를 생성합니다
            // const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
            // // 마커를 생성합니다
            //
            // const latLng  = new kakao.maps.LatLng(id.x, id.y);
            //
            // const marker = new kakao.maps.Marker({
            //     map: newMap, // 마커를 표시할 지도
            //     position: latLng, // 마커를 표시할 위치
            //     title : response[i].campName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            //     image : markerImage // 마커 이미지
            // });

        });

      }

});


