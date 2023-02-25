<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/bootstrap.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/354b0809a2.js" crossorigin="anonymous"></script>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>챌린지 확인 페이지</title>
    <link rel="stylesheet" href="/css2/common.css">
    <link rel="stylesheet" href="/css2/questions.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/card.css">
    <link rel="stylesheet" href="/css/maincolor.css">
    <link rel="stylesheet" href="/css/mainstyle.css">
    <link rel="stylesheet" href="/css/mate.css">
</head>
<body>
    <!-- TOP -->
   <%@ include file="../common/top.jsp" %>
   <div class="question-box">
       	<div class="question">
        	<h3>${c.cname}<br>
        		챌린지를 성공하셨나요?</h3>
       	</div>
		<br>
		<button class="btn btn-gray choice" type="submit"
			onclick="location.href='/challenge/save/${c.cid}'">네, 성공했어요! ☺︎</button>
		<button class="btn btn-gray choice"
			onclick="location.href='/challenge/choice'">챌린지 다시 선택하기</button>
		<button class="btn btn-gray choice"
			onclick="location.href=#">취소</button>
	</div>
</body>
</html>