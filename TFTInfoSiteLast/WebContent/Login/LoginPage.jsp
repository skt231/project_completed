<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="/TFTInfoSite/template/style.css">
</head>
<style>

</style>
<script>
window.onload=function(){
	
	<%session.invalidate();%>
	
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
                <!-- <li><a href="#">HOME</a></li>
                <li><a href="https://lolchess.gg/?hl=ko-KR">정보사이트 가기</a></li>
                li><a href="#">LOGIN</a></li
                <li><a href="#">COMUNITY</a></li> -->
            </ul>
        </div>
        <div class="intro_bg"></div>
            <div class="temp_body" align="center">
                <div id="Login_title">
                <h1>Login Page</h1>
                </div>
                <form action="/TFTInfoSite/Login/login.login">
                <div id="id_pw" style="font-size: 22px;">
                    ID :<br>
                    PW :
                </div>                
                <div id="textbox">                    
                    <input type="text"placeholder="id"style="height:25px;width:200px;"name ="id" id = "text"><br>
                    <input type="password" placeholder="PW" name='pw' id = "text"
                    style="height: 25px; width: 200px">                                 
                </div>
                <br>
                <button type="submit" id="button_login">Enter</button>
                </form>
                <a href="signUp.jsp"><button type="button" id="button_login">Sign Up</button></a>
            
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