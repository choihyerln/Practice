<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- // Heading -->
	<%@ include file="../common/heading.jsp"%>
	<!-- // Heading -->
    <title></title>
	<link rel="stylesheet" href="/css/loginForm.css">
</head>
<body>
 	<!-- TOP -->
	<%@ include file="../common/top.jsp"%>
	<!-- TOP -->
	 
    <div class="container">
        <!-- Heading -->
        <h1>Save dot</h1>
        
        <!-- Links -->
        <ul class="links">
          <li>
            <a href="#" id="signin">로그인</a>
          </li>
          <li>
            <a href="/user/join" id="signup">회원가입</a>
          </li>
        </ul>
        <!-- 일반 로그인 -->
        <form action="/user/login" method="post">
            <!-- id input -->
            <div class="first-input input__block first-input__block">
                <input type="text" name="id" placeholder="아이디" class="input" id="id"/>
            </div>
            <!-- password input -->
            <div class="input__block">
                <input type="password" name="pwd" placeholder="비밀번호" class="input" id="password"/>
            </div>
            <!-- repeat password input -->
            <div class="input__block">
                <input type="password" placeholder="비밀번호 확인" class="input repeat__password" id="repeat__password"    />
            </div>

            <!-- sign in button -->
            <button type="submit" class="signin__btn">
                로그인
            </button>
        </form>
        <!-- separator -->
        <div class="separator">
          <p>OR</p>
        </div>
        <!-- 카카오 로그인 -->
        <button class="kakao__btn">
          <i class="fa fa-kakao"></i>
          카카오계정으로 로그인
        </button>
      </div>
      
      <footer>
        <p>
          <i class="fa fa-heart"></i> 
          <i class="fa fa-heart"></i> 
          <i class="fa fa-heart"></i> 
        </p>
      </footer>
      <script src="/js/loginForm.js?ver=1"></script>
</body>
</html>