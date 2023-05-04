function deleteOwnerWrite(){

    const settings = {
        "url": "community/deleteownerwrite?writeCode="+$('#writeCode').val(),
        "method": "DELETE",
        "timeout": 0
        }

    $.ajax(settings).done(function (response) {
        location.href='/community';

    });
}
