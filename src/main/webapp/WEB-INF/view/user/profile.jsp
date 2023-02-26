<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- //// MYPAGE PAGE - MAIN //// -->

<!DOCTYPE html>
<html lang="ko">
<head>
<!-- // Heading -->
<%@ include file="../common/heading.jsp"%>
<!-- // Heading -->

<title>회원정보 수정</title>
<style>
.nickname_ok {
	color: #008000;
	display: none;
}

.nickname_already {
	color: #6A82FB;
	display: none;
}
</style>
</head>
<body>
	<!-- //TOP -->
	<%@ include file="../common/top.jsp"%>
	<!-- TOP// -->
	<!-- MYPAGE - TOP -->
	<%@ include file="../common/mypage_top.jsp"%>
	<!-- MYPAGE - TOP -->

	<div class="container-lg">
		<div class="row">
			<!-- // ASIDE -->
			<%@ include file="../common/aside.jsp"%>
			<!-- ASIDE// -->

			<!-- content -->
			<!-- 일반 회원가입 폼 -->
			<form action="/user/update" method="post">
			<legend>필수입력사항</legend>

				<!-- 이름 -->
				<div>
					<label>* 이름</label> <br> <input class="form-control" value="${user.uname}"
						name="uname" placeholder="ex) 홍길동" disabled>
				</div>

				<!-- 아이디 -->
				<div>
					<label>* 아이디</label>
					<p>다른 유저와 겹치지 않도록 입력해주세요. (2~15자)</p>
					<input type="text" id="id" name="id" class="form-control"
						oninput="checkId()" placeholder="아이디" value="${user.id}" disabled>
				</div>

				<!-- 비밀번호 -->
				<div>
					<label>* 비밀번호</label>
					<p>영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</p>
					<input type="password" name="pwd" class="form-control"
						placeholder="비밀번호" value="" >
				</div>
				<div>
					<label>* 비밀번호 확인</label> <br> <input type="password"
						class="form-control" value="" name="pwd2" placeholder="비밀번호 확인">
				</div>

				<!-- 닉네임 -->
				<div>
					<label>* 닉네임</label>
					<p>다른 유저와 겹치지 않도록 입력해주세요. (2~15자)</p>
					<input type="text" id="nickname" name="nickname"
						class="form-control" oninput="checkNickname()" placeholder="별명"
						value="${user.nickname}" required>
					<!-- nickname ajax 중복체크 -->
					<span class="nickname_ok">사용 가능한 닉네임입니다.</span> <span
						class="nickname_already">누군가 이 닉네임을 사용하고 있어요.</span>
				</div>

				<!-- 이메일 -->
				<div>
					<label>* 이메일</label>
					<div>
						<span class="email-input__local"> <input type="email"
							class="form-control"
							placeholder="ex) savedot@mulcam.com (@ 포함기입)" required
							name="email" value="${user.email}">
						</span>
					</div>
				</div>

				<!-- 선택 항목 -->
				<legend>선택입력사항</legend>
				<!-- 연락처 -->
				<div>
					<label>연락처</label> <br> <input type="number"
						class="form-control" value="${user.tel}" name="tel"
						placeholder="ex) 01012345678">
				</div>

				<!-- 생년월일 -->
				<div>
					<label>생년월일</label>
					<p>생년월일 8자리 숫자를 입력해주세요.</p>
					<input type="number" class="form-control" value="${user.birthDate}" name="birthDate"
						placeholder="ex) 19990101">
				</div>

				<!-- 주소 -->
				<div>
					<label>주소</label> <br> <label><input
						class="form-control" name="addr" type="text" id="sample4_postcode"
						placeholder="우편번호"></label> <input type="button" onclick=""
						value="${user.addr}"><br>
				</div>
				<div>
					<label>도로명주소(자동입력)</label> <br> <input class="form-control"
						type="text" name="addr" id="sample4_roadAddress"
						placeholder="우편번호찾기를 이용해주세요" readonly><br> <input
						type="hidden" id="sample4_jibunAddress" placeholder="지번주소">
					<span id="guide" style="color: #999; display: none"></span> <input
						type="hidden" id="sample4_extraAddress" placeholder="참고항목">
				</div>

				<!-- 급여 -->
				<div>
					<label>월 급여 또는 용돈</label> <br> <input type="number"
						class="form-control" value="${user.pay}" name="pay"
						placeholder="급여나 용돈을 입력해주세요">
				</div>

				<!-- 출발지 -->
				<div>
					<label>출발지</label> <br> <input class="form-control" value="${user.departures}"
						name="departures" placeholder="">
				</div>

				<!-- 목적지 -->
				<div>
					<label>목적지</label> <br> <input class="form-control" value="${user.arrivals}"
						name="arrivals" placeholder="">
				</div>

				<!-- 교통수단 -->
				<div>
					<label>교통수단</label> <br> <select name="vehicles" id="vehicles"
						class="form-select required font-14" style="flex: 0.2 0 0">
						<option value="" selected>선택해주세요</option>
						<option value="taxi">택시</option>
						<option value="car">자차</option>
					</select>
				</div>

				<!-- 자주 사용하는 계좌 -->
				<div>
					<label>자주 사용하는 계좌</label> <br> <label> <select
						name="bank" id="bank" class="form-select required font-14"
						style="flex: 0.2 0 0">
							<option value="" selected>은행</option>
							<option value="KB국민은행">KB국민은행</option>
							<option value="IBK기업은행">IBK기업은행</option>
							<option value="NH농협은행">NH농협은행</option>
							<option value="신한은행">신한은행</option>
							<option value="씨티은행">씨티은행</option>
							<option value="SC제일은행">SC제일은행</option>
							<option value="우리은행">우리은행</option>
							<option value="카카오뱅크">카카오뱅크</option>
							<option value="케이뱅크">케이뱅크</option>
							<option value="토스뱅크">토스뱅크</option>
							<option value="하나은행">하나은행</option>
							<option value="경남은행">경남은행</option>
							<option value="광주은행">광주은행</option>
							<option value="대구은행">대구은행</option>
							<option value="부산은행">부산은행</option>
							<option value="KDB산업은행">KDB산업은행</option>
							<option value="수협은행">수협은행</option>
							<option value="우체국은행">우체국은행</option>
							<option value="전북은행">전북은행</option>
							<option value="제주은행">제주은행</option>
							<option value="새마을금고">새마을금고</option>
							<option value="신협은행">신협은행</option>
							<option value="SBI저축은행">SBI저축은행</option>
							<option value="저축은행">저축은행</option>
							<option value="" disabled>증권</option>
							<option value="NH투자증권">NH투자증권</option>
							<option value="미래에셋증권">미래에셋증권</option>
							<option value="삼성증권">삼성증권</option>
							<option value="신한투자증권">신한투자증권</option>
							<option value="SK증권">SK증권</option>
							<option value="유안타증권">유안타증권</option>
							<option value="유진투자증권">유진투자증권</option>
							<option value="한국투자증권">한국투자증권</option>
					</select>
					</label> <label><input type="number" name="accountNumber"
						class="form-control" placeholder="계좌번호 (-)제외" value=""></label>
				</div>

				<!-- 내 지역 -->
				<div>
					<label>지역</label> <br> <select name="code" id="code"
						class="form-select required font-14" style="flex: 0.2 0 0">
						<option value="" selected>지역</option>
						<option value="서울특별시">서울특별시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="인천광역시">인천광역시</option>
						<option value="광주광역시">광주광역시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="울산광역시">울산광역시</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청북도">충청북도</option>
						<option value="충청남도">충청남도</option>
						<option value="전라북도">전라북도</option>
						<option value="전라남도">전라남도</option>
						<option value="경상북도">경상북도</option>
						<option value="경상남도">경상남도</option>
						<option value="제주특별자치도">제주특별자치도</option>
					</select>
				</div>
				<br>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">회원가입하기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- /container -->
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="/js/idCheck.js"></script>
	<script src="/js/nicknameCheck.js"></script>
</body>
</html>