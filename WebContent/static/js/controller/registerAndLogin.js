//登陆与注册模块Controller

//注册用户
function UserRegister(name,password){
	console.log("register:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token,
		"name":name,
		"password":password
	}
	var url="/MusicSharing/register"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			registerSuccess(res)
 		}
	})
}

//用户登录
function UserLogin(name,password){
	console.log("login:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token,
		"name":name,
		"password":password
	}
	var url="/MusicSharing/login"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			loginSuccess(res)
 		}
	})
}

//注册时验证账户名是否已存在
function ifNameExist(name){
	console.log("ifNameExist:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token
		"name":name
	}
	var url="/MusicSharing/verify/username"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			ifNameExistSuccess(res)
 		}
	})
}
