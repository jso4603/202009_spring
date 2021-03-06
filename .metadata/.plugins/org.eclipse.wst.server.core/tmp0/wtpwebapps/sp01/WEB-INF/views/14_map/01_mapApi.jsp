<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 지도 표시하기</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bu893hnprh"></script>
<script>
	$(function() {
		// 맵을 만들기 위한 옵션
		var mapOptions = {
			    center: new naver.maps.LatLng(37.5666805, 126.9784147),
			    zoom: 15
		};
		
		// 옵션을 이용한 맵 만들기
		var map = new naver.maps.Map('map', mapOptions);
		
		// 마커 만들기
		var marker = new naver.maps.Marker({
		    position: new naver.maps.LatLng(37.5666805, 126.9784147),
		    map: map
		}); 
		
		// 정보 표시하기
		var contentString = [
	        '<div class="iw_inner">',
	        '   <h3>서울특별시청</h3>',
	        '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
	        '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
	        '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
	        '   </p>',
	        '</div>'
	    ].join('');

		var infowindow = new naver.maps.InfoWindow({
		    content: contentString
		});
	
		naver.maps.Event.addListener(marker, "click", function(e) {
		    if (infowindow.getMap()) {
		        infowindow.close();
		    } else {
		        infowindow.open(map, marker);
		    }
		});
	});
	
</script>
</head>
<body>
	<div id="map" style="width:100%;height:400px;"></div>
</body>
</html>