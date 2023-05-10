// 페이지가 로드되면 이벤트 리스너를 등록합니다.
window.onload = function() {
    // "btnSearch" 버튼 클릭 이벤트 리스너를 등록합니다.
    document.getElementById("btnSearch").addEventListener("click", searchCamp);
};

function showCampList(camps) {
    var campListDiv = document.getElementsByClassName("campList")[0];
    if (campListDiv === undefined) {
        campListDiv = document.createElement("div");
        campListDiv.className = "campList";
        document.body.appendChild(campListDiv);
    } else {
        campListDiv.innerHTML = ""; // 이전에 표시된 데이터를 초기화합니다.
    }

    // 각각의 캠핑장 데이터를 순회하며 div 요소를 생성하고 캠핑장 정보를 추가합니다.
    for (var i = 0; i < camps.length; i++) {
        var camp = camps[i];
        var campDiv = document.createElement("div");
        campDiv.className = "camp-item";
        campDiv.innerHTML = "<p>" + camp.campName + "</p><p>" + camp.campAddress1 + "</p>";
        campListDiv.appendChild(campDiv);
    }
}