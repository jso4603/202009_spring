<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<script type="text/javascript">
	if ('${msg}' != ''){
		alert('${msg}');
	}

</script>
</head>
<body>
	<h2>회원조회</h2>
	<div>
		<input type="button" value="회원추가" onclick="location.href='/sample/member/insert'">
	</div>
	<c:forEach var="member" items="${list}">
		${member.userid}  ${member.passwd} ${member.email} <br>
	</c:forEach>
	
</body>
</html>