// 댓글 수정 버튼 클릭 시 실행되는 함수
function editName(campCode, campName) {
    const campOwner = $('#campOwner').val(); // 여기서 campOwner 변수를 선언하도록 수정
    console.log("campCode: "+ campCode);
    console.log("campName: "+ campName);
    console.log("campOwner: "+ campOwner);
    // 비동기로 댓글박스 생성 및 기존 댓글내용 담기
    const editBox =
        '<div class="edit-box">'
        + '<textarea class="origin-campName-' + campCode + '">'
        + campName
        +'</textarea>' +
        '<button onclick="submitEdit(\'' + campCode + '\')">' + '등록</button>' +
        '<button onclick="cancelEdit(\'' + campCode + '\')">취소</button>' +
        '</div>';
    $("#campName-" + campCode).replaceWith(editBox);
}

function cancelEdit(campCode) {
    const originCampName = $(".origin-campName-" + campCode).val();
    const campnameBox =
        '<div class="campname-box" id="campName-' + campCode + '">' +
        '<p>' + originCampName + '</p>' +
        '</div>';

    $(".edit-box").replaceWith(campnameBox);
}




// 댓글 수정 제출 버튼 클릭 시 실행되는 함수
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

        success: function(response) {
            alert('newcapmname'+newCampName);
            // 새로운 페이지로 이동
            // location.href = 'owner/readcampall?campOwner=' + campOwner;
            // location.href = '/';
            // 새로운 페이지로 이동
        }
    });
}


