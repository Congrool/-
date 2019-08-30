<%@ page language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>娱乐</title>
		<jsp:include page="Toptemplate.jsp"></jsp:include>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--å¯¼å¥æ ¸å¿æä»¶-->
		<script src="bootstrap3/js/holder.js"></script>
		<link href="bootstrap3/css/bootstrap.css" rel="stylesheet" type="text/css">
		<script src="bootstrap3/jquery-1.9.1.min.js"></script>
		<script src="bootstrap3/js/bootstrap.js"></script>
		<!-- å­ä½å¾æ  -->
		<link rel="stylesheet" href="../bootstrap3/font-awesome-4.7.0/css/font-awesome.css" />
		<link rel="stylesheet" type="text/css" href="css/layout.css" />
		<link rel="stylesheet" type="text/css" href="css/top.css" />
		<link href="css/multiColumnTemplate.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<div class="container" style="font-family:Microsoft YaHei;">
		
			<div class="col-md-2">
				<!--å·¦ä¾§å¯¼èªå¼å§-->
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<!--ä¸»éé¡¹ï¼æçè®¢å-->
							<span class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">分类</a>
							</span>
						</div>
						<div id="collapseOne" class="panel-collapse collapse">
							<div class="panel-body">
								<div><a href="yule1.jsp">明星</a></div>
								<div><a href="#"><b>影视<b></a></div>

							</div>
						</div>
					</div>
					
				</div>
				<!--å·¦ä¾§å¯¼èªç»æ-->
			</div>
			<div class="col-md-10	">
				<div class="panel panel-default">
					<ul style="margin-top:20px;margin-left:20px;font-size:18px;">
						<li><a href="NewsDetail?newsid=105">王志文领衔戏骨团《最长一枪》发“演技派狂欢”</a></li><br/>
						<li><a href="NewsDetail?newsid=116">哪吒票房突破45亿再创记录，距《流浪地球》仅有一步之遥</a></li><br/>
					</ul>
					<div class="panel-body">
						<!--ä¿®æ¹èµæè¡¨åå¼å§-->
						
						
					</div>
				</div>
			</div>
		</div>

	</body>

</html>
		