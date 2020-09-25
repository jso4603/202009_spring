<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@include file="../include/includeFile.jsp" %>
<%@include file="../include/message.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입화면</title>
</head>
<script type="text/javascript">
	function joinCheck() {
		//필수 값 체크
		var userid = joinForm.userid.value;
		var email = joinForm.email.value;
		var name = joinForm.name.value;
		var passwd = joinForm.passwd.value;
		var repw = joinForm.repw.value;
		var zipcode = joinForm.zipcode.value;
		var addr1 = joinForm.addr1.value;
		var addr2 = joinForm.addr2.value;
		
		if (userid == ''){
			alert('아이디를 입력하세요');
			joinForm.userid.focus();
		} else if(email ==''){
			alert('이메일을 입력하세요');
			joinForm.email.focus();
		} else if(name == ''){
			alert('이름을 입력하세요');
			joinForm.name.focus();
		} else if(passwd == ''){
			alert('비밀번호를 입력하세요');
			joinForm.passwd.focus()
		} else if(passwd != repw){
			alert('비밀번호가 일치하지 않습니다.');
			joinForm.repw.focus()
		} else if(zipcode == ''){
			alert('우편번호를 입력하세요');
			joinForm.zipcode.focus();
		} else if(addr1 == ''){
			alert('주소를 입력하세요');
			joinForm.addr1.focus();
		} else if(addr2 == ''){
			alert('상세주소를 입력하세요');
			joinForm.addr2.focus();
		} else {
			joinForm.submit();
		}
	}
</script>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="${path}/member/join" name="joinForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" value="${resultMap.id}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${resultMap.email}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${resultMap.name}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<th>비밀번호 재입력</th>
				<td><input type="password" name="repw"> </td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="zipcode"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr1"></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="addr2"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photofile"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="가입" onclick="joinCheck()">
				<input type="reset" value="취소">
				<input type="button" value="로그인화면" onclick="location.href = '${path}/login/'">
				<input type="button" value="메인화면" onclick="location.href = '${path}/board/'">
				</td>
			</tr>
		</table>
	</form>
	<!-- 네이버 로그인  -->
	<a href="${apiURL}"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
</body>
</html>