<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Include/includeFile.jsp" %>    
<%@include file="../Include/msg.jsp" %>
<%@include file="../Include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<script type="text/javascript">

	//팝업창에 전달하는 값 함수
	function getValue(){
		var passwd = modifyForm.passwd.value;
		pop.checkPWForm.passwd.value = passwd;
	}

	// 수정 확인
	function updateCheck() {
		var email = modifyForm.email.value;

		if(email == ''){
			alert('변경할 이메일을 입력하세요.');
		} else{
			pop = window.open('${path}/member/checkPW','pop','width=700,height=600,left=1000');
		}
	}
	
	// 수정 실행
	function update() {
		modifyForm.action = '${path}/member/modify';
		modifyForm.submit();
	}
	
	// 비밀번호 변경
	function changePW() {
		modifyForm.action = '${path}/member/moveChangePW';
		modifyForm.submit();
	}
	
	// 탈퇴 확인
	function deleteCheck() {
		var result = confirm('탈퇴하시겠습니까?');
		
		if(result){
			modifyForm.action = '${path}/member/deletePW';
			modifyForm.submit();
		}
	}
</script>
<body>
	<h2>마이페이지(수정화면)</h2>
	<form name="modifyForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" value="${dto.userid}" readonly></td>
			</tr>
			<tr>
				<th>이메일*</th>
				<td>
					<input type="text" name="email" placeholder="${dto.email}">
				</td>
			</tr>
			<tr>
				<th>사진*</th>
				<td>
					<img src="/images/${dto.filename}" width="100px"> <br>
					<input type="text" name="filename" value="${dto.filename}" readonly> <br>
					<input type="file" name="photofile">
					
					<input type="hidden" name="passwd" value="${dto.passwd}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="정보수정"
						onclick="updateCheck()">
					<input type="button" value="비밀번호변경"
						onclick="changePW()">	
					<input type="button" value="회원탈퇴"
						onclick="deleteCheck()">
					<input type="button" value="메인화면"
						onclick="location.href = '${path}/login/main'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>