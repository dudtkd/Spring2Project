<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME0202</title>
</head>
<body>
	<p>coin : ${coin } </p>
	<!-- 기본적인 type 속성의 값은 number -->
	<fmt:parseNumber value="${coin }" type="currency" var="coinCurrency"/>
	<p>coinCurrency : ${coinCurrency } </p>
</body>
</html>