<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/header.jsp"%>  
<head>
<title>지도보기</title>
<script type="text/javascript">
	
 		navigator.geolocation.getCurrentPosition(initmap);
	
 		
 		function initmap(position) {
		let locations = [['강남도서관',37.514712, 127.047142,'http://gnlib.sen.go.kr/'],['강동도서관',37.539419, 127.143459,'http://gdlib.sen.go.kr/'],
						 ['강서도서관',37.548531, 126.859811,'http://gslib.sen.go.kr/'],['개포도서관',37.484198, 127.063552,'http://gplib.sen.go.kr/'],
						 ['고덕평생학습관',37.556857, 127.158333,'http://gdllc.sen.go.kr/'],['고척도서관',37.505501, 126.853141,'https://gclib.sen.go.kr/'],
						 ['구로도서관',37.498498, 126.891616,'http://grlib.sen.go.kr/'],['남산도서관',37.553095, 126.981285,'http://nslib.sen.go.kr/'],
						 ['노원평생학습관',37.639520, 127.067667,'http://nwllc.sen.go.kr/'],['도봉도서관',37.653138, 127.012936,'http://dblib.sen.go.kr/'],
						 ['동대문도서관',37.573573, 127.024826,'http://ddmlib.sen.go.kr/'],['동작도서관',37.506006, 126.940049,'http://djlib.sen.go.kr/'],
						 ['마포평생아현분관',37.553909, 126.957136,'http://ahyon.sen.go.kr/'],['마포평생학습관',37.554355, 126.924094,'http://mpllc.sen.go.kr/'],
						 ['서대문도서관',37.583390, 126.940778,'http://sdmlib.sen.go.kr/'],['송파도서관',37.500092, 127.134820,'http://splib.sen.go.kr/'],
						 ['양천도서관',37.533799, 126.876538,'http://yclib.sen.go.kr/'],['어린이도서관',37.576580, 126.967887,'http://childlib.sen.go.kr/'],
						 ['영등포평생학습관',37.526393, 126.907365,'http://ydpllc.sen.go.kr/'],['용산도서관',37.552048, 126.979997,'http://yslib.sen.go.kr/'],
						 ['정독도서관',37.581062, 126.983005,'http://jdlib.sen.go.kr/'],['종로도서관',37.576504, 126.966330,'http://jnlib.sen.go.kr/']
						 ];
		
	    let map = new google.maps.Map(document.getElementById('map'), {
	        zoom: 12,
	        center: new google.maps.LatLng(37.549012, 126.988546),
	      });
	    let marker, i;
	    
	    for (i = 0; i < locations.length; i++) {  
	      marker = new google.maps.Marker({
	        id:i,
	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
	        map: map,
	        label: locations[i][0],
	        url: locations[i][3]
	      });
	      
	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	           let page = locations[i][3];
	           return function() {
	        	 window.open(page, "_blank")
	             //window.location.href = page; 
	           }
	         })(marker, i));
	    }
 		}
</script>
</head>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	
	<div class="container">
		<br>
		<br>
		<br>
		<h2 class="text-center font-weight-normal"><strong>공공 도서관 위치</strong></h2>
		<p class="text-center font-black font-weight-normal">마커 클릭시, 해당 사이트로 이동합니다.</p>
		<br>
	
		<div class="map" id="map" style="width: 80%;height: 400px; margin:auto; border-style: ridge"></div>
	</div>
	
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>   
</body>
</html>