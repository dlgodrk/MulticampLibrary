<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">

<style>
	.bd-placeholder-img {
    	font-size: 1.125rem;
    	text-anchor: middle;
    	-webkit-user-select: none;
    	-moz-user-select: none;
    	-ms-user-select: none;
    	user-select: none;
  	}
  	@media (min-width: 768px) {
    	.bd-placeholder-img-lg {
      		font-size: 3.5rem;
    	}
  	}
</style>
</head>
<body class="text-center">

	<form class="form-signin" id="loginform" name="loginform" method="post" action="${pageContext.request.contextPath}/login.do">
  		<img class="mb-4" src="${pageContext.request.contextPath}/resources/img/bluelogo.png" alt="" width="72" height="72">
  		
  		<h2 class="h3 mb-3 font-weight-normal"><strong>로그인</strong></h2>
  		
		<input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus>
		
		<input type="password" id="userpwd" name="userpwd" class="form-control" placeholder="비밀번호" required>
  		
  		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
  		<br>
		<a class="font-black font-weight-normal" href="${pageContext.request.contextPath}/signup.do">회원 가입</a>
		<br><br>
		<a class="font-black font-weight-normal" href="${pageContext.request.contextPath}/main/main.do">돌아가기</a>
	</form>
</body>
</html>
