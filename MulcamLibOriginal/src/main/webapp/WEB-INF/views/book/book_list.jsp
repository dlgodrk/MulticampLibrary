<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/header.jsp"%>  
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	<br>
	<br>
	<div class="container">
     	<div class="col-md-10 col-lg-10 cl-xl-9 mx-auto">
            	<form name="searchform" method="post" action="${pageContext.request.contextPath}/booklist.do">
	                <div class="form-row">
                  		<div class="col-md-20 col-md-3">
                      		<select  id="library" name="library"  class="form-control form-control-lg" aria-controls="dataTable">
		                  		<option value="강남도서관">강남도서관</option>
								<option value="강동도서관">강동도서관</option>
								<option value="강서도서관">강서도서관</option>
								<option value="개포도서관">개포도서관</option>
								<option value="고덕평생학습관">고덕평생학습관</option>
								<option value="고척도서관">고척도서관</option>
								<option value="구로도서관">구로도서관</option>
								<option value="남산도서관">남산도서관</option>
								<option value="노원평생학습관">노원평생학습관</option>
								<option value="도봉도서관">도봉도서관</option>
								<option value="동대문도서관">동대문도서관</option>
								<option value="동작도서관">동작도서관</option>
								<option value="마포평생아현분관">마포평생아현분관</option>
								<option value="마포평생학습관">마포평생학습관</option>
								<option value="서대문도서관">서대문도서관</option>
								<option value="송파도서관">송파도서관</option>
								<option value="양천도서관">양천도서관</option>
								<option value="어린이도서관">어린이도서관</option>
								<option value="영등포평생학습관">영등포평생학습관</option>
								<option value="용산도서관">용산도서관</option>
								<option value="정독도서관">정독도서관</option>
								<option value="종로도서관">종로도서관</option>
	                   		</select>
	                	</div>
                     	<div class="col-md-20 col-md-2">
                       		<select  id="option" name="option" class="form-control form-control-lg" aria-controls="dataTable" >
                           		<option value="title">도서제목</option>
	                           	<option value="publisher">출판사</option>
	                           	<option value="author">저자</option>
                        	</select>
                    	</div>
                        <div class="col-md-20 col-md-6">
                        	<!-- 엔터키 방지 -->
                           	<input hidden="hidden"/> 
                            <input type="text" id="target" name="target" class="form-control form-control-lg" placeholder="">
                       	</div>
                        <div class="col-md-20 col-md-1">
                            <button type="submit" id="btnSearch" class="btn btn-block btn-lg btn-primary" onclick=""> 
                            	<img class="mb-2" src="${pageContext.request.contextPath}/resources/img/search.png" alt="" width="20" height="20">  
                            </button>
                       	</div>
                    </div>
              	</form>
           	</div>
       	<br>
       	<div id="layoutSidenav_content">
        	<main>
            	<div class="container-fluid">
                	<div class="card mb-4">
                    	<div class="card-header"> <i class="fas fa-table mr-1"></i><strong>검색 도서 리스트 </strong></div>
                       	<div class="card-body">
                        	<div class="table-responsive">
                            	<table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
	                                <thead>
	                                    <tr>
	                                        <th style="width:50px"><strong>번호</strong></th>
	                                        <th><strong>제목</strong></th>
	                                        <th style="width:100px"><strong>저자</strong></th>
	                                        <th style="width:120px"><strong>출판사</strong></th>
	                                        <th style="width:70px"><strong>출판년도</strong></th>
	                                        <th style="width:70px"><strong>위치</strong></th>
	                                        <th style="width:70px"><strong>조회수</strong></th>
	                                    </tr>
	                                </thead>
                                    <tbody>
                                    <c:if test="${!empty booklist}">
                                    <c:forEach var="book" items="${booklist}" varStatus="status">
                                    	<tr>
                                        	<td>${status.count}</td>
                                            <td><a href="book.do?bookKey=${book.bookKey}&check=1">${book.title}</a></td>
                                            <td>${book.author}</td>
                                            <td>${book.publisher}</td>
                                            <td>${book.pubYear}</td>
                                            <td>${book.libName}</td>
                                            <td>${book.viewcount}</td>
                                        </tr>
                                     </c:forEach>
                                     </c:if>
                                     <c:if test="${empty booklist}">
                                    <c:forEach var="book" items="${booklist}">
                                    	<tr>
                                        	<td>해당 도서는 없습니다.</td>
                                        </tr>
                                     </c:forEach>
                                     </c:if>
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
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	   
</body>
</html>