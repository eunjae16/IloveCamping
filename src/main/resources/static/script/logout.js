$(document).ready(function() {
    $("#logoutBtn").click(function(e) {
        e.preventDefault(); // 기본 동작(링크 이동) 방지
        $.post("/logout", function() {
            window.location.href = "/"; // 로그아웃 성공 시 홈페이지로 이동
        });
    });
});