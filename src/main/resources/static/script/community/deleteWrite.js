function deleteWrite(){

    const settings = {
        "url": "community/deletewrite?writeCode="+$('#writeCode').val(),
        "method": "DELETE",
        "timeout": 0
        }

    $.ajax(settings).done(function (response) {
        location.href='/community';

    });
}
