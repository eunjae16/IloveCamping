const setting = {
    "url" : "/get/categorycount",
    "method" : "GET",
    "timeout" : 0
}

$.ajax(setting).done(function (response) {
    console.log(response);

    response.forEach((list) => {
        if (list.categoryCode === `CT100001`) {
            $('#percent').append(
                `<div id="whole-count" class="progress" data-percent="${list.count}"><p>${list.count}</p></div>`
            );
        } else if (list.categoryCode === `CT100002`) {
            $('#percent').append(
                `<div id="camping-count" class="progress" data-percent="${list.count}"><p>${list.count}</p></div>`
            );
        } else {
            $('#percent').append(
                `<div id="caraban-count" class="progress" data-percent="${list.count}"><p>${list.count}</p></div>`
            );
        }
    });
})

$(document).ready(function() {
    // selectSite 변경 시
    $('#selectSite').change(function() {
        var selectedOption = $(this).val();
        var searchBoxValue = $('#searchBox').val();

// 페이지가 로드되면 이벤트 리스너를 등록합니다.
// window.onload = function() {
//     // "btnSearch" 버튼 클릭 이벤트 리스너를 등록합니다.
//     document.getElementById("btnSearch").addEventListener("click", searchCamp);
// };
        if (selectedOption !== 'none') {
            if (selectedOption === 'viewAll') {
                // viewAll을 선택한 경우 모든 데이터를 요청
                getCamps('viewAll', '');
            } else {
                // selectSite의 값과 첫 두 글자가 일치하는 데이터를 요청
                getCamps('addressPrefix', selectedOption.substring(0, 2));
            }
        } else {
            // selectSite를 선택하지 않은 경우
            if (searchBoxValue !== '') {
                // 검색어가 입력된 경우
                getCamps('search', searchBoxValue);
            } else {
                // 검색어가 입력되지 않은 경우 모든 데이터를 요청
                getCamps('viewAll', '');
            }
        }
    });

    // 검색 버튼 클릭 시
    $('#btnSearch').click(function() {
        var selectedOption = $('#selectSite').val();
        var searchBoxValue = $('#searchBox').val();

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

        if (selectedOption !== 'none') {
            if (selectedOption === 'viewAll') {
                // viewAll을 선택한 경우 모든 데이터를 요청
                getCamps('viewAll', '');
            } else {
                // selectSite의 값과 첫 두 글자가 일치하는 데이터를 요청
                getCamps('addressPrefix', selectedOption.substring(0, 2));
            }
        } else {
            // selectSite를 선택하지 않은 경우
            if (searchBoxValue !== '') {
                // 검색어가 입력된 경우
                getCamps('search', searchBoxValue);
            } else {
                // 검색어가 입력되지 않은 경우 모든 데이터를 요청
                getCamps('viewAll', '');
            }
        }
    });
});

function getCamps(type, value) {
    $.ajax({
        url: '/campsite/search',
        type: 'GET',
        data: {
            site: type,
            query: value
        },
        success: function(data) {
            // 요청한 데이터를 처리하는 코드 작성
            // 예를 들어, viewCampsite.jsp의 campList에 데이터를 추가하는 등의 작업을 수행할 수 있습니다.
        },
        error: function(error) {
            console.log(error);
        }
    });
}

