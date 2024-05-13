<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>   

<!DOCTYPE html>
<html lang="ko">

<style>
	@font-face {
	    font-family: 'mice';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2206-01@1.0/MICEGothic Bold.woff2') format('woff2');
	    font-weight: 700;
	    font-style: normal;
	}

	.mice {
    	font-family: 'mice';
	}
</style>

<head>
    <meta charset="utf-8">
    <title>앗!차차</title>
</head>
<!-- Body-->

<body>
    <!-- Page wrapper-->
    <main class="page-wrapper">
        <!-- Page content-->
            <!-- Home button--><a class="text-nav btn btn-icon bg-light border rounded-circle position-absolute top-0 end-0 p-0 mt-3 me-3 mt-sm-4 me-sm-4" href="index.html" data-bs-toggle="tooltip" data-bs-placement="left" title="Back to home"><i class="ai-home"></i></a>
            <!-- Sign up form-->
                    <h1 calss="mice">Sign up</h1>
                    <p class="pb-3 mb-3 mb-lg-4">이미 계정이 있으세요?&nbsp;&nbsp;<a href='${path}/mypage/signIn'>로그인 하러가기</a></p>
                    <form class="needs-validation" novalidate name="signUp" action="${path}/member/enroll" method="post">
                        <!-- ID / 이름 -->
                            <div class="col mb-4">
                                <input class="form-control form-control-lg" type="text" name="userId" id="idcheck" placeholder="ID" required>
                            </div>
                            <div class="col mb-4">
                                <input class="form-control form-control-lg" type="text" name="user_name" placeholder="Name" required>
                            </div>
                        <!-- 닉네임 -->
                        <div class="col mb-4">
                            <input class="form-control form-control-lg" type="text" name="user_nickname" id="nicknamecheck" placeholder="Nickname" required>
                        </div>
                        <!-- 전화번호 -->
                        <div class="col mb-4">
                            <input class="form-control form-control-lg" type="tel" name="user_phone" placeholder="Phone" required>
                        </div>
                        <!-- 비밀번호 -->
                        <div class="password-toggle mb-4">
                            <input class="form-control form-control-lg" type="password" name="user_password" placeholder="Password" required>
                            <label class="password-toggle-btn" aria-label="Show/hide password">
                                <input class="password-toggle-check" type="checkbox">
                                <span class="password-toggle-indicator"></span>
                            </label>
                        </div>
                        <!-- 비밀번호 확인 -->
                        <div class="password-toggle mb-4">
                            <input class="form-control form-control-lg" type="password" placeholder="Confirm password" required>
                            <label class="password-toggle-btn" aria-label="Show/hide password">
                                <input class="password-toggle-check" type="checkbox">
                                <span class="password-toggle-indicator"></span>
                            </label>
                        </div>
                        <!-- E-Mail -->
                        <div class="col mb-4">
                            <input class="form-control form-control-lg" type="email" name="user_email" placeholder="E-Mail" required>
                        </div>
                        <!-- 약관동의 -->
                        <div class="pb-4">
                            <div class="form-check my-2">
                                <input class="form-check-input" type="checkbox" id="terms" checked>
                                <label class="form-check-label ms-1" for="terms"><a>개인정보 제3자 제공 및 약관에 동의합니다.</a></label>
                            </div>
                        </div>
                        <!-- 회원가입 버튼 -->
                        <button class="btn btn-lg btn-primary w-100 mb-2" type="submit">Sign up</button>
                        <h2 class="h6 text-center pt-3 pt-lg-4 mb-4">Or sign in with your social account</h2>
                        <!-- 카카오 회원가입 -->
                        <!-- <div class="pb-3 mb-3 row-cols-3 row-cols-sm-2 gy-3">
                            <button onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=bb1b195fa1cb4272d2535902db3d9984&redirect_uri=http://localhost/realfinal/kakao/callback&response_type=code'" class="btn btn-lg btn-primary w-100 mb-2" style="background-color: #FEE500; border-color: #FEE500; border-radius: 12px; height:57px;" type="button" id="kakaologin" ><img src="${path}/resources/resources2a/assets/img/account/kakao_logo01.png" width: 50%; height: 50%;>&nbsp Login with Kakao</button>
                        </div> -->
                    </form>
                </div>
                <!-- Copyright-->
                <p class="w-100 fs-sm pt-5 mt-auto mb-5" style="max-width: 526px;"><span class="text-muted"></span>
                    <a class="nav-link d-inline-block p-0 ms-1" href="https://createx.studio/" target="_blank" rel="noopener"></a>
                </p>
            </div>
    </main>
    <!-- Back to top button-->
    <a class="btn-scroll-top" href="#top" data-scroll>
        <svg viewBox="0 0 40 40" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <circle cx="20" cy="20" r="19" fill="none" stroke="currentColor" stroke-width="1.5" stroke-miterlimit="10"></circle>
    </svg><i class="ai-arrow-up"></i></a>
    <!-- Vendor scripts: js libraries and plugins-->
    <!-- <script src="${path}/resources/resources2a/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/resources/resources2a/assets/vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script> -->
</body>

</html>