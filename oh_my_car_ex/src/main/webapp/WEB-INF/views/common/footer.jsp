<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>  

<html>
<body>

<footer class="bg-light pt-3">
        <div class="container ">
            <!-- About and Newsletter START -->
            <div class="row pt-3 pb-1 ">
                <div class="col-md-3 ">
                    <img src="${path}/resources/resources1b/images/01_main/tcat_logo_white_under.png" alt="footer logo ">
                </div>
                <div class="col-md-5 ">
                    <p class="text-dark "> <br>
                    누구나 Try하면 정보를 Catch할 수 있는 Ticket이 되어 드리겠습니다. <br>
                    TCAT은 늘 정치, 경제 관련 최신 정보를 여러분께 전달합니다.<br>
                    </p>
                </div>
                <div class="col-md-4 ">
                    <!-- Form -->
                    <form class="row row-cols-lg-auto g-2 align-items-center justify-content-end ">
                        <div class="col-12 ">
                            <input type="email " class="form-control " placeholder="Enter your email address ">
                        </div>
                        <div class="col-12 ">
                            <button type="submit " class="btn btn-primary m-0 ">Subscribe</button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Divider -->
            <hr>
            <!-- Widgets START -->   
            <div class="row pt-1 text-dark ">
                <!-- Footer Widget -->
                <div class="col-md-6 col-lg-3 mb-3 ">
                    <h5 class="mb-4 text-dark ">Recent post</h5>
                    <!-- Item -->
                    <div class="mb-4 position-relative ">
                        <div><a class="badge text-bg-danger mb-2 "><i class="fas fa-circle me-2 small fw-bold "></i>Finance</a></div>
                        <a class="btn-link text-dark fw-normal ">10조로 커진 액티브 ETF…금리연동·채권형 대세로</a>
                    </div>
                </div>
                <!-- Footer Widget -->
                <div class="col-md-6 col-lg-3 mb-3 text-dark ">
                    <h5 class="mb-4 text-dark ">Sponsor</h5>
                    <div class="row ">
                        <div class="col-6 ">
                            <ul class="nav flex-column ">
                                <li class="nav-item "><a class="nav-link " href="https://www.assembly.go.kr/portal/main/main.do">대한민국 국회</a></li>
                                <li class="nav-item "><a class="nav-link pt-0 " href="https://www.fss.or.kr/fss/main/main.do">금융감독원</a></li>
                                <li class="nav-item "><a class="nav-link pt-0 " href="https://www.fsc.go.kr/index">금융감독위원회 </a></li>
                            </ul>
                        </div>
                        <div class="col-6 ">
                            <ul class="nav flex-column ">
                                <li class="nav-item "><a class="nav-link " href="https://www.moef.go.kr">기획재정부</a></li>
                                <li class="nav-item "><a class="nav-link " href="http://www.molit.go.kr/portal.do">국토교통부</a></li>
                                <li class="nav-item "><a class="nav-link " href="https://nhuf.molit.go.kr">주택도시기금</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Footer Widget -->
                <div class="col-sm-6 col-lg-3 mb-3 text-dark ">
                    <h5 class="mb-4 text-dark ">Get Regular Updates</h5>
                    <ul class="nav flex-column ">
                        <li class="nav-item ">
                            <a class="nav-link pt-0 ">
                                <i class="fab fa-whatsapp fa-fw me-2 "></i>WhatsApp
                            </a>
                        </li>
                        <li class="nav-item "><a class="nav-link " href="https://www.youtube.com"><i class="fab fa-youtube fa-fw me-2 "></i>YouTube</a></li>
                        <li class="nav-item "><a class="nav-link " ><i class="far fa-bell fa-fw me-2 "></i>Website Notifications</a></li>
                    </ul>
                </div>
                <!-- Footer Widget -->
                <div class="col-sm-6 col-lg-3 mb-3 ">
                    <h5 class="mb-4 text-dark ">Our Mobile App</h5>
                    <p class="text-dark ">TCAT 앱을 다운로드하여 최신 속보를 가장 빠르게 확인해보세요! </p>
                    <div class="row g-2 ">
                        <div class="col ">
                            <a href="# "><img class="w-100 " src="${path}/resources/resources1b/images/app-store.svg " alt="app-store "></a>
                        </div>
                        <div class="col ">
                            <a href="# "><img class="w-100 " src="${path}/resources/resources1b/images/google-play.svg " alt="google-play "></a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Widgets END -->
        </div>
    </footer>
    <!-- ====================== 푸터 끝 ======================= -->

    <!-- Back to top -->
    <div class="back-top"><i class="bi bi-arrow-up-short"></i></div>

    <!-- ======================= JS libraries, plugins and custom scripts -->
    
    <!-- Vendor js -->
    <script src="${path}/resources/resources4h/assets2/js/vendor.min.js "></script>
    <!-- 있어야함-->
    
    <!-- Apex Charts js 코스피 상세 그래프 맞음-->
    <script src="${path}/resources/resources4h/assets2/vendor/apexcharts/apexcharts.min.js "></script>
    <!-- 있어야함-->
    
     <!-- Apex Chart Area Demo js -->
    <script src="https://apexcharts.com/samples/assets/stock-prices.js "></script>
    <script src="https://apexcharts.com/samples/assets/series1000.js "></script>
    <script src="https://apexcharts.com/samples/assets/github-data.js "></script>
    <script src="https://apexcharts.com/samples/assets/irregular-data-series.js "></script>
    <script src="${path}/resources/resources4h/assets2/js/pages/demo.apex-area.js "></script><!-- 금융메인 코스피 그래프 -->
    <script src="${path}/resources/resources4h/assets2/js/pages/demo.apex-area2.js "></script><!-- 금융메인 코스닥 그래프 -->
    <script src="${path}/resources/resources4h/assets2/js/pages/demo.crm-dashboard.js "></script><!--  금융메인 환율그래프 -->
    
    
    <!-- 환율그래프-->
    <script src="${path}/resources/resources4h/assets2/js/pages/demo.dashboard.js "></script>

    <!-- Bootstrap JS -->
    <script src="${path}/resources/resources1b/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Vendors -->
    <script src="${path}/resources/resources1b/vendor/apexcharts/js/apexcharts.min.js"></script>
    <script src="${path}/resources/resources1b/vendor/overlay-scrollbar/js/OverlayScrollbars.min.js"></script>
    <script src="${path}/resources/resources1b/vendor/sticky-js/sticky.min.js"></script>

    <!-- Template Functions -->
    <script src="${path}/resources/resources1b/js/functions.js"></script>
    
     <!-- jquery import -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    
    <!-- 마이페이지 수정 실시간 JS -->
    <script src="${path}/resources/resources3f/dist/vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>
    <script src="${path}/resources/resources3f/dist/js/theme.min.js"></script>

</body>

</html>