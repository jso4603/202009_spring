<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입(메소드 테스트)</h2>
	<form action="/sample/join" method="post">
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"><br>
		이메일 : <input type="email" name="email"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>