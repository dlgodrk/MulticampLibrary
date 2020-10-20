<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/common/header.jsp"%>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
   function cancle() {
      if (confirm('회원가입을 취소 하시겠습니까?') == true) {
         location.href = '${pageContext.request.contextPath}/main/main.do'
      }
   }
</script>
</head>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<img class="mb-4" src="${pageContext.request.contextPath}/resources/img/bluelogo.png" alt="" width="72" height="72">
	    	<h2 class="text-black text-center"><strong>회원가입</strong></h2>
	   	</div>
        <hr/>
        <div class="col-md-12 order-md-1">
        	<h4 class="mb-3">회원 정보 입력</h4>
            <form class="form-horizontal" id="signupform" name="signupform" method="post" action="">
            	<div class="row">
                	<div class="col-md-10 col-lg-10 mb-3 " id="divId">
                    	<label for="inputId"><strong>아이디</strong></label>
                       	<input type="text" required="required" class="form-control" id="userid" name="userid" data-rule-required="true" placeholder="" value ="">
               		</div>
                  	<div class="col-md-2 col-lg-2 mb-3" id="divIdCheck">
                       	<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                       	<button type="button" class="btn btn-primary" id="idOverlap">중복확인</button>
                   	</div>
               		<div id="id_check"></div>
                </div>
                <div class="row">
                	<div class="col-md-6 form-group" id="divPassword">
                    	<label for="inputPassword"><strong>비밀번호</strong></label>
                        <input type="password" required="required" class="form-control" id="userpwd" name="userpwd" data-rule-required="true" placeholder="숫자,영문자,특수문자 조합으로 8자리 이상 사용해야 합니다." >
                   	</div>
                    <div class="col-md-6 form-group" id="divPasswordCheck">
                       	<label for="inputPasswordCheck"><strong>비밀번호 확인</strong></label>
                       	<input type="password" class="form-control" id="pwdcheck" name="pwdcheck" data-rule-required="true" placeholder="" >
                   	</div><br>
                   	<div id="pwd_check"></div> 	
                </div>
                <div class="mb-3" id="divName">
               		<label for="inputName"><strong>이름</strong></label>
                    <input type="text" required="required" class="form-control onlyHangul" id="username" name="username" data-rule-required="true" placeholder="" >
                </div>
               	<div class="mb-3" id="divEmail">
                	<label for="inputEmail" class="control-label"><strong>이메일&nbsp;(선택)</strong></label>
                   	<input type="email" class="form-control" id="email" name="email" data-rule-required="true" placeholder="선택입력">
               	</div>
               <span id="emailCheck"></span>
               	<div class="mb-3" id="divPhoneNumber">
                	<label for="inputPhoneNumber" class="control-label">전화번호&nbsp;(선택)</label>
                    <input type="tel" class="form-control onlyNumber" id="phone" name="phone" phonedata-rule-required="true" placeholder="선택입력">
              	</div>
              	<div class="mb-3" id="divEmail">
                	<label for="inputAddress" class="control-label"><strong>주소</strong>&nbsp;(선택)</label>
                   	<input type="text" class="form-control" id="address" name="address" data-rule-required="true" placeholder="선택입력">
               	</div>
                <hr class="mb-4">
               	<button type="submit" class="btn btn-primary btn-lg btn-block"><strong>가입하기</strong>></button>
               	<br>
               	<button class="btn btn-primary btn-lg btn-block" onclick = "cancle()"><strong>가입취소</strong>></button>
               	<br>
           	</form>
       	</div>
     </div>
</body>

<script type="text/javascript">
	let idCheck= 0;
	let pwdCheck = 0;
	let passwdCheck =  /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$/
	let emailCheck = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	$('#idOverlap').click(function () {
		let userid = $('#userid').val();
		$.ajax({
			type:'POST',
			url: '${pageContext.request.contextPath}/idcheck.do',
			data:{userid : userid},
			success:function(data) {
				console.log(data + "data입니다.")
				if(userid == "" && data == '0') {
					$(".btn-block").attr("disabled", true);
					$("#id_check").css("color", "red");
					$("#id_check").text("아이디를 입력해주세요");
					idCheck = 0;
				}else if (data == '0') {
					idCheck = 1;
					$(".btn-block").attr("disabled", false);
					$("#id_check").css("color", "blue");
					$("#id_check").text("아이디 사용 가능");
				}else if(data == '1') {
					$(".btn-block").attr("disabled", true);
					$("#id_check").css("color", "red");
					$("#id_check").text("이미 사용중인 아이디입니다.");
					idCheck = 0;
				}
			},
			error:function(e) {
				error = e;
				log(e);
				log("실패");
			}
		})
	});
	
	
	
	$("#pwdcheck").blur(function () {
		if($("#userpwd").val()!=$("#pwdcheck").val()) {
			if($("#pwdcheck").val()!="") {
				$("#pwd_check").text("비밀번호가 일치하지 않습니다.");
				$("#pwd_check").css("color", "red");
				$(".btn-block").attr("disabled", true);
			} else {
				$("#pwd_check").text("");
				$(".btn-block").attr("disabled", false);
			}
			
		}
		
	})
	$("#userpwd").blur(function () {
		if(passwdCheck.test($("#userpwd").val()) == false) {
			console.log("확")
			$("#pwd_check").text("숫자,영문자,특수문자 조합으로 8자리 이상 사용해야 합니다.");
			$("#pwd_check").css("color", "red");
			$(".btn-block").attr("disabled", true);
			
		} else {
			$("#pwd_check").text("");
			$(".btn-block").attr("disabled", false);
		}
	})
	
	
	$("#email").blur(function () {
		if(emailCheck.test($("#email").val()) == false) {
			$("#emailCheck").text("email형식에 맞지 않습니다.");
			$("#emailCheck").css("color", "red");
			$(".btn-block").attr("disabled", true);
			
		} else {
			$("#emailCheck").text("");
			$(".btn-block").attr("disabled", false);
		}
	})
	
</script>
</html>