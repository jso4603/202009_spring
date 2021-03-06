<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/message.jsp" %>
<%@include file="../include/includeFile.jsp" %>
<%@include file="../include/sessionCheck.jsp" %>
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
		var name = modifyForm.name.value;
		var zipcode = modifyForm.zipcode.value;
		var addr1 = modifyForm.addr1.value;
		var addr2 = modifyForm.addr2.value;

		if(email == ''){
			alert('변경할 이메일을 입력하세요.');
			modifyForm.email.focus();
		} else if(name == ''){
			alert('변경할 이름을 입력하세요.');
			modifyForm.name.focus();
		} else if(zipcode == ''){
			alert('변경할 우편번호를 입력하세요.');
			modifyForm.zipcode.focus();
		} else if(addr1 == ''){
			alert('변경할 주소를 입력하세요.');
			modifyForm.addr1.focus();
		} else if(addr2 == ''){
			alert('변경할 상세주소를 입력하세요.');
			modifyForm.addr2.focus();
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
				<th>이름*</th>
				<td>
					<input type="text" name="name" placeholder="${dto.name}">
				</td>
			</tr>
			<tr>
				<th>우편번호*</th>
				<td>
					<input type="text" name="zipcode" placeholder="${dto.zipcode}">
				</td>
			</tr>
			<tr>
				<th>주소*</th>
				<td>
					<input type="text" name="addr1" placeholder="${dto.addr1}">
				</td>
			</tr>
			<tr>
				<th>상세주소*</th>
				<td>
					<input type="text" name="addr2" placeholder="${dto.addr2}">
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
					<input type="button" value="게시판"
						onclick="location.href = '${path}/board/list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>