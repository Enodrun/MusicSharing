//私信模块逻辑处理
//收件箱成功函数
function selectLetterByReceiveManSuccess(msg){
	console.log("letter.js-selectLetterByReceive:")
	var letterReadArea=document.getElementById("letterReadArea");
	letterReadArea.innerHTML=null;//先清空信箱内容再重新加载
	for (var i = 0; i < msg.length; i++) {
		var letter_id = msg[i].letter_id;
		var receive=msg[i].fk_user_receive;//我自己
		var send=msg[i].fk_user_send;
		var time=msg[i].datetime;
		var content=msg[i].content;
		var sendName=msg[i].sendName
		var html= "<div id="+letter_id+"><p>日期：<span>"+time+"</span></p><p>来自：<a href='#' onclick='letterSendTo("+send+")'><span>"+sendName+"</span></a></p><p style='text-indent: 2em'>"+content+"</p></div><hr><br>"	
		$("#letterReadArea").append(html)
	}
}

//发件箱成功函数
function selectLetterBySendManSuccess(msg){
	console.log("letter.js-selectLetterBySend:")
	var sendReadArea=document.getElementById("sendReadArea");
	sendReadArea.innerHTML=null;//先清空信箱内容再重新加载
	for (var i = 0; i < msg.length; i++) {
		var letter_id = msg[i].letter_id;
		var receive=msg[i].fk_user_receive;//我自己
		var send=msg[i].fk_user_send;
		var time=msg[i].datetime;
		var content=msg[i].content;
		var receiveName=msg[i].receiveName
		var html= "<div id="+letter_id+"><p>日期：<span>"+time+"</span></p><p>发给：<span><a href='#' onclick='letterSendTo("+receive+")'>"+receiveName+"</span></a></p><p style='text-indent: 2em'>"+content+"</p></div><hr><br>"	
		$("#sendReadArea").append(html)
	}
}

//打开私模块私信编辑框
function letterSendTo(toWho){
	openLetterArea(400,400,toWho)
}