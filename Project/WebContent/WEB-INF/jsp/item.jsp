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
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="top-wrapper">
			<div class="container">
				<div class="a">
					<a href="TopPage" class="return">>戻る</a>
				</div>
				<div class="container_out">
					<div class="container-left w_container">
							<img src="img/${item.fileName}" width="500" height="375" alt="">
						<form action="ItemAdd" method="POST">
							<input type="hidden" name="item_id" value="${item.id}">
							<div class="container_in">
								<h2>¥${item.price}&emsp;
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
							<p class="item_name">${item.name}</p>
							<p class="item_detail">${item.detail}</p>
							<button class="cart_btn" type="submit" name="action">お気に入り</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${user.id == 1}">
			<div class="bot_wrapper">
				<div class="container">
					<a href="ItemDetail?item_id=${item.id}" class="go">編集</a>
					<a href="ItemDelete?item_id=${item.id}" class="go">削除</a>
				</div>
			</div>
		</c:if>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	</body>
</html>