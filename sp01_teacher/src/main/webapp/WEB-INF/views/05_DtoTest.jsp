<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(dtoTest)</title>
</head>
<body>

<!-- 	<form action="/sample/dtoTest"> -->
 	<form action="/sample/dtoTest">
		아이디 : <input type="text" name="userid"> <br>
		비밀번호 : <input type="password" name="passwd"><br>
		이메일 : <input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
	${dto}
	${map}
</body>
</html>