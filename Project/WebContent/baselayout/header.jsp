<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
	  <div class="container">
        <div class="header-center">
        	<a href="TopPage" class="title"><i class="fas fa-coffee"></i> Cake</a>
        </div>
			<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>
        <div class="header-right">
			<%if(isLogin){ %>
			<a href="UserData"><i class="material-icons">account_circle</i></a>
			<%}else{ %>
			<a href="Login" class="login_btn btn">ログイン</a>
			<%} %>

			<%if(isLogin){ %>
			<a href="Logout"><i class="material-icons">exit_to_app</i></a>
			<%}else{ %>
			<a href="Regist" class="signup_btn btn">新規登録</a>
			<%} %>
		</div>
      </div>
	</header>