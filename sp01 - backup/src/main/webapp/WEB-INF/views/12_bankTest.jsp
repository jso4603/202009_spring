<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금/출금내역 테스트</title>
</head>
<body>
	<!-- a통장에서 b통장으로 이체  -->
	<form action="/sample/bank/" method="post">
		입급할 돈을 입력하세요 :
		<input type="number" name="money">원 <br>
		<input type="submit" value="송금"> 
	</form>
</body>
</html>