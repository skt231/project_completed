<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>게시판 목록</title>

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

.head {
	text-align: center;
	font-size: 25px;
}

.sign_head {
	display: flex;
	align-items: center;
	font-size: 13px;
}

.pagination {
	font-size: 12px;
	text-align: center;
	margin-top: 20px;
	height: 10px;
}

.pagination ul {
	list-style: none;
	padding: 0;
}

.pagination li {
	display: inline;
	margin-right: 5px;
}

.pagination a {
	text-decoration: none;
	background-color: #007BFF;
	color: #fff;
	padding: 5px 10px;
	border-radius: 5px;
}

.pagination a:hover {
	background-color: #0056b3;
}

.pagination a.current {
	background-color: #d80000;
}

table th {
	font-size: 14px;
}

table td {
	font-size: 13px;
}

table.border_tbl {
	width: 100%;
	border: 1px solid #000; /* 테이블의 외곽선을 1px 두께의 검정 선으로 설정 */
	border-collapse: collapse; /* 테이블 셀 간의 간격을 없애고 경계를 합침 */
}

table.border_tbl th, table.border_tbl td {
	border: 1px solid #000; /* 각 셀의 외곽선을 1px 두께의 검정 선으로 설정 */
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
				<h5 class=head>게시판</h5>
				<br>

				<div class=sign_head>

					<div style="flex-grow: 1;">
						<select name="searchType">
							<option value="n"
								<c:out value="${pageDto.searchType eq '-----'?'selected':'' }"/>>-----</option>
							<option value="t"
								<c:out value="${pageDto.searchType eq 't'?'selected':'' }"/>>제목</option>
							<option value="c"
								<c:out value="${pageDto.searchType eq 'c'?'selected':'' }"/>>내용</option>
							<option value="w"
								<c:out value="${pageDto.searchType eq 'w'?'selected':'' }"/>>작성자</option>
							<option value="tc"
								<c:out value="${pageDto.searchType eq 'tc'?'selected':'' }"/>>제목+
								내용</option>
						</select> <input type="text" name="keyword" id="keywordInput"
							value="${pageDto.keyword}">
						<button id="searchBtn">검색하기</button>
						&nbsp; <span>카테고리&nbsp;</span> <select name="searchType"
							id="titleContainer"
							data-xmlurl="http://www.kopis.or.kr/openApi/restful/pblprfr?service=b0a82e699a254319bbe6decc02de2489&stdate=20230901&eddate=20230910&cpage=1&rows=5&prfstate=02&signgucode=11&signgucodesub=1111&kidstate=Y">
							<option value="all">전체글</option>
							<option value="free">자유</option>
						</select>
						<button id="categoryBtn">조회</button>

					</div>

				</div>
				&nbsp;
				<table class='border_tbl'>

					<tr class="tbl_head">
						<th style="width: 10px">&nbsp;</th>
						<th style="width: 200px">분류</th>
						<th style="width: 200px">제목</th>
						<th style="width: 100px">작성자</th>
						<th style="width: 200px">작성일</th>
						<th style="width: 40px">조회수</th>
					</tr>

					<c:forEach items="${list}" var="board">
						<tr>
							<td style="width: 10px">${board.board_id }</td>
							<td style="width: 100px">${board.bulletin }</td>
							<td><a
								href="/app/board/view${pageDto.makeSearch()}&board_id=${board.board_id}&indent=${board.indent}&depthno=${board.depthno}">${board.title }</a></td>
							<td style="width: 100px">${board.username }</td>
							<td style="width: 200px"><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm" value="${board.create_date}" /></td>
							<td style="width: 40px">${board.viewcnt }</td>
						</tr>
					</c:forEach>
				</table>

				<button class='writeBtn' style="position: relative;">글쓰기</button>

				<div class="pagination">
					<c:if test="${pageDto.page !=1}">
						<a href='list${pageDto.makeSearch(1)}'>&laquo;</a>
					</c:if>
					<c:if test="${pageDto.prev }">
						<a href='list${pageDto.makeSearch(pageMaker.startPage-1)}'>&lt;</a>
					</c:if>

					<c:forEach begin="${pageDto.startPage }" end="${ pageDto.endPage}"
						var="idx">
						<a href='list${pageDto.makeSearch(idx)}'
							<c:out value="${pageDto.page==idx?' class=active ':'' }"/>>
							${idx}</a>
					</c:forEach>
					<c:if test="${pageDto.next }">
						<a href='list${pageDto.makeSearch(pageDto.endPage+1)}'>&gt;</a>

					</c:if>


					<c:if test="${pageDto.page != pageDto.totalEndPage}">
						<a href='list${pageDto.makeSearch(pageDto.totalEndPage)}'>&raquo;</a>
					</c:if>
				</div>
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
		/* 	var result = '${msg}';

			if (result == 'success') {
				console.log("처리가 완료되었습니다.");
			} */
		$(document).ready(
				function() {
					$('#searchBtn').on(
							"click",
							function(event) {
								console.log("list" + '${pageDto.makePage(1)}'
										+ '&searchType='
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val());

								self.location = "list"
										+ '${pageDto.makePage(1)}'
										+ '&searchType='
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							})

					$('.writeBtn').on("click", function(event) {
						location.href = "/app/board/write";
					});
					$('#newBtn').on("click", function(event) {
						self.location = "write";
					});
				});
		/* ------------------------------------- */

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

		/* ------------------------------------- */

		document.addEventListener("DOMContentLoaded", function() {
			// categoryBtn을 클릭했을 때의 이벤트 핸들러를 추가합니다.
			document.getElementById("categoryBtn").addEventListener(
					"click",
					function() {
						var selectedValue = document
								.getElementById("titleContainer").value; // 선택된 값 가져오기
						var encodedValue = encodeURIComponent(selectedValue);
						var redirectUrl = "/app/board/category?bulletin="
								+ encodedValue; // 리다이렉트 URL 생성

						// 페이지를 리다이렉트합니다.
						if (encodedValue == "all") {
							window.location.href = "/app/board/list"
						} else {
							window.location.href = redirectUrl;
						}
					});
		});
	</script>
</body>
</html>
