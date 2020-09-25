<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/includeFile.jsp" %>    
<%@include file="../Include/msg.jsp" %>
<%@include file="../Include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<script type="text/javascript">
	function logoutCheck() {
		var result = confirm('로그아웃 하시겠습니까?');
		
		if(result){
			location.href = '${path}/login/logout'
		}
	}
</script>
<body>
	<h2>메인화면</h2>
	${sessionScope.userid} 님 반갑습니다.<br>
	<input type="button" value="마이페이지" 
		onclick="location.href = '${path}/member/modify?userid=${sessionScope.userid}'">
	<input type="button" value="로그아웃" onclick="logoutCheck()"> <br>	
</body>
</html>