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