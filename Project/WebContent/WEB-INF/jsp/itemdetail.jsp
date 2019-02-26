<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品編集 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/ItemDetail.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

	<script type="text/javascript">
	        $(document).ready(function(){
	            $('.slider').bxSlider({
	            	controls: false,
	                auto: false,
	                pause: 5000,
	            });
	        });
	</script>
</head>
	<body>
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage.html" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	        <a href="ItemList.html" class="list_btn btn"><i class="fas fa-list-ul"></i></a>
	        	<a href="UserManager.html" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage.html" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart.html" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout.html" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<form action="ItemAdd" method="POST">
			<div class="top-wrapper">
				<div class="container">
					<div class="a">
						<a href="Item.html" class="return">>戻る</a>
					</div>
					<div class="container_out">
						<div class="container-left w_container">
								<img src="img/MAX76_gjmax20140531_TP_V4.jpg" width="500" height="375" alt="">
								<input type="hidden" name="item_id" value="${item.id}">
								<div class="container_in">
									<input type="file">
									<div class="price">
										<label for="price2">値段</label>
										<input type="text" class="detail">
										<label for="item_name detail">商品名</label>
								<input type="text" class="detail" value="#####">
								<label for="item_detail detail">商品情報</label>
								<textarea class="detail itemDetail">12345</textarea>
								<button class="cart_btn" type="submit" name="action">更新</button>
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>