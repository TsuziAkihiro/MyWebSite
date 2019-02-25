<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>トップページ - Cake</title>
	<link rel="stylesheet" href="css/TopPage.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
</head>
<body>
	<header>
	  <div class="container">
        <div class="header-center">
        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
        </div>
        <div class="header-right">
			<a href="Login" class="login_btn btn">ログイン</a>
			<a href="Regist" class="signup_btn btn">新規登録</a>
		</div>      </div>

	</header>
	<div class="top-wrapper">
		<div class="container">
			<h1>さがしてみる。</h1>
			<form>
				<div class="inputs">
					<input class="eatText" type="text" placeholder="食べ物を入力">
					<a href="#" class="search"><i class="fas fa-search"></i></a>
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
		<div class="container">
			<img src="img/873aad49a96e34e28397b7b3723791a7_s.jpg" alt="海の写真" width="438.75vw" height="300vw">
		</div>
		<div class="container">
			<img src="img/76769.jpg" alt="海の写真"  width="438.75vw" height="300vw">
		</div>
		<div class="container">
			<img src="img/annitop.jpg" alt="海の写真" width="438.75vw" height="300vw">
		</div>
		<div class="container">
			<img src="img/images.jpeg" alt="海の写真" width="438.75vw" height="300vw">
		</div>
		<div class="container">
			<img src="img/a11b4bb3ba448d1fa402ac3dc62cc91f.jpg" alt="海の写真" width="438.75vw" height="300vw">
		</div>
		<div class="container">
			<a href="Item"><img src="img/MAX76_gjmax20140531_TP_V4.jpg" alt="海の写真" width="438.75vw" height="300vw"></a>
		</div>
		<div class="container">
			<img src="img/merusi14.jpg" alt="海の写真" width="438.75vw" height="300vw">
		</div>
	</div>
	<footer>
		<div class="container">
			<div class="text">Cake</div>
		</div>
	</footer>
</body>
</html>