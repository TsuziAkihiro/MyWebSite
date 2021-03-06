<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>お気に入り商品 - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/Favorite.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
</head>
<body>
	<jsp:include page="../../baselayout/header.jsp" />
	<div class="main">
		<div class="container">
			<div class="text_wrapper">
				<h1>お気に入りリスト</h1>
			</div>
			<div class="goods_wrapper">
			<form action="Favorite" method="POST">
			<c:forEach var="favorite" items="${favoriteList}" >
				<div class="goods">
					<a href="Item?item_id=${favorite.itemId}"><img src="./img/${favorite.fileName}" width="280" height="210" alt=""></a>
					<p class="name">${favorite.name}</p>
					<p class="price">
						<fmt:formatNumber value="${favorite.price}"
	                    type="currency" currencySymbol="¥"
	                    maxFractionDigits="0"/>
	                </p>
					<button class="cart_btn" type="submit" name="item_id" value="${favorite.itemId}">お気に入りから外す</button>
				</div>
			</c:forEach>
			</form>
			</div>
		</div>
	</div>
	<div class="up_icon">
		<i class="fas fa-angle-up fa-2x color" id="hoge"></i>
	</div>
	<jsp:include page="/baselayout/footer.jsp" />
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/List.js"></script>
</body>
</html>