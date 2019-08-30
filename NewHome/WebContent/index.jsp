<%@ page language="java" contentType="text/html;
 charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content_login="IE=edge">
<meta name="viewport" content_login="width=device-width, initial-scale=1">


<title>每行都队新闻</title>
<link href="css/multiColumnTemplate.css" rel="stylesheet" type="text/css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
  <header>

    <nav class="secondary_header" id="menu">
      <ul>
        <a href="shizheng1.jsp"><li>时政</li></a>
        <a href="yule1.jsp"><li>娱乐</li></a>
        <a href="keji1.jsp"><li>科技</li></a>
        <a href="shenghuo1.jsp"><li>生活</li></a>
        <a href="tiyu1.jsp"><li>体育</li></a>
          <c:if test="${username==null }">
        <li class="btn" onclick="val()"style="font-size:20px;margin-top:-7px;">注册/登录</li>
        </c:if>
        <c:if test="${username!=null }"><b>用户：${username}<a href="userdata.jsp">用户信息</a></b>
        </c:if>
      </ul>
    </nav>
  </header>
  <section>
<style>
        * {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        #container {
            width: 99.5%;
            border: 1px solid #aaa;
            margin: 100px 0px;
        }

        #pictures {
            width: 99%;
            height: 382px;
            overflow: hidden;
            position: relative;
        }

        #ul1 {
            position: absolute;
            left: 0;
            top: 0;
            overflow: hidden;
        }

        #ul1 li {
            float: left;
            width: 900px;
            height: auto;
        }

        #ul1 li img {
            width: 900px;
            height: auto;
        }
        
        
    </style>
    <script>
        window.onload = function () {
            var oDiv = document.getElementById("pictures");
            var oUl = document.getElementById("ul1");
            var speed = -3;
            var oLi = document.getElementsByTagName("li");

            oUl.innerHTML += oUl.innerHTML;//先把图片增加一组
            oUl.style.width = oLi.length * oLi[0].offsetWidth + "px";

            function move() {
                if (oUl.offsetLeft < -oUl.offsetWidth / 2) {
                    oUl.style.left = "0";
                }
                oUl.style.left = oUl.offsetLeft + speed + "px";
            }
            var timer = setInterval(move, 30);
            oDiv.onmouseover = function () {
                clearInterval(timer);
            };
            oDiv.onmouseout = function () {
                timer = setInterval(move, 30);
            };
        }

    </script>



    <br/>
        <div id="pictures">
            <ul id="ul1">
                <a href="NewsDetail?newsid=115"><li><img src="img/fm5.jpg"></li></a>
                <li><a href="NewsDetail?newsid=101"><img src="img/fm1.jpg"></a></li>
                
                <li><a href="NewsDetail?newsid=106"><img src="img/fm3.jpg"></a></li>
                <li><a href="NewsDetail?newsid=112"><img src="img/fm2.jpg"></a></li>
                <li><a href="NewsDetail?newsid=112"><img src="img/fm2.jpg"></a></li>
            </ul>
        </div>
    
  </section>
  <div class="row">
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/nezha1.jpg" alt="" class="thumbnail"/> </p>
      <a href="NewsDetail?newsid=116" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>哪吒票房突破45亿再创记录，距《流浪地球》仅有一步之遥</h4></a>
      <p style="font-weight:400;">在近日，有关媒体透露消息，哪吒电影票房截止到北京时间8月26日，已经累积票房总数突破了45亿的大坎，朝着今年电影圈票房最高的电影流浪地球榜首位置又靠近了一大步。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/pingpang1.jpeg" alt="" class="thumbnail"/> </p>
      <a href="NewsDetail?newsid=117" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>国乒奥运资格争夺终于开幕！央视记者道出真相，2人入选毫无悬念</h4></a>
      <p>北京时间8月27日，国际乒乓球联合会（ITTF）官方宣布：2019年世界巡回赛总决赛落户中国郑州，将于12月12日-15日进行，届时全球顶尖乒坛好手就将齐聚于此，角逐年终最高荣誉以及高达一百万美元赛事奖金。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/5g0.jpg" alt="" class="thumbnail"/> </p>
      <a href="NewsDetail?newsid=118" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>5G已来： 订单大增业绩暴涨 产业链公司蓄势待发</h4></a>
      <p>这一波5G行情起来，工信部发牌照只能算是催化因素，最重要的原因可能还是华为加速5G布局。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/shenghuo2.png" alt="" class="thumbnail"/> </p>
      <a href="NewsDetail?newsid=119" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>刷新城市“颜值” 栖霞区举全区之力推动紫东地区建设发展</h4></a>
      <p>南京市委、市政府部署城市“东部崛起”，明确了紫东地区加快提档升级，全力推动紫东栖霞片区环境提升，举全区之力推动紫东地区建设发展。</p>
    </div>
  </div>
  <footer >
 

<div style="width: 100%;
	padding-top: 15px;
	padding-bottom: 25px;
	background-color: #01B2D1;
	font-size:15px;
	font-family:Microsoft YaHei;
	clear: left;
	color:#ffffff;">
	<p align=center >
	<a href="http://www.tencent.com" target="_blank" style="text-decoration:none;color:#ffffff;">关于我们</a>&nbsp;|&nbsp;
	<a href="http://mail.qq.com/cgi-bin/readtemplate?check=false&amp;t=mail_clause"target="_blank"style="text-decoration:none;color:#ffffff;">服务条款</a>&nbsp;|&nbsp;
	<a href="https://privacy.qq.com/"target="_blank"style="text-decoration:none;color:#ffffff;">隐私政策</a>&nbsp;|&nbsp;
	<a href="http://kf.qq.com/product/email.html" target="_blank"style="text-decoration:none;color:#ffffff;">客服中心</a>&nbsp;|&nbsp;
	<a href="http://mail.qq.com/contact_us.html" target="_blank"style="text-decoration:none;color:#ffffff;">联系我们</a>&nbsp;|&nbsp;
	<a href="http://service.mail.qq.com" target="_blank"style="text-decoration:none;color:#ffffff;">帮助中心</a>&nbsp;&nbsp;<br/>
	©1998 - 2019 Tencent Inc. All Rights Reserved.</p>
</div>
  </footer>
</div>
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
</body>
</html>
