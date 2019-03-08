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
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width:75px;"></th>
				      <th scope="col" style="width:325px;">商品名</th>
				      <th scope="col" style="width:125px;"></th>
				      <th scope="col"style="width:100px;">価格</th>
				      <th scope="col"style="width:100px;">個数</th>
				      <th scope="col"style="width:100px;">小計</th>
				      <th scope="col"style="width:100px;"></th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="item" items="${cart}" varStatus="status">
				    <tr>
				      <th scope="row"></th>
				      <td>${item.name}</td>
				      <td></td>
				      <td>
				      	<fmt:formatNumber value="${item.price}"
	                    type="currency" currencySymbol="¥"
	                    maxFractionDigits="0"/>
				      </td>
				      <td>
			      		<select name="cnt" class="cnt_name">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
						</select>
					  </td>
				      <td>12345</td>
				      <td><button type="button" class="btn btn-danger">削除</button></td>
				    </tr>
				    </c:forEach>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td><a href="BuyConfirm" class="go">購入確認</a></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>