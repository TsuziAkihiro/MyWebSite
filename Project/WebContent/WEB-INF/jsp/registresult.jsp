<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登録完了しました - Cake</title>
		<link rel="stylesheet" href="css/RegistResult.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
		<meta http-equiv="Refresh" content="3;TopPage.html">
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
	  <h1>入力内容確認</h1>
	  <form>
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="email" name="email" placeholder="Cake ID" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="password" placeholder="名前" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="password" placeholder="メールアドレス" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="address" placeholder="住所" value="######" readonly></input>
	    </div>
	    <div class="confirm_text">上記の内容で登録しました。</div>
	  </form>
	</div>
	</body>
</html>