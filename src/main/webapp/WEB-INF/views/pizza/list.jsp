<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ include file="/WEB-INF/views/jspf/header.jspf" %>
<title>Pizza List</title>
</head>
<body> 	
 	<figure class="text-center">
	  <blockquote class="blockquote">
	    <h2># Pizza List</h2>
	    	<button onclick="javascript:location.href='./add'" class="btn btn-outline-info">등록</button>	    	
	  </blockquote>
	</figure>
	<table class="table table-dark table-hover">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">피자 이름</th>
	      <th scope="col">가격</th>
	      <th scope="col">calories</th>	      	      
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${pizzas }" var="pizza">
	    <tr>
	      <th scope="row"> ☆ </th>
	      <th scope="row" class="board-title" data-num="${pizza.id }"><a href="./info?id=${pizza.id }">${pizza.name }</a></th>
	      <td>${pizza.price }</td>
	      <td>${pizza.calories } calories</td>     
	    </tr>	
	    </c:forEach>    
	  </tbody>
	</table>	
	
	<script type="text/javascript">
		//const btnAdd = document.getElementById("btnAdd");
	</script>

</body>
</html>