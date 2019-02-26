<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購入詳細 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/BuyDetail.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">

</head>
	<body>
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage.html" class="title"><i class="fas fa-coffee"></i> Cake</a>
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
				<a href="MyPage" class="return">>マイページへ</a>
				</div>
			</div>
			<div class="item_wrapper">
				<div class="container">
					<div class="row">
						<h3 class="cart_title">購入詳細</h3>
					</div>
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col" style="width:75px;"></th>
					      <th scope="col" style="width:325px;">購入日時</th>
					      <th scope="col" style="width:160px;"></th>
					      <th scope="col"style="width:100px;">配送料</th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:100px;">合計金額</th>
					      <th scope="col"style="width:100px;"></th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row"></th>
					      <td>2018年12月34日56時78分</td>
					      <td></td>
					      <td>500円</td>
					      <td></td>
					      <td>12345</td>
					      <td></td>
					    </tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="item_wrapper item_wrapper2">
				<div class="container">
					<div class="row">
						<h3 class="cart_title">商品詳細</h3>
					</div>
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col" style="width:75px;"></th>
					      <th scope="col" style="width:325px;">商品名</th>
					      <th scope="col" style="width:100px;"></th>
					      <th scope="col"style="width:100px;">個数</th>
					      <th scope="col"style="width:100px;">単価</th>
					      <th scope="col"style="width:100px;">小計</th>
					      <th scope="col"style="width:120px;"></th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row"></th>
					      <td>濃厚ガトーのフォルダンショコラ</td>
					      <td></td>
					      <td>15</td>
					      <td>11111</td>
					      <td>12345</td>
					      <td><a href="item.html" class="detail_btn">>商品ページ</a></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td>グルテンフリークッキー</td>
					      <td></td>
					      <td>15</td>
					      <td>11111</td>
					      <td>12345</td>
					      <td><a href="item.html" class="detail_btn">>商品ページ</a></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td>ヘーゼルシフォンケーキ</td>
					      <td></td>
					      <td>15</td>
					      <td>11111</td>
					      <td>12345</td>
					      <td><a href="item.html" class="detail_btn">>商品ページ</a></td>
					    </tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	<script type="text/javascript" src="./js/MyPage.js"></script>
	</body>
</html>