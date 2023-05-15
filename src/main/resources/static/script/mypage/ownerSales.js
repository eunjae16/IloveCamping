const ownerCode = $('.container')[0].id;

$("#btn").click(function() {
    $.ajax({
        "url": `/get/monthlysales/ownercode?ownerCode=${ownerCode}`,
        "method": "GET",
        "timeout": 0
    }).done(function(response1) {
        columnChart1(response1);
        console.log(response1);
    });
});

$("#btn2").click(function() {
    $.ajax({
        "url": `/get/dailysales/ownercode?ownerCode=${ownerCode}`,
        "method": "GET",
        "timeout": 0
    }).done(function(response) {
        columnChart2(response);
        console.log(response);
    });
});

google.charts.load('current', { packages: ['corechart'] });

function columnChart1(response1) {

    var arr = [
        ['월별', '매출액'],
    ];

    response1.forEach(function(response) { // 변수명 수정: response1 -> response
        let monthly = response.month + '월';
        let total = response.totalSales;
        arr.push([monthly, total]);
    });

    if (arr.length === 1) {
        var objDiv = document.getElementById('column_chart_div1');
        objDiv.innerHTML = '<div style="margin-top: 30px"><p>ㅠㅠ 매출이 없어요</p><p>캠핑장을 등록해주세요!</p></div>';
        return;
    }

    var dataTable = google.visualization.arrayToDataTable(arr);

    var options = {
        title: '월별 매출',
        hAxis: {
            title: '월별',
            titleTextStyle: {
                color: 'black'
            }
        },
        legend: 'none',
        series: {
            0: { color: '#FFB9B9' }
        }
    };

    var objDiv = document.getElementById('column_chart_div1');
    var chart = new google.visualization.ColumnChart(objDiv);
    chart.draw(dataTable, options);
}


function columnChart2(response) {

    var arr = [
        ['일별', '매출액'],
    ];

    response.forEach(function(data) {
        let daily = data.salesDate;
        let total = data.totalSales;
        arr.push([daily, total]);
    });

    if (arr.length === 1) { // arr 배열이 비어있을 경우
        var objDiv = document.getElementById('column_chart_div1');
        objDiv.innerHTML = '<div style="margin-top: 30px"><p>ㅠㅠ 매출이 없어요</p><p>캠핑장을 등록해주세요!</p></div>'; // HTML 요소를 추가합니다.
        return; // 함수 종료
    }

    var dataTable = google.visualization.arrayToDataTable(arr);

    var options = {
        title: '일별 매출',
        hAxis: {
            title: '일별',
            titleTextStyle: {
                color: 'black'
            }
        },
        legend: 'none',
        series: {
            0: { color: '#FFB9B9' }
        }
    };

    var objDiv = document.getElementById('column_chart_div1');
    var chart = new google.visualization.ColumnChart(objDiv);
    chart.draw(dataTable, options);

}