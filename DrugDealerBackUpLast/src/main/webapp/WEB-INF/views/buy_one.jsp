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
</head>
<body>
<h1>결제 화면</h1>
<table>
<tr>
	<th>odNum</th>
	<th>pn</th>
	<th>price</th>
	<th>quantity</th>
	<th>result</th>	
	<th>금액</th>
</tr>
<form action="/ex/order/delete" id="sell">
	<c:forEach items="${dto }" var="orderDto">
	
	<tr>
		<td>${orderDto.odnum }</td>		
		<td>${orderDto.pn }</td>
		<input type=hidden name=pn value="${orderDto.pn }">
		<td>${orderDto.price}</td>
		<td>${orderDto.quantity }</td>
		<input type=hidden name=inventory value="${orderDto.inventory }">
		<input type=hidden name=quantity value="${orderDto.quantity }">		
		<td>${orderDto.result }</td>
		<td>${orderDto.price*orderDto.quantity }원</td>		
		<c:set var="sum" value="${sum+orderDto.price*orderDto.quantity }"></c:set>		
	</tr>
	</c:forEach>
	<tr>
	<td>총 금액</td>	
	<td>${sum}원</td>
	</tr>		
	</form>
</table>
<button onclick="document.getElementById('sell').submit();">결제</button><br>
<a href="/ex/selectAll">목록가기</a>
</body>
</html>