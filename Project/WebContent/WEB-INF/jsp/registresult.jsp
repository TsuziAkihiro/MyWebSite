<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登録完了しました - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/RegistResult.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
		<meta http-equiv="Refresh" content="3;TopPage">
	</head>
	<body>
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="form-wrapper">
	  <h1>入力内容確認</h1>
	  <form>
	    <div class="form-item">
	      <label for="email"></label>
	      <input type="email" name="email" placeholder="Cake ID" value="${udb.loginId}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="password" placeholder="名前" value="${udb.name}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="password" placeholder="メールアドレス" value="${udb.mailAddress}" readonly></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="text" name="address" placeholder="住所" value="〒${udb.postalCode}&emsp;${udb.prefecture}&emsp;${udb.address}" readonly></input>
	    </div>
	    <div class="confirm_text">上記の内容で登録しました。</div>
	  </form>
	</div>
	</body>
</html>