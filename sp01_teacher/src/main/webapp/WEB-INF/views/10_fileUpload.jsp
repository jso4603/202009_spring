<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h2>한개의 파일 업로드</h2>
	
	<form action="/sample/file/upload" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="name"> <br>
		파일 <input type="file" name="myfile"> <br>
		<input type="submit" value="저장">
	</form>
	<h5>업로드된 파일 정보</h5>
	파일명 : ${resultMap.savefile} <br>
	파일사이즈 : ${resultMap.filesize} <br>
	파일타입 : ${resultMap.filetype} <br>
	
	
</body>
</html>