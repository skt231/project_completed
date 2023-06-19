<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" /> -->
	 <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<style type="text/css">
li a {
	text-decoration: none;
	color: rgba(0, 0, 0, 0.767);
}

.bg-light rounded-3 py-5 px-4 px-md-5 mb-5 {
	position: relative;
}

#changepw_bt, #resign_bt {
	font-size: 0.7em;
}

.bodyFrame {
    padding:15px;
	position: relative;
	height: 300px;
	width:50px;
	margin: 100px 80px 100px 80px;
	background-color: #F8F9FA;
	overflow: inherit;
	
}

.col-xl-8 {
	margin-left: auto;
}
</style>
<script>
	function check_res(){
		var msg= confirm("정말 탈퇴하시겠습니까?","title");
		if(msg==true){
			window.location.href = '/ex/users/deleteid?id=${dto.id}';
		}else{
			alert("no");
		}
	}

</script>
</head>

<body class="d-flex flex-column">
	<main class="flex-shrink-0"> <!-- Page content-->
	<section class="py-5">
		<!-- Contact form-->
		<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">

			<!--------------------------------------------------------------------  -->
			<div class="row gx-5">
				<div class="col-xl-8">
					<!-- FAQ Accordion 1-->
					<h2 class="fw-bolder mb-3">My page</h2>

				</div>
			</div>
			<div class="bodyFrame"
				style="position: absolute; left: 24%; top: 20%; display: inline-block; width: 70%; border: 1px solid;">
				<p>
					<strong>이름:</strong> ${dto.name}
				</p>
				<p>
					<strong>ID:</strong>${dto.id}</p>
				<p>
					<strong>비밀번호:</strong> <span id="pw">${pw }</span>
					<!-- <button id="changepw_bt" type="button"
						onclick="window.open('/ex/users/updatePW','비밀번호 수정','width=390px,height=250px')">수정
					</button> -->
				</p>
				<p>
					<strong>E-mail:</strong>${dto.email}</p>
				<p>
					<strong>주소:</strong> ${dto.address}
				</p>
				<p>
					<strong>전화번호:</strong> ${dto.phone}
				</p>
				<button id="resign_bt" type="button"
					onclick="check_res()">탈퇴</button>
					
			</div>

		</div>

		<!--------------------------------------------------------------------  -->




	</section>
	</main>
	<!-- Footer-->
	<%@include file="../include/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->

	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>



</body>
</html>




