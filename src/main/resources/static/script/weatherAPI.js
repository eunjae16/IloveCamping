function formatTime(timestamp) {
    var date = new Date(timestamp * 1000);
    var hours = date.getHours();
    var minutes = "0" + date.getMinutes();
    var seconds = "0" + date.getSeconds();
    var formattedTime = hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
    return formattedTime;
}
$(document).ready(function() {
    // 날씨 및 일출, 일몰 API 호출
    $("#btn-get-weather").click(function() {
        var city = $("#input-city").val();
        var date = $("#input-date").val();

        // 날씨 API 호출
        $.ajax({
            url: "https://api.openweathermap.org/data/2.5/weather",
            data: {
                q: city,
                appid: "e131607edd699682a18e880c64b450be"
            },
            success: function(weatherResult) {
                // 날씨 API 호출 성공 시 처리
                var weatherDescription = weatherResult.weather[0].description;

                // 날짜 관련 처리
                var startDate = new Date(date);
                var endDate = new Date(startDate.getTime() + 6 * 24 * 60 * 60 * 1000);
                var startTimestamp = Math.floor(startDate.getTime() / 1000);
                var endTimestamp = Math.floor(endDate.getTime() / 1000);

                // 일출, 일몰 API 호출 (1주일치 데이터 가져오기)
                $.ajax({
                    url: "https://api.weatherbit.io/v2.0/forecast/daily",
                    data: {
                        city: city,
                        key: "1e2ceed0033d40a8ac7a501920737afe",
                        start_date: startTimestamp,
                        end_date: endTimestamp
                    },
                    success: function(weatherForecastResult) {
                        // 일출, 일몰 API 호출 성공 시 처리
                        var forecasts = weatherForecastResult.data;

                        // 테이블 생성 및 표시
                        var tableHtml = "<table><tr><th>날짜</th><th>날씨</th><th>일출 시간</th><th>일몰 시간</th></tr>";
                        for (var i = 0; i < forecasts.length; i++) {
                            var forecast = forecasts[i];
                            var forecastDate = new Date(forecast.datetime);
                            var formattedDate = forecastDate.toLocaleDateString();
                            var sunrise = formatTime(forecast.sunrise_ts);;
                            var sunset = formatTime(forecast.sunset_ts);
                            var weatherDescription = forecast.weather.description;
                            tableHtml += "<tr><td>" + formattedDate + "</td><td>" + weatherDescription + "</td><td>" + sunrise + "</td><td>" + sunset + "</td></tr>";
                        }
                        tableHtml += "</table>";
                        $("#weather-table").html(tableHtml);

                        // 날씨, 일출, 일몰 시간 표시
                        $("#weather-info").text("도시: " + city + " / 날씨: " + weatherDescription);
                        $("#sunrise-time").text("일출 시간: " + formatTime(forecasts[0].sunrise_ts));
                        $("#sunset-time").text("일몰 시간: " + formatTime(forecasts[0].sunset_ts));
                    },
                    error: function(weatherForecastError) {
                        // 일출, 일몰 API 호출 실패 시 처리
                        console.log("일출, 일몰 API 호출 실패:", weatherForecastError);
                    }
                });
            },
            error: function(weatherError) {
                // 날씨 API 호출 실패 시 처리
                console.log("날씨 API 호출 실패:", weatherError);
            }
        });
    });
});
