$('#btnSearch').click(function (){
    if($('#searchBox').val() != ''){
        let searchText = $('#searchBox').val();
        $.ajax({
            type: 'POST',
            url: '/search/camp',
            data: {keyword: searchText},
            success: function (data){},
            error:function (a,b,c){
                console.log(a,b,c);
            }
        })
    }
})