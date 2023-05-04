function searchCamp() {
    var selectedOption = document.querySelector('#selectSite').value;
    if (selectedOption === "viewAll") {
        fetch('/getCampAll')
            .then(response => response.json())
            .then(data => {
                var campListDiv = document.getElementById('campList');
                campListDiv.innerHTML = ''; // 기존 목록 초기화

                // 캠핑장 목록을 순회하며 각각의 속성을 화면에 표시
                if (Array.isArray(data)) { // 배열인지 확인
                    data.forEach(camp => {
                        var campDiv = document.createElement('div');
                        var campName = document.createElement('p');
                        var campAddress = document.createElement('p');
                        var campCategory = document.createElement('p');
                        var campTheme = document.createElement('p');
                        var campImg = document.createElement('img'); // img 엘리먼트 생성


                        campDiv.id = 'listResult'; // id 부여
                        campImg.src = camp.campImage; // img 엘리먼트의 src 속성 설정
                        campName.textContent += '캠핑장 이름: ' + camp.campName;
                        campAddress.textContent += '주소: ' + camp.campAddress1;
                        campTheme.textContent += '테마 : ' + camp.theme;
                        campCategory.textContent += '시설 : ' + camp.categoryName;


                        campDiv.appendChild(campImg); // img 엘리먼트를 campDiv에 추가
                        campDiv.appendChild(campName);
                        campDiv.appendChild(campAddress);
                        campDiv.appendChild(campTheme);
                        campDiv.appendChild(campCategory);
                        campListDiv.appendChild(campDiv);
                    });
                }
                else {
                    console.log('서버에서 받은 응답이 배열이 아닙니다.');
                }
            })
            .catch(error => console.log(error));
    } else {
        fetch('/searchCamp?selectedOption=' + selectedOption)
            .then(response => response.json())
            .then(data => {
                var campListDiv = document.getElementById('campList');
                campListDiv.innerHTML = ''; // 기존 목록 초기화

                // 캠핑장 목록을 순회하며 각각의 속성을 화면에 표시
                if (Array.isArray(data)) { // 배열인지 확인
                    data.forEach(camp => {
                        var campDiv = document.createElement('div');
                        var campName = document.createElement('p');
                        var campAddress = document.createElement('p');
                        var campCategory = document.createElement('p');
                        var campTheme = document.createElement('p');
                        var campImg = document.createElement('img'); // img 엘리먼트 생성

                        campDiv.id = 'listResult'; // id 부여
                        campImg.src = camp.campImage; // img 엘리먼트의 src 속성 설정
                        campName.textContent += '캠핑장 이름: ' + camp.campName;
                        campAddress.textContent += '주소: ' + camp.campAddress1;
                        campTheme.textContent += '테마 : ' + camp.theme;
                        campCategory.textContent += '시설 : ' + camp.categoryName;

                        campDiv.appendChild(campImg); // img 엘리먼트를 campDiv에 추가
                        campDiv.appendChild(campName);
                        campDiv.appendChild(campAddress);
                        campDiv.appendChild(campTheme);
                        campDiv.appendChild(campCategory);
                        campListDiv.appendChild(campDiv);
                    });
                } else {
                    console.log('서버에서 받은 응답이 배열이 아닙니다.');
                }
            })
            .catch(error => console.log(error));
    }
}

// select 요소의 변경 이벤트에 searchCamp 함수 연결
document.querySelector('#selectSite').addEventListener('change', searchCamp);