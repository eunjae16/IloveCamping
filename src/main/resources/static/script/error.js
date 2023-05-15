function redirectToMainPage() {
    location.href = "/";
}

function changeMessage2() {
    $('#message').text('2초 뒤에 메인 화면으로 이동합니다');
    setTimeout(changeMessage1, 1000);
}

function changeMessage1() {
    $('#message').text('1초 뒤에 메인 화면으로 이동합니다');
    setTimeout(redirectToMainPage, 1000);
}

setTimeout(changeMessage2, 1000);