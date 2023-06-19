<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>장바구니</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/basket.css">
<link rel="stylesheet" href="js/basket.js">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap"
	rel="stylesheet">

<style>
.w3-bar-block .w3-bar-item, .w3-right, h3, p, p a {
	font-family: "Karma", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 20px
}

a {
	text-decoration: none
}

input:focus {
	outline: none;
}
</style>
</head>

<body>
	<form method="get">
		<input type="hidden" name="name" value="name" />
		<!-- Sidebar (hidden by default) -->
		<nav
			class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left"
			style="display: none; z-index: 2; width: 40%; min-width: 300px"
			id="mySidebar">
			<a href="javascript:void(0)" onclick="w3_close()"
				class="w3-bar-item w3-button">✕</a>

			<c:if test="${empty sessionScope.id}">
				<a href="login.do" onclick="w3_close()"
					class="w3-bar-item w3-button">Login</a>
			</c:if>

			<c:if test="${not empty sessionScope.id}">
				<a href="logout.do" onclick="w3_close()"
					class="w3-bar-item w3-button">Logout</a>
			</c:if>

			<c:if test="${not empty sessionScope.id}">
				<c:choose>
					<c:when test="${sessionScope.id eq 'admin'}">
						<a href="admin_product_upload.do?id=${sessionScope.id}"
							onclick="w3_close()" class="w3-bar-item w3-button">Admin</a>
					</c:when>
					<c:when test="${sessionScope.id ne 'admin'}">
						<a href="mypage.do?id=${sessionScope.id}" onclick="w3_close()"
							class="w3-bar-item w3-button">Mypage</a>
					</c:when>
				</c:choose>
			</c:if>

			<br> <a href="outerwear.do" onclick="w3_close()"
				class="w3-bar-item w3-button">Outerwear</a> <a href="top.do"
				onclick="w3_close()" class="w3-bar-item w3-button">Top</a> <a
				href="bottom.do" onclick="w3_close()" class="w3-bar-item w3-button">Bottom</a>
			<a href="accessories.do" onclick="w3_close()"
				class="w3-bar-item w3-button">Accessories</a> <br> <a
				href="qa.do?id=${sessionScope.id}" onclick="w3_close()"
				class="w3-bar-item w3-button">Q/A</a> <a
				href="review.do?id=${sessionScope.id}" onclick="w3_close()"
				class="w3-bar-item w3-button">Review</a> <br>
			<div class="w3-bar-item search_div">
				<input type="text" placeholder="Search..." class="search"
					style="border: none;" name="search"> <input type="image"
					src="icon/search.png" style="width: 20px" class="search2"
					onclick="javascript: form.action='search.do';">
			</div>
		</nav>
	</form>

	<!-- Top menu -->
	<div class="w3-top">
		<div class="w3-white w3-xlarge"
			style="max-width: 1200px; margin: auto">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
			<div class="w3-right w3-padding-16">
				<a href="cart.do?id=${sessionScope.id}">Cart
			</div>
			</a>
			<div class="w3-center w3-padding-16">
				<a href="goshop.do"><img src="icon/logo2.png" width="100"
					alt="로고"></a>
			</div>
		</div>
	</div>

	<main>
	<div class="basket">

		<div class="basket-labels">
			<ul>
				<li class="item item-heading">Item</li>
				<li class="price">Price</li>
				<li class="quantity">Quantity</li>
				<li class="subtotal">Total</li>
			</ul>
		</div>


<%-- 		<%=new java.util.HashMap<Integer,Integer>() %>
 --%>

		<c:forEach items="${requestScope.dtos}" var="dto">
			<c:set var="sum" value="${dto.price2 * dto.quantity}"></c:set>
			<c:set var="sum2" value="${sum2 + sum}"></c:set>
			<form method="get">
				<input type="hidden" name="cseq" value="${dto.cseq}">
				<div class="basket-product">
					<div class="item">
						<div class="product-image">
							<img src="${dto.image}" class="product-frame">
						</div>
						<div class="product-details">
							<h1>
								<strong>${dto.name}</strong>
							</h1>
							<p>
								<strong>${dto.color}</strong>
							</p>
							<p>
								<strong>${dto.psize}</strong>
							</p>
						</div>
					</div>
					<div class="price">
						<fmt:formatNumber value="${dto.price2}" pattern="#,###,###" />
					</div>
					<div class="quantity">
						<input type="number" value="${dto.quantity}" min="1"
							class="quantity-field">
					</div>
					<div class="subtotal">
						<fmt:formatNumber value="${sum}" type="currency" />
					</div>
					<div class="remove">

						<input type="hidden" name="id" value="${dto.id}"> <input
							type="submit" value="Remove"
							onclick="javascript: form.action='cartdelete.do?cseq=${dto.cseq}';">


					</div>
				</div>
			</form>
		</c:forEach>


	</div>




	<aside>
		<div class="summary">
			<div class="summary-total-items">
				<span class="total-items"></span> Items in your Bag
			</div>
			<div class="summary-subtotal">
				<div class="subtotal-title">Total</div>
				<div class="subtotal-value final-value" id="basket-subtotal">
					<fmt:formatNumber value="${sum2}" pattern="#,###,###" />
				</div>
				<div class="summary-promo hide">
					<div class="promo-title">Promotion</div>
					<div class="promo-value final-value" id="basket-promo"></div>
				</div>
			</div>
			<div class="summary-delivery"></div>
			<div class="summary-total">
				<div class="total-title">Total</div>
				<div class="total-value final-value" id="basket-total">
					<fmt:formatNumber value="${sum2}" type="currency" />
				</div>
			</div>
			<div class="summary-checkout">
				<form>
					<input type="hidden" name="id" value="${sessionScope.id}">
					<input type="hidden" name="pseq" value="${dto.pseq}"> <input
						type="submit" value="Go to Secure Checkout" class="checkout-cta"
						style="cursor: pointer;"
						onclick="javascript: form.action='payment.do';" />
				</form>
			</div>
		</div>
	</aside>
	</main>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1200px; margin-top: 100px">

		<hr id="about">

		<!-- Footer -->
		<footer class="w3-row-padding w3-padding-32">
			<div class="w3-third">
				<h3 class="ir_su">FOOTER</h3>
				<p>6 AM: Co. | info@6AmCheonan.com | 041-1212-3456 | 000-00,
					Daeheung-Dong, Dongnam-Gu, Cheonan-Si, Korea Ceo. Human | Permit
					Number. 2021-CheonanDaeheung-0123 | Business Number. 010-1234-5678</p>
				<p>&copy; 6 AM: cheonan.</p>
			</div>
		</footer>

		<!-- End page content -->
	</div>

	<script>
  // Script to open and close sidebar
  function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
  }
  
  function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
  }
  </script>
</body>
</html>