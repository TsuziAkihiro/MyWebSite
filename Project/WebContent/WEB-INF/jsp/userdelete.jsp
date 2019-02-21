<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザ削除 - Cake</title>
		<link rel="stylesheet" href="css/ItemDelete.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
	</head>
	<body>
	<header>
	  <div class="container">
        <div class="header-center">
        	<a href="TopPage.html" class="title"><i class="fas fa-coffee"></i> Cake</a>
        </div>
        <div class="header-right">
			<a href="Login.html" class="login_btn btn">ログイン</a>
			<a href="Regist.html" class="signup_btn btn">新規登録</a>
		</div>
      </div>
	</header>
		<div class="form-wrapper">
	  <h1>このユーザーを削除しますか？</h1>
		<div class="item">
			<img src="img/MAX76_gjmax20140531_TP_V4.jpg" width="200" height="150" alt="">
		    <label for="aaa" class="aaa">${aaaa}</label>
		    <form action="Delete" method="POST">
			    <div class="button-panel">
			      <input type="submit" class="button" title="Sign In" value="削除する"></input>
			    </div>
		    </form>
		</div>
	</div>
	</body>
</html>