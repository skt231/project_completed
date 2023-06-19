<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/TFTInfoSite/template/style.css">
</head>
<style>
</style>
<script>
window.onload=function(){
	

<%

	String id =(String)session.getAttribute("id");
	System.out.println(id);
	if(!id.equals("admin")){
%>
		alert("잘못된 접근입니다.");
		location.href="/TFTInfoSite/Login/LoginPage.jsp";
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
             <li><a href="Item.jsp">아이템</a></li>
				<li><a href="/TFTInfoSite/Main_Select/selectUser.rank">랭크</a></li>
				<li><a href="https://lolchess.gg/?hl=ko-KR">정보사이트 가기</a></li>
				<li><a href="/TFTInfoSite/Login/LoginPage.jsp">로그아웃</a></li>
				<li><a href="../Login/Withdrawal.jsp">회원 탈퇴</a></li>
            </ul>
        </div>
        <div class="intro_bg"></div>
            <div class="temp_body_select" align="center">
                <h1>회원 정보</h1>
                <div class="temp_select">
<!-- ----------------------------------------------------------------------------- -->
<div id="topsquare">
	<table border="1" width="90%" id="champion">
		<tr>
			<th>ID</th>
			<th>PW</th>
		</tr>
		<tr>
			<td>${requestScope.dto.ID }</td>
		 	<td>${requestScope.dto.PW }</td>
		</tr>
	</table>

	<a href="/TFTInfoSite/Main_Select/MemberSelect.member"><button id="button_login">목록가기</button></a>
	<a href="/TFTInfoSite/Main_Select/Memberdelete.member?ID=${requestScope.dto.ID }"><button id="button_login">삭제하기</button></a> 
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