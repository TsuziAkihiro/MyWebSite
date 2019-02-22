<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザ一覧 - Cake</title>
	<link rel="stylesheet" href="css/UserManager.css">
	<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="img/ice_cream.png">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">

</head>
	<body>
		<header>
		  <div class="container">
	        <div class="header-center">
	        	<a href="TopPage.html" class="title"><i class="fas fa-coffee"></i> Cake</a>
	        </div>
	        <div class="header-right">
	        	<a href="ItemList.html" class="list_btn btn"><i class="fas fa-list-ul"></i></a>
	        	<a href="UserManager.html" class="list_btn btn"><i class="fas fa-users"></i></a>
				<a href="MyPage.html" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a>
				<a href="Cart.html" class="signup_btn btn"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
				<a href="Logout.html" class="logout_btn btn"><i class="fas fa-sign-out-alt"></i></a>
			</div>
	      </div>
		</header>
		<div class="main">
			<div class="return_wrapper">
				<div class="a">
				<a href="MyPage.html" class="return">>マイページへ</a>
				</div>
			</div>
			<div class="item_wrapper">
				<div class="container">
					<div class="row">
						<h3 class="cart_title">ユーザーリスト</h3>
					</div>
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col" style="width:50px;"></th>
					      <th scope="col" style="width:50px;"></th>
					      <th scope="col" style="width:50px;">ID</th>
					      <th scope="col" style="width:100px;">ログインID</th>
					      <th scope="col"style="width:100px;">名前</th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:100px;"></th>
					      <th scope="col"style="width:50px;"></th>
					      <th scope="col" style="width:50px;"></th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row"></th>
					      <td><img src="img/a1e0f003ecb29b57d6392a532d17da6d (1).png" width="40" height="30" alt=""></td>
					      <td>1</td>
					      <td>abcde</td>
					      <td>〇〇さん</td>
					      <td></td>
					      <td><a href="Update.html" class="go">編集</a></td>
					      <td><a href="UserDelete.html" class="delete">削除</a></td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td><img src="img/gahag-0114507215.jpg" width="40" height="30" alt=""></td>
					      <td>2</td>
					      <td>abcde</td>
					      <td>〇〇さん</td>
					      <td></td>
					      <td><a href="Update.html" class="go">編集</a></td>
					      <td><a href="UserDelete.html" class="delete">削除</a></td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td><img src="img/76769.jpg" width="40" height="30" alt=""></td>
					      <td>3</td>
					      <td>abcde</td>
					      <td>〇〇さん</td>
					      <td></td>
					      <td><a href="Update.html" class="go">編集</a></td>
					      <td><a href="UserDelete.html" class="delete">削除</a></td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td><img src="img/merusi14.jpg" width="40" height="30" alt=""></td>
					      <td>4</td>
					      <td>abcde</td>
					      <td>〇〇さん</td>
					      <td></td>
					      <td><a href="Update.html" class="go">編集</a></td>
					      <td><a href="UserDelete.html" class="delete">削除</a></td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row"></th>
					      <td><img src="img/873aad49a96e34e28397b7b3723791a7_s.jpg" width="40" height="30" alt=""></td>
					      <td>5</td>
					      <td>abcde</td>
					      <td>〇〇さん</td>
					      <td></td>
					      <td><a href="Update.html" class="go">編集</a></td>
					      <td><a href="UserDelete.html" class="delete">削除</a></td>
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
	</body>
</html>