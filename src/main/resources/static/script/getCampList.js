// HTTP GET 요청을 보내고 결과 데이터를 이용하여 HTML을 동적으로 생성합니다.
function searchCamp(selectedOption) {
    $.ajax({
        type: "GET",
        url: "/searchCamp",
        data: {selectedOption: selectedOption},
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var camp = data[i];
                html += "<div class='camp-item'>";
                html += "<img src='" + camp.campImage + "' class='camp-image'>";
                html += "<div class='camp-info'>";
                html += "<h3 class='camp-name'>" + camp.campName + "</h3>";
                html += "<p class='camp-address'>" + camp.campAddress1 + "</p>";
                html += "<p class='camp-theme'>" + camp.campTheme + "</p>";
                html += "</div>";
                html += "</div>";
            }
            $("#camp-list").html(html);
        },
        error: function (xhr, status, error) {
            console.log(error);
        }
    });
}

    // 이전 페이지에서 선택한 option 값을 가져옵니다.
    var selectedOption = '<%= request.getParameter("selectedValue") %>';

    // 가져온 option 값을 이용하여 검색 요청을 보냅니다.
    if (selectedOption) {
    searchCamp(selectedOption);
}
