<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link hreff="" https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/TFTInfoSite/template/style.css">
</head>
<style>
</style>

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
                <h1>챔피언 추가</h1>
                <div class="temp_select">
<!-- ----------------------------------------------------------------------------- -->
<div id = "topsquere">
	<form action="/TFTInfoSite/Main_Select/InsertDB.TFT" >
		이름 : <input type="text" name="name" id="text"><br>
		스킬 : <input type="text" name="skill" id="text"><br>
		가격 : <input type="text" name="price" id="text"><br>
		진영1: <input type="text"	name="synerge1" id="text"><br>
		진영2: <input type="text"	name="synerge2" id="text"><br>
		진영3: <input type="text"	name="synerge3" id="text"><br>
		<button id="button_login" type="submit">생성</button>
	</form>
</div>

<!-- ----------------------------------------------------------------------------- -->
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