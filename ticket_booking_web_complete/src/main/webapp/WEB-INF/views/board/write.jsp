<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>게시글 작성</title>

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
.head {
	text-align: center;
	font-size: 36px;
}

.top-right {
	position: absolute;
	top: 10px;
	right: 10px;
}

.top-right a {
	color: aliceblue;
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
			<div class="container py-4 my-5">
				<h1 class=head>글쓰기</h1>
				<form id="writeForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}"> <input type='hidden'
						name='user_id' value="${userses.id}"> <select
						name="bulletin" id="titleContainer"
						data-xmlurl="http://www.kopis.or.kr/openApi/restful/pblprfr?service=b0a82e699a254319bbe6decc02de2489&stdate=20230901&eddate=20230910&cpage=1&rows=5&prfstate=02&signgucode=11&signgucodesub=1111&kidstate=Y">
						<option value="free">자유</option>
					</select>
					<h6>
						제목 <input type="text" name='title' placeholder="제목을 입력해 주세요"
							style="width: 100%" required>
					</h6>
					<h6>
						내용
						<textarea name="content" class="content" rows="8"
							style="width: 100%" placeholder="내용을 50자 이상 입력해 주세요." required></textarea>
						<br> <span style="color: #aaa;" id="counter">
							<p class="count">0</p>/ 최대 2000자
						</span>
					</h6>
					<h6>
						작성자 <input type="text" name="username" value="${userses.username}"
							style="width: 100%" readonly="readonly" required>
					</h6>
					<!-- /.box-body -->
					<button type="button" class="btnCancel">취소</button>
					<button type="submit" class="btnSave">새글등록</button>
				</form>

			</div>
		</div>
	</section>
	<!-- END main-wrapper -->
	<!-- 	---------------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- All JS Files -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/bootstrap/bootstrap.min.js"></script>
	<!-- 메인 스크립트 -->
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/imageModule.js"></script>
	<script>
		$(document).ready(function() {
			var fObject = $("#writeForm");

			$(".btnCancel").on("click", function() {

				fObject.attr("method", "get");
				fObject.attr("action", "/app/board/list");
				fObject.submit();

			})
			$(".btnSave").on("click", function() {
				fObject.attr("method", "post");
				fObject.attr("action", "/app/board/write");
				fObject.submit();
			})

		});

		function bytesHandler(obj) {
			var text = $(obj).val();
			$('p.bytes').text(getTextLength(text));
		}
		$(document).ready(function() {
			$("textarea").keyup(function() {
				var inputLength = $(this).val().length;
				if (inputLength > 2000)
					alert("더이상 입력할 수 없습니다.");
				var remain = 2000 - inputLength;
				$(".count").html(remain);
			});
		});
		/* --- */
		document.addEventListener("DOMContentLoaded", function() {
			fetchAndDisplayTitle().then(function(data) {
				var titleContainer = document.getElementById('titleContainer');

				data.forEach(function(item) {
					var option = document.createElement('option');
					option.value = item.title.trim(); // 여기에서 실제 값을 지정
					option.textContent = item.title; // 여기에서 제목을 가져옴
					console.log(item.title);
					titleContainer.appendChild(option);
				});
			});
		});
	</script>
</body>
</html>
