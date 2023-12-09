<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="utf-8">
<title>공연정보</title>

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
body {
	max-width: 830px;
	margin: 0 auto;
}

#info img {
	margin: 30px;
	width: 400px;
}

#info td {
	border: white 1px dotted;
	font-size: 13px;
}

.main-content {
	width: 100%;
	height: 100%;
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
	<!-- -------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- Main Content -->
	<div class="main-content">
		<table id="info">
			<tr>
				<td rowspan="6"><img id="poster" src="" alt=""></td>
				<td>제목 : <span id="title"></span></td>
			</tr>
			<tr>
				<td>공연날짜 : <span id="prStart"></span> ~ <span id="prEnd"></span><br>
					<span id="prDatetime"></span></td>
			</tr>
			<tr>
				<td>공연시간 : <span id="prtime"></span></td>
			</tr>
			<tr>
				<td>장소 : <span id="prloc"></span></td>
			</tr>
			<tr>
				<td>출연진 : <span id="prcast"></span> / <span id="prcrew"></span></td>
			</tr>
			<tr>
				<td>가격 : <span id="prprice"></span></td>
			</tr>
			
		</table>
	</div>


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
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {
							function displayInfo() {
								fetchAndInfo()
										.then(
												function(data) {
													var keys = Object
															.keys(data);
													for (var i = 0; i < keys.length; i++) {
														var key = keys[i];
														if (document
																.querySelector("#"
																		+ key)) {
															if (key === 'poster') {
																document
																		.querySelector("#"
																				+ key).src = data[key];
															} else {
																document
																		.querySelector("#"
																				+ key).textContent = data[key];
															}
														}
													}
												});
							}

							displayInfo();
						});
	</script>
</body>
