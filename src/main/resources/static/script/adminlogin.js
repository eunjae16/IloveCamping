function checkValues(htmlForm){
    let url = "adminlogin"

    const userCode = document.getElementById("id").value;
    const userPassword = document.getElementById("password").value;

    let check = true;

    if(userCode === ""){
        alert("아이디를 입력해주세요");
        check = false;
    }
    else if(userPassword === ""){
        alert("페스워드를 입력해주세요");
        check = false;
    }


    if(check === false){
        location.href = url;
    }
    else{
        htmlForm.submit();
    }
}