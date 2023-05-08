<%--
  Created by IntelliJ IDEA.
  User: leah
  Date: 5/3/23
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 글쓰기페이지</title>
</head>
<body>
<section>
    <form>
        <table>
            <tr>
                <td>
                    <select id="category" name="category">
                        <option value="">카테고리선택</option>
                        <option value="CC100001">공지사항</option>
                        <option value="CC100005">캠핑팁</option>
                    </select>
                </td>
                <td>작성자 : </td>
                <td id="nickname" name="nickname" value="${sessionScope.log.adminNickname}">${sessionScope.log.adminNickname}</td>
            </tr>
            <tr>
                <td><input type="text" id="title" name="title" placeholder="제목"></td>
            </tr>
            <tr>
                <td><textarea id="content" name="content" placeholder="[관리자] 내용 작성"></textarea>
            </tr>
        </table>
        <input type="button" value="등록" onclick="clientWrite(form)">
        <input type="button" value="작성취소" onclick="location.href='community'">
    </form>
</section>
</body>
</html>
