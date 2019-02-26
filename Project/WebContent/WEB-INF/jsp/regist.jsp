<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規登録 - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Regist.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
		<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>

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
	  <h1>新規会員登録</h1>
	  <c:if test="${validationMessage != null}">
	  		<div class="alert alert-danger" role="alert">
	  			<FONT color="#ff0000">${validationMessage}</FONT>
	  		</div>
	  </c:if>
	  <form action="RegistConfirm" method="POST">
	  <p class="address">Cake IDを入力してください</p>
	      <label for="email"></label>
	      <input type="text" name="login_id" class="input_txt" value="${udb.loginId}"></input>
	  <p class="address">名前を入力してください</p>
	      <label for="email"></label>
	      <input type="text" name="name" class="input_txt" value="${udb.name}"></input>
	  <p class="address">メールアドレス</p>
	      <label for="password"></label>
	      <input type="email" name="mail_address" class="input_txt" value="${udb.mailAddress}"></input>
	    <!-- ▼郵便番号入力フィールド(3桁+4桁) -->
		  <script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
			 <div class="h-adr">
				<span class="p-country-name" style="display:none;">Japan</span>
				<p class="address">郵便番号</p>
				〒<input type="text" name="postal_code" value="${udb.postalCode}" class="p-postal-code input_address" size="8" maxlength="8" ><br>
				<p class="address address_txt">住所</p>
				<select name="prefecture" class="p-region-id input_address">
					<option value="">--</option>
						<c:forEach var="ddb" items="${ddbList}">
							<option value="${ddb.id}"
								<c:if test="${ddb.prefecture == udb.postalCode}">
								  selected
								</c:if>
							>${ddb.prefecture}</option>
						</c:forEach>
				</select>
				<input type="text"  name="address" value="${udb.address}" class="p-locality p-street-address p-extended-address input_address_txt"/><br>
				</div>
			<p class="address">パスワード</p>
	      <label for="password"></label>
	      <input type="password" name="password" class="input_txt" required></input>
	    <p class="address">パスワード(確認用)</p>
	      <label for="password"></label>
	      <input type="password" name="confirm_password" class="input_txt" required></input>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="登録"></input>
	    </div>
	  </form>
	</div>
	</body>
</html>