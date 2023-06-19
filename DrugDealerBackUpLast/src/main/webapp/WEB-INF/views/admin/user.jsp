<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="cart">
	<table class="cart__list">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>주소</td>
		<td>전화번호</td>
		<td>유저등급</td>
		<td>가입날자</td>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
		<td>${dto.id }</td>
		<td>${dto.name } </td>
		<td>${dto.email }</td>
		<td>${dto.address }</td>
		<td>${dto.phone }</td>
		<td>${dto.authority }</td>
		<td><fmt:formatDate value="${dto.regdate }" /></td>
	
		<td>
			<form method="post">
			<input type="hidden" name="useyn" value="${dto.useyn }">
			<input type="hidden" name="id" value="${dto.id }">
			<input type=submit value="등급변경" formaction="/ex/users/update_tier">
			<input type=submit value="삭제" formaction="/ex/users/delete">
			</form>
		</td>
		</tr>
	</c:forEach>
	</table>
	<div class="cart__mainbtns">
	<button class="cart__bigorderbtn left"><a href="/ex/selectAll">목록가기</a></button>
	</div>
</section>
</body>
</html>