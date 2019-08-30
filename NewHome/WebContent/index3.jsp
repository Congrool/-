<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!doctype html>
<html>
<jsp:include page="Toptemplate.jsp"></jsp:include>
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
            height: 320px;
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
            width: 700px;
            height: auto;
        }

        #ul1 li img {
            width: 700px;
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
</head>

<body>
    <div id="container">
        <div id="pictures">
            <ul id="ul1">
                <li><a href="https://www.baidu.com/"><img src="img1.jpg"></a></li>
                <li><a href="https://www.baidu.com/"><img src="img2.jpg"></a></li>
                <li><a href="https://www.baidu.com/"><img src="img3.jpg"></a></li>
                <li><a href="https://www.baidu.com/"><img src="img4.jpg"> </a> </li>
            </ul>
        </div>
    </div>

    <article class="left_article">
      <a href="content1.html" style="color:#232323;text-decoration:none;"target="_blank"><h2>俄专家：没有西方国家支持 香港暴乱事件根本就不会发生</h2></a>
      <p>香港24日举行的“观塘游行”再度重演“快闪式”暴乱，部分“游行人士”瞬间化身暴徒，堵道路、攻警署、袭警员...</p>
      <p>“考虑到由美国挑起却“无疾而终”的贸易战，最近发生在中国香港的暴乱本质上是西方尝试对中国持续施压”，俄罗斯外交政策、国防与安全领域专家格里高利·特罗菲姆丘克说道。</p>
	 <p>特罗菲姆丘克认为，目前发生在香港的暴乱始于数年前由美国挑起的保护主义。然而不同于经济手段，这种波及面广且持续时间长的骚乱已经是一种纯碎的政治手段。他表示，西方国家企图以此试探中国对香港局势的反应，
	 并试图刺激中国政府作出强硬回答。尽管如此，中国政府还是在法律框架内对香港局势做出了恰当回应，这恰恰也遏制住了破坏份子挑衅的势头</p>   
    </article>
    <aside class="right_article"><img src="img/content1.jpg" alt="" width="300"  class="placeholder"/> </aside>
  </section>
  <div class="row">
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/nezha1.jpg" alt="" class="thumbnail"/> </p>
      <a href="content2.html" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>哪吒票房突破45亿再创记录，距《流浪地球》仅有一步之遥</h4></a>
      <p style="font-weight:400;">在近日，有关媒体透露消息，哪吒电影票房截止到北京时间8月26日，已经累积票房总数突破了45亿的大坎，朝着今年电影圈票房最高的电影流浪地球榜首位置又靠近了一大步。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/pingpang1.jpeg" alt="" class="thumbnail"/> </p>
      <a href="content3.html" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>国乒奥运资格争夺终于开幕！央视记者道出真相，2人入选毫无悬念</h4></a>
      <p>北京时间8月27日，国际乒乓球联合会（ITTF）官方宣布：2019年世界巡回赛总决赛落户中国郑州，将于12月12日-15日进行，届时全球顶尖乒坛好手就将齐聚于此，角逐年终最高荣誉以及高达一百万美元赛事奖金。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/5g0.jpg" alt="" class="thumbnail"/> </p>
      <a href="content4.html" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>5G已来： 订单大增业绩暴涨 产业链公司蓄势待发</h4></a>
      <p>这一波5G行情起来，工信部发牌照只能算是催化因素，最重要的原因可能还是华为加速5G布局。</p>
    </div>
    <div class="columns">
      <p class="thumbnail_align"> <img src="img/shenghuo2.png" alt="" class="thumbnail"/> </p>
      <a href="content5.html" style="color:#01B2D1;text-decoration:none;"target="_blank"><h4>刷新城市“颜值” 栖霞区举全区之力推动紫东地区建设发展</h4></a>
      <p>南京市委、市政府部署城市“东部崛起”，明确了紫东地区加快提档升级，全力推动紫东栖霞片区环境提升，举全区之力推动紫东地区建设发展。</p>
    </div>
  </div>
  <div class="row blockDisplay">
    <div class="column_half left_half">
      <h2 class="column_title">LEFT COLUMN</h2>
    </div>
    <div class="column_half right_half">
      <h2 class="column_title">RIGHT COLUMN</h2>
    </div>
  </div>
  <div class="social">
    <p class="social_icon"><img src="images/bkg_06.jpg" width="100" alt="" class="thumbnail"/></p>
    <p class="social_icon"><img src="images/bkg_06.jpg" width="100" alt="" class="thumbnail"/></p>
    <p class="social_icon"><img src="images/bkg_06.jpg" width="100" alt="" class="thumbnail"/></p>
    <p class="social_icon"><img src="images/bkg_06.jpg" width="100" alt="" class="thumbnail"/></p>
  </div>
  <footer class="secondary_header footer">
    <div class="copyright">&copy;2015 - <strong>SIMPLE Theme</strong></div>
  </footer>
</div>
</body>
</html>
