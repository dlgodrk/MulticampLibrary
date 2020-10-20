 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	<div class="container">
		<br>
		<br>
		<br>
	    <!-- Page Content -->
	    <h2 class="text-black text-center"><strong>독서 게시판</strong></h2>
	   
	   <br>
	    <button type="button" class="btn btn-info" id = "wrbutton" style="float:right"
	     onclick = "location.href ='${pageContext.request.contextPath}/writeboard.do'"><strong>게시글 쓰기</strong></button>
	     <c:if test="${empty id}">
	    	<script>
		    	const wrbutton = document.getElementById("wrbutton");
				wrbutton.setAttribute("onclick","location.href ='${pageContext.request.contextPath}/login.do'");
	    	</script>
	    </c:if>
	    <br>
	    <br>
	  
	   <div id="layoutSidenav_content">
        	<main>
            	<div class="container-fluid">
                	<div class="card mb-4">
                    	<div class="card-header"> <i class="fas fa-table mr-1"></i><strong>게시글 목록 </strong></div>
                       	<div class="card-body">
                        	<div class="table-responsive">
                            	<table class="table table-bordered table-hover" style="table-layout: fixed" id="dataTable" width="100%" cellspacing="0" >
	                                <thead >
								    	<tr>
								           <th>번호</th>
								           <th style="width:50%;  text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">제목</th>
								           <th>작성자</th>
								           <th>작성일</th>
								           <th>조회수</th>
								        </tr>
									</thead>
							        <tbody>
								        <c:forEach var="data" items="${boardlist}" varStatus="status">
								        <tr>
								           <td>${status.count}</td>
								           <td style="width:50%;  text-overflow:ellipsis; overflow:hidden; white-space:nowrap;"><a href="viewboard.do?boardno=${data.boardno}&boardcount=${length-status.index}">${data.title}</a></td>
								           <td>${data.writer}</td>
								           <td>${data.boarddate}</td>
								           <td>${data.viewcount}</td>
								        </tr>
								        </c:forEach>
							        </tbody>
                              	</table>
                            </div>
                        </div>
                    </div>
                </div>
          	</main>
		</div>
	</div>
	<!-- dataTable 기능 제거 및 위치-->
		<script>
			$("#dataTable").DataTable({   
		   
		   		dom : "<'row'<'col-sm-2'l><'col-sm-7'><'col-sm-3'f>>" +
		   			"<'row'<'col-sm-12'tr>>" +
		   			"<'row'<'col-sm-12 col-md-8'p>>",
		   		 "language":{
		   		   "url": "//cdn.datatables.net/plug-ins/1.10.9/i18n/Korean.json"
		   		 },
				"bFilter": false
			});   
		</script>  
	<%@include file="/WEB-INF/views/common/footer.jsp"%>   
</body>
</html>
