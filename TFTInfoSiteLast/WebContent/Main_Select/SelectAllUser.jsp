<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/TFTInfoSite/template/style.css">
</head>
<script>
window.onload=function(){
	

<%

	String id =(String)session.getAttribute("id");
	System.out.println(id);
	if(id.equals("admin")){
%>
		location.href="/TFTInfoSite/Main_Select/SelectAll.TFT";
<%
	
	}
%>
}
</script>

<body>
    <div class="wrap">
        <div class="header">
            <a href="https://teamfighttactics.leagueoflegends.com/ko-kr/?
            utm_source=riotbar&utm_medium=productcard%2Bwww.leagueoflegends.com&utm_campaign=tft&
            utm_content=tft_keyart_dragon_academy"><div class="logo">
            </div></a>
            <ul class="nav" style="color: white;">
             	<li><a href="/TFTInfoSite/Main_Select/Item.jsp">아이템</a></li>
				<li><a href="/TFTInfoSite/Main_Select/selectUser.rank">랭크</a></li>
				<li><a href="https://lolchess.gg/?hl=ko-KR">정보사이트 가기</a></li>
				<li><a href="/TFTInfoSite/Login/LoginPage.jsp">로그아웃</a></li>
				<li><a href="../Login/Withdrawal.jsp">회원 탈퇴</a></li>
            </ul>
        </div>
        <div class="intro_bg"></div>        	
            <div class="temp_body_select" align="center">
                <h1>챔피언 목록</h1>	
		 <div class="temp_select">
		 <div id="topsquare">
		</div>	
	<table border="1" width="90%" id="Champion">
		<tr>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=name">name</a></th>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=skill">skill</a></th>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=price">cost</a></th>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=synerge1">synerge1</a></th>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=synerge2">synerge2</a></th>
			<th><a href="/TFTInfoSite/Main_Select/SelectFilterNameUser.TFT?filter=synerge3">synerge3</a></th>
		</tr>
		<c:forEach items="${dtos }" var="ChampionSynergeDto">
			<tr>
				<td><center>${ChampionSynergeDto.name }</center></td>
				<td><center><a
					href="/TFTInfoSite/Main_Select/SelectOneUser.TFT?name=${ChampionSynergeDto.name}&
					skill=${ChampionSynergeDto.skill }">${ChampionSynergeDto.skill }</a></center></td>
				<td><center>${ChampionSynergeDto.price }</td>
				<td><center>${ChampionSynergeDto.synerge.synerge1 }</center></td>
				<td><center>${ChampionSynergeDto.synerge.synerge2 }</center></td>
				<td><center>${ChampionSynergeDto.synerge.synerge3 }</center></td>
			</tr>
		</c:forEach>
	</table>
	<div id="sendman">
	<div id="search">
		<form action="/TFTInfoSite/Main_Select/searchUser.Servlet">
			검색 조건 <select name="menu" id = "text">
				<option value="name">이름</option>
				<option value="skill">스킬</option>
				<option value="price">가격</option>
				<option value="synerge">시너지</option>
			</select> <input type="text" placeholder="검색어를 입력하세요" name="keyword" id = "text">
			<button type="submit">검색</button>
		</form>
	</div>
	</div>
</body>
</html>