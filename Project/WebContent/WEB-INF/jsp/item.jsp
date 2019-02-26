<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品確認 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Item.css">
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
	        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	        <a href="ItemList.html" class="list_btn btn"><i class="fas fa-list-ul"></i></a>
	        	<a href="UserManager" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<div class="top-wrapper">
			<div class="container">
				<div class="a">
					<a href="TopPage" class="return">>戻る</a>
				</div>
				<div class="container_out">
					<div class="container-left w_container">
							<img src="img/MAX76_gjmax20140531_TP_V4.jpg" width="500" height="375" alt="">
						<form action="ItemAdd" method="POST">
							<input type="hidden" name="item_id" value="${item.id}">
							<div class="container_in">
								<h2>¥$item.price　
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
								</h2>
								<button class="cart_btn" type="submit" name="action">カートに入れる</button>
							</div>
						</form>
					</div>
					<div class="container-right w_container">
						<form action="ItemAdd" method="POST">
						<div class="container-right_in">
							<p class="item_name">$item.name</p>
							<p class="item_detail">$item.detail</p>
							<button class="cart_btn" type="submit" name="action">お気に入り</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="bot_wrapper">
			<div class="container">
				<a href="ItemDetail" class="go">編集</a>
				<a href="ItemDelete" class="go">削除</a>
			</div>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>