package com.lee.test;
/* @Description:批量添加数据，进行演示
 * @author: loved
 * @date: 2019年4月6日 下午12:13:10
 */

import java.io.File;

import javax.servlet.jsp.jstl.tlv.PermittedTaglibsTLV;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.NamedNodeMap;

import com.lee.pojo.User;
import com.lee.pojo.Comment;
import com.lee.pojo.Letter;
import com.lee.pojo.Like;
import com.lee.pojo.Music;
import com.lee.service.CommentService;
import com.lee.service.LetterService;
import com.lee.service.LikeService;
import com.lee.service.MusicService;
import com.lee.service.SmsMusicService;
import com.lee.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddData {
	@Autowired
	private UserService userService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private SmsMusicService smsMusicService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private LetterService letterService;
	@Autowired
	private LikeService likeService;
	
	//User---user_id{38-68}
	static String[] name=new String[]{"Sophia","Emma","Olivia","Ava","Mia","Isabella"
									  ,"Zoe","Lily","Emily","Madison","Jackson","Aiden"
									  ,"Liam","Lucas","Noah","Mason","Ethan","Caden","Logan"
									  ,"Jacob","缺氧的气息","憂傷像光線","殇小魂","凌乱丿美","哪个刁民想害朕"
									  ,"沐晴つ","风掠幽蓝","冰萱★莉琬","流年梦","輓歌擾殘風"};
	//Music---music_id{195-342}
	static String[] file=new String[] {"Adele - Chasing Pavements","宗次郎 - いつも何度でも","幽兰操"
									  ,"古巨基 - 友共情","Nilotpala - Дорога Перемен"};
	static String[] words=new String[]{"沉淀一年，回归简单生活，用全新能量在第三张原创专辑当中活出自我l 部落格女孩Colbie Caillat、心灵投手James Morrison诚意跨刀献声！出生自维吉尼亚的一个朴实小镇的Jason Mraz，在纽约念大学的时候主修音乐剧，有一天他拿起吉他，突然发现自己的天命，于是便在毕业之后，跑到圣地亚哥当起街头艺人。在那段时期，他和自称是灵媒的流浪汉，成为心灵伙伴，他也开始四处流浪探索人生，并在这过程当中，很幸运地遇到生命中的贵人--知名音乐人鼓手Toca Rivera，两人一同演出的精彩现场表演，也成为当时美国西岸网络间，最广为流传的行家级必备珍藏。Jason Mraz这位出色的素人歌手，在2002顺利获得唱片合约，推出首张专辑“Waiting For My Rocket To Come”，专辑一推出，随即攻下全美热门潜力榜亚军，并获得了白金销售认证，当中的「The Remedy (I Won’t Worry)」、「You and I Both」也都成为传唱度极高的单曲。2005发行第二张原创大碟“Mr. A-Z”，甫发行即空降美国告示牌TOP5，而Jason擅长把玩文字的创意，也在这张专辑里作了更淋漓尽致的发挥。在发行了两张专辑、参加无数场现场表演、以及一连串的宣传行程之后，Jason决定把时间留给自己，他想利用一年的时间，让自己回归到一般生活里。他不打算安排任何的工作行程，只想简单地逛逛杂货店、亲手喂猫咪、自己洗衣服、照顾花园里的草木等…。在回归简单生活的几个月之后，奇妙的事发生了，源源不绝的创作灵感，不停自脑中满溢出来，Jason在这休息的过程里，慢慢地从自我了解到自我强化，一直到自我成长，而这些崭新的音乐能量，自然而然地汇集结成第三张原创专辑“We Sing, We Dance, We Steal Things”！ 「Make It Mine」作了有一点戏剧化的开场，积极的喜悦、真挚的热情、无虑的自在，我们都感受到了；如果想把大自然写成一首歌，「I`m Yours」就是最好的问候语，而Jason Mraz则会是最佳的翻译官，这首歌早已透过网络的传递，让许多人补充满满的好心情；部落格女孩Colbie Caillat(寇比凯蕾)和Jason Mraz的温暖情歌「Lucky」，让幸福以最简单的方式，提供随身携带的服务；心灵投手James Morrison和Jason Mraz，用彼此不同的声线，编织出「Details In The Fabric」的纹理分明；「The Dynamo Of Volition」一边在舌尖按下快转键，Jason一边大玩特玩他刚刚发现、叫做Acid Jazz的新玩具；带着简单的吉他声，一同来到夕阳满溢的时间回廊里，逆着时光前进的方向走，一个男人拉开身体的拉炼，发现里面住着一位受了伤的小男孩，双手紧握着「Love For A Child」这张泛黄的相片；十指轻敲浅岸水面，阵阵钢琴音符像连漪散开，令人心醉神迷，不知不觉走向水中央，「If It Kills Me」随着弦乐交织成的漩涡，一同慢慢陷入灭顶终点；爱的瞬间就像一场美丽核爆，而被毁灭后的世界荒芜残破，铺天盖地的寂寞尘埃，散落空中慢速纷飞，「Beautiful Mess」沙哑地叙述这场，无力招架、没有筹码的连锁效应！每个人的心里都住着一个孩子，曾经不想长大的Jason Mraz，这一次他终于弯下腰来，牵起那个跟他有着一样微笑的孩子，手拉着手一起走出自在的步伐。 "
									  ,"专辑的名字来自一位墨西哥艺术家Frida Kahlo给自己的一幅画的命名。\r\n" + 
									  		"　　在这张专辑制作的早期，三名乐队成员各自把对新专辑的想法都写在一张白板上，每一个人的想法都很激进前卫，最后，Chris Martin收回了他的看法。他希望以后有机会再游说他们。\"我听到波诺曾经说过一句话，'乐队不应该为钱而分裂，他们应该只为了歌曲名单而分裂，'”他说，在这一点上，没有什么比这更有针对性了。”\r\n" + 
									  		"　　乐队聘请了传奇制片人Brian Eno做他们第4张专辑的制作人。并且，他们有针对性地试图排除一切外来影响。吉他手Johnny Buckland说： \"我们感觉自己的头三张专辑是一个三部曲，我们已经完成了。因此，我们想要做一些不同的。\" 乐队让记者听了一下他们正在制作的歌曲小样，大多数听起来令人耳目一新， 完全不同于他们以往的热门歌曲“Clocks”和“Speed Of Sound”。\r\n" + 
									  		"　　好几首歌相当粗糙靠近边缘，伴随着扭曲的吉他和更加突出的敲击。歌词是暗色调的，反复出现了死亡和孤独的主题。其中有几首歌，Martin延长他的声带调色板，其表现大大超出了人们对他以往运用假声的理解，其音色低沉，性感，给人的感觉更个人，更真实。\"不管这样好还是不好，我们已经开始在音乐里融入更多的色彩。”Martin说。 \"取悦每一个人是不可能做到的，我们经历了这么长时间才体会到这一点。这样说让人觉得自由——可能没有一个人喜欢我们做的这些东西，但我们此时此刻就是想这样做，而且要把它做完为止。”\r\n" + 
									  		"　　在新专辑里，乐队探索了各种声波的方向，其中一些来自制作人呢Brain Eno的启发和鼓励。\"他不主观臆断，做出来的东西令人耳目一新。”Matin说。Buckland补充说， \"他不仅仅是带来声音或其他东西，他带来了对一切事情的想法，甚至具体到，怎样构筑我们渡过的这一天。他的建议让我们停下来，仔细考虑很多问题。” "
									  ,"周杰伦的出现，让人们相信台湾创造本土R&B的可能性；周杰伦的走红，彻底地宣布音乐新声代的来临。作曲、填词、编曲、演唱样样俱精的周杰伦，首张同名专辑《Jay杰伦》推出后，销售势如破竹，不单有“音乐新人王”称号，他自成一格的R&B演绎方法，更被誉为陶吉吉的劲敌。 顶着台湾金曲奖“最佳唱片”、“最佳制作人”的光环，周杰伦的第二张专辑《Fantasy(范特西)》终于在万千歌迷的期待中推出。这次杰伦依然一手包办所有作品的作曲，词的部份则延续第一张专辑的徐若？、方文山及他本人的铁三角。曲风较上张专辑更为的广泛，除了抒情歌及R&B外，杰伦还首次在歌中加入他在音乐班主修的大提琴，更有类似林普巴兹提特的摇滚及Hip-Hop曲风。 如今身价过亿新台币的杰伦在与BMG续约两张专辑的发行权后，有了更多的创作空间，在《范特西》中天马行空的音乐想法无处不在，就连歌名也都是令人意想不到的饶富趣味。有专门讲述日本忍者的“对不起”、因为喜爱看中国的武打电影而创作的“双截棍”等。第一主打曲“开不了口”由徐若？填的词、杰伦作曲，是一首描述生离死别的抒情作品。在Music Video中杰伦扮演一名宇航员，但却不幸意外身亡，之后又经历犹如电影《第六感生死恋》的天人永隔的无奈，故事情节令人心碎。 成功的跨出歌坛的第一步后，周杰伦成为现今台湾流行乐坛最抢手的创作人，而紧接他将会在11月举行大型的售票演唱会，年底还将大举进军日本，发行日本专辑，由此可见周杰伦的实力及威力都非常的惊人。 "		
									  };
	//Letter---letter_id{15-314}
	static String[] letters=new String[]{"第二张专辑依旧很高的品质，甚至可以说是他最经典的专辑（没有之一）。周杰伦和方文山这对完美组合的小宇宙大爆发诞生出这样的好作品，让《安静》、《双截棍》和《简单爱》一跃成为KTV常年热门的点唱歌曲，而《爱在西元前》、《爸我回来了》也是让我记忆深刻的歌！"
										,"十年来我只给两张专辑打满分，这是其一。"
										,"十来岁的记忆全部浓缩在这张专辑里；从它开始学会了怎样欣赏音乐，体验到了陶醉和沉浸的感觉"
										,"我也不知道为什么今天晚上就听了这张专辑。忽然就想起很多小时候的事。这张专辑出来的时候应该是我初中毕业的那年暑假。他当时还是小众。还是某种独特品位的代表。现在可以叫做标杆了吧？哈。" 
										,"这些淡淡的透满清纯的调调。现在听着总想微微上扬嘴角，对浮现出的种种曾经或者正在的青涩表现某种不屑的释然。"
										};
	//Comment---comment_id{176-44575}
	static String[] comments=new String[]{"这是一张非常清淡的专辑。不管是什么样的你，都会随着音乐慢慢平静下来，然后怀恋下自己曾经的初恋和当年自己的傻呵呵。 人生其实很长，很美好，不是吗？"
										 ,"天才就是天才。有生之年我一定要去听你现场。"
										 ,"没有令我为之一震的兴奋，可是这类歌曲本来就容易招人喜爱。"
										 ,"好多歌都听了无数次[i'm yours,lusky,butterfly,love for a child]"
										 ,"年纪大了 竟听不懂歌里的故事"
										 ,"哎呀我觉得很不错也~"
										 ,"爱上某个事物，真的只是一瞬间的事情。"
										 ,"那时我们在听的一首歌，叫做《Curbside Prophet》。"
										 ,"虽然看起来有点像没心没肺，但于我而言，能够始终牢记世界的明媚，并学会在一切麻烦事前保持微笑，就是人生的至high境界了。"
										 ,"以为带上耳机大声唱人人都会跟着叫，其实只有寝室的人知道自己今天羊癫疯又没有吃药。"
										};
//	@Test
	public void register() {
		User user = new User();
		for (int i = 0; i < name.length; i++) {
			user.setName(name[i]);
			user.setNick_name(name[i]);
			user.setPassword("12345678");
			user.setHead_picture("http://localhost:8080/MusicSharing/static/images/head/"+((int)(Math.random()*11)+1)+".jpg");
			user.setMail("1061673303@qq.com");
			userService.addUser(user);
			System.out.println(user.toString());
		}
	}
	
	
//	@Test
	public void Music() {
		Music music = new Music();
		for (int i = 0; i < 148; i++) {
			int j=(int)(Math.random()*5);
			music.setFk_user_id(((int)(Math.random()*(68-38)+39)));
			music.setCover("images/cover ("+i+").JPG");
			music.setFile("files/"+file[j]+".mp3");
			music.setName(file[j]+".mp3");
			music.setLikes((int)(Math.random()*999));
			music.setWords(words[(int)Math.random()*3]);
			musicService.addMusic(music);
			System.out.println(music.toString());
		}
	}
	
//	@Test
	public void like() {
		Like like = new Like();
		for (int i = 39; i < 69; i++) {
			for (int j = 195; j <343; j++) {
				like.setFk_user_id(i);
				like.setFk_music_id(j);
				likeService.addLike(like);
				System.out.println(like.toString());
			}
		}
	}
	
//	@Test
	public void letter() {
		Letter letter = new Letter();
		for (int i = 0; i < letters.length; i++) {
			for (int j = 39; j < 69; j++) {
				int user_id=(int)(Math.random()*(68-39))+40;
				letter.setFk_user_send(j);
				letter.setFk_user_receive(user_id);
				letter.setContent(letters[i]);
				letterService.addLetter(letter);
				System.out.println(letter.toString());
				letter.setFk_user_send(user_id);
				letter.setFk_user_receive(j);
				letterService.addLetter(letter);
				System.out.println(letter.toString());
			}
		}
	}
	
	@Test
	public void comment() {
		Comment comment = new Comment();
		for (int i = 39; i < 69; i++) {
			for (int j = 195; j < 343; j++) {
				for (int j2 = 0; j2 < comments.length; j2++) {
					comment.setFk_user_id(i);
					comment.setFk_music_id(j);
					comment.setContent(comments[j2]);
					commentService.addComment(comment);
					System.out.println(comment.toString());
				}
			}
		}
	}
}

