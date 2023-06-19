<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link hreff="" https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
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
                <h1>챔피언 목록</h1>
                <div class="temp_select">
<form action='/TFTInfoSite/Main_Select/updateDB.TFT' method="get">
<table border="1" width="90%" id="champion">
	<tr>
	<th>name</th>
	<th>skill</th>
	<th>price</th>
	<th>synerge1</th>
	<th>synerge2</th>
	<th>synerge3</th>
	</tr>
	
	<tr>
		<input type='hidden' name="name1" value='${requestScope.dto.name }'>
		<td><input type='text' name="name2" value='${requestScope.dto.name }'id = "text"></td>
		<input type = "hidden" name = "skill1" value='${requestScope.dto.skill }'>
		<td><input type='text' name="skill2" value='${requestScope.dto.skill }'id = "text"></td>
		<td><input type='text' name="price" value='${requestScope.dto.price }'id = "text"></td>		
		<td><input type='text' name="synerge1" value='${requestScope.dto.synerge.synerge1 }'id = "text"></td>
		<td><input type='text' name="synerge2" value='${requestScope.dto.synerge.synerge2 }'id = "text"></td>
		<td><input type='text' name="synerge3" value='${requestScope.dto.synerge.synerge3 }'id = "text"></td>
		
	</tr>
</table>
<input type="submit" value='수정' id="button_login">
</form>
<a href="/TFTInfoSite/Main_Select/SelectAll.TFT"><button id="button_login">목록가기</button></a>
    </div>  
            </div>            
        </div>
        <div class="bar_under">
            <ul class="info_under">
                <li>LWC, HYJ, SKT</li><br>
                <li>KKH, KJH, PKH</li>
            </ul>
        </div>
    </div>
</body>
</html>