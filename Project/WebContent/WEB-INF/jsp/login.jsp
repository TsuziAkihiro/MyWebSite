<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン - Cake</title>
		<link rel="stylesheet" href="css/Login.css">
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
	  <h1>ログイン</h1>
	  <form action="Login" method="POST">
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="email" name="email" placeholder="Cake ID"></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="password" name="password" placeholder="パスワード"></input>
	    </div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="ログイン"></input>
	    </div>
	  </form>
	  <ul class="accounts">
		  <li class="account">アカウントをお持ちでないですか？</li>
		  <li class="account"><a href="Regist">　新規登録</a></li>
	  </ul>
	</div>
	</body>
</html>