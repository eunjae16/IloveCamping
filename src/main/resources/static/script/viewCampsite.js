// select 요소 변경 시, 서버에 캠핑장 목록 요청 후 결과를 화면에 표시하는 함수
function searchCamp() {
    var selectedOption = document.querySelector('select[name="selectSite"]').value;

    fetch('/searchCamp?selectedOption=' + selectedOption)
        .then(response => response.json())
        .then(data => {
            var campListDiv = document.getElementById('campList');
            campListDiv.innerHTML = ''; // 기존 목록 초기화

            // 캠핑장 목록을 순회하며 각각의 속성을 화면에 표시
            data.forEach(camp => {
                var campDiv = document.createElement('div');
                campDiv.innerText = '캠핑장 이름: ' + camp.campName + ', 주소: ' + camp.campAddress1;
                campListDiv.appendChild(campDiv);
            });
        })
        .catch(error => console.log(error));
}

// select 요소의 변경 이벤트에 searchCamp 함수 연결
document.querySelector('select[name="selectSite"]').addEventListener('change', searchCamp);