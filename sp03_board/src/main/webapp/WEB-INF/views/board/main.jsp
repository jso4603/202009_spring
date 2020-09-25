<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- 라지 버튼 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- 슬라이더 바 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

	<script>
	    $(document).ready(function(){
	        $('.slider').bxSlider({
	            auto: true,
	            autoControls: true,
	            stopAutoOnClick: true,
	            pager: true,
	            slideWidth: 600
	        });
	    });
	</script>
	
	<script type="text/javascript">
		$(function() {
			$('#boardList').on('click', function() {
				$(location).attr('href', '${path}/board/list');
			});
		});
	</script> 
	
</head>
<body>
	<header>
		<h2>게시판에 오신걸 환영합니다!</h2>	
		<div class="container">
			<button type="button" class="btn btn-lg" id="boardList">게시판목록</button>
			<button type="button" class="btn btn-lg" id="login">로그인</button>
			<button type="button" class="btn btn-lg" id="join">회원가입</button>
		</div>
	</header>
	
	<div class="slider">
    	<div><img alt="슬라이더이미지" src="${path}/resources/images/javascript.jpeg"  width="500px" height="250px"></div>
    	<div><img alt="슬라이더이미지" src="${path}/resources/images/jquery.png"  width="500px" height="250px" ></div>
    	<div><img alt="슬라이더이미지" src="${path}/resources/images/jsp.png"  width="500px" height="250px"></div>
    	<div><img alt="슬라이더이미지" src="${path}/resources/images/spring.png"  width="500px" height="250px"></div>
	</div>
	
<%-- 	<div>
		<!-- servlet-context.xml 에 이미지 경로 매핑 -->
		<img alt="메인이미지" src="${path}/resources/images/cat.jpg" width="100px">
		<img alt="메인이미지" src="${path}/img/cat.jpg" width="100px">
		<img alt="메인이미지" src="${path}/localimg/cat.jpg" width="100px">
		<!-- server.xml에 이미지 경로 매핑 -->
		<img alt="메인이미지" src="/images/cat.jpg" width="100px">
	</div> --%>
</body>
</html>