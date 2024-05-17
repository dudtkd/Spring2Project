<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>
</head>
<body>
	<table border="1">
			<tr>
				<td>유저 ID</td>
				<td><input type="text" name="userId" value="${info.userId }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>${info.password }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${info.userName }</td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td>${info.email }</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${info.date }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					${info.gender } 
				</td>
			</tr>
			<tr>
				<td>개발자 여부</td>
				<td>${info.developer }</td>
			</tr>
			<tr>
				<td>외국인 여부</td>
				<td>${info.korea }</td>
			</tr>
			<tr>
				<td>국적</td>
				<td>
					${info.nationality }
				</td>
			</tr>
			<c:set var="car" value="${info.cars }"/>
			<tr>
				<td>소유차량</td>
				<td>
					${info.cars }
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					${info.hobby }
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>${info.address.postCode }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${info.address.location}</td>
			</tr>
			<c:forEach items="${info.cardList }" var="card" varStatus="status">
				<tr>
					<td>카드${status.count } - 번호</td>
					<td>${card.no }</td>
				</tr>
				<tr>
					<td>카드${status.count } - 유효년월</td>
					<td>${card.cardDate }</td>
				</tr>
			</c:forEach>
			<tr>
				<td>소개</td>
				<td>
					${info.introduction }
				</td>
			</tr>
			<tr>
				<td>개인정보 동의</td>
				<td>
					${info.agree }
				</td>
			</tr>
			
		</table>
</body>
</html>