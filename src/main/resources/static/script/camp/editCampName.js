function editName(campName, campCode) {
    const editBox =
        '<div class="edit-box">'
        + '<input class="origin-siteName-' + campCode + '">'
        + campName +
        '<button onclick="submitEdit(\'' + campCode + '\')">' + '등록</button>' +
        '<button onclick="cancelEdit(\'' + campCode + '\')">취소</button>' +
        '</div>';
    $("#campName-" + campName).replaceWith(editBox);
}

function cancelEdit(campCode) {
    const originCampName = $(".origin-siteName--" + campCode).text();
    const campNameBox =
        '<div class="campName-box" id="campName-' + campCode + '">' +
        '<p>' + originCampName + '</p>' +
        '</div>';

    $(".edit-box").replaceWith(campNameBox);
}

function submitEdit(campCode) {
    const newCampName = $(".origin-campName-" + campCode).val();
    const data = {
        campName: newCampName,
        campCode: campCode
    };

    // 수정된 내용 putmapping
    $.ajax({
        url: "/campName/update?campCode=" + campCode,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function(url) {
            location.href = owner/readcampall;
        }

    });
}