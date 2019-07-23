//点播模块逻辑处理
/*smsMusic.html*/
/*页面居中*/
window.onload=uploadMusicContentCenter(550,580);
function uploadMusicContentCenter(width,height){
	var area=document.getElementById("letterArea");
	var w=window.innerWidth
	var h=window.innerHeight
	var left=(w-width)/2;
	var top=(h-height)/2;
	area.style="position:absolute;z-index:10000;left:"+left+"px;top:"+top+"px;border: 10px solid transpant;border-radius: 30px;padding:50px;float:left;width:"+width+"px;height:"+height+"px;"
}
	function showName(music){
		var name=document.getElementById("name")
		var title=document.getElementById("title")
		var files=music.files
		name.innerHTML=files[0].name;//把音频文件名赋值给name区域
		title.value=files[0].name;//把音频文件名赋值给title输入框
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
			var uploadPictureArea=document.getElementById("smsContentArea")
			uploadPictureArea.style="background-image: url("+imgSrc+");background-size: cover"
			console.log("picture finish")
		}

//查看点播列表成功返回函数
function listSmsMusicToPlaySuccess(msg){
	var listArea=document.getElementById("smsMusicListArea")//点播列表
	listArea.innerHTML=null;
	var letterArea=document.getElementById("smsMusicInfoArea")//历史点播
	letterArea.innerHTML=null;
	for (var i = 0; i <msg.length; i++) {
		var command=msg[i].command
		var datetime=msg[i].datetime
		var music_path=msg[i].music_path
		var picture_path=msg[i].picture_path
		var receive=msg[i].receive
		var send=msg[i].send
		var sms_id=msg[i].sms_id
		var title=msg[i].title
		var url=msg[i].url
		var words=msg[i].words
		var letter=msg[i].letter

		var htmlA="<tr><td><a href='#' onclick='toPlaySms("+sms_id+")'>"+title+"</a></td><td><a href='#' onclick='toUrl("+sms_id+")'>"+sms_id+"</a></td><td><a href='#' onclick='shareSmsUrlService("+sms_id+")'>分享</a></td></tr>"
		$("#smsMusicListArea").append(htmlA)
		
		var html="<tr><td><p>日期：<span>"+datetime+"</span></p><p>歌曲标题：<span>"+"" +
				"<a href='#' onclick='toPlaySms("+sms_id+")'>"+title+"</a></span></p>" +
				"<p>歌曲id：<span>"+sms_id+"</span></p><p>音乐口令：<span>"+command+"</span></p>" +
				"<p>音乐寄语：</p><p style='text-indent: 2em'>"+words+"</p>"+
				"<p>回信留言：</p><p style='text-indent: 2em'>"+letter+"</p>"+
				"<p><a href='#' onclick='toUrl("+sms_id+")'>前往收听页面</a></p>"+
				"</td></tr>"
		$("#smsMusicInfoArea").append(html)
	}
}
	function toPlaySms(sms_id){//在本页播放sms_music
		selectSmsMusicBySmsId(sms_id)
	}
	function selectSmsMusicBySmsIdSuccess(msg) {
		var	audioindex=document.getElementById("audioindex")
	    var	titleindex=document.getElementById("titleindex")
	    titleindex.innerHTML=msg.title
	    audioindex.src=msg.music_path
	}
		function toUrl(sms_id){//前往sms_music收听页面
				window.open("page/sound.html?sms_id="+sms_id)
			}
			function shareSmsUrlService(sms_id){//用二维码分享收听地址
				var host=window.location.host//获取主机名和端口号
				var url = host+"/MusicSharing/static/page/sound.html?sms_id="+sms_id
				shareSmsUrl(url)//调用ajax请求
			}
			function shareSmsUrlSuccess(msg){
				openQRCode(200,200)
				var url=msg
				var QRCodeImg=document.getElementById("QRCodeImg")
				QRCodeImg.src=url
				setTimeout("closeQRCode()",20000)
			}
			function closeQRCode(){
				var mask=document.getElementById("mask");//遮罩层
				var QRCode=document.getElementById("QRCode")//登录框
				QRCode.style.display="none";mask.style.display="none"			
			}