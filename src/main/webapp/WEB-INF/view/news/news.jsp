<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<!-- 	<div class="container-nonaside-sm"> -->
		<h2>간편 경제 뉴스</h2>
		<div class="row">
			<div class="col-md-4">
				<div class="box" data-aos="fade-up" data-aos-delay="100">
					<h6 class="card-date">${pubDate}
						<span class="badge badge-secondary">금리</span>
					</h6>
					<h5>
						<a href="${link}" class="card-title">${title}</a>
					</h5>
					<p class="card-text">${description}</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="box" data-aos="fade-up" data-aos-delay="200">
					<h6 class="card-date">${pubDate}
						<span class="badge badge-secondary">주택</span>
					</h6>
					<h5>
						<a href="${link}" class="card-title">${title}</a>
					</h5>
					<p class="card-text">${description}</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="box" data-aos="fade-up" data-aos-delay="300">
					<h6 class="card-date">${pubDate}
						<span class="badge badge-secondary">주식</span>
					</h6>
					<h5>
						<a href="${link}" class="card-title">${title}</a>
					</h5>
					<p class="card-text">${description}</p>
				</div>
			</div>
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
</body>
</html>