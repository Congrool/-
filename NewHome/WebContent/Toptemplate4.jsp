
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--导入核心文件-->
		<script src="bootstrap3/js/holder.js"></script>
		<link href="bootstrap3/css/bootstrap.css" rel="stylesheet" type="text/css">
		<script src="bootstrap3/jquery-1.9.1.min.js"></script>
		<script src="bootstrap3/js/bootstrap.js"></script>
		<!-- 字体图标 -->
		<link rel="stylesheet" href="../bootstrap3/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" type="text/css" href="css/layout.css" />
		<link rel="stylesheet" type="text/css" href="css/top.css" />
		<link href="css/multiColumnTemplate.css" rel="stylesheet" type="text/css">

<div class="container">
  <header>

    <nav class="secondary_header" id="menu">
      <ul>
         <a href="shizheng1.jsp"><li>时政</li></a>
        <a href="yule1.jsp"><li>娱乐</li></a>
        <a href="keji1.jsp"><li>科技</li></a>
        <a href="shenghuo1.jsp"><li>生活</li></a>
        <a href="tiyu1.jsp"><li>体育</li></a>
        <li class="btn" style="font-size:20px;margin-top:-7px;">注册/登录</li>
      </ul>
    </nav>
  </header>
</div>
<br/>
    <!-- 弹窗内容 -->
<div class="bk_login"> <!-- 出现弹窗时屏蔽其他内容 -->
	<div id=content_login class="tc_login">
		<label style="text-align:center;"><b>　登录</b></label>
		<span class="close_login">✖</span>
	<div align="center">     
	<form id=regist-form action="#" method="post">
		<div class="text-group">
				<hr><br>
			<label>用户名：</label>
				<input class="con" placeholder="输入用户名"/>
				<br><br>
			<label>密　码：</label>
				<input class="con" type="password" placeholder="输入密码"/>
				<br><br>
				<input type="submit" value="登录"/>         
				<input type="reset" value="重置"/>  
				<br/>
			<a href="#"><p class="btn_regist">还没有账户？前往注册</p></a>
		</div>
	</form>
	</div>
	</div>       
</div>
	<script>
		$('.btn').click(function(){
			$('.tc_login').fadeIn();
		});
		$('.close_login').click(function(){
			$('.tc_login').fadeOut();
		});
	</script>
	     <!-- 弹窗内容 -->
<div class="bk_regist"> <!-- 出现弹窗时屏蔽其他内容 -->
	<div id=content_regist class="tc_regist">
			<label><b>　注册</b></label>
	<span class="close_regist">✖</span>
	<div align="center"> 
	<form id=regist-form_regist action="#" method="post">
		<div class="text-group">
				<hr><br>
			<label>用 户 名：</label>
				<input class="con" placeholder="输入用户名"/>
			<br><br>
			<label>邮　　箱：</label>
				<input class="con" placeholder="输入邮箱"/>
				<br><br>
			<label>密　　码：</label>
				<input class="con" type="password" placeholder="输入密码"/>
				<br><br>
			<label>确认密码：</label>
				<input class="con" type="password" placeholder="请再输入一遍密码"/>
				<br><br>
			<input type="submit" value="注册"/>         
			<input type="reset" value="重置"/>  
		</div>
	</form>
	</div>       
</div>
</div>
	<script>
		$('.btn_regist').click(function(){
			$('.tc_regist').fadeIn();
			$('.tc_login').fadeOut();
		});
		$('.close_regist').click(function(){
			$('.tc_regist').fadeOut();
		});
	</script>

