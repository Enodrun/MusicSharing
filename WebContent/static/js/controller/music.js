/*音乐模块数据交互*/

//随机分页查询音乐列表
// function selectMusicByPage(){
// 	console.log("selectMusicByPage:")//1.标识函数，方便调试
// 	var url="/MusicSharing/selectMusicByPage"

// 	$.ajax({								//3.编写ajax请求
// 		type:"post",
// 		url:url,
// 		// data:JSON.stringify(data),
// 		dataType:"json",
// 		contentType:"application/json;charset=UTF-8",
// 		success:function(res){
//  			alert(res)//4.测试查看返回值
//  		}
// 	})
// }

//根据id查询音乐信息
/*function selectMusicById(music_id){
	console.log("selectMusicById:")//1.标识函数，方便调试
	// var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var data={
		// "token":token,
		"music_id":music_id
	}
	var url="/MusicSharing/selectMusicById"

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
}*/


//根据上传者Id查询音乐列表
function listMusicByUserId(){
	console.log("listMusicByUserId:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"user_id":user_id
	}
	var url="/MusicSharing/listMusicByUserId"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			listMusicByUserIdSuccess(res.msg);
 		}
	})
}

//根据music_id删除对应的音乐
function deleteMusicById(music_id){
	console.log("deleteMusicById:")//1.标识函数，方便调试
	var token=sessionStorage.getItem("token")//2.取值、转换成json字串
	var user_id=sessionStorage.getItem("user_id")
	var data={
		"token":token,
		"fk_user_id":user_id,
		"music_id":music_id
	}
	var url="/MusicSharing/deleteMusicById"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			deleteMusicByIdSuccess(res.msg);
 		}
	})
}

//根据输入的每页显示数量，分页查询音乐——
function selectMusicByPageRandom(count){
	console.log("selectMusicByPageRandom:")//1.标识函数，方便调试
	var data={
		"count":count
	}
	var url="/MusicSharing/selectMusicByPageRandom"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			// selectMusicByPageRandomSuccess(res.msg);//效果不好，暂时不使用
 			selectMusicByPageRandomSuccessI(res.msg);
 		}
	})
}


