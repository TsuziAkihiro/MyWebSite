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
		<jsp:include page="../../baselayout/header.jsp" />
		<form action="ItemAdd" method="POST">
			<div class="top-wrapper">
				<div class="container">
					<div class="a">
						<a href="Item?item_id=${item.id}" class="return">>戻る</a>
					</div>
					<div class="container_out">
						<div class="container-left w_container">
						<div class="item_picture">
								<img src="img/${item.fileName}" width="500" height="375" alt="">
									<div class="good_title">
										<label for="item_name detail" class="item_detail">商品名</label>
										<input type="text" class="detail" value="${item.name}">
									</div>
								</div>
								<input type="file" class="file">
								<input type="hidden" name="item_id" value="${item.id}">
								<div class="container_in">
									<div class="price">
										<label for="price2">値段</label>
										<input type="text" class="detail" value="${item.price}">
										<label for="item_detail detail">詳細</label>
										<textarea class="detail itemDetail">${item.detail}</textarea>
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