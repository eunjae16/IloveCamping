$(document).ready(function() {

    function getCamps(type, value) {
        $.ajax({
            url: '/campsite/search',
            type: 'GET',
            data: {
                site: type,
                query: value
            },
            success: function(data) {
                handleCampsResponse(data);
            },
            error: function(error) {
                console.log(error);
            }
        });
    }

    function handleCampsResponse(camps) {
        const campList = $('.campList');

        // 기존에 있는 캠프 목록을 모두 제거합니다.
        campList.empty();

        // 서버에서 받은 캠프 목록을 순회하면서 HTML을 생성하여 campList에 추가합니다.
        for (let i = 0; i < camps.length; i++) {
            const camp = camps[i];
            const campItem = $('<div class="campItem"></div>');
            campItem.append(`<img src="${camp.campImage}">`);
            campItem.append(`<p>${camp.campName}</p>`);
            campItem.append(`<p>${camp.campAddress1}</p>`);
            campItem.append(`<p>${camp.campPhone}</p>`);
            campList.append(campItem);
        }
    }
});
