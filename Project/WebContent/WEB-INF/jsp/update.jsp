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
	  <h1>情報更新</h1>
	  <form>
	  <p class="address">Cake ID</p>
	      <label for="email"></label>
	      <input type="text" name="email" class="input_txt" value="${udb.name}"></input>
	  <p class="address">名前を入力してください</p>
	      <label for="email"></label>
	      <input type="text" name="email" class="input_txt"></input>
	  <p class="address">メールアドレス</p>
	      <label for="password"></label>
	      <input type="email" name="email" class="input_txt"></input>
	    <!-- ▼郵便番号入力フィールド(3桁+4桁) -->
		  <script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
			 <div class="h-adr">
				<span class="p-country-name" style="display:none;">Japan</span>
				<p class="address">郵便番号</p>
				〒<input type="text" class="p-postal-code input_address" size="8" maxlength="8"><br>
				<p class="address address_txt">住所</p>
				<select class="p-region-id input_address">
				<option value="">--</option>
				<option value="1">北海道</option>
				<option value="2">青森県</option>
				<option value="3">岩手県</option>
				<option value="4">宮城県</option>
				<option value="5">秋田県</option>
				<option value="6">山形県</option>
				<option value="7">福島県</option>
				<option value="8">茨城県</option>
				<option value="9">栃木県</option>
				<option value="10">群馬県</option>
				<option value="11">埼玉県</option>
				<option value="12">千葉県</option>
				<option value="13">東京都</option>
				<option value="14">神奈川県</option>
				<option value="15">新潟県</option>
				<option value="16">富山県</option>
				<option value="17">石川県</option>
				<option value="18">福井県</option>
				<option value="19">山梨県</option>
				<option value="20">長野県</option>
				<option value="21">岐阜県</option>
				<option value="22">静岡県</option>
				<option value="23">愛知県</option>
				<option value="24">三重県</option>
				<option value="25">滋賀県</option>
				<option value="26">京都府</option>
				<option value="27">大阪府</option>
				<option value="28">兵庫県</option>
				<option value="29">奈良県</option>
				<option value="30">和歌山県</option>
				<option value="31">鳥取県</option>
				<option value="32">島根県</option>
				<option value="33">岡山県</option>
				<option value="34">広島県</option>
				<option value="35">山口県</option>
				<option value="36">徳島県</option>
				<option value="37">香川県</option>
				<option value="38">愛媛県</option>
				<option value="39">高知県</option>
				<option value="40">福岡県</option>
				<option value="41">佐賀県</option>
				<option value="42">長崎県</option>
				<option value="43">熊本県</option>
				<option value="44">大分県</option>
				<option value="45">宮崎県</option>
				<option value="46">鹿児島県</option>
				<option value="47">沖縄県</option>
				</select>
				<input type="text" class="p-locality p-street-address p-extended-address input_address_txt"/><br>
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