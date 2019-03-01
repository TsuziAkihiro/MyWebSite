<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>情報更新 - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Update.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
	</head>
	<body>
		<jsp:include page="../../baselayout/header.jsp" />
		<div class="form-wrapper">
	  <h1>情報更新</h1>
	  <form action="UpdateResult" method="POST">
	  <p class="address">Cake ID</p>
	      <label for="email"></label>
	      <input type="text" name="loginId" class="input_txt" value="${udb.loginId}"></input>
	  <p class="address">名前を入力してください</p>
	      <label for="email"></label>
	      <input type="text" name="name" class="input_txt" value="${udb.name}"></input>
	  <p class="address">メールアドレス</p>
	      <label for="password"></label>
	      <input type="email" name="mailAddress" class="input_txt"value="${udb.mailAddress}"></input>
	    <!-- ▼郵便番号入力フィールド(3桁+4桁) -->
		  <script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
			 <div class="h-adr">
				<span class="p-country-name" style="display:none;">Japan</span>
				<p class="address">郵便番号</p>
				〒<input type="text" name="postal_code" value="${udb.postalCode}" class="p-postal-code input_address" size="8" maxlength="8"><br>
				<p class="address address_txt">住所</p>
				<select class="p-region-id input_address">
					<option value="">--</option>
						<c:forEach var="ddb" items="${ddbList}">
							<option value="${ddb.id}"
								<c:if test="${ddb.prefecture == udb.postalCode}">
								  selected
								</c:if>
							>${ddb.prefecture}</option>
						</c:forEach>
				</select>
				<input type="text" name="address" value="${udb.address}" class="p-locality p-street-address p-extended-address input_address_txt"/><br>
				</div>
   <div class="confirm_text">この内容で更新しますか？</div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="戻る"></input>
	    </div>
	    <div class="button-panel regist_btn_panel">
	      <input type="submit" class="button regist_btn" title="Sign In" value="更新"></input>
	    </div>
	  </form>
	</div>
	</body>
</html>