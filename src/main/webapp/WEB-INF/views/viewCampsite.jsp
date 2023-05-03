    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>캠핑장 목록</title>
    </head>
    <body>
    <div>
        <p>지역 선택</p>
        <select id="selectSite" name="selectSite" required onchange="searchCamp()">
            <option value="none" selected hidden>선택</option>
            <option value="viewAll">전체보기</option>
            <option value="서울">서울</option>
            <option value="경기">경기도</option>
            <option value="강원">강원도</option>
            <option value="충북">충청북도</option>
            <option value="충남">충청남도</option>
            <option value="전북">전라북도</option>
            <option value="전남">전라남도</option>
            <option value="경북">경상북도</option>
            <option value="경남">경상남도</option>
        </select>
        <div id="campList"> <!-- 캠핑장 목록을 표시 -->

        </div>
    </div>

    <script src="script/viewCampsite.js"></script>
    </body>
    </html>