<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script>
	if ('${msg}' != ''){
		alert('${msg}')
	}

</script>
</head>
<body>
	<h2>메인</h2>
	반값습니다.	${userid} ${passwd}
	${msg}
	<hr>
	세션 userid : ${sessionScope.userid} 
	
	
	
</body>
</html>