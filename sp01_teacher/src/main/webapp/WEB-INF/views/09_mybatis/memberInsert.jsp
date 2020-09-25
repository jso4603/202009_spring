<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원저장</title>
</head>
<body>
	<h2>회원추가</h2>
	<form action="/sample/member/insert" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"> </td>
			</tr>
			
		
		</table>
	
	</form>
</body>
</html>