<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<%@include file="../include/message.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사소개 화면</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bu893hnprh"></script>
<script type="text/javascript">
	$(function() {
		var address = $('#address').val();
		// alert(location);
		
		$.ajax({
			type:'get',
			contentType:'application/x-www-form-urlencoded; charset=utf-8',
			url:'${path}/company/geocodingFind?address='+address,
			dataType:'json',
			success:function(result){
				// alert('성공');
				console.log(result);
				$('#divResult').html(result.x);
				$('#divResult').append('<br>');
				$('#divResult').append(result.y);
				mapDraw(result.x,result.y); // 지도그리기 함수 호출
			},
			error:function(result){
				alert('실패');
				console.log(result);
			}
		});
		
		// 지도 불러오기
		function mapDraw(x,y) {
			var mapOptions = {
				    center: new naver.maps.LatLng(y, x),
				    zoom: 15
				};

			//옵션을 이용한 맵만들기
			var map = new naver.maps.Map('map', mapOptions);
			
			//마커 만들기
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(y, x),
			    map: map
			});
		}
		
		// 메인화면으로 이동
		$('#main').on('click', function(){
			$(location).attr('href', '${path}/board/')
		});
	});
</script>
</head>
<body>
	<h2>회사소개</h2>
	위치 : <input id="address" type="text" value="서울시 관악구 관천로24길 26" size="50"> 
	<button type="button" id="main">메인화면</button>
	<div id="map" style="width:400px;height:400px;"></div>
</body>
</html>