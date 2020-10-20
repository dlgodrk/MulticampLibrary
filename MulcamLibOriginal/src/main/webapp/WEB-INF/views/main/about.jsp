<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/header.jsp"%>  
<body>
	
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	
	<!-- Header - set the background image for the header in the line below -->
  	<header class="py-9 bg-image-full masthead" >
  			<br>
  			<br>
    	   <img class="img-fluid d-block mx-auto" src="${pageContext.request.contextPath}/resources/img/bluelogo.png" alt="" width="72" height="72">
  	</header>

  	<!-- Content section -->
  	<section class="py-5">
    	<div class="container">
      		<h1 class="font-black font-weight-normal"><strong>공공 도서관의 도서 검색 사이트</strong></h1>
      		<p class="font-black font-weight-normal">공공 도서관의 도서를 쉽게 검색하기 위한 사이트입니다.</p>
      		<p class="font-black font-weight-normal">사용자의 편의와 접근성을 고려한 디자인입니다.</p>
    	</div>
  	</section>
	
	<br>
   	<br>
   	<br>
   	<br>
   	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>   
   	


</body>
</html>