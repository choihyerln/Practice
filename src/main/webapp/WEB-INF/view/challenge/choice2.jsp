<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>챌린지 선택</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/questions.css">
    <script language="javascript">
        function showPopup() { window.open("popup.jsp", "a", "width=400, height=300, left=500, top=200"); }
        </script>
</head>
<body>
    <div class="question-box">
        <div class="question">
            <h3>${uname}님,<br>
                오늘 참여한 챌린지를<br>
                선택해주세요!</h3>
        </div>
        <button class="btn btn-gray choice choice1" type="submit" name="op" value="cha1" onclick="showPopup();">${challenge.get(0)}</button><br>
        <button class="btn btn-gray choice choice2" type="submit" name="op" value="cha2">${challenge.get(1)}</button><br>
        <button class="btn btn-gray choice choice3" type="submit" name="op" value="cha3" onclick="showPopup();">${challenge.get(2)}</button>
    </div>
</body>
</html>