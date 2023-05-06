// 댓글 수정 버튼 클릭 시 실행되는 함수

function editReply(replyCode, comment) {

    console.log(replyCode);
    console.log(comment);
    // 비동기로 댓글박스 생성 및 기존 댓글내용 담기
    const editBox =
        '<div class="edit-box">'
        + '<textarea class="origin-comment-' + replyCode + '">'
        + comment
        +'</textarea>' +
        '<button onclick="submitEdit(\'' + replyCode + '\')">' + '등록</button>' +
        '<button onclick="cancelEdit(\'' + replyCode + '\')">취소</button>' +
        '</div>';
    $("#comment-" + replyCode).replaceWith(editBox);
}

function cancelEdit(replyCode) {
    const originComment = $(".origin-comment-" + replyCode).text();
    const commentBox =
        '<div class="comment-box" id="comment-' + replyCode + '">' +
        '<p>' + originComment + '</p>' +
        '</div>';

    $(".edit-box").replaceWith(commentBox);
}



// 댓글 수정 제출 버튼 클릭 시 실행되는 함수
function submitEdit(replyCode) {
    const writeCode = $('#writeCode').val();
    const newContent = $(".origin-comment-" + replyCode).val();
    const data = {
        comment: newContent,
        replyCode: replyCode
    };

    // 수정된 내용 putmapping
    $.ajax({
        url: "/reply/update?replyCode=" + replyCode,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function(url) {
            location.href = `communityread?writeCode=`+ writeCode;
        }

    });
}

