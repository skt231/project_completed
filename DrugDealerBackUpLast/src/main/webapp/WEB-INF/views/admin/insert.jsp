<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>상품 등록</h1><br>
<form action="/ex/insert" method="post">
상품 번호<input type="text" name=pn placeholder="숫자"><br>
상품 이름<input type="text" name=name><br>
상품 가격<input type="text" name=price placeholder="숫자"><br>
상품 원산지<input type="text" name=origin><br>
상품 분류<input type="text" name=category placeholder="한글자"><br>
상품 설명<input type="text" name=content><br>
상품 재고<input type="text" name=inventory placeholder="숫자"><br>
상품 판매 가능 여부<input type="text" name=sellable placeholder="한글자"><br>
y:판매 가능 / n:판매 불가능<br>
<button type="button" onclick="location.href='/ex/selectAll' ">취소</button>
<input type="reset" value="초기화">
<input type="submit" value="등록">

</form>
</body>
</html>
