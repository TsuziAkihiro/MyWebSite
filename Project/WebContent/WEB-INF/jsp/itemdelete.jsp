<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品削除 - Cake</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
		<link rel="stylesheet" href="css/ItemDelete.css">
		<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="img/ice_cream.png">
	</head>
	<body>
	<jsp:include page="../../baselayout/header.jsp" />
		<div class="form-wrapper">
	  <h1>この商品を削除しますか？</h1>
		<div class="item">
			<img src="img/${item.fileName}" width="200" height="150" alt="">
		    <label for="aaa" class="aaa">&emsp;&emsp;${item.name}</label>
		    <form action="ItemDelete" method="POST">
		   	    <input type="hidden" value="${item.id}" name="item_id">
			    <div class="button-panel">
			      <input type="submit" class="button" title="Sign In" value="削除する" onclick='return confirm("本当に「${item.name}」を削除しますか？");'></input>
			    </div>
		    </form>
		</div>
	</div>
	</body>
</html>