//与用户相关的数据交互方法
//查看用户的全部信息
function getUserAll(user_id){
	console.log("getUserAll:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/getUserAll"
		
	$.ajax({								//3.编写ajax请求
		type:"post",
//		async:true,//异步默认为true
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res.msg.name)//4.测试查看返回值
 		}
	})
}

//查看用户除密码之外的信息:获取上传该音乐的用户信息并显示出来:播放页面
function getUserInfo(user_id){
	console.log("getUserInfo:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/getUserInfo"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			user_id=res.msg.user_id
			name=res.msg.name
			head_picture=res.msg.head_picture
			getUserInfoSuccessPlay(user_id,name,head_picture)
 		}
	})
}


//查看用户除密码之外的信息:个人账户页面
function getUserInfoPersonal(){
	console.log("getUserInfoPersonal:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/getUserInfo"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			user_id=res.msg.user_id
			nick_name=res.msg.nick_name
			head_picture=res.msg.head_picture
			mail=res.msg.mail
			getUserInfoPersonalSuccess(head_picture,nick_name,mail)
 		}
	})
}

//查看用户除密码之外的信息：获取某条评论下的用户信息并显示出用户名和用户头像
function getUserInfoComment(user_id,comment_id){
	console.log("getUserInfo:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/getUserInfo"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			user_id=res.msg.user_id
			name=res.msg.name
			head_picture=res.msg.head_picture
			getUserInfoCommentSuccess(name,head_picture,comment_id)//进行逻辑处理，在相应的评论下赋值用户名和头像
			console.log("user.jsc："+"name:"+name+"-head_picture:"+head_picture+"-comment_id:"+comment_id)
 		}
	})
}


//查看用户除密码之外的信息：把letterArea的用户Id换成名字，区域为FA,TA
function getUserNameLetterArea(from,to,FA,TA){
	console.log("getUserNameLetterArea:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"fromId":parseInt(from),
		"toId":parseInt(to)
	}
	var url="/MusicSharing/getUserNameLetterArea"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			var info=res.msg
			FA.innerHTML=info.fromName;
			TA.innerHTML=info.toName;
			console.log("con-user.js-getUserNameLetterArea finish")
 		}
	})
}


//管理员权限，获取所有用户资料
function listUser(){
	console.log("listUser:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token
	}
	var url="/MusicSharing/listUser"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res)//4.测试查看返回值
 		}
	})
}

//分页查询用户信息
function listUserByPage(start,count){
	console.log("listUserByPage:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"start":start,
		"count":count
	}
	var url="/MusicSharing/listUserByPage"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res)//4.测试查看返回值
 		}
	})
}

//验证用户名是否存在
function selectUserIfExist(name){
	console.log("selectUserIfExist:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token,
		"name":name
	}
	var url="/MusicSharing/selectUserIfExist"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res)//4.测试查看返回值
 		}
	})
}

//获取总用户数量
function totalUser(){
	console.log("totalUser:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	// var data={
	// 	"token":token,
	// 	"name":
	// }
	var url="/MusicSharing/totalUser"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		// data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res)//4.测试查看返回值
 		}
	})
}

//删除用户
function deleteUserById(user_id){
	console.log("deleteUserById:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/deleteUserById"



	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			alert(res)//4.测试查看返回值
 		}
	})
}

/*更新用户，不上传图片，只传输图片路径*/
function updateUserByPath(){
	console.log("updateUserByPath:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var myHeadPicture=document.getElementById("myHeadPicture").src//头像
	var nick_name=document.getElementById("nick_name").value//昵称
	var mail=document.getElementById("mail").value//邮箱
	var data={
		"token":token,
		"user_id":user_id,
		"nick_name":nick_name,
		"head_picture":myHeadPicture,
		"mail":mail
	}
	var url="/MusicSharing/updateUserByPath"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			if (res.status) {
				showUserInfo()
			}
 			alert("更新成功："+res.status)//4.测试查看返回值
 		}
	})
}