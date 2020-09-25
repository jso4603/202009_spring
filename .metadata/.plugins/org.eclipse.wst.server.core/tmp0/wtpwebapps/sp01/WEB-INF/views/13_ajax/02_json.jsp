<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json으로 값 받기</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<!-- 핸들바 라이브러리 추가  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>
<!-- 첫번째 탬플릿 소스 -->
<!-- {{#each .}} : 객체 자신을 반복하는 반복문  -->
<script id="template_source" type="text/x-handlebars-template">
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
		</tr>
	{{#each .}}
		<tr>
			<td>{{userid}}</td>
			<td>{{passwd}}</td>
			<td>{{email}}</td>
		</tr>
	{{/each}}
	</table>
</script>
<script type="text/javascript">
	$(function() {
		// 전체읽기
		$('#jsonResult').on('click',function(){
			console.log(jsonResult);
			$.ajax({
				type: "get",
				url: "/sample/ajax/jsonResult",
				dataType:'json',
				success:function(data){
					console.log(data);
					// 핸들바를 이용한 데이터 출력
					var source = $('#template_source').html();
					var template = Handlebars.compile(source);
					$('#result').html(template(data));
				},
				error:function(data){
					alert('실패');
				}
			});
		});
		
		// 한 건만 조회
		$('#jsonResultOne').on('click',function(){
			// 아이디 값 읽기
			var userid = $('#userid').val();
			
			console.log(jsonResultOne);
			$.ajax({
				type: "get",
				url: "/sample/ajax/jsonResultOne/"+userid,
				dataType:'json',
				success:function(data){
					console.log(data);
					// 핸들바를 이용한 데이터 출력
					var source = $('#template_source').html();
					var template = Handlebars.compile(source);
					$('#result').html(template(data));
				},
				error:function(data){
					alert('실패');
				}
			});
		});
	});
</script>
</head>
<body>
	아이디 : <input id = "userid" type="text"> <br>
	<button id="jsonResult">json으로 값 받기</button>
	<button id="jsonResultOne">한건만 가져오기</button>
	<div id="result">
	
	</div>
</body>
</html>