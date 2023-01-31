<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Song List</h3>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th><th>제목</th><th>가사</th>
		</tr>
	<c:forEach var="song" items="${songList}">
		<tr>
			<td>${song.sid}</td>
			<td>${song.title}</td>
			<td>${song.lyrics}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>