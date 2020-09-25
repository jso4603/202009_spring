<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/includeFile.jsp" %>    
<%@include file="../Include/msg.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
</head>
<script type="text/javascript">

	// 회원가입 체크
	function joinCheck() {
		var userid = joinForm.userid.value;
		var passwd = joinForm.passwd.value;
		var email = joinForm.email.value;
		var photofile = joinForm.photofile.value;
		
		if(userid ==''){
			alert('아이디를 입력해주세요');
			joinForm.userid.focus();
		} else if(passwd ==''){
			alert('비밀번호를 입력해주세요');
			joinForm.passwd.focus();
		} else if(email ==''){
			alert('이메일을 입력해주세요');
			joinForm.email.focus();
		} else if(photofile ==''){
			alert('사진을 입력해주세요');
			joinForm.photofile.focus();
		} else {
			joinForm.submit();
		}
	}
</script>
<body>
	<h2>회원가입</h2>
	<form name="joinForm" action="${path}/member/join" method="post" 
		enctype="multipart/form-data">
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
				<th>이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photofile"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="joinCheck()">
					<input type="reset" value="입력취소">
					<input type="button" value="로그인화면" 
						onclick="location.href = '${path}/login/'"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>