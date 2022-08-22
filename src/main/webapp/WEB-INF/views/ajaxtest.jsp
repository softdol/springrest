<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AJAX 사용하기</title>
<style>
	img {
		width: 100px;		
	}
</style>
</head>
<body>
	<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>

	<h1>테스트</h1>		
	
	
	<hr />
	value : <input type="text" id="textValue" value="" /> <br />	 
	<button id="btnSend">전송</button>
	<hr />
	
	<div id="divOut">결과. </div>

	<script src="<c:url value="/resources/js/ajaxtest.js"/>" charset="UTF-8"></script>
</body>
</html>













