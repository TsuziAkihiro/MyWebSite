<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Login.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
	</head>
	<body>
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="form-wrapper">
	  <h1>ログイン</h1>
	  <form action="Login" method="POST">
	    <div class="form-item">
	      <label for="text"></label>
	      <input type="text" name="loginId" placeholder="Cake ID"></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="password" name="password" placeholder="パスワード"></input>
	    </div>
	    <c:if test="${errMsg != null}" >
		    <div class="alert alert-danger" role="alert">
			  <FONT color="#ff0000">${errMsg}</FONT>
			</div>
		</c:if>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="ログイン"></input>
	    </div>
	  </form>
	  <ul class="accounts">
		  <li class="account">アカウントをお持ちでないですか？&emsp;</li>
		  <li class="account"><a href="Regist">新規登録</a></li>
	  </ul>
	</div>
	</body>
</html>