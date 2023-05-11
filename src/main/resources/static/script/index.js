$(document).ready(function() {
    // selectSite 변경 시
    $('#selectSite').change(function() {
        var selectedOption = $(this).val();
        var searchBoxValue = $('#searchBox').val();

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
