//与评论相关的数据交互方法

/*显示播放界面的歌曲评论*/
function commentSuccessPlay(msg){
	var commentArea=document.getElementById("comment")
	commentArea.innerHTML=null
	for (var i = 0; i < msg.length; i++) {
		var comment_id=msg[i].comment_id;
		var user_id=msg[i].fk_user_id;
		var music_id=msg[i].fk_music_id;
		var datetime=msg[i].datetime;
		var content=msg[i].content;
		var commentArea=document.getElementById("comment")
		/*插入一条评论*/
		var html="<div style='width:100%'><img style='width:50px;height:50px'></img><span style='20px'></span><span style='margin:20px'>"+datetime+"</span><p style='text-indent:2em'>"+content+"</p><a id=\""+user_id+"\"href='#' style='float:right;margin:10px;background-color:white;' onclick='writeAletterTo(this.id)'>私信</a><a id=\""+comment_id+"\"href='#' style='float:right;margin:10px;background-color:white' onclick='reportComment(this.id)'>举报</a></div>"
		console.log("commentSuccessPlay.jss:"+"comment_id:"+comment_id+"user_id:"+user_id+"music_id"+music_id+"datetime:"+datetime+"content:"+content)
		/*获取并赋值用户头像和用户名*/
		$("#comment").append(html)
		getUserInfoComment(user_id,comment_id)//发送id信息获取用户的头像和用户名
	}

}


/*写私信给某人*/
function writeAletterTo(user_id){
	openLetterArea(400,400,user_id)//打开私信编辑区域
}

/*为某首歌写评论*/
function writeAComment(music_id) {
	var content=document.getElementById("commentContent").value
	var music_id=music_id;
	var user_id=sessionStorage.getItem("user_id")
	addComment(user_id,music_id,content)//调用ajax新增一条评论
}

/*举报评论*/
function reportComment(comment_id){
	StatusToBad(comment_id);//调用ajax修改评论状态为举报
}
	function reportCommentSuccess(comment_id){
		console.log("reportCommentSuccess:"+comment_id)
		alert("举报成功，感谢您的热心监督")
		var me = document.getElementById(comment_id)
		me.style.display="none"//举报按钮变为不可见
	}