//歌词模块数据交互

//根据sms_id，搜索歌曲
function selectSmsMusicBySmsId(sms_id){
	console.log("lyric.js-selectSmsMusicBySmsId:")//1.标识函数，方便调试
	var data={
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
 			var music=document.getElementById("music");
 			var title=document.getElementById("title");
 			var info=res.msg;//音乐信息
 			music.name=info.sms_id
 			music.src="../"+info.music_path
 			title.innerHTML=info.title
 			console.log("lyric.js-selectSmsMusicBySmsId finish")
 		}
	})
}

//跟据music_id搜索歌曲
function selectMusicById(music_id){
	console.log("selectMusicById:")//1.标识函数，方便调试
	var data={
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
			var music=document.getElementById("music");
 			var title=document.getElementById("title");
 			var info=res.music;//音乐信息
 			music.name=info.music_id
 			music.src="../"+info.file
 			title.innerHTML=info.name
 			alert("selectSmsMusicBySmsId finish")
 		}
	})
}

//跟据music_id,classify搜索歌曲的对应歌词
function listLyric(music_id,classify){
	console.log("listLyric:")//1.标识函数，方便调试
	var data={
		"music_id":music_id,
		"classify":classify
	}
	var url="/MusicSharing/listLyric"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			if (res.msg!=null&&res.msg!="") {
 				document.getElementById("lyricAreaScroll").innerHTML=null//清空之前的append
 				var lyric=res.msg
 				for (var i = 0; i < lyric.length; i++) {
 					var time=lyric[i].time
 					var content=lyric[i].content
 					console.log("time-content:"+time+"-"+content)
 					var html="<p id=\""+time+"\">"+content+"<p>"
 					$("#lyricAreaScroll").append(html)
 				}
 			}else{
 				alert("本歌曲尚未上传歌词")
 			}
 		}
	})
}

//添加歌词
function addLyric(music_id,classify,allKeyValue){
	console.log("addLyric:")//1.标识函数，方便调试
	var data={
		"music_id":music_id,
		"classify":classify,
		"allKeyValue":allKeyValue
	}
	var url="/MusicSharing/addLyric"

	$.ajax({								//3.编写ajax请求
		type:"post",
		url:url,
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		success:function(res){
 			if (res.status==true) {
 				alert("添加成功")//4.测试查看返回值
 				window.history.go(-1)//返回上一页
			}else {
				alert("歌词已存在，添加失败")//4.测试查看返回值
				window.history.go(-1)//返回上一页
				console.log("con-lyric.js-addLyric finish")
			}
 		}
	})
}