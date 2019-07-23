//与评论相关的数据交互方法
//案例
function example(){
	console.log("addComment:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token
	}
	var url="/MusicSharing/selectCommentByMusicId"

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

//添加评论
function addComment(user_id,music_id,content){
	console.log("addComment:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"fk_user_id":user_id,
		"fk_music_id":music_id,
		"content":content
	}
	var url="/MusicSharing/addComment"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			var status=res.status;
 			if (status) {
				document.getElementById("comment").innerHTML=null//清空其他人评论区域
				document.getElementById("commentContent").value=null//清空本次评论编辑框内容
				selectCommentByMusicId(music_id);//重新搜索评论列表
			}else{
				alert("评论失败，请稍后再试")
			}
 			
 		}
	})
}

//举报评论:评论界面举报评论
function StatusToBad(comment_id){
	console.log("StatusToBad:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"comment_id":comment_id
	}
	var url="/MusicSharing/StatusToBad"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
			console.log("举报成功：comment.jsc-statustobad:"+res.msg)
 			reportCommentSuccess(comment_id);//调用逻辑处理把本次举报的评论变透明
 		}
	})
}

//把评论变为正常
function StatusToGood(comment_id){
	console.log("StatusToGood:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"comment_id":comment_id
	}
	var url="/MusicSharing/StatusToGood"

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

//查看评论状态1即举报状态的评论
function selectComment(){
	console.log("selectComment:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"status":1
	}
	var url="/MusicSharing/selectComment"

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

//点击评论按钮，获取某一首歌的所有评论
function selectCommentByMusicId(music_id){
	console.log("selectCommentByMusicId:")//标识函数，方便调试
//	var actionComment=document.getElementById("actionComment")
// 	var music_id = actionComment.name
	var token=sessionStorage.getItem("token")
	
	var data={
		"music_id":music_id,
		"token":token
	}
	var url="/MusicSharing/selectCommentByMusicId"

	$.ajax({
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			commentSuccessPlay(res.msg)//调用业务函数把信息显示到播放页面
 			console.log("comment.jsc:"+res.msg)
 		}
	})
}

//删除评论
function deleteCommentById(comment_id){
	console.log("deleteCommentById:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"comment_id":comment_id
	}
	var url="/MusicSharing/deleteCommentById"

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
