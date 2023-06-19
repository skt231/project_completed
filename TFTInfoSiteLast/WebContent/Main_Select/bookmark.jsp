<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark title here</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/TFTInfoSite/template/style.css">
</head>
<body>
    <div class="wrap">
        <div class="header">
            <a href="https://teamfighttactics.leagueoflegends.com/ko-kr/?
            utm_source=riotbar&utm_medium=productcard%2Bwww.leagueoflegends.com&utm_campaign=tft&
            utm_content=tft_keyart_dragon_academy"><div class="logo">
            </div></a>
            <ul class="nav" style="color: white;">
             <li><a href="Item.jsp">아이템</a></li>
				<li><a href="/TFTInfoSite/Main_Select/selectUser.rank">랭크</a></li>
				<li><a href="https://lolchess.gg/?hl=ko-KR">정보사이트 가기</a></li>
				<li><a href="/TFTInfoSite/Login/LoginPage.jsp">로그아웃</a></li>
				<li><a href="../Login/Withdrawal.jsp">회원 탈퇴</a></li>
            </ul>
        </div>
        <div class="intro_bg"></div>        	
            <div class="temp_body_select" align="center">
                <h1>찜 목록</h1>	
		 <div class="temp_select">
		 <div id="topsquare">
		</div>
		<table border="1" width="90%" id="Champion">
			<tr>
				<th>name</th>
				<th>skill</th>	
				<th>price</th>
				<th>synerge1</th>
				<th>synerge2</th>
				<th>synerge3</th>		
			</tr>
			<c:forEach items="${dtos }" var="jjimDto">
				<tr>
					<td><center>${jjimDto.name }</center></td>					
					<td><center>${jjimDto.skill }</center></td>			
					<td><center>${jjimDto.price }</center></td>	
					<td><center>${jjimDto.synerge1 }</center></td>	
					<td><center>${jjimDto.synerge2 }</center></td>	
					<td><center>${jjimDto.synerge3 }</center></td>							
				</tr>
			</c:forEach>
		</table>		
		<a href="/TFTInfoSite/Main_Select/SelectAllUser.TFT"><button id="button_login">목록가기</button></a>
	</div>
	</div>
	</div>
		<div class="bar_under">
		<ul class="info_under">
			<li>LWC, HYJ, SKT</li>
			
			<li>KKH, KJH, PKH</li>
		</ul>
	</div>
</body>
</html>