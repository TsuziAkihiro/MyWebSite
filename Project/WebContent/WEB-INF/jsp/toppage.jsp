<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>トップページ - Cake</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<link rel="stylesheet" href="css/TopPage.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
</head>
<body>
	<jsp:include page="../../baselayout/header.jsp" />
	<div class="top-wrapper">
		<div class="container">
			<h1>さがしてみる。</h1>
			<form id="form" action="Index">
				<div class="inputs">
					<input class="eatText" type="text" placeholder="食べ物を入力" name="search_word">
					<button class="eat_input"><i class="fas fa-search"></i></button>
				</div>
			</form>
		</div>
	</div>
	<div class="text_wrapper">
		<h3>美味しいものを食べよう。<br>
		</h3>
	</div>
	<div class="lesson-wrapper">
		<div class="wrapper">
			<h1>豊富な商品ラインナップ</h1>
		</div>
		<c:forEach var="item" items="${itemList}" >
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item?item_id=${item.id}"><img src="img/${item.fileName}" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		</c:forEach>
	</div>
	<footer>
		<div class="container">
			<div class="text">Cake</div>
		</div>
	</footer>
</body>
</html>