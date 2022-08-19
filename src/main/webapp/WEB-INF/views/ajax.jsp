<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AJAX ����ϱ�</title>
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
		���� �ڿ����� webapp/resources�� �����ϰ�
		/resources/** uri�� �����ϸ� �ȴ�
		(servlet-context.xml�� ������ ����)
	</p>
	
	
	<h1>���� ��� ����</h1>
	
	<hr />	
	name : <input type="text" id="post-pizza-name" value="�׽�Ʈ" /> <br />
	price : <input type="text" id="post-pizza-price" value="3000" /> <br />
	calories : <input type="text" id="post-pizza-calories" value="30.30" /> <br />
	 
	<button id="btn-xhttp-post">XHttp POST �غ���(INSERT)</button>
	<hr />
	
	<div id="out3">���� �߰� ���Դϴ�.</div>
	<hr />
	
	<h1>���� ��� ��</h1>
	
	<hr />
	
	
	
	
	
	
	<img src="https://post-phinf.pstatic.net/MjAxNzA5MDFfMTUy/MDAxNTA0MjQ4ODQ2MDYy.rFYrZCWFw_MmimDnG2jsnm5_sd-vxwIBK6d11Iq22mog.fPrPc-0xtvsv4GJWvOgTx1zeScl64oniSZg9hWPG4z4g.JPEG/GettyImages-523882338.jpg?type=w1200" alt="" />
	<br />
	<img src="<c:url value="/resources/images/p1.jpg"/>" alt="���" />
	
	<div id="out"></div>
	<button id="btn-xhttp">����</button>
	
	<hr />
	
	name :
	<select id="selName">
		<option value="">-- ���ڸ� ������ �ּ��� --</option>
		<c:forEach items="${pizzas }" var="pizza">
			<option value="${pizza.id }">${pizza.name }</option>
		</c:forEach>		
	</select> 
 <br />
	price : <input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�." id="txtPrice"  name="price" /> <br />
	calories : <input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�." id="txtCalories" name="calories" /> <br />
	pizza id: 	<input type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�." id="txtId" name="id" readonly /> <br />
	
	<button id="btn-xhttp-put">XHttp PUT �غ���(update)</button>
	<hr />
	<button id="btn-xhttp-put2">XHttp PUT �غ���(update)2</button>
	
	<hr />	
	
	
	
	
	<script src="<c:url value="/resources/js/ajax.js"/>" charset="UTF-8"></script>
</body>
</html>













