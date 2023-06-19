
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>
<html>
<head>
<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
<!-- Core theme JS-->
<script src="js/scripts.js"></script>

<style type="text/css">
table a{
color: black;
text-decoration: none;
}
table a:hover{
color: inherit;
text-decoration: underline;
}
table a:visited{
color: inherit;
}
.main {
	font-size: 15px;
	margin: 0;
	padding: 0;	
}

.tbl_head {
	background-color: #CBC5C2;
}

#searchType {
	border: dotted 1px #CBC5C2;
	border-style: dotted;
}

.detail_list {
	position: relative;
	margin: 50px;
	display: flex;
}

.orderlist, .cartlist, .myinfo {
	width: 150px;
	height: 150px;
	border-radius: 20px;
	border: solid 1px #ffffff;
	display: inline-block;
	text-decoration: none;
	text-align: center;
	margin: 0px 100px;
}

.qna_hd {
	width: 1300px;
	height: 80px;
	background-color: FFFFFF;
	margin: auto;
}

.qna_hd h4{
	text-align: center;
	height: 100px;
}

.caution {
	font-size: 13px;
	font-color: grey;
}

#searchType {
	height: 500px;
}
.pagination{
	position: absolute;
	top: 10px;
	left: 10px;
	font
}
.writeBtn,#searchBtn,.pagination a{
	    color: #fff;
    background-color: #0d6efd;
    border-color: #0d6efd;
    margin: 1px;
     transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}
.paginationa a:link  {
	color: white;
}
tr td{
font-size: 14px;
}
</style>
</head>
<link
	href="${pageContext.request.contextPath}/resources/css/styles1.css"
	rel="stylesheet" type="text/css" />

<script>
	var result = '${msg}';

	if (result == 'success') {
		console.log("처리가 완료되었습니다.");
	}
	$(document).ready(
			function() {
				$('#searchBtn').on(
						"click",
						function(event) {
							console.log("list" + '${pageMaker.makePage(1)}'
									+ '&searchType='
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val());

							self.location = "list" + '${pageMaker.makePage(1)}'
									+ '&searchType='
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						})

				$('.writeBtn').on("click", function(event) {
					location.href = "/ex/notice/write";
				});
				$('#newBtn').on("click", function(event) {
					self.location = "write";
				});

			});
</script>
</head>
<body>
	  <main class="flex-shrink-0">
		<div class="qna_hd">
		<br><br>
			<h4>공지사항</h4>
		</div>
		<div>
			<select name="searchType">
				<option value="n"
					<c:out value="${pageMaker.searchType eq '-----'?'selected':'' }"/>>-----</option>
				<!-- <option value="n" selected>----</option>
    		<option value="n">----</option> -->
				<option value="t"
					<c:out value="${pageMaker.searchType eq 't'?'selected':'' }"/>>제목</option>
				<option value="c"
					<c:out value="${pageMaker.searchType eq 'c'?'selected':'' }"/>>내용</option>
				<option value="tc"
					<c:out value="${pageMaker.searchType eq 'tc'?'selected':'' }"/>>제목+ 내용</option>
			</select>

			<!-- input 에 text를 입력하면 value로 설정된 pageMaker에 keyword의 값이 id값으로 들어간다.
    	입력값이 쿼리 스트링에 들어간다. -->
			<input type="text" name="keyword" id="keywordInput"
				value="${pageMaker.keyword}">
			<button id="searchBtn">검색하기</button>
		</div>

		<table class='customers' width=100% border="1">

			<tr class="tbl_head">
				<th style="width: 10px">&nbsp;</th>
				<th style="width: 200px">제목</th>
				<th style="width: 300px">내용</th>
				<th style="width: 100px">작성자</th>
				<th style="width: 200px">작성일</th>
				<th style="width: 40px">조회수</th>
			</tr>

			<c:forEach items="${list}" var="dto">
				<tr>
					<td style="width: 10px">${dto.bno }</td>
					<td><a
						href="/ex/notice/read${pageMaker.makeSearch()}&bno=${dto.bno}">${dto.title }</a></td>
					<td style="width: 300px">${dto.content }</td>
					<td style="width: 100px">${dto.writer }</td>
					<td style="width: 200px"><fmt:formatDate
							pattern="yyyy-MM-dd HH:mm" value="${dto.regdate }" /></td>
					<td style="width: 40px">${dto.viewcnt }</td>
				</tr>
			</c:forEach>
		</table>

		<button class='writeBtn' style="position: relative;">글쓰기</button>

		<div class="pagination">
			<c:if test="${pageMaker.page !=1}">
				<a href='list${pageMaker.makeSearch(1)}'>&laquo;</a>
			</c:if>
			<!-- 앞전 page 모양을 클릭하면 pageMarker.startPage에 -1을 처리해준다.-->
			<c:if test="${pageMaker.prev }">
				<a href='list${pageMaker.makeSearch(pageMaker.startPage-1)}'>&lt;</a>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${ pageMaker.endPage}" var="idx">
				<a href='list${pageMaker.makeSearch(idx)}'
					<c:out value="${pageMaker.page==idx?' class=active ':'' }"/>>
					${idx}</a>
			</c:forEach>

			<%--<a href='#'>1</a>
    	 <a href='list${pageMaker.makeSearch(2)}'>2</a>
    	<a href='#' class="active">3</a> --%>

			<c:if test="${pageMaker.next }">
				<a href='list${pageMaker.makeSearch(pageMaker.endPage+1)}'>&gt;</a>

			</c:if>


			<c:if test="${pageMaker.page != pageMaker.totalEndPage}">
				<a href='list${pageMaker.makeSearch(pageMaker.totalEndPage)}'>&raquo;</a>
			</c:if>

		</div>
	<br><br>
	<!-- info cards-->
	<div class="detail_list">
		<div class="orderlist">
			<span id="orderlist_">주문내역</span>
			<div class="orderdetail">
				<a href="">주문조회</a>
			</div>

		</div>
		<div class="cartlist">
			<div id="cartlist_">카트내역</div>
			<div>
				<a href="">카트조회</a>
			</div>
			<i class="bi bi-people"></i>
		</div>
		<div class="myinfo">
			<div id="myinfo_">계정</div>
			<p>
				<a href="">회원정보</a>
			</p>
			<p>
				<a href="">비밀번호 수정</a>
		</div>
	</div>
	<div class="col">
		<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
			<i class="bi bi-telephone"></i>
		</div>
		<div class="h5">Call us</div>
		<p class="text-muted mb-0">Call us during normal business hours at
			(555) 123-4567.</p>
	</div>


	<div class="caution">
		ㅇㅇㅇㅇㅇ.com © 모든 저작권리는 1997-2023 ㅇㅇㅇㅇㅇ, LLC.에 있습니다. <br> ㅇㅇㅇㅇㅇ®는
		ㅇㅇㅇㅇㅇ사의 등록 상표이며, Trusted Brands. Healthy Rewards. ㅇㅇㅇㅇㅇ.com Trusted
		Brands. Healthy Rewards. <br> 로고는 ㅇㅇㅇㅇ가 보유한 상표입니다. *면책사항: 본
		웹사이트에서 제공되는 판매 상품 및 정보는 미국 식품의약국(FDA)에 의해 의약품으로 검증되지 않았습니다. <br>
		질병의 진단, 치료, 예방의 목적으로 사용하지 마십시오.
	</div>
	<br>
	</main>
	<%@include file="../include/footer.jsp"%>
</body>
</html>











