// index.js

// 페이지가 로드되면 이벤트 리스너를 등록합니다.
window.onload = function() {
    // "btnSearch" 버튼 클릭 이벤트 리스너를 등록합니다.
    document.getElementById("btnSearch").addEventListener("click", searchCamp);
};

function searchCamp() {
    var selectedSite = document.getElementById("selectSite").value;
    var searchBox = document.getElementById("searchBox").value;

    $.ajax({
        url: "/campsite/search",
        type: "GET",
        data: { site: selectedSite, query: searchBox },
        success: function(result) {
            window.location.href = "/viewCampsite?campList=" + encodeURIComponent(JSON.stringify(result));
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
}
