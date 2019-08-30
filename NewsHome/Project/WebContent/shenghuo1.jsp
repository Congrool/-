<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>生活</title>
		<jsp:include page="Toptemplate.jsp"></jsp:include>
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
		
			<div class="col-md-2">
				<!--左侧导航开始-->
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
					
							<span class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">分类</a>
							</span>
						</div>
						<div id="collapseOne" class="panel-collapse collapse">
							<div class="panel-body">
								<div><a href="#"><b>生活周边</b></a></div>

							</div>
						</div>
					</div>
					
				</div>
				<!--左侧导航结束-->
			</div>
			<div class="col-md-10	">
				<div class="panel panel-default">
					<ul style="margin-top:20px;margin-left:20px;font-size:18px;">
						<li><a href="NewsDetail?newsid=110">生活垃圾分类</a></li><br/>
						<li><a href="NewsDetail?newsid=111">如何解决室内干燥 一个加湿器是不行的</a></li><br/>
						<li><a href="NewsDetail?newsid=119">刷新城市“颜值” 栖霞区举全区之力推动紫东地区建设发展</a></li><br/>
					</ul>
					<div class="panel-body">
						<!--修改资料表单开始-->
						
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>
		