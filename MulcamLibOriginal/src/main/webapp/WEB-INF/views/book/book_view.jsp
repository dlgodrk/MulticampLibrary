<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/header.jsp"%>  

</head>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	
	<div class="container">
	   	<br>
	   	<br>
	    <h2 class="text-black text-center"><strong>책 상세정보</strong></h2>
	   	<br>
	   	<br>
	    <table class="table">
	    	<tr>
		        <th width="200px"><strong>책 등록번호</strong></th>
		        <td>${book.bookKey}</td>
		        <th width="100px"><strong>조회수</strong></th>
		        <td>${book.viewcount}</td>
	       	</tr>
	        <tr>
	            <th><strong>제목</strong></th>
	            <td>${book.title}</td>
	            <th><strong>저자</strong></th>
	            <td>${book.author}</td>
	       	</tr>                  
	       	<tr>
	            <th><strong>출판사</strong></th>
	            <td>${book.publisher}</td>
	            <th><strong>출판년도</strong></th>
	            <td>${book.pubYear}</td>
	       	</tr>                	
	   	</table>
	
		
		<p align = "right">
		<c:if test= "${check==1}">
			<form name="backform" method="post" action="${pageContext.request.contextPath}/booklist.do">
			    <button type="submit" class="btn btn-primary"><strong>목록</strong></button>               
		       	<input type="hidden" id="library" name="library" value="${library}">
		       	<input type="hidden" id="option" name="option" value="${option}">
		       	<input type="hidden" id="target" name="target" value="${target}">
	       	</form>
       	</c:if>
       	<c:if test ="${check==0}">
			<form name="backform" method="post" action="${pageContext.request.contextPath}/main/main.do">
			    <button type="submit" class="btn btn-primary"><strong>홈으로</strong></button> 
	       	</form>
       	</c:if>
       	</p>
       	
	</div>
	<br> 	
	<br>
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>   
</body>
</html>
