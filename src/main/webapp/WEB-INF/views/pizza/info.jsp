<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ include file="/WEB-INF/views/jspf/header.jspf" %>
<title>피자 정보</title>
</head>
<body>

<div class="view-padding">
	<div class="card" >
	  <div class="card-body">
	    <h4 class="card-title">name : ${pizza.name }</h4><hr />
	    <h4 class="card-title">price : ${pizza.price }</h4><hr />
	    <h4 class="card-title">calories : ${pizza.calories } calories</h4><hr />
	    
    	<button id="btnReWrite" onclick="fnConfirm('수정','./mod?id=${pizza.id }');" type="button" class="btn btn-primary">수정</button>
    	<button id="btnReWrite" onclick="fnConfirm('삭제','./del?id=${pizza.id }');" type="button" class="btn btn-danger">삭제</button>
	    
	    <a class="btn btn-dark" href="./list" role="button">목록보기</a>
	    </div>
	</div>
</div>

</body>
</html>