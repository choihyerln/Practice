<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>챌린지 선택</title>
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
            <h3>${uname}님,<br>
                오늘 참여한 챌린지를<br>
                선택해주세요!</h3>
        </div>
        <c:forEach items="${challenge}" var="c">
        <button class="btn btn-gray choice" type="button" name="op" value="cha1" onclick="location.href='/challenge/choice/${c.cid}'">
	        <c:if test="${c.cid eq 1}">&#128652;</c:if>
	        <c:if test="${c.cid eq 2}">&#127869;</c:if>
	        <c:if test="${c.cid eq 3}">☕</c:if>
        	${c.cname}<br><strong style="color:CornflowerBlue; font-size: smaller; font-weight: 400;">${c.camount}원 절약</strong>
        </button>
        </c:forEach>		
    </div>
    <!-- </form> -->
</body>
</html>