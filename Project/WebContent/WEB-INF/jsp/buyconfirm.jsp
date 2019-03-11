<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購入確認 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/BuyConfirm.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">

</head>
	<body>
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="main">
			<div class="return_wrapper">
				<div class="a">
					<button type="button" class="btn btn-secondary" onclick="location.href='Cart'">>戻る</button>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<h3 class="cart_title">購入内容</h3>
				</div>
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width:50px;"></th>
				      <th scope="col" style="width:50px;"></th>
				      <th scope="col" style="width:150px;">商品名</th>
				      <th scope="col" style="width:50px;">価格</th>
				      <th scope="col" style="width:50px;">個数</th>
				      <th scope="col" style="width:30px">小計</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="item" items="${cart}" varStatus="status">
				    <tr>
				      <td></td>
				      <th scope="row"><img src="img/${item.fileName}" width="40" height="30" alt=""></th>
				      <td>${item.name}</td>
				      <td>
				      	<fmt:formatNumber value="${item.price}"
	                    type="currency" currencySymbol="¥"
	                    maxFractionDigits="0"/>
				      </td>
				      <td>${item.number}</td>
				      <td>
					      <fmt:formatNumber value="${item.subtotal}"
					      type="currency" currencySymbol="¥"
		                  maxFractionDigits="0"/>
				      </td>
				    </tr>
				   </c:forEach>
				    <tr>
				        <td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>配送料</td>
				    	<td>${bdb.deliveryMethodPrice}円</td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>合計</td>
				    	<td>
			   	       	<fmt:formatNumber value="${bdb.totalPrice}"
					      type="currency" currencySymbol="¥"
		                  maxFractionDigits="0"/>
				    	</td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
		<div class="go_container">
			<a href="BuyResult" class="go">購入します。</a>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>