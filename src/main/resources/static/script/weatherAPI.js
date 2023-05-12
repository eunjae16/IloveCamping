function getWeatherFromWeatherBit(city) {
    // API 키와 도시 이름을 사용하여 API 요청 URL 생성
    var apiKey = "1e2ceed0033d40a8ac7a501920737afe";
    var apiUrl = "https://api.weatherbit.io/v2.0/current?city=" + city + "&key=" + apiKey;

    // Ajax를 사용하여 API 호출
    $.ajax({
        url: apiUrl,
        type: "GET",
        dataType: "json",
        success: function(data) {
            // API 응답에서 필요한 정보 추출
            var weatherDescription = data.data[0].weather.description;
            var sunrise = data.data[0].sunrise;
            var sunset = data.data[0].sunset;

            // 결과를 웹 페이지에 표시
            $("#sunhead").html("<span>오늘: " + weatherDescription + "</span>");
            $("#sunrise").html("<span>일출시간: " + sunrise + "</span>");
            $("#sunset").html("<span>일몰시간: " + sunset + "</span>");
        },
        error: function(error) {
            console.log("일출일몰 정보를 가져오는 데 실패했습니다.");
            console.log(error);
        }
    });
}

// campAddress2 가져오기
var city = "${camp.campAddress2}";

// WeatherBit API를 사용하여 날씨 정보 가져오기
getWeatherFromWeatherBit(city);