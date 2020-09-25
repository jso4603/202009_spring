<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/includeFile.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript">
	$(function() {
		if ('${sessionScope.userid}' ==''){
			$('#aLogin').show();
			$('#aJoin').show();
			$('#aLogout').hide();
		}else{
			$('#aLogin').hide();
			$('#aJoin').hide();
			$('#aLogout').show();			
		}
		
		//게시판목록
		$('#aBoardList').on('click', function(e) {
			if ('${sessionScope.userid}' ==''){
				alert('로그인을 먼저 하세요!');
				e.preventDefault(); //객체의 기본기능을 소멸
			}else{
				$(this).attr('href', '${path}/form/board/list');
			}
		});

		//홈
		$('#aHome').on('click', function(e) {
			$(this).attr('href', '${path}/form/home');
		});

		//로그아웃
		$('#aLogout').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			var result = confirm('로그아웃 하시겠습니까?');
			if (result){
				$(location).attr('href', '${path}/form/logout');
			}
		});
		//내정보
		$('#aMyinfo').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			$(this).attr('href', '${path}/form/myinfo');
		});
		
		//로그인
		$('#btnLogin').on('click', function(e) {
			//아이디/패스워드 체크
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#loginForm').attr('action','${path}/form/login');
			$('#loginForm').attr('method','post');
			$('#loginForm').submit();
		});
		
		//회원가입
		$('#btnJoin').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			$(this).attr('href','${path}/form/join');
			$('#myModal').modal('hide');
			
		});
		
		//로그인 취소
		$('#btnLoginCancel').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#loginModal').modal('hide');
		});
		
		//회원가입 취소
		$('#btnJoinCancel').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#joinModal').modal('hide');
		});

	});

</script>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="" id="aHome" target="myframe">홈</a>
      <a class="navbar-brand" href="" id="aBoardList" target="myframe">게시판</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" data-toggle="modal" data-target="#loginModal" id="aLogin">로그인</a></li>
        <li><a href="#" data-toggle="modal" data-target="#joinModal" id="aJoin">회원가입</a></li>
        <li><a href="" id="aLogout">로그아웃</a></li>
        <li><a href="" id="aMyinfo" target="myframe">${sessionScope.userid}</a></li>
      </ul>
    </div>
    
    
  <!-- 로그인 Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
		<div class="modal-header">
	 		<h4 class="modal-title">로그인</h4>
	    </div>
        <div class="modal-body">	    
			<form id ="loginForm">
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			    	<input id="id" type="text" class="form-control" name="id" placeholder="id">
			  	</div>
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			    	<input id="password" type="password" class="form-control" name="pw" placeholder="Password">
			  	</div>
			</form>
		</div>
 		<div class="modal-footer">
 			<a href=""  class="btn btn-primary" id="btnLogin">로그인</a>
 			<a href="" class="btn btn-success" id="btnLoginCancel">취소</a>
		</div>      
      </div>
    </div>
  </div>
  

  <!-- 회원가입 Modal -->
  <div class="modal fade" id="joinModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
		<div class="modal-header">
	 		<h4 class="modal-title">회원가입</h4>
	    </div>
        <div class="modal-body">	    
			<form id ="joinForm">
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			    	<input id="id" type="text" class="form-control" name="id" placeholder="id">
			  	</div>
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			    	<input id="password" type="password" class="form-control" name="pw" placeholder="password">
			  	</div>
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
			    	<input id="password" type="email" class="form-control" name="email" placeholder="email">
			  	</div>
			  	<div class="input-group">
			    	<span class="input-group-addon"><i class="glyphicon glyphicon-camera"></i></span>
			    	<input id="password" type="file" class="form-control" name="photofile" placeholder="photo">
			  	</div>

			</form>
		</div>
 		<div class="modal-footer">
 			<a href=""  class="btn btn-primary" id="btnJoin">저장</a>
 			<a href="" class="btn btn-success" id="btnJoinCancel">취소</a>
		</div>      
      </div>
    </div>
  </div>
    
    
  </div>
</nav>	 
<!-- First Container -->
<iframe name="myframe" src="${path}/form/home">

</iframe>

<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p>국제아카데미 <a href="http://www.gcacademy.co.kr">www.gcacademy.co.kr</a></p> 
</footer>
</body>
</html>