/*音乐模块逻辑操作*/

//上传者列表返回成功函数
function listMusicByUserIdSuccess(msg){
	var area=document.getElementById("listMusicByUserIdArea")
	area.innerHTML=null;
	for (var i = 0; i <msg.length; i++) {
		var music_id = msg[i].music_id;
		var name =msg[i].name;//歌曲名
		var file=msg[i].file//音乐文件路径
		var cover=msg[i].cover;
		var likes=msg[i].likes;
		var words=msg[i].words;//上传者寄语
		var user_id=msg[i].fk_user_id//上传者

		var area=document.getElementById("listMusicByUserIdArea")//列表显示区域
		var html="<tr><td><a href='#' onclick='toPlayLike("+music_id+")'>"+name+"</a></td><td>"+likes+"</td><td><a href='#' onclick='deleteTheMusic("+music_id+")'>删除</a></td></tr>"
		$("#listMusicByUserIdArea").append(html)
	}
}


// 音乐收藏和取消收藏
function likeAndDislike(music_id){
	var token=sessionStorage.getItem("token");
	if (token==null) {
		openLogin(400,250);
		return
	}
	var user_id=parseInt(sessionStorage.getItem("user_id"));
	var music_id=parseInt(music_id)
	console.log("user_id-music_id:"+user_id+"-"+music_id);
	addLike(user_id,music_id);
}

//上传者删除自己的音乐列表
function deleteTheMusic(music_id){
	deleteMusicById(music_id);//调用ajax进行数据交互
}
	function deleteMusicByIdSuccess(msg){//删除成功逻辑操作
		alert("music.js-deleteMusicByIdSuccess：音乐删除成功")
	}

//固定封面大小，固定音乐区域居中显示；
function selectMusicByPageRandomSuccessI(msg){//定义成功返回函数
	selectMusicByPageRandomSuccessISize(100,50,20,msg)//设置内容区域页面居中和上下边距
}
	function selectMusicByPageRandomSuccessISize(left,top,marginTop,msg){
		var area = document.getElementById("selectMusicByPageRandomArea");
		area.innerHTML=null;//先清空
		var w =window.innerWidth-2*left;//内容框架宽高//DIV-1
		var h=window.innerHeight-2*top;

		var left=(window.innerWidth-w)/2//内容框架页面居中的坐标
		var top=(window.innerHeight-h)/2
		area.style="position:absolute;left:"+left+"px;top:"+top+"px;width:"+w+"px;height:"+h+"px;"
		console.log("1-size finish");

		/*msg.length==15时*/
		var wm=w/6//区域框宽度高度
		var wh=h/3
		var m=marginTop;//图片框上边距
		var z=(wh-2*m)//每个封面图片的size
		for (var i = 0; i < msg.length;i++ ){
			var music_id=msg[i].music_id
	  		var title=msg[i].name
	  		var audio=msg[i].file//音乐路径
	  		var cover=msg[i].cover//封面路径
			var likes=msg[i].likes

			var html="<div style='width:"+wm+"px;height:"+wh+"px;float:right;text-align:center;'><div style='border:none;opacity:1;margin:"+m+"px auto;'onclick='sendId("+music_id+")' "
					+"onmousemove='dark(this.style)' onmouseout='reColor(this.style)'>"
					+"<a href='#'><img class='img-rounded' src=\""+cover+"\" width=\""+z+"px;\" height=\""+z+"px;\"style='border:1px solid white'></a></div></div>"
			$("#selectMusicByPageRandomArea").append(html)
		}
	}
		function dark(para){//this.style
			para.opacity=para.opacity-0.02;
		}
		function reColor(para){
			para.opacity=1
		}
function closeselectMusicByPageRandomArea(){
	var area = document.getElementById("selectMusicByPageRandomArea");
		area.style.display="none"
}
	function openselectMusicByPageRandomArea() {
		var area = document.getElementById("selectMusicByPageRandomArea");
		area.style.display="block"
	}



/*上传音乐模块*/
window.onload=uploadMusicContentCenter(400,650)
	/*页面居中*/
function uploadMusicContentCenter(width,height){
	var area=document.getElementById("uploadMusicContent");
	var w=window.innerWidth
	var h=window.innerHeight
	area.width=width+"px";//设置大小
	area.height=height+"px";
	var left=(w-width)/2;
	var top=(h-height)/2;
	area.style="position:absolute;left:"+left+"px;top:"+top+"px;"
}
	function showName(music){
		var name=document.getElementById("name")
		var files=music.files
		name.value=files[0].name;//把音频文件名赋值给name区域
		console.log("name:"+files[0].name)
		var URL=window.URL||window.webkitURL
		var audioSrc=URL.createObjectURL(files[0])//利用URL对象把文件对象弄成src路径
		var uploadAudio=document.getElementById("uploadAudio")
		uploadAudio.src=audioSrc
	}
	function showPicture(picture){
			var files=picture.files
			var URL=window.URL||window.webkitURL
			var imgSrc = URL.createObjectURL(files[0])
			var uploadPictureArea=document.getElementById("uploadPictureArea")
			uploadPictureArea.src=imgSrc
		}
// //获取音乐列表固定封面大小成功返回函数(效果不好，暂时不用)
// function selectMusicByPageRandomSuccess(msg){
// 	var area = document.getElementById("selectMusicByPageRandomArea");
// 		area.innerHTML=null;//清空区域内容
// 	setSelectMusicByPageRandomAreaSize(30);//坐标top值
// 	var x=setEveryCoverSize(msg.length,20,30);//参数1：列表音乐总数；参数2：每个音乐之间的间距margin;参数3：坐标top值
// 	for (var i = 0; i < msg.length; i++) {
// 				var music_id=msg[i].music_id
// 	  			var title=msg[i].name
// 	  			var audio=msg[i].file//音乐路径
// 	  			var cover=msg[i].cover//封面路径
// 	  			var likes=msg[i].likes

// 	  			// var html="<a href='#' onclick='sendId("+music_id+")' ><img src=\""+cover+"\" width=\""+x+"px\" height=\""+x+"px\"></a>"
// 	  			var html="<a href='#'><div style=\"width:"+x+"px;height:"+x+"px;background-image:url("+cover+");background-size: cover;float:right;\"></div></a>"
// 	  			$("#selectMusicByPageRandomArea").append(html)
// 	  			console.log("selectMusicByPageRandomSuccess finish")
// 			}		
// }			
// 	function setSelectMusicByPageRandomAreaSize(top){//设置音乐列表的区域的屏幕大小:参数-坐标top
// 		var w = window.innerWidth;
// 		var h = window.innerHeight-top;
// 		var x;var y=top;//开始坐标
// 		var area = document.getElementById("selectMusicByPageRandomArea")
// 		area.style="width:"+w+"px;height:"+h+"px;position:absolute;left:0px;top:"+y+"px;"
// 		console.log("setSelectMusicByPageRandomAreaSize：")
// 	}
// 		function setEveryCoverSize(length,margin,top){//根据音乐列表的音乐数量设置每个音乐的等宽高，margin为水平位置间距
// 			var area=document.getElementById("selectMusicByPageRandomArea");	
// 			var w=window.innerWidth;//父节点的宽高
// 			var h=Math.floor(w*9/16)-top;
// 			var mx;
// 			var my;
// 			var ex;
// 			if(length==15){			
// 					mx=margin;//margin-left&margin-right
// 					my=Math.floor(20*mx/18);//margin-top&margin-bottom
// 					ex=Math.floor((h-my*4)/3);//每个正方形封面区域的宽高
// 				}else if (length==28) {
// 					mx=margin;//margin-left&margin-right
// 					my=(Math.floor(20*mx/18));//margin-top&margin-bottom
// 					ex=(Math.floor((h-my*5)/4));//每个正方形封面区域的宽高
// 				}else if (length==45) {
// 					mx=margin;//margin-left&margin-right
// 					my=Math.floor(20*mx/18);//margin-top&margin-bottom
// 					ex=Math.floor((h-my*6)/5);//每个正方形封面区域的宽高
// 				}
// 			var contentStyle=document.getElementById("contentStyle")
// 				contentStyle.innerHTML="#selectMusicByPageRandomArea a div{margin:"+my+"px "+mx+"px;opacity:0.5}"

// 			console.log("length-marginx-marginy-ex:"+length+" "+mx+" "+my+" "+ex)
// 			console.log("window.innerHeight:"+window.innerHeight)
// 			console.log("setEveryCoverSize:")
// 			return ex;//返回每个放图片的边长x
// 		}