<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="/sample/resources/css/style.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">
    
    <script>
    	$(function(){
    		$('#btnMsg').on('click', function(){
    			var msg = $('#txtMsg').val();
    			var date = getToday();
				var appendMsg = '<div class="outgoing_msg"> ' + 
                				'<div class="sent_msg"> ' +
                				'<p>' + msg + '</p> ' +
                				'<span class="time_date"> '+ date +'</span> </div> ' +
            					'</div> ';    
            	
				$('#divHistory').append(appendMsg);
    			$('#divHistory').scrollTop($('#divHistory').height());
    			
    			$.ajax({
    				type:'post',
    				contentType:'application/json',
    				url : '/sample/chat/sendMsg',
    				data : JSON.stringify({msg:msg}), //json문자열 표기법으로 변환
    				dataType : 'text',  //결과값의 타입
    				success : function(result){
    					console.log(result);
    					receiveMsgAppend(result);
    				},
    				error:function(result){
    					alert("error");
    					console.log(result);
    				}
    			});
    			
    			//받은메시지 추가
    			function receiveMsgAppend(msg){
        			var date = getToday();
    				var appendMsg = '<div class="incoming_msg"> ' +
            	                    '<div class="incoming_msg_img"> <img src="/sample/resources/images/lion.png" alt="sunil"> </div> ' +
            	                    '<div class="received_msg"> ' +
            	                    '<div class="received_withd_msg"> ' +
            	                    '    <p>' + msg + '</p> ' +
            	                    '    <span class="time_date"> '+ date +'</span></div> ' +
            	                    '</div> ' +
            	                	'</div>';
            	                
    				$('#divHistory').append(appendMsg);
        			$('#divHistory').scrollTop($('#divHistory').height());    				
    			}
    			
    			//시스템 날짜 구하기
    			function getToday(){
    				var date = new Date();
    				return date.getFullYear() + "-" + 
    						("0" + (date.getMonth() + 1)).slice(-2) + "-" + ("0" + (date.getDate() + 1)).slice(-2) +  ' | ' +
    						date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
    			}
    			
    		});
    	});
    
    </script>
    
</head>
<body>
   <div class="container">
        <h3 class=" text-center">Messaging</h3>
        <div class="messaging">
            <div class="mesgs">
                <div id = "divHistory" class="msg_history">
                </div>
                <div class="type_msg">
                <div class="input_msg_write">
                    <input id="txtMsg" type="text" class="write_msg" placeholder="Type a message" />
                    <button id="btnMsg" class="msg_send_btn" type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                </div>
            	</div>
       		</div>
		</div>
  	</div>  
</body>
</html>
