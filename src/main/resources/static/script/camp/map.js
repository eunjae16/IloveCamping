


const mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
    // 지도 중심좌표
        center: new kakao.maps.LatLng(37.44078048718621, 127.89332675009311),
        level: 10 // 지도의 확대 레벨
    };

const map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커 클러스터
// const cluster = new kakao.maps.MarkerCluster({
//     map: map,
//     averageCenter: true
// });


// function displayMaker(locPosition, message) {(
//     // 마커 생성 및 인포윈도우
//     const marker = new kakao.maps.Marker({
//         map: map,
//         position: locPosition
//     });
//
//     const iwContent = message,
//         iwRemoveable = true
//
//
//
// )};

// 마커를 표시할 위치와 title 객체 배열입니다
let positions;

positions = [
    {
        title: '소나무 캠프',
        latlng: new kakao.maps.LatLng(37.76329732940934, 128.1667803111291),

    },

    {
        title: '자연소리 캠프',
        latlng: new kakao.maps.LatLng(36.8711159, 127.9314478),
    }

    ];

// 마커 이미지의 이미지 주소입니다
const imageSrc = "image/tent.png";

for (let i = 0; i < positions.length; i ++) {

    // 마커 이미지의 이미지 크기 입니다
    const imageSize = new kakao.maps.Size(40, 30);

    // 마커 이미지를 생성합니다
    const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // const iwContent = '<div style="padding:5px"> + positions[i].title + </div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    //     iwPosition = new kakao.maps.LatLng(positions[i].latlng), //인포윈도우 표시 위치입니다
    //     iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다



    // 마커를 생성합니다
    const marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage,// 마커 이미지

        // const infowindow = new kakao.maps.InfoWindow({
        //     map: map, // 인포윈도우가 표시될 지도
        //     position: positions[i].latlng, // 마커를 표시할 위치
        //     content : iwContent,
        //     removable : iwRemoveable

    });

    // 인포윈도우를 생성하고 지도에 표시합니다
    // const infowindow = new kakao.maps.InfoWindow({
    //     map: map, // 인포윈도우가 표시될 지도
    //     position: positions[i].latlng, // 마커를 표시할 위치
    //     content : iwContent,
    //     removable : iwRemoveable
    // });



}