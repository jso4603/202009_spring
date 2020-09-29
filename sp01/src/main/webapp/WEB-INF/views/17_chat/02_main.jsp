<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/css/animate.min.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/css/jquery.modal.css" />

<script src="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/js/jquery.modal.js"></script>

<script src="//cdn.jsdelivr.net/gh/stove99/jquery-modal-sample@v1.4/js/modal.js"></script>    
	<script>
		$(function(){
		    $('#btn').click(function(event) {
		        event.preventDefault();
		        this.blur();
		        $.popup({
		            url: '/sample/chat/',
		            close: function(result) {
		                console.log(result);
		            }
		        });
		    });
			
		});
	</script>
</head>
<body>
	<button id="btn" type="button" class="btn btn-primary btn-lg">팝업</button>
</body>
</html>
