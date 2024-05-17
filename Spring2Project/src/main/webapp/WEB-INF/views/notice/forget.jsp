<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<div class="">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p class="h4">
				<b>아이디찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">아이디 찾기는 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memEmail" name="memEmail" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memName" name="memName" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p id="findId">
					
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" id="findIdBtn" name="findIdBtn" class="btn btn-primary btn-block">아이디찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br />
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p href="" class="h4">
				<b>비밀번호찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">비밀번호 찾기는 아이디, 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memId1" placeholder="아이디를 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memEmail1" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memName1" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p id="findPw">
						
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" id="findPwBtn" class="btn btn-primary btn-block">비밀번호찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br/>
	<div class="card card-outline card-secondary">
		<div class="card-header text-center">
			<h4>MAIN MENU</h4>
			<button type="button" class="btn btn-secondary btn-block" id="loginBtn">로그인</button>
		</div>
	</div>
</div>
<script type="text/javascript">

$(function() {
	var findIdBtn = $("#findIdBtn");
	var findPwBtn = $("#findPwBtn");
	var loginBtn= $("#loginBtn");
	
	loginBtn.on("click",function(){
		
		location.href="/notice/login.do";
		
	});
	
	findIdBtn.on("click", function() {
		var memEmail = $("#memEmail").val();
		var memName = $("#memName").val();

		var info = {

			memEmail : memEmail,
			memName : memName

		}

		$.ajax({
			type : "post",
			url : "/notice/idForget.do",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(info),
			beforeSend : function(xhr){	// 데이터를 전송 하기 전, 헤더에 csrf값 설정
				xhr.setRequestHeader(header, token);
			},
			success : function(res) {
				console.log("res >>> " + res);

				if (res == null || res == "") {
					alert("정보를 제대로 입력하세요");
					$("#memEmail").val("");
					$("#memName").val("");
					$("#findId").html("");
				} else {
					$("#findId").html("<P>회원님의 아이디는 " + res + " 입니다.</p>");
				}
			}
		});

	});

	findPwBtn.on("click", function() {
		var memId = $("#memId1").val();
		var memEmail = $("#memEmail1").val();
		var memName = $("#memName1").val();

		var info = {

			memId : memId,	
			memEmail : memEmail,
			memName : memName

		}

		$.ajax({
			type : "post",
			url : "/notice/pwForget.do",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(info),
			beforeSend : function(xhr){	// 데이터를 전송 하기 전, 헤더에 csrf값 설정
				xhr.setRequestHeader(header, token);
			},
			success : function(res) {
				console.log("res >>> " + res);

				if (res == null || res == "") {
					alert("정보를 제대로 입력하세요");
					$("#memId1").val("");
					$("#memEmail1").val("");
					$("#memName1").val("");
					$("#findPw").html("");
				} else {
					$("#findPw").html("<P>회원님의 비밀번호는 " + res + " 입니다.</p>");
				}
			}
		});

	});
});
</script>