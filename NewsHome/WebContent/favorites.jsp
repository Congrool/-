<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的收藏</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
	</head>

	<body>
		<div class="container" style="font-family:Microsoft YaHei;">
		<header>
    <nav class="secondary_header" style="background-color:#52bad5;"id="menu">
      <ul>
        <li>时政</li>
        <li>娱乐</li>
        <li>科技</li>
        <li>生活</li>
        <li>体育</li>
        <li>注册/登录</li>
      </ul>
    </nav>
    <br/>
	</header>
			<div class="col-md-2">
				<!--左侧导航开始-->
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<!--主选项：我的订单-->
							<p class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">我的收藏</a>
							</p>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<div><a href="orders.jsp"><b>全部收藏</b></a></div>
								<div><a href="comments.jsp">我的评论</a></div>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<!--主选项：资料修改-->
							<p class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">资料修改</a>
							</p>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<div ><a href="password.jsp">修改密码</a></div>
								<div><a href="userdata.jsp">个人资料</a></div>
								<div><a href="upload.jsp">上传头像</a></div>
							</div>
						</div>
					</div>
				</div>
				<!--左侧导航结束-->
			</div>
			<div class="col-md-10	">
				<div class="panel panel-default">
					<ul style="margin-top:20px;margin-left:20px;font-size:18px;">
						<li><a href="">收藏的页面在此展现</a></li><br/>
						<li><a href="">收藏的页面在此展现</a></li><br/>
						<li><a href="">收藏的页面在此展现</a></li><br/>
					</ul>
					<div class="panel-body">
						<!--修改资料表单开始-->
						
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>
		