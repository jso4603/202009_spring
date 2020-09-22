<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<%@include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인화면</title>
</head>
<script type="text/javascript">

	if ('${msg}' == "비밀번호 일치"){
		alert('${msg}');
		opener.update();
		closeWindow();
		
	} else if ('${msg}' == "비밀번호 불일치"){
		alert('${msg}');
	}
	
	function closeWindow() {
		close();
	}
	
</script>
<body>
	<h2>비밀번호 확인</h2>
	비밀번호를 입력하세요.<br>
	<form name="checkPWForm" action="${path}/member/checkPW" method="post">
	
		<input type="hidden" name="passwd">
		<input type="password" name="insertPW">
		
		<input type="submit" value="확인">
		<input type="button" value="취소" onclick="closeWindow()">
	</form>
	
<script type="text/javascript">
	<!-- 부모에서 값 가져오기 -->
	opener.getValue();
</script>
</body>
</html>