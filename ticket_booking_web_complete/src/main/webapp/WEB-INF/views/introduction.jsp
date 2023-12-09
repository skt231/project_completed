<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<head>
<meta charset="utf-8">
<title>소개</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- ** Plugins Needed for the Project ** -->
<!-- Bootstrap -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome/css/all.css">

<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">


<!--Favicon-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	type="image/x-icon">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	type="image/x-icon">
<!-- style -->

<style>
.top-right {
	position: absolute;
	top: 10px;
	right: 10px;
}

.top-right a {
	color: aliceblue;
}

.main-content {
	padding: 60px 0;
}

.main-content h2 {
	color: #333;
	font-size: 36px;
	font-weight: 700;
	margin-bottom: 20px;
}

.main-content p {
	color: #666;
	font-size: 18px;
	line-height: 1.6;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<!-- 소통페이지 -->
	<!-- START preloader-wrapper -->
	<div class="preloader-wrapper">
		<div class="preloader-inner">
			<div class="spinner-border text-red"></div>
		</div>
	</div>
	<!-- END preloader-wrapper -->

	<!-- START main-wrapper -->
	<section class="d-flex">

		<!-- start of sidenav -->
		<aside>
			<div
				class="sidenav position-sticky d-flex flex-column justify-content-between">
				<a class="navbar-brand" href="/app/" class="logo"> <img
					src="${pageContext.request.contextPath}/resources/images/logo.png"
					alt="">
				</a>
				<!-- end of navbar-brand -->

				<div class="navbar navbar-dark my-4 p-0 font-primary">
					<ul class="navbar-nav w-100">
						<li class="nav-item active"><a
							class="nav-link text-white px-0 pt-0" href="/app/">Home</a></li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/introduction">소개</a></li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/board">소통공간</a></li>
						<li class="nav-item  accordion">
							<div id="drop-menu_1" class="drop-menu collapse">
								<a class="d-block " href="/app/reservation/rsv">예매하기</a> <a
									class="d-block " href="/app/playList">전체 공연</a> <a
									class="d-block "
									href="/app/reservation/readId?userid=${userses.id}">예매현황</a>
							</div> <a class="nav-link text-white" href="#!" role="button"
							data-toggle="collapse" data-target="#drop-menu_1"
							aria-expanded="false" aria-controls="drop-menu_1">예매하기</a>
						</li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/user/userDetailed?id=${userses.id}">MyPage</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="nav-item  accordion">
								<div id="drop-menu_2" class="drop-menu collapse">
									<a class="d-block " href="/app/user//listAll">회원목록</a> <a
										class="d-block " href="###">###</a> <a class="d-block "
										href="###">###</a>
								</div> <a class="nav-link text-white" href="#!" role="button"
								data-toggle="collapse" data-target="#drop-menu_2"
								aria-expanded="false" aria-controls="drop-menu_2">관리메뉴</a>
							</li>
						</sec:authorize>
					</ul>
				</div>
				<!-- end of navbar -->
				<br>
			</div>
		</aside>

		<div class="top-right">
			<sec:authorize access="isAnonymous()">
				<p>

					<span><a href="/app/user/login">로그인</a></span> &nbsp; <span><a
						href="/app/user/linkRegister">등록</a></span>
				</p>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<span>${userses.username}!</span> &nbsp;
        <a href="${pageContext.request.contextPath}/user/logout"
					onclick="event.preventDefault(); document.getElementById('logoutForm').submit();">
					로그아웃 </a>
				<form:form id="logoutForm"
					action="${pageContext.request.contextPath}/user/logout"
					method="POST" style="display: none;">
				</form:form>
			</sec:authorize>
		</div>
		<!-- end of sidenav -->
		<!-- -------------------------------------------------------------------------------------------------------------------------------------- -->
		<div class="main-content">
			<!-- start of mobile-nav -->
			<header class="mobile-nav pt-4">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-6">
							<a href="/app/"> <img
								src="${pageContext.request.contextPath}/resources/images/logo.png"
								alt="">
							</a>
						</div>
						<div class="col-6 text-right">
							<button class="nav-toggle bg-transparent border text-white">
								<span class="fas fa-bars"></span>
							</button>
						</div>
					</div>
				</div>
			</header>
			<div class="nav-toggle-overlay"></div>
			<!-- end of mobile-nav -->
			<section class="main-content py-5">
				<div class="container px-4 px-lg-5 mt-5">
					<h3 class="mb-4">여정의 시작, 뮤지컬의 매력을 만나다</h3>

					<p>뮤지컬 예매 웹사이트는 여러분을 특별한 뮤지컬 여행으로 초대합니다. "여정의 시작, 뮤지컬의 매력을
						만나다"는 우리의 모토입니다. 음악과 연기, 무용이 만끽할 수 있는 최고의 뮤지컬 공연을 여러분에게 소개합니다.</p>
					<br>
					<h3 class="mb-4">감동의 순간, 뮤지컬 예매 웹사이트에서 함께 나눠요</h3>

					<p>여러분은 이곳에서 뮤지컬의 감동을 만끽할 수 있습니다. 음악과 연기의 조화, 무용의 아름다움이 어우러진
						무대에서 여러분만의 특별한 순간을 찾아보세요. 뮤지컬 예매 웹사이트는 오롯이 여러분을 위한 최고의 뮤지컬 작품을
						선별하여 제공합니다.</p>
					<br>
					<h3 class="mb-4">당신만을 위한 예매 경험, 여기서 시작됩니다</h3>

					<p>뮤지컬 예매는 단순한 티켓 구매가 아닌, 여러분과 뮤지컬과의 감동을 이어주는 특별한 경험입니다. 여러분은
						이곳에서 각종 뮤지컬 작품들 중 여러분이 원하는 것을 골라 예매할 수 있습니다.</p>
					<br>
					<h3 class="mb-4">뮤지컬 예매 웹사이트와 함께라면, 더 특별한 순간이 펼쳐집니다</h3>

					<p>여러분의 뮤지컬 여정은 지금 시작됩니다. 뮤지컬 예매 웹사이트에서는 여러분에게 특별한 순간들을 선사할 준비가
						되어 있습니다. 함께해요, 당신만을 위한 특별한 여정이 여기에서 펼쳐집니다.</p>
				</div>
			</section>


		</div>

	</section>
	<!-- END main-wrapper -->
	<!-- 	---------------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- All JS Files -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/imageModule.js"
		defer></script>
	<!-- Main Script -->
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	<script>
		
	</script>
</body>
