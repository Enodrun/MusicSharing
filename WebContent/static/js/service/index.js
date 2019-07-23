// 主页
var w;//屏幕宽度
var h;//屏幕高度
var cleft;//页面居中x坐标
var ctop;//页面居中y坐标
var background=document.getElementById("background")
var nav=document.getElementById("nav")
var skin=document.getElementById("skin")
var contentStyle=document.getElementById("contentStyle")
var audioindex=document.getElementById("audioindex")
var body=document.getElementById("body")
/*登录注册*/
var loginindex=document.getElementById("loginindex");//登录注册按钮
var mask=document.getElementById("mask");//遮罩层
var login=document.getElementById("login")//登录框
var register=document.getElementById("register")//注册框


setInterval("setBackGround(13)",20000)//定时切换背景
// 主函数
function main(){
	setBackGround(13);//设置随机背景
//	audioCenter(300);//设置audio标签居中
	selectMusicByPageRandom(18);//加载音乐
}

/*1.随机设置背景图片*/
		function setBackGround(count){
			w=window.innerWidth;h=window.innerHeight;
			var array = new Array(count)
			if (w>h) {
				array[0]="UI/background/b1.jpg"
				array[1]="UI/background/b2.jpg"
				array[2]="UI/background/b3.jpg"
				array[3]="UI/background/b4.jpg"
				array[4]="UI/background/b5.jpg"
				array[5]="UI/background/b6.jpg"
				array[6]="UI/background/b7.jpg"
				array[7]="UI/background/b8.jpg"
				array[8]="UI/background/b9.jpg"
				array[9]="UI/background/b10.jpg"
				array[10]="UI/background/b11.jpg"
				array[11]="UI/background/b12.jpg"
				array[12]="UI/background/b13.jpg"
			}else{
				array[0]="UI/background/s1.jpg"
				array[1]="UI/background/s2.jpg"
				array[2]="UI/background/b3.jpg"
				array[3]="UI/background/b4.jpg"
				array[4]="UI/background/b5.jpg"
				array[5]="UI/background/b6.jpg"
				array[6]="UI/background/b7.jpg"
				array[7]="UI/background/b8.jpg"
				array[8]="UI/background/b9.jpg"
				array[9]="UI/background/b10.jpg"
				array[10]="UI/background/b11.jpg"
				array[11]="UI/background/b12.jpg"
				array[12]="UI/background/b13.jpg"
			}
			var i=Math.floor(Math.random()*count)
			body.style="background-image:url("+array[i]+");background-size:cover"
		}


/*2.打开遮罩层登录框，注册框，二维码显示框*/
		function openLogin(width,height){
			var mask=document.getElementById("mask")//登录框
			var login=document.getElementById("login")//登录框
			mask.style.display="block";login.style.display="block"		
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			login.style.width=w+"px";login.style.height=h+"px"
			login.style.left=x+"px";login.style.top=y+"px"
		}
		function openRegister(width,height){
			var mask=document.getElementById("mask")//登录框
			var register=document.getElementById("register")//注册框
			mask.style.display="block";register.style.display="block"	
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			register.style.width=w+"px";register.style.height=h+"px"
			register.style.left=x+"px";register.style.top=y+"px"
			
		}
		function openQRCode(width,height){
			var mask=document.getElementById("mask")
			var QRCode=document.getElementById("QRCode")
			mask.style.display="block";QRCode.style.display="block"		
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			QRCode.style.width=w+"px";QRCode.style.height=h+"px"
			QRCode.style.left=x+"px";QRCode.style.top=y+"px"
		}
/*打开左边功能区域*/
		function openArea(width,top){
			var token=sessionStorage.getItem("token");
			if (token==null) {
				openLogin(400,250);
				return
			}

			var area=document.getElementById("area");
			var w=width;var h=window.innerHeight-top;
			area.style.display="block"
			area.style.width=w+"px";area.style.height=h+"px"
		}
/*打开音乐播放区域*/
		function openPlayArea(width,height){
			var token=sessionStorage.getItem("token");
			if (token==null) {
				openLogin(400,250);
				return
			}
			
			var play=document.getElementById("playArea")
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			play.style.display="block"	
			play.style.width=w+"px";play.style.height=h+"px"
			play.style.left=x+"px";play.style.top=y+"px"

			var user_id=document.getElementById("uploadPersonPlayId").innerHTML
			var music_id=document.getElementById("music_idPlay").innerHTML
			getUserInfo(user_id)//调用ajax获取这首歌上传的用户名和id
			selectCommentByMusicId(music_id)
			console.log("index.js-openPlayArea："+music_id)
		}
/*打开私信编辑区域*/
		function openLetterArea(width,height,user_id){
			var area=document.getElementById("letterArea")
			var comment=document.getElementById("comment")//评论区域id，取收件人的用户名
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			area.style.display="block"	
			area.style.width=w+"px";area.style.height=h+"px"
			area.style.left=x+"px";area.style.top=y+"px"
//			把显示user_id换成user_name
			var from=sessionStorage.getItem("user_id")
			var to=user_id
			var FA=area.children[3]
			var TA=area.children[1]
			getUserNameLetterArea(from,to,FA,TA)
//			area.children[1].innerHTML=user_id//获取comment节点用户id
			setInterval(getNow,1000);//显示当前时间
//			area.children[3].innerHTML=sessionStorage.getItem("user_id")//获取我的用户名
			area.children[6].name=user_id//把收件人id赋值给button的name属性
		}
/*打开头像选择区域*/
		function openHeadPictureArea(width,height){
			var area=document.getElementById("headPictureArea")
			var w=width;var h=height;
			var x=cleft(w);var y=ctop(h);
			area.style.display="block"	
			area.style.width=w+"px";area.style.height=h+"px"
			area.style.left=x+"px";area.style.top=y+"px"
		}
/*3.关闭遮罩层登录注册框*/
		function closeMask(){
			var mask=document.getElementById("mask");//遮罩层
			var login=document.getElementById("login")//登录框
			var register=document.getElementById("register")//注册框
			var QRCode=document.getElementById("QRCode")//登录框
			login.style.display="none";register.style.display="none";mask.style.display="none"			
			QRCode.style.display="none";
		}
/*关闭功能区域*/
		function closeArea(){
			var area=document.getElementById("area");//遮罩层
			area.style.display="none";	
		}

/*关闭音乐播放区域*/
		function closePlayArea(){
			var commentArea=document.getElementById("comment")//清空评论区域
			commentArea.innerHTML=null
			var area=document.getElementById("playArea")
			area.style.display="none"
		}
//4.<audio>便签水平居中
function audioCenter(width){
	w=window.innerWidth;h=window.innerHeight;
	var xleft=(w-width)/2
	audioindex.style="position:absolute;left:"+ xleft+"px;width:"+width+"px;"
}
//短信点播登录判断
function shareUpload(id){
	var token=sessionStorage.getItem("token")
	if (token==null) {
		openLogin(400,250)
	}else{
		var area=document.getElementById(id)
		area.target="blank"
		area.href="page/短信点播.html"
	}
}
//上传音乐功能登录判断
function toUpLoad(id){
	var token=sessionStorage.getItem("token")
	if (token==null) {
		openLogin(400,250)
	}else{
		var area=document.getElementById(id)
		area.target="_blank"
		area.href="page/上传音乐.html"
	}
}
/*工具函数*/
function cleft(width){//获取居中的x坐标
	var w=window.innerWidth
	var cleft=(w-width)/2
	return cleft;
}
function ctop(height){//获取居中的y坐标
	var h=window.innerHeight
	var ctop=(h-height)/2
	return ctop;
}
function getNow(){//获取当前时间输出到私信编辑框
	var area=document.getElementById("letterArea")
	var now=new Date()
	area.children[4].innerHTML=now
}

window.onload=main()