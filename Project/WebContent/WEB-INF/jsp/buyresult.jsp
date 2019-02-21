<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購入確認 - Cake</title>
	<link rel="stylesheet" href="css/BuyResult.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">

</head>
	<body>
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage.html" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	        	<a href="UserManager.html" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage.html" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart.html" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout.html" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<div class="main">
			<div class="container">
				<div class="row">
					<h3 class="cart_title">お買い上げありがとうございます。</h3>
				</div>
			<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width:50px;"></th>
				      <th scope="col" style="width:325px;">商品名</th>
				      <th scope="col" style="width:125px;"></th>
				      <th scope="col"style="width:100px;">価格</th>
				      <th scope="col"style="width:100px;">個数</th>
				      <th scope="col"style="width:100px;">小計</th>
				      <th scope="col"style="width:50px;"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル</td>
				      <td></td>
				      <td>22222</td>
				      <td>1</td>
				      <td>12345</td>
				      <td></td>
				    </tr>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル</td>
				      <td></td>
				      <td>22222</td>
				      <td>1</td>
				      <td>12345</td>
				      <td></td>
				    </tr>
				    <tr>
				      <th scope="row"></th>
				      <td>サンプル</td>
				      <td></td>
				      <td>22222</td>
				      <td>1</td>
				      <td>12345</td>
				      <td></td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>配送料</td>
				    	<td>500円</td>
				    	<td></td>
				    </tr>
				    <tr>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td></td>
				    	<td>合計</td>
				    	<td>500円</td>
				    	<td></td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
		<div class="go_container">
				<a href="TopPage.html" class="go">トップページへ</a>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>