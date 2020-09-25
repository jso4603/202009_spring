<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<%@include file="../include/message.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
</head>

<script type="text/javascript">

	function loginCheck() {
		//필수 값 체크
		var userid = loginForm.userid.value;
		var passwd = loginForm.passwd.value;
		
		if (userid == ''){
			alert('아이디를 입력하세요');
			loginForm.userid.focus();
		} else if(passwd == ''){
			alert('비밀번호를 입력하세요');
			loginForm.passwd.focus()
		} else {
			loginForm.submit();
		}
	}	
</script>

<body>
	<h2>로그인화면</h2>
	<form name="loginForm" action="${path}/login/" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onclick="loginCheck()" value="로그인">
					<input type="reset" value="취소">
					<input type="button" value="회원가입" onclick="location.href = '${path}/member/join'">
					<input type="button" value="메인화면" onclick="location.href = '${path}/board/'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>