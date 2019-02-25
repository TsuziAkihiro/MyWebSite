<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新確認 - Cake</title>
		<link rel="stylesheet" href="css/UpdateResult.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
		<meta http-equiv="Refresh" content="3;MyPage.html">
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
	  <h1>内容確認</h1>
	  <form>
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="text" name="email" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="text" name="email" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="address" name="password" value="######" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="address" value="######" readonly></input>
	    </div>
	    <div class="confirm_text">上記の内容で更新しました。</div>
	  </form>
	</div>
	</body>
</html>