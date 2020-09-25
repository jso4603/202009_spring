<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/sessionCheck.jsp" %>
<%@include file="../Include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 비밀번호 확인</title>
</head>
<body>
	<h2>비밀번호 확인</h2>
	삭제할 ID의 비밀번호를 입력하세요.<br>
	<form action="${path}/member/delete" method="post">
		<input type="hidden" name="userid" value="${dto.userid}">
		<input type="hidden" name="passwd" value="${dto.passwd}">
		<input type="hidden" name="email" value="${dto.email}">
		
		<input type="password" name="insertPW">
		<input type="submit" value="확인">
		<input type="button" value="취소" onclick="location.href = '${path}/login/main'">
	</form>
</body>
</html>