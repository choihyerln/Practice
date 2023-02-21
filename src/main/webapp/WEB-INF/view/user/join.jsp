<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
</head>
<body>
<div class="container" style="max-width: 500px">
    <div class="py-5">

            <!-- 간편 회원가입 -->
            <div class="text-center">
                <h3>회원가입</h3>
                <div>
                    <div>카카오 계정으로 간편 로그인/회원가입</div>
                    <a dataype="kakao" href="#">
                        <svg width="48" height="48" viewBox="0 0 48 48" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><path fill="#FFEB00" d="M0 24C0 10.745 10.745 0 24 0s24 10.745 24 24-10.745 24-24 24S0 37.255 0 24z"></path><path fill="#3C2929" d="M24 11.277c8.284 0 15 5.306 15 11.85 0 6.545-6.716 11.85-15 11.85-.92 0-1.822-.066-2.697-.191l-6.081 4.105a.43.43 0 0 1-.674-.476l1.414-5.282C11.777 31.031 9 27.335 9 23.127c0-6.544 6.716-11.85 15-11.85zm6.22 8.407c-.416 0-.718.297-.718.707v5.939c0 .41.289.686.718.686.41 0 .718-.295.718-.686v-1.932l.515-.526 1.885 2.57c.277.374.426.54.691.568.037.003.075.005.112.005.154 0 .66-.04.716-.563.038-.293-.137-.52-.348-.796l-2.043-2.675 1.727-1.743.176-.196c.234-.26.353-.39.353-.587.009-.422-.34-.652-.687-.661-.274 0-.457.15-.57.262l-2.528 2.634v-2.3c0-.422-.288-.706-.717-.706zm-9.364 0c-.56 0-.918.432-1.067.837l-2.083 5.517a.84.84 0 0 0-.065.315c0 .372.31.663.706.663.359 0 .578-.162.69-.51l.321-.97h2.999l.313.982c.111.335.34.498.7.498.367 0 .655-.273.655-.62 0-.056-.017-.196-.081-.369l-2.019-5.508c-.187-.53-.577-.835-1.069-.835zm-2.92.064h-4.452c-.417 0-.642.337-.642.654 0 .3.168.652.642.652h1.51v5.21c0 .464.274.752.716.752.443 0 .718-.288.718-.751v-5.21h1.508c.474 0 .643-.352.643-.653 0-.317-.225-.654-.643-.654zm7.554-.064c-.442 0-.717.287-.717.75v5.707c0 .497.28.794.75.794h2.674c.434 0 .677-.321.686-.627a.642.642 0 0 0-.17-.479c-.122-.13-.3-.2-.516-.2h-1.99v-5.195c0-.463-.274-.75-.717-.75zm-4.628 1.306l.008.01 1.083 3.265h-2.192L20.842 21a.015.015 0 0 1 .028 0z"></path></g></svg>
                    </a>
                </div>
            </div>
            <hr class="my-4">
               
               <!-- 일반 회원가입 폼 -->
            <form action="/user/join" method="post">
                <!-- 아이디 -->
                <div>
                    <label>아이디</label>
                    <div>
                        <label><input class="form-control" placeholder="아이디" name="id" value=""></label>
                        <button name="idCheck" type="button">아이디 중복확인</button>
                    </div>
                </div>
                
                <!-- 비밀번호 -->
                <div>
                    <label>비밀번호</label>
                    <p>영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</p>
                    <label><input type="password" name="pwd" class="form-control" placeholder="비밀번호" value=""></label>
                   </div>
                <div>
                    <label class="css-fl3hsq euhjq6q2">비밀번호 확인</label>
                    <br>
                    <label><input type="password" class="form-control" value="" name="pwd2" placeholder="비밀번호 확인"></label>
                </div>
    
                <!-- 닉네임 -->
                <div>
                    <label>닉네임</label>
                    <p>다른 유저와 겹치지 않도록 입력해주세요. (2~15자)</p>
                    <label><input class="form-control" value="" name="nickname" placeholder="별명 (2~15자)"></label>
                </div>
    
                <!-- 이메일 -->
                <div>
                    <label>이메일</label>
                    <div>
                        <span class="email-input__local">
                            <label><input type="email" class="form-control" placeholder="이메일" name="email" value=""></label>
                        </span>
                        <!-- <span class="email-input__separator" name="@">@</span>
                        <span class="email-input__domain" name="email2" id="email2">
                            <label><select class="form-control empty">
                                <option value="" disabled selected>선택해주세요</option>
                                <option value="naver.com">naver.com</option>
                                <option value="hanmail.net">hanmail.net</option>
                                <option value="daum.net">daum.net</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="nate.com">nate.com</option>
                                <option value="hotmail.com">hotmail.com</option>
                                <option value="outlook.com">outlook.com</option>
                                <option value="icloud.com">icloud.com</option>
                                <option value="1">직접입력</option>
                            </select></label>
                            <button class="email-input__domain__expand" aria-label="초기화" type="button" tabindex="-1"><svg class="icon" width="10" height="10" preserveAspectRatio="xMidYMid meet" style="fill: currentcolor;"><path fill-rule="evenodd" d="M0 3l5 5 5-5z"></path></svg></button>
                        </span> -->
                    </div>
                </div>
                    
                    <!-- <input type="text" id="email_id" class="form_w200" value="" title="이메일 아이디" placeholder="이메일" maxlength="18" /> @ 
                    <input type="text" id="email_domain" class="form_w200" value="" title="이메일 도메인" placeholder="이메일 도메인" maxlength="18"/> 
                    <select class="select" title="이메일 도메인 주소 선택" onclick="setEmailDomain(this.value);return false;">
                        <option value="">-선택-</option>
                        <option value="naver.com">naver.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="hanmail.net">hanmail.net</option>
                        <option value="hotmail.com">hotmail.com</option>
                        <option value="korea.com">korea.com</option>
                        <option value="nate.com">nate.com</option>
                        <option value="yahoo.com">yahoo.com</option>
                    </select> -->

                <!-- 선택 항목 -->
    
                <!-- 연락처 -->
                <div>
                    <label>연락처</label>
                    <br>
                    <label><input class="form-control" value="" name="tel" placeholder="휴대전화번호를 입력해주세요 (- 제외)"></label>
                </div>
    
                <!-- 급여 -->
                <div>
                    <label>월 급여 또는 용돈</label>
                    <br>
                    <label><input class="form-control" value="" name="pay" placeholder="급여나 용돈을 입력해주세요"></label>
                </div>
    
                <!-- 출발지 -->
                <div>
                    <label>출발지</label>
                    <br>
                    <label><input class="form-control" value="" name="departures" placeholder=""></label>
                </div>
    
                <!-- 목적지 -->
                <div>
                    <label>목적지</label>
                    <br>
                    <label><input class="form-control" value="" name="arrivals" placeholder=""></label>
                </div>
    
                <!-- 교통수단 -->
                <div>
                    <label>교통수단</label>
                    <br>
                    <label><select class="form-control empty" name="vehicles">
                        <option value="" selected>선택해주세요</option>
                        <option value="taxi">택시</option>
                        <option value="car">자차</option>
                    </select></label>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">회원가입하기</button>
                </div> 
            </form>
        </div>
    </div> <!-- /container -->
</body>
</html>