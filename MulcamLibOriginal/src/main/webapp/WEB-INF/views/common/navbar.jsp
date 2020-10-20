<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/main/main.do">
    		<img class="mb-0" src="${pageContext.request.contextPath}/resources/img/logo.png" alt="" width="60" height="60">
    	</a>
      	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="#navbar" aria-expanded="false" aria-label="Toggle navigation">
        	<span class="navbar-toggler-icon"></span>
      	</button>
      	<div class="collapse navbar-collapse" id="navbar" name="navbar">
        	<ul class="navbar-nav ml-auto">
          		<li class="nav-item active">
            		<a class="nav-link" href="${pageContext.request.contextPath}/main/main.do">Home
            			<span class="sr-only">(current)</span>
            		</a>
          		</li>
	          	<li class="nav-item">
	        	    <a class="nav-link" href="${pageContext.request.contextPath}/about.do">About</a>
	        	</li>
		        <li class="nav-item">
		            <a class="nav-link" href="${pageContext.request.contextPath}/map.do">Map</a>
		        </li>
		        <li class="nav-item">
		            <a class="nav-link" href="${pageContext.request.contextPath}/boardlist.do">Review</a>
		        </li>
		        <c:catch>
			        <c:choose>
			        	<c:when test="${empty login }">		        
					        <li class="nav-item">
			           	      	<a class="btn btn-primary" href="${pageContext.request.contextPath}/login.do">Sign In</a>
					        </li>
					    </c:when>
					    <c:otherwise>
					    	<li class="nav-item">
			           	      	<a class="nav-link text-white font-weight-normal" href="#"><strong>${id}</strong></a>
					       		<span class="sr-only">(current)</span>
					        </li>
							<li class="nav-item">
			           	      	<a class="btn btn-primary" href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
					        </li>				        
					    </c:otherwise>
					</c:choose>
				</c:catch>
        	</ul>
      	</div>
    </div>
</nav>  