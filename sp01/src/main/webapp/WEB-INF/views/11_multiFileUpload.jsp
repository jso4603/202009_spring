<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러개 파일 업로드</title>
</head>
<body>
	<h2>여러개 파일 업로드</h2>
	<form action="/sample/file/uploads" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="name"> <br>
		파일 <input type="file" name="myfiles" multiple="multiple"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h5>업로드 된 파일 정보</h5>
	<c:forEach items="${list}" var="f">
		파일명 : ${f.savefile}
		<input type="button" value="다운로드" 
			onclick="location.href = '/sample/file/download?filename=${f.savefile}'"> <br>
		파일사이즈 : ${f.filesize} <br>
		파일타입 : ${f.filetype} <br>
		<hr>
	</c:forEach>
</body>
</html>