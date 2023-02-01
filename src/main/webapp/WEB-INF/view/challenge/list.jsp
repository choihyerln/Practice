<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cSuccess List</h1>
	<table border="1">
		<tr>
			<th>sid</th><th>successDate</th><th>cid</th><th>uid</th>
		</tr>
		<c:forEach items="${successList}" var="s">
		<tr>
			<td>${s.sid}</td>
			<td>${s.successDate}</td>
			<td>${s.cid}</td>
			<td>${s.uid}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>