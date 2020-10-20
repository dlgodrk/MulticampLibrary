<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/common/header.jsp"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function deletePage(boardno){
        if(confirm("글이 삭제됩니다!")==true){
            location.href="${pageContext.request.contextPath}/deleteboard.do?boardno="+boardno;
        }
    };
</script>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	
	<div class="container">
	   	<br>
	   	<br>
	    <h2 class="text-black text-center">리뷰 상세</h2>
	   	<br>
	   	<br>
	    <table class="table">
	    	<tr>
		        <th width="100px"><strong>번호</strong></th>
		        <td>${boardcount}</td>
		        <th width="100px">조회수</th>
		        <td>${board.viewcount}</td>
	       	</tr>
	        <tr>
	            <th>작성자</th>
	            <td>${board.writer}</td>
	            <th>작성일</th>
	            <td>${board.boarddate}</td>
	       	</tr>                  
	       	<tr>
	            <th>제목</th>
	            <td colspan="3">${board.title}</td>
	       	</tr>              
	        <tr>
	            <th>내용</th>
	            <td colspan="3">${board.content}
	            </td>
	        </tr>   
	   	</table>
	
		<p align = "right">
		<c:if test="${!empty id}">
	       	<c:forEach var="data" items="${boardlist}">
				<c:if test="${id == data.writer}">
			   	 <button type="button" class="btn btn-primary" id="cbutton" onclick="location.href ='${pageContext.request.contextPath}/changeboard.do?boardno=${board.boardno}&title=${board.title}&content=${board.content}'">수정</button>
           		<button type="button" class="btn btn-primary" id="dbutton" onclick="deletePage(${board.boardno})">삭제</button>
	       		</c:if>
		    </c:forEach>
	    </c:if>
	    <button type="button" class="btn btn-primary" onclick = "location.href ='${pageContext.request.contextPath}/boardlist.do'">목록</button>               
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
