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
                <!-- <li><a href="#">HOME</a></li>
                <li><a href="#">ABOUT</a></li>
               	<li><a href="#">LOGIN</a></li>
                <li><a href="#">COMUNITY</a></li> -->
            </ul>
        </div>
        <div class="intro_bg"></div>
            <div class="temp_body_select" align="center">
                <h1>비밀번호 변경</h1>
                <div class="temp_select">
<!-- ----------------------------------------------------------------------------- -->

<form action='../changePW.changePW'>
PW : <input type="password" name='pw1' id = "text"><br><br>
변경할 비밀번호 : <input type="password" name='pw2' id = "text"><br>
비밀번호 확인 : <input type="password" name='pw3' id = "text"><br>
<input type="submit" value="변경" id="button_login">
</form>


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