

const mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
    // 지도 중심좌표
        center: new kakao.maps.LatLng(37.44078048718621, 127.89332675009311),
        level: 3 // 지도의 확대 레벨
    };

const map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커를 표시할 위치와 title 객체 배열입니다
let positions;
positions = [
    {
        title: '자연소리 캠프',
        latlng: new kakao.maps.LatLng(37.76329732940934, 128.1667803111291)
    }
    ];

// 마커 이미지의 이미지 주소입니다
const imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

for (let i = 0; i < positions.length; i ++) {

    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지
    });
}