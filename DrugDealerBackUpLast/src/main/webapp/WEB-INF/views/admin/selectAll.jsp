<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script>
	 var result = '${msg}';
		if (result == 'success') {
			alert("처리가 완료되었습니다.");
		}
	</script>
	<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
  select
  
  <table id='customers' width=100% border="1">
	<tr>
		<th style="width: 10px">id</th>
		<th style="width: 100px">pw</th>
		<th style="width: 200px">ad_num</th>
	<c:forEach items="${list}" var="dto">	
		<tr>
		<!--시간추가는 나중에 -->
			<td><a href="/ex/admin/selectId?id=${dto.id }">${dto.id }</a></td>
			<td >${dto.pw}</td>
			<td >${dto.ad_num }</td>
			
		</tr>
	</c:forEach>
    </table>
	<a href="/ex/admin/insert">새글</a>
</body>
</html>
