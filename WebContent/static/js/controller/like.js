//音乐收藏模块数据交互
//案例
//添加收藏
function addLike(user_id,music_id){
	console.log("addLike:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"fk_user_id":user_id,
		"fk_music_id":music_id
	}
	var url="/MusicSharing/addLike"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			var status=res.status
 			if (status) {
				document.getElementById("like").innerHTML="已收藏";
				listMusicByOne();
			}else {
				alert("该歌曲已收藏")
				document.getElementById("like").innerHTML="已收藏"
				listMusicByOne();
			}
 		}
	})
}

//删除收藏
function dislike(music_id){
	console.log("dislike:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"fk_user_id":user_id,
		"fk_music_id":music_id
	}
	var url="/MusicSharing/dislike"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			var status=res.status
 			if (status) {
//				alert("操作成功")
				var area=document.getElementById("like");
				area.innerHTML="收藏";
				listMusicByOne();
			}else {
				alert("操作失败，请稍后再试")
			}
 		}
	})
}

//查询某首歌的收藏用户有哪些
function listLikeByMusic(music_id){
	console.log("listLikeByMusic:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		"token":token,
		"fk_music_id":music_id
	}
	var url="/MusicSharing/listLikeByMusic"

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

//查询某个用户收藏的音乐有哪些：
function listMusicByOne(){
	console.log("listMusicByOne:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"fk_user_id":user_id
	}
	var url="/MusicSharing/listMusicByOne"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			listMusicByOneSuccess(res.msg);//收藏列表逻辑处理
 		}
	})
}