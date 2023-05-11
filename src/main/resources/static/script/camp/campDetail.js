// 해당 캠핑장의 좌표

const mapContainer = document.getElementsByClassName('map')[0];
const [x, y] = mapContainer.id.split('/');
const address = $('#address').text();
const campName = $('#campName').text();

const mapOption = {
    center: new kakao.maps.LatLng(x, y), // 지도의 중심좌표
    level: 5 // 지도의 확대 레벨
};


const map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다
const markerPosition  = new kakao.maps.LatLng(x, y);

// 마커를 생성합니다
const marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 길찾기 옵션
const iwContent = '<div style="padding:5px;">'+campName+'<br>' +
        '<a href="https://map.kakao.com/link/map/' + campName + ',' + x + ',' + y + '"style="color:blue" target="_blank"></a>' +
'<a href="https://map.kakao.com/link/to/' + campName + ',' + x + ',' + y + '" style="color:blue" target="_blank">길찾기</a></div>',
    // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(x, y); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
const infowindow = new kakao.maps.InfoWindow({
    position : iwPosition,
    content : iwContent
});

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker);

var xhr = new XMLHttpRequest();
var url = 'http://apis.data.go.kr/B090041/openapi/service/RiseSetInfoService/getAreaRiseSetInfo'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'unQxKQrF1AU5TOE9cX9FpU5bOaWN2J6Hlhf0V9i4y9iYTnl0WVya53CopLztL2%2BW6lyx5cwB9X7DlaDPjIXGGA%3D%3D'; /*Service Key*/
queryParams += '&' + encodeURIComponent('locdate') + '=' + encodeURIComponent('20150101'); /**/
queryParams += '&' + encodeURIComponent('location') + '=' + encodeURIComponent('서울'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');
