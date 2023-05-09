<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>캠핑장 정보</title>
</head>
<body>
<c:if test="${not empty camp}">
    <h2>${camp.campName}</h2>
    <p>${camp.campAddress1} ${camp.campAddress2}</p>
    <img src="${camp.campImage}" alt="campsite-image">
    <p>${camp.campInfo}</p>
</c:if>
</body>
</html>
