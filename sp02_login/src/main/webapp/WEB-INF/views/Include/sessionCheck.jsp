<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Include/includeFile.jsp" %>  
<script type="text/javascript">
	//세션체크
	if ('${sessionScope.userid}' == ''){
		alert("세션만료 : 로그인 후 이용하세요!");
		location.href ="${path}/board/";
	}
</script>