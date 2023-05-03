function searchCamp() {
    var selectedOption = document.querySelector('#selectSite').value;

    fetch('/searchCamp?selectedOption=' + selectedOption)
        .then(response => response.json())
        .then(data => {
            var campListDiv = document.getElementById('campList');
            campListDiv.innerHTML = ''; // 기존 목록 초기화

            // 캠핑장 목록을 순회하며 각각의 속성을 화면에 표시
            if (Array.isArray(data)) { // 배열인지 확인
                data.forEach(camp => {
                    var campDiv = document.createElement('div');
                    campDiv.textContent = '캠핑장 이름: ' + camp.campName + ', 주소: ' + camp.campAddress1;
                    campListDiv.appendChild(campDiv);
                });
            }
            else {
                console.log('서버에서 받은 응답이 배열이 아닙니다.');
            }
        })
        .catch(error => console.log(error));
}

// select 요소의 변경 이벤트에 searchCamp 함수 연결
document.querySelector('#selectSite').addEventListener('change', searchCamp);
