function campModify() {
    const campOwner = $('#ownerCode').val()

    console.log("campowner : " + campOwner);


    let url = "owner/readcampall?campOwner=";
    if (campOwner != null) {
        location.href = url+campOwner;
        console.log("campowner : " + campOwner);
    }

}




