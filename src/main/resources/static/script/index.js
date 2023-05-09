function searchCamp() {
    var selectedSite = document.getElementById("selectSite").value;
    var searchBox = document.getElementById("searchBox").value;

    $.ajax({
        url: "/campsite/search",
        type: "GET",
        data: { site: selectedSite, query: searchBox },
        success: function (result) {
            // 결과 데이터를 가공하여 viewCampsite.jsp로 전달하고, 이동
            window.location.href = "/viewCampsite?campList=" + encodeURIComponent(JSON.stringify(result));
        },
        error: function (xhr, status, error) {
            console.log(error);
        },
    });
}