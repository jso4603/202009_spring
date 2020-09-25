<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러개의 파일 올리기</title>
</head>
<body>
	<h2>여러개의 파일 업로드</h2>
	<form action="/sample/file/uploads" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="name"> <br>
		파일 <input type="file" name="myfiles" multiple="multiple"> <br>
		<input type="submit" value="저장">
	</form>
	<h5>업로드된 파일 정보</h5>
	
	<c:forEach var="map" items="${resultList}">
		<hr>
		파일이름 : ${map.savefile} 
		<button onclick="location.href='/sample/file/download?filename=${map.savefile}'">다운로드</button>
		<br>
		파일사이즈 : ${map.filesize} <br>
		파일타입 : ${map.filetype} <br>
	</c:forEach>

</body>
</html>