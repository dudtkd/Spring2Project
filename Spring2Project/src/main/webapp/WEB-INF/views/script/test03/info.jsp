<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
</head>
<body>
	<!-- 
		1) 로그인에 성공한 학생 정보를 아래에 출력해주세요!
		2) 로그인페이지로 버튼을 클릭 시 로그인 페이지로 이동해주세요.
	 -->
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					${msg}
				</div>
				<div class="card-body">
					<table class="table table-bordered">
						<tr>
							<td>아이디</td>
							<td>${member.memId }</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>${member.memPw }</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${member.memName }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${member.memEmail }</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${member.memPhone }</td>
						</tr>
					</table>
				</div>
				<div class="card-footer">
					<button type="button" class="btn btn-primary mb-2" id="backBtn">로그인페이지로></button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var backBtn = $("#backBtn");
	
	backBtn.on("click",function(){
		location.href="/test03/login.do";
	})
});
</script>
</html>