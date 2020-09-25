<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form action="/sample/file/upload" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="name"> <br>
		파일 <input type="file" name="myfile"> <br>
		<input type="submit" value="전송">
	</form>
	
	<h5>업로드 된 파일 정보</h5>
	파일명 : ${map.savefile} <br>
	파일사이즈 : ${map.filesize} <br>
	파일타입 : ${map.filetype} <br>
</body>
</html>