//歌词模块逻辑处理
/*lyric.html*/
	window.onload=run();
	function run(){//业务主函数
		openSmsLyric(600,600);
		var keyValue=getParam();//获取键值对
		console.log("keyValue:"+keyValue[0])
		console.log("keyValue:"+keyValue[1])
		if (keyValue[0]=="music_id") {
			selectMusicById(keyValue[1])//执行查询
		}else if (keyValue[0]=="sms_id") {
			selectSmsMusicBySmsId(keyValue[1])//执行查询
		}
	}
	// 打开并居中歌词框
	function openSmsLyric(width,height){
		var w=window.innerWidth;
		var h=window.innerHeight;
		var left=(w-width)/2
		var top=(h-height)/2

		var smsLyric=document.getElementById("smsLyric")
			smsLyric.style="width:"+width+"px;height:"+height+"px;left:"+left+"px;top:"+top+"px;position:absolute;;overflow: scroll;background-color: rgb(0,0,0,0.5);border: 10px solid black;"
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
	
//	截取当前的时间节点
	var s=0;
	function getCurrentTime(music){	
		s=s+1;
		var t="t"+s;
		var l="l"+s;
		// alert(t[from+1]);
		if (s>100) {alert("最多只能插入100条歌词");return}
		var time=Math.floor(music.currentTime);
		var html="<tr><td class='t'><input type='text' readonly='true' value=\""+time+"\" name=\""+t+"\"></td>"
				+"<td class='c'><input type='text' name="+l+"></td><td><a class='d' href='#' onclick='this.parentNode.parentNode.innerHTML=null'>取消</a></td></tr>"
		// var lyric = document.getElementById("lyric")
		$("#lyric").append(html)
		// return time;
	}
	
//	序列化歌词，发送到后台
	function sendLyric(){
		var allKeyValue=$("form").serializeArray();//封装成json数组
		var music_id=document.getElementById("music").name//获取music_id
		var classify;
		
		var keyValue=getParam();//获取键值对
		if (keyValue[0]=="music_id") {
			classify=0;
		}else if (keyValue[0]=="sms_id") {
			classify=1;
		}
		
		addLyric(music_id,classify,allKeyValue)//调用ajax方法传递数据到后台
		console.log("allKeyValue:"+allKeyValue)
		console.log("music_id:"+music_id)
		console.log("classify:"+classify)
	}