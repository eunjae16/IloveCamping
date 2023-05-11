var selectedObj = {};

function extractSelectedValues(selectedObj) {
    const result = {};
    for (let year in selectedObj) {
        for (let month in selectedObj[year]) {
            const arr = selectedObj[year][month];
            const firstValue = arr[0];
            const lastValue = arr[arr.length - 1];
            const firstProp = `${year}-${month}-0`;
            const lastProp = `${year}-${month}-${arr.length - 1}`;

            result[firstProp] = `${firstValue}`;
            result[lastProp] = `${lastValue}`;
        }
    }
    return result;
}

var arrayDate = extractSelectedValues(selectedObj);

let firstDate = arrayDate[0];
let lastDate = arrayDate[1];

function submitReservation(){
    $.ajax({
        type: `POST`,
        url: ``,
    })
}

$('.campsite-card').on("click", e => {
    const id = e.target.parentNode.id;


})
