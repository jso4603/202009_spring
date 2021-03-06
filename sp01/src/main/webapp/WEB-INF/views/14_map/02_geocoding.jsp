<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소를 이용해서 위/경도</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bu893hnprh"></script>
<script type="text/javascript">
	$(function() {
		$('#btnGeoCoding').on('click',function(){
			var address = $('#txtGeocoding').val();
			alert(address);
			
			$.ajax({
				type:'get',
				contentType:'application/x-www-form-urlencoded; charset=utf-8',
				url:'/sample/map/geocodingFind?address='+address,
				dataType:'json',
				success:function(result){
					alert('성공');
					console.log(result);
					$('#divResult').html(result.x);
					$('#divResult').append('<br>');
					$('#divResult').append(result.y);
					mapDraw(result.x,result.y);
				},
				error:function(result){
					alert('실패');
					console.log(result);
				}
			});
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
	});
</script>
</head>
<body>
	<h2>주소=>위경</h2>
	주소 : <input id="txtGeocoding" type="text">
	<button id="btnGeoCoding">찾기</button>
	<div id="divResult">
	
	</div>
	
	<div id="map" style="width:400px;height:400px;"></div>
</body>
</html>