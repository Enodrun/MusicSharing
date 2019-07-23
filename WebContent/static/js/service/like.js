//音乐收藏模块逻辑处理

//查询用户的收藏音乐列表
function listMusicByOneSuccess(msg){
	var area=document.getElementById("listMusicByOneArea")
	area.innerHTML=null;
	for (var i = 0; i <msg.length; i++) {
		var music_id = msg[i].music_id;
		var name =msg[i].name;//歌曲名
		var file=msg[i].file//音乐文件路径
		var cover=msg[i].cover;
		var likes=msg[i].likes;
		var words=msg[i].words;//上传者寄语
		var user_id=msg[i].fk_user_id//上传者

		var area=document.getElementById("listMusicByOneArea")//列表显示区域
		var html="<tr><td><a href='#' onclick='toPlayLike("+music_id+")'>"+name+"</a></td><td>"+likes+"</td><td><a href='#' onclick='dislikeTheMusic("+music_id+")'>删除</a></td></tr>"
		$("#listMusicByOneArea").append(html)
	}
}

//取消收藏
function dislikeTheMusic(music_id){
	dislike(music_id)//调用controller请求
	listMusicByOne()//重新加载列表
}

//播放列表音乐
function toPlayLike(music_id){
	sendId(music_id)
}
