<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post/get</title>
</head>
<body>
	<h2>GET방식 테스트</h2>
	<form action="/sample/methodTest" method="get">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		<input type="submit" value="GET버튼">
	</form>
	<hr>
	<h2>POST방식 테스트</h2>
	<form action="/sample/methodTest" method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		<input type="submit" value="POST버튼">
	</form>
</body>
</html>