<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력 시 db에 저장</h1>
	<div class="layout">
		<form action="/challenge/test" method="post">
			<input name="cid" type="number"><br>
			<input name="uid" type="text"><br>
			<button type="submit">저장</button>
		</form>
	</div>
</body>
</html>