/*service和success处理*/
/*注册赋值调用*/
function registerService(){
	var name=document.getElementById("rname").value
	var password=document.getElementById("rpassword").value
	UserRegister(name,password)
}
/*注册回调函数*/
	function registerSuccess(res){
		if (res.status==1) {
			alert("注册成功")
			closeMask()//关闭登录注册框
		}else{
			alert("注册失败")
		}
	}
	
/*登录赋值调用*/
function loginService(){
	var name=document.getElementById("lname").value
	var password=document.getElementById("lpassword").value
	UserLogin(name,password)
}
/*登录回调函数*/
		function loginSuccess(res){
			if (res.status==1) {
					sessionStorage.setItem("token",res.token)//存token					
					var user = res.user
					var user_id=user.user_id;
					sessionStorage.setItem("user_id",user_id)//存用户id信息
					closeMask();/*登录成功则关闭登录注册框*/
				}else {
					alert("登陆失败")
				}
		}

/*用户名认证*/
function ifNameExistSuccess(res){
	if (res.msg==0) {
		alert("用户名可用")
	}else{
		alert("用户名已存在")
	}
}