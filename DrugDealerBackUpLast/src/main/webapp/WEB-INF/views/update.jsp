<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
update
<form action="/ex/update" method="post">
상품 번호<input type="text" name=pn value="${drugDto.pn }" readonly><br>
상품 이름<input type="text" name=name value="${drugDto.name }"><br>
상품 가격<input type="text" name=price value="${drugDto.price }"><br>
상품 원산지<input type="text" name=origin value="${drugDto.origin }"><br>
상품 분류<input type="text" name=category value="${drugDto.category }"><br>
상품 설명<input type="text" name=content value="${drugDto.content }"><br>
상품 재고<input type="text" name=inventory value="${drugDto.inventory }"><br>
상품 판매 가능 여부<input type="text" name=sellable value="${drugDto.sellable }"><br>
y:판매 가능 / n:판매 불가능<br>
상품 등록 번호<input type="text" name=ps value="${drugDto.ps }"><br>
<button type="button" onclick="location.href='/ex/selectAll' ">취소</button>
<input type="reset" value="초기화">
<input type="submit" value="수정">
</form>
</body>
</html>
