<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>退会について - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/Delete.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
	</head>
	<body>
	<jsp:include page="../../baselayout/header.jsp" />
		<div class="form-wrapper">
	  <h1>本当に退会しますか？</h1>
	<p>退会をご希望される場合は、注意事項に同意の上、退会してください。</p>
	 <h1>注意事項</h1>
		<p>・退会処理後、同じアカウントのご利用はできなくなります。</p>
		<p>・退会にすることにより、退会前のご注文はキャンセルになることはございません。</p>
	 	<p>・注文の詳細が確認できる履歴は、退会と同時に閲覧ができなくなります。
	 	<br>
	 					　ご了承ください。</p>
	 <form action="DeleteResult" method="POST">
	    <div class="button-panel">
	      <input type="submit" class="button" title="Sign In" value="退会する"></input>
	    </div>
	  </form>
	</div>
	</body>
</html>