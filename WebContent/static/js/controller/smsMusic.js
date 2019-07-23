//点播模块数据交互

//传讯点播列表： 查询我点播的信息
function listSmsMusic(){
	console.log("listSmsMusic:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/listSmsMusic"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			listSmsMusicSuccess(res.msg)//执行逻辑操作
 		}
	})
}

//传讯点播列表：点播列表
function listSmsMusicToPlay(){
	console.log("listSmsMusic:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/listSmsMusic"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			listSmsMusicToPlaySuccess(res.msg)//执行逻辑操作
 		}
	})
}

//进入点播音乐播放页面，根据sms_id和command————————————————
function selectSmsMusicBySmsIdAndCommand(url,command){
	console.log("selectSmsMusicBySmsIdAndCommand:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"url":url,
		"command":command
	}
	var url="/MusicSharing/selectSmsMusicBySmsIdAndCommand"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			selectSmsMusicBySmsIdAndCommandSuccess(res)
 		}
	})
}


//进入点播音乐播放页面，根据sms_id和command————————————————
function selectSmsMusicBySmsId(sms_id){
	console.log("selectSmsMusicBySmsId:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"sms_id":sms_id
	}
	var url="/MusicSharing/selectSmsMusicBySmsId"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			selectSmsMusicBySmsIdSuccess(res.msg)
 		}
	})
}


//回信给点播人
function updateSmsMusicByLetter(sms_id,letter){
	console.log("updateSmsMusicByLetter:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token,
		"letter":letter,
		"sms_id":sms_id
	}
	var url="/MusicSharing/updateSmsMusicByLetter"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			if (res.msg) {
 				alert("留言成功")//4.测试查看返回值
				var wordsArea = document.getElementById("letter")
				wordsArea.value=null
			}
 		}
	})
}

//获取分享二维码:sound.html页面
function ShareUrl(url){
	console.log("ShareUrl:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串

	var data={
		// "token":token,
		"url":url
	}
	var url="/MusicSharing/ShareUrl"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			if (token!=null) {
				ShareUrlSuccess(res.msg)//图片路径字符串
			}else {
				ShareUrlSuccess2(res.msg)//图片路径字符串
			}
 		}
	})
}

//获取分享二维码：index.html的点播列表
function shareSmsUrl(url){
	console.log("shareSmsUrl:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串

	var data={
		// "token":token,
		"url":url
	}
	var url="/MusicSharing/ShareUrl"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			if (res.msg) {
				console.log("con-smsMusic.js-shareSmsUrl finish")
				shareSmsUrlSuccess(res.msg)
			}
 		}
	})
}