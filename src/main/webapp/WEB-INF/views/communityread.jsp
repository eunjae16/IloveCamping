<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 클릭했어용</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/header.css">
<body>
<section>
    <h4>커뮤니티</h4>
    <table>
        <tr>
            <td>${community.title}</td>
        </tr>
        <tr>
            <td>${community.writerNickname}</td>>
            <td>${community.registeredDate}</td>
        </tr>
        <tr>
            <td><p>
                ${community.content}
            </p>
            </td>

        </tr>
    </table>
    <table>
        <tr>
            <th>댓글</th>
        </tr>
        <tr>
            <td><input type="textarea"></td>
            <td><input type="submit" value="저장"></td>
        </tr>
    </table>




</section>
</body>
</html>