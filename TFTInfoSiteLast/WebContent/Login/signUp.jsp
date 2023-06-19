<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                <!-- <li><a href="#">HOME</a></li> -->                
                
            </ul>
        </div>
        <div class="intro_bg"></div>
            <div class="temp_body" align="center" style="height:530px">
                <div id="Login_title" style="position: relative; ">
                <h2>회원 가입</h2>
                </div>
                
                <form action="../Login.signUp" style="height:200px; z-index: 10;">                          
                <div id="textbox">                    
                   ID  <input type="text" placeholder="id" style="height: 25px; width: 200px;" name = id id="text"><br>
                   PW  <input type="password" placeholder="PW" name = "pw" id = "text"
                    style="height: 25px; width: 200px">                
              	     비밀번호 확인  <input type = "password" placeholder = "PW" name = "c_pw" id = "text"
                    style="height:25px; width: 200px">                 
                </div>
                <br>
                <br>
                <button type="submit" id="button_login" style="display:block; ;">회원가입</button>
            </form>
            </div>            
        </div>
    <div class="bar_under">
        <ul class="info_under">
            <li>LWC, HYJ, SKT</li><br>
            <li>KKH, KJH, PKH</li>
        </ul>
    </div>
</body>
</html>