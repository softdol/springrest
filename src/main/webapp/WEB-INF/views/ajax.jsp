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

	<h3>Ajax Index</h3>
	
	<h5>static resource mapping</h5>
	
	<p>
		정적 자원들은 webapp/resources에 보관하고
		/resources/** uri로 접근하면 된다
		(servlet-context.xml의 내용을 참조)
	</p>
	
	
	<h1>피자 등록 시작</h1>
	
	<hr />	
	name : <input type="text" id="post-pizza-name" value="테스트" /> <br />
	price : <input type="text" id="post-pizza-price" value="3000" /> <br />
	calories : <input type="text" id="post-pizza-calories" value="30.30" /> <br />
	 
	<button id="btn-xhttp-post">XHttp POST 해보기(INSERT)</button>
	<hr />
	
	<div id="out3">아직 추가 전입니다.</div>
	<hr />
	
	<h1>피자 등록 끝</h1>
	
	<hr />
	
	
	
	
	
	
	<img src="https://post-phinf.pstatic.net/MjAxNzA5MDFfMTUy/MDAxNTA0MjQ4ODQ2MDYy.rFYrZCWFw_MmimDnG2jsnm5_sd-vxwIBK6d11Iq22mog.fPrPc-0xtvsv4GJWvOgTx1zeScl64oniSZg9hWPG4z4g.JPEG/GettyImages-523882338.jpg?type=w1200" alt="" />
	<br />
	<img src="<c:url value="/resources/images/p1.jpg"/>" alt="펭귄" />
	
	<div id="out"></div>
	<button id="btn-xhttp">전송</button>
	
	<hr />
	
	name :
	<select id="selName">
		<option value="">-- 피자를 선택해 주세요 --</option>
		<c:forEach items="${pizzas }" var="pizza">
			<option value="${pizza.id }">${pizza.name }</option>
		</c:forEach>		
	</select> 
 <br />
	price : <input type="text" placeholder="피자를 선택하면 값이 채워집니다." id="txtPrice"  name="price" /> <br />
	calories : <input type="text" placeholder="피자를 선택하면 값이 채워집니다." id="txtCalories" name="calories" /> <br />
	pizza id: 	<input type="text" placeholder="피자를 선택하면 값이 채워집니다." id="txtId" name="id" readonly /> <br />
	
	<button id="btn-xhttp-put">XHttp PUT 해보기(update)</button>
	<hr />
	<button id="btn-xhttp-put2">XHttp PUT 해보기(update)2</button>
	
	<hr />	
	
	
	
	
	<script src="<c:url value="/resources/js/ajax.js"/>" charset="UTF-8"></script>
</body>
</html>













