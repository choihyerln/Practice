<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
<!-- // Heading -->
<%@ include file="../common/heading.jsp"%>
<!-- // Heading -->

<title>알뜰 정보</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/aos.css">
<link rel="stylesheet" type="text/css" href="/css/owl.carousel.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/css/news.css">
</head>
<body>
	<!-- TOP -->
	<%@ include file="../common/top.jsp"%>
	<!-- TOP -->
	
	<div class="container">
<!--<div class="container-nonaside-sm"> -->
        <h2>간편 경제 뉴스</h2>
        <p id="WhatTimeIsItNow" class="time"></p>
        <br>
		<div class="row">
			<c:forEach items="${newsList}" var="list">
				<div class="col-md-4">
					<div class="box" data-aos="fade-up" data-aos-delay="100">
						<h6 class="card-date">${list.pubDate}
							<span class="badge badge-secondary">${list.category}</span>
						</h6>
						<h5>
							<a href="${list.link}" class="card-title">${list.title}</a>
						</h5>
						<p class="card-text">${list.description}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/script.js"></script>
    <script src="../js/time.js"></script>
    <script language="javascript">
        window.setTimeout('window.location.reload()', 300000);       // 5분마다 갱신
    </script>
</body>
</html>