<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
        </div>
        <div class="header-right">
			<a href="Login" class="login_btn btn">ログイン</a>
			<a href="Regist" class="signup_btn btn">新規登録</a>
		</div>
      </div>
	</header>
		<div class="form-wrapper">
	  <h1>入力内容確認</h1>
	  <form action="RegistResult" method="POST">
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="text" name="login_id" placeholder="Cake ID" value="${udb.loginId}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="name" placeholder="名前" value="${udb.name}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="mail_address" placeholder="メールアドレス" value="${udb.mailAddress}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="postal_code" placeholder="郵便番号" value="${udb.postalCode}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="prefecture" placeholder="都道府県" value="${udb.prefecture}" readonly></input>
	    </div>
		<div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="address" placeholder="住所" value="${udb.address}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="password" name="password" placeholder="パスワード" value="${udb.password}" readonly></input>
	    </div>
	    <div class="confirm_text">この内容で登録しますか？</div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="修正" name="default_button"></input>
	    </div>
	    <div class="button-panel">
	      <input type="submit" class="button regist_btn" title="Sign In" value="登録" name="confirm_button"></input>
	    </div>
	  </form>
	</div>
	</body>
</html>