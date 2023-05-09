var campList = JSON.parse(decodeURIComponent(getUrlParameter("campList")));

for (var i = 0; i < campList.length; i++) {
    var camp = campList[i];
    var html = "<div class='campsite-card'>" +
        "<a href='/viewCampDetail?id=" + camp.id + "' data-campid='" + camp.id + "'>" +
        "<img src='" + camp.campImage + "' alt='campsite-image'>" +
        "<p>" + camp.campName + "</p>" +
        "<p>" + camp.campAddress1 + "</p>" +
        "<p>" + camp.campAddress2 + "</p>" +
        "</a>" +
        "</div>";
    document.getElementById("campList").innerHTML += html;
}