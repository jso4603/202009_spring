<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/includeFile.jsp" %>    
<%@include file="../Include/msg.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
</head>
<body>
	<h2>로그인화면</h2>
	<form name="loginForm" action="${path}/login/" method="post">
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"> <br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href = '${path}/member/join'">
	</form>
</body>
</html>