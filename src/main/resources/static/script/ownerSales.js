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

    response1.forEach(function(data) {
        let monthly = data.month + '월';
        let total = data.totalSales;
        arr.push([monthly, total]);
    });

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
        let daily = data.date;
        let total = data.totalSales;
        arr.push([daily, total]);
    });

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