<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規登録確認 - Cake</title>
		<link rel="stylesheet" href="css/RegistConfirm.css">
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
	  <h1>入力内容確認</h1>
	  <form>
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="text" name="email" placeholder="Cake ID" value="######" readonly></input>
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
	    <div class="confirm_text">この内容で登録しますか？</div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="修正"></input>
	    </div>
	    <div class="button-panel">
	      <input type="submit" class="button regist_btn" title="Sign In" value="登録"></input>
	    </div>
	  </form>
	</div>
	</body>
</html>