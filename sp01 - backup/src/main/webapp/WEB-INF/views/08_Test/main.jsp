<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<script type="text/javascript">
	if('${msg}' != ''){
		alert('${msg}');
	}
</script>
</head>
<body>
	<h2>메인</h2>
	반갑습니다. <br> 
	아이디 : ${userid} 패스워드 : ${passwd} 이메일 : ${email}<br>
</body>
</html>