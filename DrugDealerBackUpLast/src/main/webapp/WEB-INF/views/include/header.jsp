<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css"/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/ex/resources/css/template.css" />
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container px-5">
			<a class="navbar-brand" href="/ex/"><Strong>The Trippy</Strong></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/ex/">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/ex/login/login">Sign In</a></li>
					<!-- <li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li> -->
					<li class="nav-item"><a class="nav-link" href="/ex/qna/faq">FAQ</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/ex/notice/list">Notice</a></li>
					<!-- <li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Blog</a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdownBlog">
							<li><a class="dropdown-item" href="blog-home.html">Blog
									Home</a></li>
							<li><a class="dropdown-item" href="blog-post.html">Blog
									Post</a></li>
						</ul></li> -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdownPortfolio"
						href="#" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> info</a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdownPortfolio">
							<li><a class="dropdown-item" href="/ex/users/info">
									myinfo </a></li>
							<!-- <li><a class="dropdown-item" href="portfolio-item.html">Portfolio
									Item</a></li> -->
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>