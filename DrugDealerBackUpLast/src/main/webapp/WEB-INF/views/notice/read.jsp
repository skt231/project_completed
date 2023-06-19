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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
    </script>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<script>
var fObject=$(".form");
function remove(){	
	fObject.attr("action","/ex/notice/remove");		
	fObject.submit();
}


$(document).ready(function() {
	var fObject=$(".form");
	
	$(".btnList").on("click",function(){
		fObject.attr("method","get");
		fObject.attr("action","/ex/notice/list");
		fObject.submit();
		
	});
	
	/* $(".btnRemove").on("click",function(){ */
	
	function remove(){	
		fObject.attr("action","/ex/notice/remove");		
		fObject.submit();
	}
	/* }); */
	
	$(".btnModify").on("click",function(){
		fObject.attr("method","get");
		fObject.attr("action","/ex/notice/modify");
		fObject.submit();
	});
});
</script>

	<style>
	.box-footer a:link{
	color: inherit;!important;
	text-decoration: none;
	}
	.bg-gradient {
  background-image: var(--bs-gradient) !important;
}
	</style>


</head>
    <body class="d-flex flex-column">
        <main class="flex-shrink-0">
            <!-- Page content-->
            <section class="py-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">공지사항</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">

 <!------------------------------------------------------------------------------------------------------------------------------------------------  -->
							<div class="main">
					
 <form class="contactForm" method="post">

					<input type='hidden' name='bno' value="${list_read.bno}"> 
					<input type='hidden' name='page' value="${pageMaker.page}"> 
					<input type='hidden' name='perPageNum' value="${pageMaker.perPageNum}">
					<input type='hidden' name='searchType' value="${pageMaker.searchType}">
					<input type='hidden' name='keyword' value="${pageMaker.keyword}">
 


	<h6>제목</h6>
 	<h6>
		<input type="text"
			style="width:100%" name='title' value="${list_read.title}"
			readonly="readonly"></h6>
	
		<h6>
		내용
		<textarea  style="width:100%" name="content" rows="3"
			readonly="readonly">${list_read.content}</textarea>
		</h6>
	
		<h6>
		작성자 <input type="text"
			name="writer" style="width:100%" value="${list_read.writer}"
			readonly="readonly">
		</h6>
		</form>
<%--  </c:forEach>  --%>
<!-- /.box-body -->
<div class="d-grid">
	<button type="button" class="btnModify" onclick="location.href='/ex/notice/modify?bno=${list_read.bno }&title=${list_read.title}&content=${list_read.content}&writer=${list_read.writer}'">수정</button>
	<button type="submit" class="btnRemove" onclick="location.href='/ex/notice/remove?bno=${list_read.bno }&title=${list_read.title}&content=${list_read.content}&writer=${list_read.writer}'">삭제</button>
	<button type="button" class="btnList" onclick="location.href='/ex/notice/list'">LIST page로 이동</button>

      
              
              </div>
              <!------------------------------------------------------------------------------------------------------------------------------------------------  -->
                        </div>
                    </div>
                    </div>
   <!-- Contact cards-->
                    <div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-chat-dots"></i></div>
                            <div class="h5 mb-2">Chat with us</div>
                            <p class="text-muted mb-0">Chat live with one of our support specialists.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-people"></i></div>
                            <div class="h5">Ask the community</div>
                            <p class="text-muted mb-0">Explore our community forums and communicate with other users.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-question-circle"></i></div>
                            <div class="h5">Support center</div>
                            <p class="text-muted mb-0">Browse FAQ's and support articles to find solutions.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-telephone"></i></div>
                            <div class="h5">Call us</div>
                            <p class="text-muted mb-0">Call us during normal business hours at (555) 892-9403.</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <!-- Footer-->
       	<%@include file="../include/footer.jsp"%>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
 <!------------------------------------------------------------------------------------------------------------------------------------------------  -->


