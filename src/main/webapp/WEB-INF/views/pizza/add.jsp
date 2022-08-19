<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/jspf/header.jspf" %>
<meta charset="EUC-KR">
<title>Pizza Insert</title>
</head>
<body>
	
<div class="view-padding">
<form action="./add" method="post">
	<div class="input-group">
		<hr />
	</div>

	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1"> &nbsp;name&nbsp; </span>
	  <input type="text" class="form-control" name="name" aria-describedby="basic-addon1">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1"> &nbsp;price&nbsp;&nbsp; </span>
	  <input type="number" class="form-control" name="price" aria-describedby="basic-addon1">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1"> calories </span>
	  <input type="number" name="calories" step="0.01" class="form-control" aria-describedby="basic-addon1">
	</div>
	
	
	
	<div class="input-group">
		<hr />
	</div>
	
	<div class="input-group">
		<div class="frm-in-center">
			<input type="submit" value="등록" class="btn btn-primary" /> <input type="reset" value="취소" class="btn btn-danger" />
			<a class="btn btn-dark" href="./list" role="button">목록으로</a>
		</div>
	</div>
</form>
</div>


</body>
</html>