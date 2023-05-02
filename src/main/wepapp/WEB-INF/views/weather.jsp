<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>weather</title>
</head>
<body>
<h1>날씨 및 일출, 일몰</h1>
<label for="input-city">도시:</label>
<input type="text" id="input-city" name="input-city"><br><br>
<label for="input-date">날짜:</label>
<input type="date" id="input-date" name="input-date"><br><br>
<button id="btn-get-weather">날씨 조회</button>

<h2>날씨 정보</h2>
<p id="weather-info"></p>

<h2>일출, 일몰 정보</h2>
<p id="sunrise-time"></p>
<p id="sunset-time"></p>

<h2>날씨 및 일출, 일몰 테이블</h2>
<div id="weather-table"></div>

<script src="script/weatherAPI.js"></script>
</body>
</html>