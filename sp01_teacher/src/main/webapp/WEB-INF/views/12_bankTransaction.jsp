<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행계좌이체</title>
</head>
<body>
	<!-- a통장에서 b통장의 이체 -->
	<h2>이체</h2>
	<form action="/sample/bank/" method="post">
		<input type="number"  name = "money">
		<input type="submit" value="이체">
	</form>
</body>
</html>