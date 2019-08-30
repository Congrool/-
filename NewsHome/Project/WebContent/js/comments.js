/*function init() {
	var len = 80; //默认显示字数
	var btn = document.getElementsByTagName('p');
	for (i = 0; i < btn.length; i++) {
		//获取div对象

		var content = btn[i].innerText; //获取div里的内容

		//alert(content);
		var span = document.createElement("span"); //创建<span>元素
		var a = document.createElement("a"); //创建<a>元素
		span.innerHTML = content.substring(0, len); //span里的内容为content的前len个字符

		a.innerHTML = content.length > len ? "... 展开" : ""; ////判断显示的字数是否大于默认显示的字数    来设置a的显示        
		a.href = "javascript:void(0)";//让a链接点击不跳转


		// 设置div内容为空，span元素 a元素加入到div中
		btn[i].innerHTML = "";
		btn[i].appendChild(span);
		btn[i].appendChild(a);
	}
}
function  showme(){


		if (a.innerHTML.indexOf("展开") > 0) { //如果a中含有"展开"则显示"收起"
			a.innerHTML = "<<&nbsp;收起";
			span.innerHTML = content;
		} else {
			a.innerHTML = "... 展开";
			span.innerHTML = content.substring(0, len);
		}

}
*/