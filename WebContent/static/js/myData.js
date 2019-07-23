//
//// 模块功能
//function Login(){//登录
//	var name=document.getElementById("lname").value
//	var password=document.getElementById("lpassword").value
//	var tips=document.getElementById("tipsregister")//获取顶部提示框节点
//
//	var data={
//			"name":name,
//			"password":password,
//	}
//	var jsondata=JSON.stringify(data)
//	var url="/MusicSharing/login"
//	$.ajax({
//		type:"post",
//		url:url,
//		data:jsondata,
//		dataType:"json",
//		contentType:"application/json;charset=UTF-8",
//		success:function(res){
//				if (res.status==1) {
//					sessionStorage.setItem("token",res.token)//存token
//					sessionStorage.setItem("user",res.user)//存用户信息
//
//					tips.innerHTML=2
//					tips.style.color="blue"
//					tips.innerHTML="登陆成功：<span id=\"time\">3</span>跳转"
//					setInterval(clock,1000);
//				}else {
//					tips.innerHTML="登录失败，请重试"
//				}
//		}
//	})	
//}
//
//
//window.onload=myData()//加载数据
////提交表单后的操作流程:触发条件onsubmit
//function sinceSubmit(){
//	setTimeout('disable()',1000)//1秒后设为不可编辑
//	 var result = $("#result").innerHTML
//	 console.log("result:"+result)//判断更新操作结果
//
//	 myData()//更新个人数据
//}
//
////变成可编辑状态
//function change(){
//	var picture=document.getElementById("show")
//	var nick_name=document.getElementById("nick_name")
//
//	$("#nick_name").attr("readOnly",false)
//	$("#mail").attr("readOnly",false)
//
//	picture.disabled=false
//	submit.disabled=false
//	
//	var user_id=sessionStorage.getItem("user_id")
//	var token=sessionStorage.getItem("token")
//	var area=document.getElementById("area")//放置user_id
//	var userToken=document.getElementById("userToken")//放置user_id
//	area.value=user_id
//	userToken.value=token
//	
//	console.log("value:"+area.value+"token:"+userToken.value)
//
//}
////变回不可编辑状态
//function disable(){
//	var picture=document.getElementById("show")
//	var nick_name=document.getElementById("nick_name")
//
//	$("#nick_name").attr("readOnly","true")
//	$("#mail").attr("readOnly","true")
//
//	picture.disabled=false
//	submit.disabled=false
//
//	var result=$("#result").innerHTML
//	console.log("result:"+result)
//}
////获取个人资料
//function myData(){
//	var token=sessionStorage.getItem("token")
//	var user_id=sessionStorage.getItem("user_id")
//	console.log("myData:"+token+"+"+user_id)
//	
//	var data={
//		"user_id":user_id,
//		"token":token
//	}
//	var jsondata=JSON.stringify(data)
//	var url="/MusicSharing/getUserInfo"
//	$.ajax({
//		type:"post",
//		url:url,
//		data:jsondata,
//		dataType:"json",
//		contentType:"application/json;charset=UTF-8",
//		success:function(res){
//			if (res.status==1) {/*响应成功，显示个人资料*/
//				var user=res.msg
//				var show=document.getElementById("show")
//				show.src="../"+user.head_picture
//				console.log("show.src:"+show.src)
//				$("#nick_name").value=user.nick_name
//				$("#mail").value=mail
//			}else if(res.status==0){
//				alert("账户名失效，请重新登录！")
//			}else{
//				alert("系统错误，请稍后再试！")
//			}
//		}
//
//	})
//}
//
