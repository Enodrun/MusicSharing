//私信模块数据交互

//增加一条私信记录:私信编辑区域
function addLetter(user_receive,content){
	console.log("addLetter:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_send=sessionStorage.getItem("user_id")//发送人id
	var data={
		"token":token,
		"fk_user_send":parseInt(user_send),
		"fk_user_receive":parseInt(user_receive),
		"content":content
	}
	var url="/MusicSharing/addLetter"


	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			console.log("addLetter finish:"+res.msg)
			var status=res.status
			if (status==true) {
				alert("发送成功")
				var letterArea=document.getElementById("letterArea")
				letterArea.children[5].value=null//清空私信编辑区域内容
				selectLetterBySend();
			}else{
				alert("发送失败，请稍后再试")
			}
 		}
	})
}

//查看收件信息:收件箱
function selectLetterByReceiveMan(){
	console.log("selectLetterByReceive:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/selectLetterByReceive"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			var temp=res.msg;
 			selectLetterByReceiveManSuccess(temp);//把信件消息数组传出进行逻辑处理
 		}
	})
}

//查看已发送信息：发件箱
function selectLetterBySend(){
	console.log("selectLetterBySend:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/selectLetterBySend"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			selectLetterBySendManSuccess(res.msg)
 		}
	})
}