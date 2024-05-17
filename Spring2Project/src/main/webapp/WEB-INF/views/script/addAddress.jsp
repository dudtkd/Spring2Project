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
	<h1>주소록 등록</h1>
	<hr/>
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<form action="/add/add.do" method="post" id="addForm">
			<table class="table table-bordered">
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" id="name"/>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="checkbox" name="gender" id="male" value="male"/>남자&nbsp;
						<input type="checkbox" name="gender" id="female" value="female"/>여자
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<select name="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
						</select> - 
						<input type="text" name="phone2" id="phone2"/> -
						<input type="text" name="phone3" id="phone3"/> 
					</td>
				</tr>
				<tr>
					<td>직업</td>
					<td>
						<input type="text" name="job" id="job"/>
					</td>
				</tr>
			</table>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-10">
			<button type="button" class="btn btn-primary" id="addBtn">등록</button>
			<button type="button" class="btn btn-warning" id="cancelBtn">취소</button>
		</div>
		<div class="col-md-2"></div> 
	</div>
</body>

<script type="text/javascript">
$(function(){

	var addForm = $("#addForm");
	var addBtn = $("#addBtn");
	var cancelBtn = $("#cancelBtn");
	
	
	addBtn.on("click", function(){
		var name = $("#name").val();
		var male = $("#male").prop("checked");
		var female = $("#female").prop("checked");
		var phone2 = $("#phone2").val();
		var phone3 = $("#phone3").val();
		var job = $("#job").val();
		
		if(name == null || name == ""){
			alert("이름을 입력해주세요");
			$("#name").focus();
			return false;
		}

		if(!male && !female ){
			alert("성별을 선택해주세요");
			return false;
		}
		
		if(phone2 == null || phone2 == ""){
			alert("중간 번호를 입력해주세요");
			$("#phone2").focus();
			return false;
		}
		
		if(phone3 == null || phone3 == ""){
			alert("끝자리 번호를 입력해주세요");
			$("#phone3").focus();
			return false;
		}

		if(job == null || job == ""){
			alert("직업을 입력해주세요");
			$("#job").focus();
			return false;
		}
		
		addForm.submit();
		
		
	});
	
	
	cancelBtn.on("click",function(){
		
		location.href="/add/addressBook.do";
		
	});
	
	
	
})

</script>




</html>