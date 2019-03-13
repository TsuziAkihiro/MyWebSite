<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購入 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Cart.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<link rel="icon" type="image/png" href="img/ice_cream.png">

</head>
	<body>
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="main">
			<div class="return_wrapper">
				<div class="a">
					<button type="button" class="btn btn-secondary" onclick="location.href='TopPage'">&emsp;>Topへ&emsp;</button>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<h3 class="cart_title">カート内容</h3>
				</div>
			<form action="Cart" method="POST">
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width:75px;"></th>
				      <th scope="col" style="width:50px;"></th>
				      <th scope="col" style="width:280px;">商品名</th>
				      <th scope="col"style="width:100px;"></th>
				      <td scope="col"style="width:100px;"></td>
				      <th scope="col"style="width:100px;">価格</th>
				      <th scope="col"style="width:100px;">個数</th>
				      <th scope="col"style="width:100px;"></th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="item" items="${cart}">
				    <tr>
				      <th scope="row"></th>
				      <td><img src="img/${item.fileName}" width="40" height="30" alt=""></td>
				      <td>${item.name}</td>
				      <td></td>
				      <td></td>
				      <td>
				      	<fmt:formatNumber value="${item.price}"
	                    type="currency" currencySymbol="¥"
	                    maxFractionDigits="0"/></td>
				      <td>${item.number}</td>
				      <td><label for="${status.index}"><button type="submit" class="btn btn-danger" name="delete_item_id_list"  value="${item.id}" >削除</button></label></td>
				    </tr>
				    </c:forEach>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td><a href="BuyConfirm" class="go">購入</a></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    </tr>
				  </tbody>
				</table>
				</form>
			</div>
		</div>
		<jsp:include page="/baselayout/footer.jsp" />
		<script>
			$(function(){
				$("#number").change(function(){

				});
			});
		</script>
	</body>
</html>