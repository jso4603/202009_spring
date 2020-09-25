<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콜백</title>
</head>
<body>
	<h2>회원 정보</h2>

	아이디 : ${resultMap.id} <br>
	이름 : ${resultMap.name} <br>
	이메일 : ${resultMap.email} <br>
</body>
</html>