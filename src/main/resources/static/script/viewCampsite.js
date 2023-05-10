 function filterCampList() {
    var selectedOption = document.getElementById("selectSite").value;
    var campList = JSON.parse(decodeURIComponent('<%= request.getParameter("campList") %>'));
    var filteredCampList = [];

    if (selectedOption === "viewAll") {
        filteredCampList = campList;
    } else {
        filteredCampList = campList.filter(function(camp) {
            return camp.campAddress1.substring(0, 2) === selectedOption;
         });
    }

    var campListDiv = document.getElementById("campList");
    campListDiv.innerHTML = "";

    filteredCampList.forEach(function(camp) {
        var campName = document.createElement("p");
        campName.innerText = camp.campName;
        campListDiv.appendChild(campName);

        var campAddress = document.createElement("p");
        campAddress.innerText = camp.campAddress1;
        campListDiv.appendChild(campAddress);

        var campImage = document.createElement("img");
        campImage.src = camp.campImage;
        campImage.alt = "campsite-image";
        campListDiv.appendChild(campImage);
    });
}
