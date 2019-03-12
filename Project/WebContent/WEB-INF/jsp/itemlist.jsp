<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品管理- Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/ItemList.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
</head>
<body>
	<jsp:include page="../../baselayout/header.jsp" />
	<div class="main">
		<div class="container">
			<form>
				<div class="refer">
					<input class="eat_text" type="text" placeholder="商品をさがす" name="search_word">
				</div>
			</form>
			<div class="text_wrapper">
				<h1>全商品リスト</h1>
			</div>
			<div class="goods_wrapper">
				<c:forEach var="item" items="${itemList}" varStatus="status">
				<div class="goods">
					<a href="Item?item_id=${item.id}"><img src="img/${item.fileName}" width="280" height="210" alt=""></a>
					<p class="name">${item.name}</p>
					<p class="price">
						<fmt:formatNumber value="${item.price}"
	                    type="currency" currencySymbol="¥"
	                    maxFractionDigits="0"/>
					</p>
					<div class="item">
						<a href="ItemDetail?item_id=${item.id}" class="go">編集</a>
						<a href="ItemDelete?item_id=${item.id}" class="delete">削除</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="up_icon">
		<i class="fas fa-angle-up fa-2x color" id="hoge"></i>
	</div>
	<footer>
		<div class="container">
			<div class="text">Cake</div>
		</div>
	</footer>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/List.js"></script>
</body>
</html>