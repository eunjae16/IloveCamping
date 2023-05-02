$(document).ready(function(){
    function reAction(){
        $("#startButton").trigger("click");
        setTimeout(function(){
            $("#stopButton").trigger("click");
        }, 6000);
    }
    reAction();
});