// /**
//  * 首页的音乐列表，实现随机动画效果【因为效果不好，暂时不使用】
//  */

  // window.onload=selectMusicByPage()//启用随机分页的动画效果，根据likes数量判断
  function selectMusicByPage(){//获取歌曲列表的信息
  	var url="/MusicSharing/selectMusicByPage"
  	$.ajax({
  		type:"post",
  		url:url,
  		dataType:"json",
  		contentType:"application/json;charset=UTF-8",
  		success:function(res){
  			console.log(res.show)
  			var data = res.show//取出音乐数组
  			getInfo(data)//循环获取音乐数据并创建音乐元素
  			setContentSize()//根据屏幕像素设置元素样式
  		}
  	})
  }

 //把用户点击的music_id传到<audio>标签的src上播放音乐和收藏按钮上
  function sendId(music_id) {
	document.getElementById("like").innerHTML="收藏"//把收藏区域回归初始状态
	var sendid=parseInt(music_id)
  	var like=document.getElementById("like")//把正在播放的music_id发送到收藏按钮的name属性中
  	like.name=music_id
  	console.log("sendid："+sendid)
  	var url="/MusicSharing/selectMusicById"
  	var data={
  		"music_id":sendid
  	}
 	
  	var jsondata=JSON.stringify(data)
 	$.ajax({
  		type:"post",
  		url:url,
  		data:jsondata,
  		dataType:"json",
  		contentType:"application/json;charset=UTF-8",
  		success:function(res){
  			var music=res.music
 			
  			var music_id=music.music_id
  			var title=music.name
  			var audio=music.file//音乐路径
  			var cover=music.cover//封面路径
  			var words=music.words//歌词或上传者寄语
  			var likes=music.likes
  			var user_id=music.fk_user_id
  			console.log(title+"+"+audio+"+"+cover+"+"+words+"+"+user_id+"+"+music_id+"+"+likes)
  			setPlayInfo(audio,title,cover,words,user_id,music_id,likes)//调用函数把数据放置音乐播放区域
  		}
  	})
 	
 }
 
 //动态生成音乐元素节点
 function create(music_id,showPicture,showSize){
 	var child="<div><a onclick=\"sendId("+music_id+")\"><img src=\""+showPicture+"\" width=\""+showSize+"\" height=\""+showSize+"\"></a></div>"
 	$("#content").append(child)
 }
 //动态生成空音乐元素
 function empty(){
 	var child="<div></div>"
 	$("#content").append(child)
	
 }

 //循环获取音乐元素节点必要参数
 function getInfo(data){
 	var list=data
 	var parent=document.getElementById("content")//获取内容框的父节点
 	if (parent.innerHTML!=null) {
 		parent.innerHTML=null
 	}
	
 	for (var i = 0; i < list.length; i++) {
 		if (list[i].name!=null) {
 			var music_id=list[i].music_id
 			var showPicture=list[i].showPicture
 			var showSize=list[i].showSize
 			create(music_id,showPicture,showSize)//根据参数创建音乐元素
 		} else {
 			empty(parent)//生成空元素
 		}
 	}
 }

 //根据屏幕像素动态调整专辑区域的宽度和高度
 function setContentSize(){
 	var html;
 	var w=window.innerWidth
 	var h=window.innerHeight
	
 	if (w>=h) {
 		var width=Math.floor(w/8)//单元宽度
 		var height=Math.floor(h/3)//单元高度
 		html="#content div{float:right;width:"+ width+"px;height: "+height+"px;}body {background-image: url(\"UI/img/skybig.gif\");background-size:contain;}"
 		console.log("width:"+width+"-height:"+height)
 	} else {
 		var width=Math.floor(w/5)//单元宽度
 		var height=Math.floor(h/6)//单元高度
 		html="#content div{float:right;width:"+ width+"px;height: "+height+"px;}body {background-image: url(\"UI/img/skysmall.jpeg\");background-size:cover;}"
 		console.log("width:"+width+"-height:"+height)
 	}
		
 	$("#contentStyle").append(html)//添加style到首页中
 }

 // 设置播放信息
 function setPlayInfo(audio,title,cover,words,user_id,music_id,likes){
 	var audioId=document.getElementById("audioindex")
 	var titleId=document.getElementById("titleindex")//顶部导航区域
 	var titlePlay=document.getElementById("titlePlay")//播放区域
 	var coverId=document.getElementById("coverindex")
 	var wordsId=document.getElementById("wordsindex")
 	var uploadPersonPlayId=document.getElementById("uploadPersonPlayId")
 	var likesPlay=document.getElementById("likesPlay")
 	var music_idPlay=document.getElementById("music_idPlay")

 	audioId.src=audio
 	titleId.innerHTML=title
 	titlePlay.innerHTML=title
 	uploadPersonPlayId.innerHTML=user_id
 	likesPlay.innerHTML=likes
 	music_idPlay.innerHTML=music_id
 	coverId.src=cover
 	wordsId.innerHTML=words
 	console.log("index_music.js-setPlayInfo finish")
 }