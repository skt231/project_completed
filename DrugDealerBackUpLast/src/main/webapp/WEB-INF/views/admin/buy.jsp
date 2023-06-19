<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.drug.dto.OrderDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" />
        <style>
            li a{
                text-decoration: none;
            }
        </style>
</head>
 <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="/ex/">Start Bootstrap</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="/ex/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/ex/login/login">Sign In</a></li>
                            <li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li>
                            <li class="nav-item"><a class="nav-link" href="faq.html">FAQ</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Blog</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                                    <li><a class="dropdown-item" href="blog-home.html">Blog Home</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">Blog Post</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Portfolio</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
                                    <li><a class="dropdown-item" href="portfolio-overview.html">Portfolio Overview</a></li>
                                    <li><a class="dropdown-item" href="portfolio-item.html">Portfolio Item</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Page Content-->
            <section class="cart">
            
                        <table>
               			<thead>
               			<tr>               		               				
               			<td>관리자</td>               			
               			</tr>
               			<tr><td>　</td></tr>
              			</thead>
              			</table>

<table class="cart__list">
<thead>
<tr>
	<td>장바구니 번호</td>
	<td>상품 번호</td>
	<td>가격</td>
	<td>수량</td>
	<td>배송 여부</td>
	<td>주문 일시</td>
	<td>주문자 아이디</td>
	<td>합계</td>	
</tr>
</thead>



	<c:forEach items="${list }" var="orderDto">
	<form method="post" id="sell">
	<tr class="cart__list__detail" style="text-align: center;">

		<td class="order_cart">${orderDto.odnum }</td>		
		<td>${orderDto.pn }
		<input type=hidden name=odnum value="${orderDto.odnum }"/>
		<input type=hidden name=pn value="${orderDto.pn }"/>
		</td>		
		<td>${orderDto.price}</td>
		<td>${orderDto.quantity }
		<input type=hidden name=inventory value="${orderDto.inventory }"/>
		</td>	
		<td>${orderDto.dt }
		<input type=hidden name=quantity value="${orderDto.quantity }"/>
		</td>
		<td><fmt:formatDate value="${orderDto.order_date }" />
		</td>
		<td>${orderDto.id }</td>
		<td><span class="price">$&nbsp;${orderDto.price*orderDto.quantity }</span>
		<c:set var="sum" value="${sum+orderDto.price*orderDto.quantity }"></c:set>
		</td>	
		<td><input type="submit" formaction="/ex/order/update" value="배송 여부 교체"></td>
		<td><input type="submit" formaction="/ex/order/delete_one" value="삭제"></td>
	</tr>
	</form>
	</c:forEach>	
	<tfoot>
	<tr><td>　</td></tr>
	</tfoot>
</table>
                               <div class="cart__mainbtns">
                    <button class="cart__bigorderbtn left"><a href="/ex/selectAll">다음에 주문하기</a></button>
                    <button type="button" class="cart__bigorderbtn right" id="orderBtn" name="order" onclick="document.getElementById('sell').submit();">결제하기</button>
                </div>
                            </section>
        </main>
                        <!-- Footer-->
        <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Your Website 2022</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="#!">Privacy</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Terms</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Contact</a>
                    </div>
                </div>
            </div>
                    </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>