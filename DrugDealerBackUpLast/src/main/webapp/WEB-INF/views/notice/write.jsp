<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/contactstyles.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
	
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<script>
	$(document).ready(function() {
		var fObject = $(".form");

		$(".btnCancel").on("click", function() {

			fObject.attr("method", "get");
			fObject.attr("action", "/ex/notice/list");
			fObject.submit();

		})
		$(".btnSave").on("click", function() {
			fObject.attr("method", "post");
			fObject.attr("action", "/ex/notice/modify");
			fObject.submit();
		})

	});
</script>
<style type="text/css">
a:link {
	color: grey;
	text-decoration: none
}

a:visited {
	color: grey;
	text-decoration: none
}
</style>
</head>

<body class="d-flex flex-column">
	<main class="flex-shrink-0"> <!-- Page content-->
	<section class="py-5">
		<!-- Contact form-->
		<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
			<div class="text-center mb-5">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-envelope"></i>
				</div>
					
				<h1 class="fw-bolder">글쓰기</h1>
			</div>
		<!--------------------------------------------------------------------  -->
			<div class="row gx-5 justify-content-center">

				<div class="col-lg-8 col-xl-6">

					<form id="contactForm" action="/ex/notice/write" method="post">

						<div class="box-header">
							<h3 class="box-title"></h3>
						</div>
						<!-- /.box-header -->
						<!-- action에 경로가 없으면 현재 페이지 주소로 이동한다.-->

						<h6>
							제목 <input type="text" name='title' placeholder="제목을 입력해 주세요"
								style="width: 100%">
						</h6>
						<h6>
							내용
							<textarea name="content" rows="8" style="width: 100%"
								placeholder="내용을 50자 이상 입력해 주세요." minlength: "50"></textarea>
							<br> <span style="color: #aaa;" id="counter">(0 / 최대
								200자)</span>
						</h6>
						<h6>
							작성자 <input type="text" name="writer" placeholder="작성자"
								style="width: 100%">
						</h6>
						<!-- /.box-body -->
						<button type="submit" class="btnSave">새글등록</button>
					</form>
					<button class="btnCancel" onclick="location.href='/ex/notice/list'">취소</button>
				</div>
				<!--------------------------------------------------------------------  -->
			</div>

		</div>

		<!-- Contact cards-->
		<div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
			<div class="col">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-chat-dots"></i>
				</div>
				<div class="h5 mb-2">Chat with us</div>
				<p class="text-muted mb-0">Chat live with one of our support
					specialists.</p>
			</div>
			<div class="col">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-people"></i>
				</div>
				<div class="h5">Ask the community</div>
				<p class="text-muted mb-0">Explore our community forums and
					communicate with other users.</p>
			</div>
			<div class="col">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-question-circle"></i>
				</div>
				<div class="h5">Support center</div>
				<p class="text-muted mb-0">Browse FAQ's and support articles to
					find solutions.</p>
			</div>
			<div class="col">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-telephone"></i>
				</div>
				<div class="h5">Call us</div>
				<p class="text-muted mb-0">Call us during normal business hours
					at (555) 892-9403.</p>
			</div>
		</div>

	</section>
	</main>
	<!-- Footer-->
	<%@include file="../include/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>




