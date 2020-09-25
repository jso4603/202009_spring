<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body>
	<h2>로그인(리다이렉트 테스트)</h2>
	<form action="/sample/loginCheck" method="post">
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"> <br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>