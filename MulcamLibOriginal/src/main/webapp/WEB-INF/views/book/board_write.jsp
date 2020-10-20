<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/header.jsp"%> 
<script>
   function cancel() {
      if (confirm('취소하시겠습니까? 작성된 글은 저장되지 않습니다.') == true) {
         location.href = '${pageContext.request.contextPath}/boardlist.do'
      }
   }
   $(function() {
      $('#content').keyup(function(e) {
         var content = $(this).val();
         $('#counter').html(content.length + '/1000');
      });
      $('#content').keyup();
   });
   function brr(){
      var str = document.getElementById("content").value;
      str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
      document.getElementById("content2").value = str;
   }
   function rrb(){
	   var str = '${content}';
	   str = str.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
	   document.getElementById("content").value= str;
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
	   	<h2 class="text-black text-center"><strong>게시글 작성</strong></h2>

	   	<form class="form-horizontal" id="writeform" name="writeform" method="post" action="${pageContext.request.contextPath}/writeboard.do">
	    	<input type ="hidden" id="boardno" name="boardno" value="${boardno}"/>
	    	<input type ="hidden" id="content2" name="content2" value="">
	    	<div>
	        	<label><strong>제목</strong></label>
	            <input type="text" maxlength="50" class="form-control" id="title" name="title" value="${title}" onkeydown='javascript_:{ if(event.keyCode==13) event.returnValue=false;}'>
	         </div>
	         <div>
	            <label><strong>내용</strong></label>
	            <c:if test="${empty content}">
	            <textarea maxlength="1000" class="form-control" id="content" name="content" rows="10"></textarea>
	            </c:if>
	            <c:if test="${!empty content}">
	            <textarea maxlength="1000" class="form-control" id="content" name="content" rows="10"></textarea>
	            <script>
	            	rrb();
	            </script>
	            </c:if>
	            <span id="counter">	</span>
	         </div>
	         <br>
			<p align = "right">
		        <button type="submit" class="btn btn-primary" form="writeform" onclick = "brr()">저장</button>
		        <button type="button" class="btn btn-primary" onclick="return cancel()">취소</button>
		        <button type="button" class="btn btn-primary" onclick="location.href ='${pageContext.request.contextPath}/boardlist.do'">목록</button>               
	       	</p>
   		</form>
	</div>
	<br>
	<br>
	<br>
   <%@include file="/WEB-INF/views/common/footer.jsp"%> 
</body>
</html>