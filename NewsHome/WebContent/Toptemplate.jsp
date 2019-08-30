
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<meta http-equiv="X-UA-Compatible" content_login="IE=edge">

<title>每行都队新闻</title>
<link href="css/blogPostStyle.css" rel="stylesheet" type="text/css">
<link href="css/multiColumnTemplate.css" rel="stylesheet"
	type="text/css">
<link href="css/comments.css" rel="stylesheet" type="text/css">
<link href="css/footbar.css" rel="stylesheet"  type="text/css">
<link href="css/top.css" rel="stylesheet"  type="text/css">
<script type='text/javascript' src='js/login.js'></script>
<script type='text/javascript' src='js/comments.js'></script>

<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<!-- <script
	src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js"
	type="text/javascript"></script> -->

</head>
<body onload="init()"><div class="container">
   <header>

    <nav class="secondary_header" style="background-color:#52bad5;" id="menu">
      <ul>
        <a href="shizheng1.jsp"><li>时政</li></a>
        <a href="yule1.jsp"><li>娱乐</li></a>
        <a href="keji1.jsp"><li>科技</li></a>
        <a href="tiyu1.jsp"><li>体育</li></a>
        <a href="shenghuo1.jsp"><li>生活</li></a>
        <c:if test="${user==null }">
        <li class="btn" onclick="val()"style="font-size:20px;margin-top:-7px;">注册/登录</li>
        </c:if>
        <c:if test="${user!=null }"><b>用户：${user.username}<a href="userdata.jsp">用户信息</a></b>
        </c:if>
      </ul>
        <a style="color:red;float:right" href="index.jsp" >返回首页</a>
    </nav>
  </header>
<br/>
</div>
	<!-- 弹窗内容 -->
<div class="bk_login"> <!-- 出现弹窗时屏蔽其他内容 -->
	<div id=content_login class="tc_login">
		<label style="text-align:center;"><b>登录</b></label>
		<span class="close_login">✖</span>
	<div align="center">     
	<form id=regist-form action="Login" method="post">
		<div class="text-group" >
				<hr><br>
			<label>用户名：</label>
				<input class="con" placeholder="输入用户名"  name="username"/>
				<br><br>
			<label>密　码：</label>
				<input class="con" type="password" placeholder="输入密码" name="password"/>
				<br><br>
				<input type="submit" value="登录"/>         
				<input type="reset" value="重置"/>  
			<a href="#"><p class="btn_regist">还没有账户？前往注册</p></a>
		</div>
	</div>
	</form>
	</div>       
</div>
<!-- 弹窗内容 -->
<div class="bk_regist"> <!-- 出现弹窗时屏蔽其他内容 -->
	<div id=content_regist class="tc_regist">
			<label><b>　注册</b></label>
	<span class="close_regist">✖</span>
	<div align="center"> 
	<form id=regist-form_regist action="regist" method="post">
		<div class="text-group">
				<hr><br>
			<label>用 户 名：</label>
				<input class="con" placeholder="输入用户名" name="username"/>
			<br><br>
			<label>邮　　箱：</label>
				<input class="con" placeholder="输入邮箱" name="email"/>
				<br><br>
			<label>密　　码：</label>
				<input id="pwd1" class="con" type="password" placeholder="输入密码" name="password"/>
	
				<br><br>
			<label>确认密码：</label>
				<input id="pwd2" onkeyup="validate()" class="con" type="password" placeholder="请再输入一遍密码" name="password_again"/></div>
				<span id="tishi"></span>
				<br><br>
			<input id=""submit0. type="submit" value="注册"/>         
			<input type="reset" value="重置"/>  
		</div>
	</form>
	</div>       
</div>
