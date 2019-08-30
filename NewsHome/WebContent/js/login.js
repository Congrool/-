function  val(){
		$('.btn').click(function(){
			$('.tc_login').fadeIn();
		});
		
		$('.close_login').click(function(){
			$('.tc_login').fadeOut();
		});
		
		$('.btn_regist').click(function(){
			$('.tc_regist').fadeIn();
			$('.tc_login').fadeOut();
		});
		
		$('.close_regist').click(function(){
			$('.tc_regist').fadeOut();
		});
		
		$('.btn_regist').click(function(){
			$('.tc_regist').fadeIn();
			$('.tc_login').fadeOut();
		});
		$('.close_regist').click(function(){
			$('.tc_regist').fadeOut();
		});
}

   function validate() {
              var pwd1 = document.getElementById("pwd1").value;
              var pwd2 = document.getElementById("pwd2").value;
              if(pwd1 == pwd2) {
                  document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
          }

