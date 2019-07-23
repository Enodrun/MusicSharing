//点播模块逻辑处理
/*点播收听.html*/
	// 模态登录框
	window.onload=openLogin(300,220)
	function openLogin(width,height){//页面居中
		var w=window.innerWidth;
		var h=window.innerHeight;
		var left=(w-width)/2
		var top=(h-height)/2

		var smsModel=document.getElementById("smsModel")//显示模态框
		smsModel.style.display="block"
			var smsLogin=document.getElementById("smsLogin")//居中登录框
			smsLogin.style="width:"+width+"px;height:"+height+"px;left:"+left+"px;top:"+top+"px;"
	}
		// 关闭模态框
		function closeLogin(){
			var smsModel=document.getElementById("smsModel")//关闭模态框
			smsModel.style.display="none"
		}

	// 打开并居中歌词框
	function openSmsLyric(width,height){
		closeSmsEdit()
		var w=window.innerWidth;
		var h=window.innerHeight;
		var left=(w-width)/2
		var top=(h-height)/2

		var smsLyric=document.getElementById("smsLyric")
		smsLyric.style.display="block"
			smsLyric.style="width:"+width+"px;height:"+height+"px;left:"+left+"px;top:"+top+"px;"
	}
//		关闭歌词框
		function closeSmsLyric(){
			var smsLyric=document.getElementById("smsLyric")
			smsLyric.style.display="none"
		}

	//打开留言框
	function openSmsEdit(width,height){
		closeSmsLyric()
		var w=window.innerWidth;
		var h=window.innerHeight;
		var left=(w-width)/2
		var top=(h-height)/2

		var smsEdit=document.getElementById("smsEdit")
		smsEdit.style.display="block"
			smsEdit.style="width:"+width+"px;height:"+height+"px;left:"+left+"px;top:"+top+"px;"
	}
		// 关闭留言框
		function closeSmsEdit(){
			var edit=document.getElementById("smsEdit")
			edit.style.display="none"
		}
		
/*登录交互逻辑*/
function selectSmsMusicBySmsIdAndCommandService(command){
	var urlLong=window.location.href;
	var url=urlLong.split("&")[0]
	console.log("url="+url);
	var command=command;
	// selectSmsMusicByTelAndCommand(sms_id,command)
	selectSmsMusicBySmsIdAndCommand(url,command);
}
	//音乐处理成功返回函数
	function selectSmsMusicBySmsIdAndCommandSuccess(res){
		console.log("ser-selectSmsMusicBySmsIdAndCommandSuccess:")
		var status=res.status;
//		var status=session.getItem()
		var msg=res.msg;
		if (msg!=null) {
			alert("登录成功");//登录成功则关闭登录框并写入音乐数据
		}else {
			alert("音乐口令有误，请重新登录")
			return;
		}
//		status=true;//测试
		console.log("status:"+status)
		if (status) {
			var vipControl=document.getElementById("vipControl")//token值验证成功显示控制区域
			vipControl.style.display="block"
			//写入数据
		}
		else {
			var listenerControl=document.getElementById("listenerControl")//token值验证成功显示控制区域
			listenerControl.style.display="block"
		}
		
		closeLogin();
		//写入数据到页面中
		var smsPlay=document.getElementById("smsPlay")
		smsPlay.src="../"+msg.music_path//音乐路径
			var smsBody=document.getElementById("smsBody")
			smsBody.style="background-image:url("+"../"+msg.picture_path+");"//封面背景图
//		var lyricArea=document.getElementById("lyricArea")
//		lyricArea.innerHTML=msg.words//测试，放歌词
			var title=document.getElementById("title")
			title.innerHTML=msg.title//放歌曲标题
		var wordsArea=document.getElementById("wordsArea")
		wordsArea.innerHTML=msg.words//放点播用户的信件内容
			var receive=document.getElementById("receive")
			receive.innerHTML=msg.receive//放收件人昵称
		var send=document.getElementById("send")
		send.innerHTML=msg.send//放发件人昵称
			var gotoLyric=document.getElementById("gotoLyric")
			gotoLyric.name=msg.sms_id//放发件人昵称
		

		// var callBack=document.getElementById("callBack")
		// callBack.onclick="callBack("+msg.sms_id+");showTel("+msg.tel+")"//设置回信按钮的触发函数
	}	
	
	//前往歌词编辑页面
	function gotoLyric(sms_id) {
		var url="lyric.html?sms_id="+sms_id;//带上歌曲参数
		window.location.href=url
		console.log("gotoLyric url:"+url)
	}
	
	
	
	
//	显示歌词内容
	function showLyric(){
		var classify;
		var key=  getParam()[0]/*键*/
		var music_id= getParam()[1]/*music_id*/
		if (key=="sms_id") {
			classify=1;
		}else if (key=="music_id") {
			classify=0;
		}
		listLyric(music_id,classify);/*请求数据*/
	}
//	根据url获取参数名和参数值
	function getParam() {
		var url=window.location.href
		console.log("url="+url);
		var array = url.split("?")//根据？切割字符串
		if (array.length>1) {
			var keyValue = array[1].split("=")//根据“=”切割得到参数名和参数值的键值对
			return keyValue;
		}else{
			return null;
		}
	}
		// 根据时间点放大歌词歌词
		var lastShow=null;//储存上一条改变样式的歌词id区域
		function changeLyricCss(){
			var time=Math.floor(document.getElementById("smsPlay").currentTime);
			var nowContent=document.getElementById(time);
			
			if(nowContent!=null){
				if (lastShow!=null) {
					lastShow.style="";//清空上一条歌词的样式
				}
			nowContent.style="color:yellow;backgroud-color:white;font-size:20px"
			lastShow=nowContent;//改变样式则把区域存储到外部对象直到下条歌词到来
			}
		}
	
		// 回信留言
		function callBack(){
			var sms_id=parseInt(getParam()[1])
			var wordsArea=document.getElementById("letter");
			var letter=wordsArea.value;
			updateSmsMusicByLetter(sms_id,letter)
		}
		
		// 分享函数
		function share(){
//			var url = window.location.href;
			var urlLong=window.location.href;
			var url=urlLong.split("&")[0]
			console.log("url="+url);
			ShareUrl(url);
		}
			function ShareUrlSuccess(msg){
				var qrcode=document.getElementById("qrcode")
				qrcode.style.display="block"
				qrcode.src="../"+msg;
				setTimeout("closeQRcode()","20000")
			}
				function closeQRcode(){
					var qrcode=document.getElementById("qrcode")
					qrcode.style.display="none"
				}
				//普通听众分享函数
				// 分享函数
				function share2(){
					var url = window.location.href;
					ShareUrl(url);
				}
					function ShareUrlSuccess2(msg){
						var qrcode=document.getElementById("qrcode2")
						qrcode.style.display="block"
						qrcode.src="../"+msg;
						setTimeout("closeQRcode2()","20000")
					}
						function closeQRcode2(){
							var qrcode=document.getElementById("qrcode2")
							qrcode.style.display="none"
						}
		/*//发短信函数
		function sendMassage(){
			alert("massage")
		}
		function showTel(){
			alert("tel")
		}*/