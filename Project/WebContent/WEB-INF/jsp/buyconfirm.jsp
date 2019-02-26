<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	     	    <a href="ItemList" class="list_btn btn"><i class="fas fa-list-ul"></i></a>
	        	<a href="UserManager" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<div class="main">
			<div class="return_wrapper">
				<div class="a">
				<a href="Cart" class="return">>戻る</a>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<h3 class="cart_title">購入内容</h3>
				</div>
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width:30px;"></th>
				      <th scope="col" style="width:150px;">商品名</th>
				      <th scope="col" style="width:50px;">価格</th>
				      <th scope="col" style="width:50px;">個数</th>
				      <th scope="col" style="width:30px">小計</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル名</td>
				      <td>12345</td>
				      <td>1</td>
				      <td>98765円</td>
				    </tr>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル名</td>
				      <td>12345</td>
				      <td>1</td>
				      <td>98765円</td>
				    </tr>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル名</td>
				      <td>12345</td>
				      <td>1</td>
				      <td>98765円</td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>配送料</td>
				    	<td>500円</td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>合計</td>
				    	<td>12345円</td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
		<div class="go_container">
			<a href="Buyresult.html" class="go">購入します。</a>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>