<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Details</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/resources/css/styles1.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column">
        <main class="flex-shrink-0">
            <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/ex/"><Strong>The Trippy</Strong></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link" href="/ex/notice/list">Notice</a></li>
                        <li class="nav-item"><a class="nav-link" href="/ex/qna/faq">FAQ</a></li>
                        <li class="nav-item">
                          <a class="nav-link" href="/ex/login/logout" role="button">Logout</a>   
                        </li>
                    </ul>
                    <form class="d-flex" action="/ex/order/selectAll">
                        <button class="btn btn-outline-dark" type="submit">
                            Buy
                        </button>
                    </form>
                    &nbsp;
                    <form class="d-flex" action="/ex/member/cart/selectAll">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${cartlist }</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
                    <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                     <!-- About section one -->
            <section class="py-5 bg-light" id="scroll-target">
                <div class="container px-5 my-5">
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6"><img class="img-fluid rounded mb-5 mb-lg-0" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." /></div>
                        <div class="col-lg-6">
                            
                           	<form method="post" id="buy">
                           	<p class="lead fw-normal text-muted mb-0" style="font-size: 12px; text-align:right">
                                등록일 : <fmt:parseDate value="${dto.regdate}" pattern="yyyy-MM-dd'T'HH:mm" var="LocalDateTime" type="both"/>
                         <fmt:formatDate pattern="yyyy-MM-dd" value="${LocalDateTime}" />
                            </p>
                            <h1 class="fw-bolder" style="color: black; text-align:left;">${dto.name }</h1>
                            <hr style="color: darkgray;">
                              <h2 style="color: black; text-align:left;">$ ${dto.price}</h2><br>
                            <p class="lead fw-normal text-muted mb-0" style=" text-align:left;">
                                원산지 : ${dto.origin}<br>
                                남은 재고 : ${dto.inventory}<br>
                                
                               선택 수량 :   	<input type="number" id ="quantity" name="quantity" min="1" max=${dto.inventory } value=1>                               
                           		 	<script>
                            		function getInputvalue(){
                            		var quantity = $('#quantity').val();
                            		}
                            		</script>
                            </p>                            
                            <br>
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">                                                        
                                    <input type="hidden" id="pn" name="pn" value=${dto.pn }>
                                    <input type="hidden" name="id" value="${id }"> 
                                    <input type="hidden" name="quantity" value="${quantity }">
                         		    <input type="hidden" id="inventory" name="inventory" value=${dto.inventory }>
                         		    <input type="hidden" name="name" value="${dto.name }">
                           		 	<input type="hidden" id="price" name="price" value=${dto.price }>
                           		 	
                           		 	<input class="btn btn-outline-dark mt-auto" type="submit" value="Add to Cart" formaction="/ex/member/cart/insert">
                            		<input class="btn btn-outline-dark mt-auto" type="submit" value="Order Now" formaction="/ex/order/insert">                                                                
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
                </div>
            </div>
        </header>     
            
            <header class="py-5">
                <div class="container px-5">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-xxl-6">
                            <div class="text-center my-5">
                                <h1 class="fw-bolder mb-3">${dto.content}Our mission is to make building websites easier for everyone.</h1>
                                <p class="lead fw-normal text-muted mb-4">Start Bootstrap was built on the idea that quality, functional website templates and themes should be available to everyone. Use our open source, free products, or support us by purchasing one of our premium products or services.</p>
                                <!--a class="btn btn-primary btn-lg" href="#scroll-target">Read our story</a-->
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            
            <!-- Team members section-->
            <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                
                
                <c:forEach items="${list}" var="list">	
                
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${list.name }</h5>
                                    <!-- Product price-->
                                    ${list.price }
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/ex/selectName${pageMaker.makeSearch()}&pn=${list.pn}">View options</a></div>
                            </div>
                        </div>
                    </div>
                    
                    </c:forEach>
                    
                    
                                     
                </div>
            </div>
        </section>
        </main>
        <!-- Footer-->
        <footer class="py-5 bg-dark" >
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
            <div class="pagination">
				    	<c:if test="${pageMaker.page !=1}">
				    		<a href='selectAll${pageMaker.makeSearch(1)}'>&laquo;</a>
				    	</c:if>
				    	<!-- 앞전 page 모양을 클릭하면 pageMarker.startPage에 -1을 처리해준다.-->
				    	<c:if test="${pageMaker.prev }">
				    		<a href='selectAll${pageMaker.makeSearch(pageMaker.startPage-1)}'>&lt;</a>
				    	</c:if>
				    	
				    	<c:forEach begin="${pageMaker.startPage }" end="${ pageMaker.endPage}" var="idx">
				    		<a href='selectAll${pageMaker.makeSearch(idx)}' 
				    		 <c:out value="${pageMaker.page==idx?' class=active ':'' }"/> >
				    		 ${idx}</a>
						</c:forEach>
				    	
				    	<%--<a href='#'>1</a>
				    	 <a href='selectAll${pageMaker.makeSearch(2)}'>2</a>
				    	<a href='#' class="active">3</a> --%>
				    	
				    	<c:if test="${pageMaker.next }">
				    		<a href='selectAll${pageMaker.makeSearch(pageMaker.endPage+1)}'>&gt;</a>
				    		
				    	</c:if>
				    	
				    	
				    	<c:if test="${pageMaker.page != pageMaker.totalEndPage}">
				    		<a href='selectAll${pageMaker.makeSearch(pageMaker.totalEndPage)}'>&raquo;</a>
				    	</c:if>    	
				    	
			</div> 
			<div class="pagination" style="position:relative; left:-10%; bottom: 50px;"> 
			<!-- <a href="/ex/insert" style="left:15px;">상품 등록</a> -->
			</div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
