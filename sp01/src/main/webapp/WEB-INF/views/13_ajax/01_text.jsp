<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 테스트1</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script type="text/javascript">
	$(function() {

		// text데이터전송/text결과
		$('#ajaxTest').on('click',function(){
			console.log('ajaxTest');
			
			// 비동기 방식으로 데이터 주고 받는다
			$.ajax({
				url:"/sample/ajax/textResult", // 매핑 url
				type:"get", // 전송방식 (get, post)
				data:"userid=hong&age=20", // 서버로 전송할 데이터
				dataType: "text", // 서버에서 받아올 데이터의 형식 지정(html, xml, json, text)
				success:function(data){
					alert(data);
					$('#result').html(data);
				},
				error:function(){
					alert('실패');
				}
			});
		});
		
		// json데이터전송/json결과
		$('#ajaxTest2').on('click',function(){
			console.log('ajaxTest2');
			
			$.ajax({
				// 순서는 상관 없음.
				type: "post",
				url: "/sample/ajax/jsonSend",
				data: JSON.stringify({name:'홍길동',age:'20'}), // json 형태의 문자열
				contentType : "application/json;charset=utf-8",
				dataType: "text",
				success:function(result){
					alert(result);
					$('#result2').html(result);
				},
				error: function(result) {
					alert(result);
					$('#result2').html('실패');
				}
			});
			
		});
	});


</script>	
</head>
<body>
	<h4>ajax 테스트(text데이터전송/text결과)</h4>
	<button id="ajaxTest">ajax테스트</button>
	<div id="result"></div>
	<hr>
	
	<h4>ajax 테스트(json데이터전송/json결과)</h4>
	<button id="ajaxTest2">ajax테스트</button>
	<div id="result2"></div>
	<hr>
</body>
</html>