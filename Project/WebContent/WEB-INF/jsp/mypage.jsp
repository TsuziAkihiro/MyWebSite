<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>マイページ - Cake</title>
	<link rel="stylesheet" href="css/MyPage.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>

</head>
	<body>
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	        	<a href="ItemList" class="list_btn btn"><i class="fas fa-list-ul"></i></a>
	        	<a href="UserManager" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<div class="main">
			<div class="return_wrapper">
				<div class="a">
				<a href="TopPage" class="return">>Topへ</a>
				</div>
			</div>
			<div class="profile_wrapper">
				<div class="container">
					<div class="icon profile_con">
							<img src="img/TOMcatDSC01768_TP_V.jpg">
							<input type="file">
					</div>
					<div class="name profile_con">
						<p>${user.name}</p>
					</div>
					<div class="update">
						<a href="Update" class="go go_update">更新へ</a>
						<a href="Delete" class="go go_delete">退会へ</a>
					</div>
				</div>
			</div>
			<div class="item_wrapper">
				<div class="container">
					<div class="row">
						<h3 class="cart_title">購入履歴</h3>
					</div>
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col" style="width:75px;"></th>
					      <th scope="col" style="width:325px;">購入日時</th>
					      <th scope="col" style="width:160px;">合計金額</th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:100px;"></th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row"></th>
					      <td>2018年12月34日56時78分</td>
					      <td>12345</td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td><button type="button" class="btn btn-info" id="detail-show">詳細</button></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td>2018年12月34日56時78分</td>
					      <td>12345</td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td><button type="button" class="btn btn-info" id="detail-show">詳細</button></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td>2018年12月34日56時78分</td>
					      <td>12345</td>
					      <td></td>
					      <td></td>
					      <td></td>
					      <td><button type="button" class="btn btn-info" id="detail-show">詳細</button></td>
					    </tr>
					    <tr>
					    	<td></td>
					    	<td></td>
					    	<td><a href="Favorite" class="go">お気に入り商品へ</a></td>
					    	<td></td>
					    	<td></td>
					    	<td></td>
					    	<td></td>
					    </tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
		<footer>
			<div class="container">
				<div class="text">Cake</div>
			</div>
		</footer>
	<script type="text/javascript" src="./js/MyPage.js"></script>
	<script type="text/javascript">
   $(function(){
      // ▼マウスが載ったらサブメニューを表示
      $("ul.ddmenu li").mouseenter(function(){
         $(this).siblings().find("ul").hide();  // 兄弟要素に含まれるサブメニューを全部消す。
         $(this).children().slideDown(150);     // 自分のサブメニューを表示する。
      });
      // ▼どこかがクリックされたらサブメニューを消す
      $('html').click(function() {
         $('ul.ddmenu ul').slideUp(150);
      });
   });
</script>
	</body>
</html>