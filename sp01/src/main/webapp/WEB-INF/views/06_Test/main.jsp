<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<script type="text/javascript">
	if('${msg}' != ''){
		alert('${msg}');
	}
</script>
<body>
	<h2>메인</h2>
	반갑습니다. 아이디 : ${userid} 패스워드 : ${passwd}<br>
	세션 스코프 아이디 : ${sessionScope.userid} 패스워드 : ${sessionScope.passwd}
</body>
</html>