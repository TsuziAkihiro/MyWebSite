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
			<form id="form" action="List" method="POST">
				<div class="inputs">
					<input class="eatText" type="text" placeholder="食べ物を入力">
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
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/76769.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/merusi14.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/a11b4bb3ba448d1fa402ac3dc62cc91f.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/FCFS_chokokakekukki_TP_V.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/873aad49a96e34e28397b7b3723791a7_s.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/76769.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
		<div class="wrapper">
			<div class="imgWrap">
				<a href="Item"><img src="img/76769.jpg" width="438.75px" height="300px" alt=""></a>
			</div>
		</div>
	</div>
	<footer>
		<div class="container">
			<div class="text">Cake</div>
		</div>
	</footer>
</body>
</html>