<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/includeFile.jsp" %>   
<%@include file="../Include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경화면</title>
</head>
<body>
	<h2>비밀번호 변경</h2>
	<form action="${path}/member/changePW">
		<input type="hidden" name="userid" value="${dto.userid}">
		<input type="hidden" name="passwd" value="${dto.passwd}">
		<input type="hidden" name="email" value="${dto.email}">
		
		기존 비밀번호 : 
		<input type="password" name="oldPW"> <br>
		변경할 비밀번호 :
		<input type="password" name="newPW"> <br>
		<input type="submit" value="확인">
		<input type="button" value="취소" onclick="location.href = '${path}/login/main'">
	</form>
</body>
</html>