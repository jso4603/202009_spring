<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<script type="text/javascript">
	if('${msg}' != ''){
		alert('${msg}');
	}
</script>
<body>
	<h2>회원조회</h2>
	<!-- location.href는 get방식  -->
	<input type="button" value="회원가입"
		onclick="location.href='/sample/member/insert'">
	<table border="2">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.userid}</td>
				<td>
					<c:forEach var="j" begin="1" end="${fn:length(i.passwd)}">
						*
					</c:forEach>
				</td>
				<td>${i.email}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>