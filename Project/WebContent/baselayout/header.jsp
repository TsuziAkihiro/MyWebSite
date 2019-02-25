<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="red darken-4" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="TopPage" class="brand-logo">Cake</a>
		<ul class="right">
			<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>

			<%if(isLogin){ %>
			<li><a href="ItemList" class="list_btn btn list-inline-item"><i class="fas fa-list-ul"></i></a></li>
			<%} %>

			<%if(isLogin){ %>
			<li><a href="UserManager" class="list_btn btn list-inline-item"><i class="fas fa-users"></i></a></li>
			<%} %>

			<%if(isLogin){ %>
			<li><a href="MyPage" class="login_btn btn"><i class="fa fa-user" aria-hidden="true"></i></a></li>
			<%}else{ %>
			<li><a href="Regist" class="signup_btn btn"><i class="fas fa-user-plus"></i></a></li>
			<%} %>

			<li><a href="Cart" class="cart_btn btn list-inline-item"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>

			<%if(isLogin){ %>
			<li><a href="Logout" class="logout_btn btn list-inline-item"><i class="fas fa-sign-out-alt"></i></a></li>
			<%}else{ %>
			<li><a href="Login"  class="login_btn btn list-inline-item"><i class="fas fa-sign-in-alt"></i></a></li>
			<%} %>
		</ul>
	</div>
</nav>