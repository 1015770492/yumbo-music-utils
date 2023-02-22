CSDN 博客 ：[Java版本中最好用的网易云音乐、qq音乐api请求工具，你还在忙于如何使用java调音乐api？来看下这里的实现](https://yumbo.blog.csdn.net/article/details/112331151)

作者：诗水人间

关注我，博客中还有关于QQ音乐和网易云音乐服务器的快速搭建，包括利用自己空闲电脑搭建一台属于自己的高带宽，高性能的公网服务器哦。

你是否看过下面两个音乐api，想要通过java去调用api，但有觉得麻烦呢
#### 在线文档：
#### [一、QQ音乐API在线文档](https://jsososo.github.io/QQMusicApi/#/)
#### [二、网易云音乐API在线文档](https://neteasecloudmusicapi.vercel.app/#/)

### 已经封装好网易云音乐api和QQ音乐api 的所有API，只需要调用我封装好的类就可以快捷调用文档获取数据
### 项目说明：
本项目中使用到的依赖：
spring-web、lombok、fastjson
```xml
<!-- 爬虫框架jsoup -->
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.3</version>
</dependency>
<!-- spring-web依赖，这个工具需要使用里面的RestTemplate工具 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.3.14</version>
</dependency>
<!-- fastjson 工具类 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.79</version>
</dependency>
<!-- lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.16</version>
    <scope>provided</scope>
</dependency>
```
NeteaseCloudMusicInfo 类的方法上自带文档，文档为2021年的接口文档。与在线文档对应（在线文档有更新的话自行更新）

![Netease Music](https://img-blog.csdnimg.cn/73ce36b3f3ac43608c368834378f2ce5.png)

QQMusicInfo 也一样有对应的方法标注文档。
![QQ Music](https://img-blog.csdnimg.cn/b5c165c6b1b545f5ac10ef2bc7351abd.png)


### 第一步、引入maven依赖
gav坐标如下

```xml
<dependency>
  <groupId>top.yumbo.music</groupId>
  <artifactId>yumbo-music-utils</artifactId>
  <version>1.2.3</version>
</dependency>
```
仓库如果找不到，请使用新版的阿里云镜像仓库地址
```xml
<repositories>
    <repository>
        <id>alimaven</id>
        <name>aliyun maven</name>
        <!-- 新版本的aliyun镜像仓库地址建议mirrors中也修改，
             如果已经改好了，则可以去掉这个repositories -->
        <url>https://maven.aliyun.com/repository/central</url>
    </repository>
</repositories>
```
### 第二步、使用NeteaseCloudMusicInfo类和 QQMusicInfo类调用封装好的方法

#### NeteaseCloudMusicInfo类和 QQMusicInfo类的特点
根据音乐api文档进行的封装
方法的命名采用驼峰命名。
例如文档中的接口是：/search/hot，则对应的方法就是：searchHot

***
### 网易云音乐
##### 例如网易云音乐的 登录接口

1. 手机登录
必选参数 :
phone: 手机号码
password: 密码

可选参数 :
countrycode: 国家码，用于国外手机号登录，例如美国传入：1
md5_password: md5加密后的密码,传入后 password 将失效

接口地址 : /login/cellphone
###### 调用接口案例
```java
import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;
public class NeteaseCloudMusicDemo {

    public static void main(String[] args) {
        final NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();// 得到封装网易云音乐信息的工具类
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","xxx@163.com");
        jsonObject.put("password","xxx");
        final JSONObject login = neteaseCloudMusicInfo.login(jsonObject);
        System.out.println(login);
    }
}
```
###### 控制台输出的内容信息如下
```bash
当前执行:class top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo.loginCellphone()
请求的相对路径:/login/cellphone
绝对路径:http://yumbo.top:3000/login/cellphone
解析前cookie是[__csrf=18c53665c73fa287455cb50e9f69327c; Max-Age=1296010; Expires=Sat, 23 Jan 2021 06:20:55 GMT; Path=/;, NMTID=00OtqtFtH3PJDbk5kOzsPSR_4AUU38AAAF24KeM-w; Max-Age=315360000; Expires=Mon, 6 Jan 2031 06:20:45 GMT; Path=/;, MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd729fa545a9fe12faf9cb4377b2d7ba249; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:20:45 GMT; Path=/;, __remember_me=true; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:20:45 GMT; Path=/;]
解析后cookie是:[__csrf=18c53665c73fa287455cb50e9f69327c; NMTID=00OtqtFtH3PJDbk5kOzsPSR_4AUU38AAAF24KeM-w; MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd729fa545a9fe12faf9cb4377b2d7ba249; __remember_me=true; ]
{"code":200,"cookie":"__csrf=18c53665c73fa287455cb50e9f69327c; Max-Age=1296010; Expires=Sat, 23 Jan 2021 06:20:55 GMT; Path=/;;NMTID=00OtqtFtH3PJDbk5kOzsPSR_4AUU38AAAF24KeM-w; Max-Age=315360000; Expires=Mon, 6 Jan 2031 06:20:45 GMT; Path=/;;MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd729fa545a9fe12faf9cb4377b2d7ba249; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:20:45 GMT; Path=/;;__remember_me=true; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:20:45 GMT; Path=/;","loginType":1,"profile":{"birthday":-2209017600000,"backgroundUrl":"https://p3.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","detailDescription":"","gender":0,"city":360700,"signature":"","followeds":0,"description":"","eventCount":0,"playlistBeSubscribedCount":0,"accountStatus":0,"avatarImgId":109951163250239070,"defaultAvatar":true,"avatarImgIdStr":"109951163250239066","backgroundImgIdStr":"109951162868128395","province":360000,"nickname":"15727742367","djStatus":0,"avatarUrl":"https://p3.music.126.net/RLeBJe4D1ZzUtltxfoKDMg==/109951163250239066.jpg","authStatus":0,"follows":3,"vipType":0,"userId":2100084321,"followed":false,"mutual":false,"avatarImgId_str":"109951163250239066","authority":0,"backgroundImgId":109951162868128400,"userType":0,"experts":{},"playlistCount":1},"bindings":[{"expiresIn":2147483647,"expired":false,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"15727742367\",\"hasPassword\":true}","refreshTime":1578119342,"id":7022519084,"type":1,"bindingTime":1578119342761,"userId":2100084321,"url":""},{"expiresIn":7776000,"expired":false,"tokenJsonStr":"{\"access_token\":\"4BE56F3B4BF64E46A80E5144524EFFFE\",\"refresh_token\":\"2DA74DF7E83C87A9E7EFC7E5DE57A6C4\",\"unionid\":\"UID_7AC14222287896DF396B93A9B5CF9CBF\",\"openid\":\"89F4447EE0B34DE1281134C732D7F226\",\"nickname\":\"过去很遥远\",\"expires_in\":7776000}","refreshTime":1610044293,"id":10644862308,"type":5,"bindingTime":1591609837921,"userId":2100084321,"url":""}],"account":{"salt":"[B@32598d1d","vipType":0,"userName":"1_15727742367","type":1,"ban":0,"anonimousUser":false,"createTime":1578119342759,"tokenVersion":2,"id":2100084321,"whitelistAuthority":0,"baoyueVersion":0,"viptypeVersion":0,"donateVersion":0,"status":0},"token":"7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd729fa545a9fe12faf9cb4377b2d7ba249"}
```
最后一串字符串就是登录成功后返回的信息

##### 需要登录的接口调用处理方式
网易云音乐 有些接口需要进行登录才可调用,对于需要登录的接口,只要通过一个工具类NeteaseCloudMusicInfo进行调用即可
###### 第一步、调用登录，也就是上面的测试案例，这个时候cookie会被保存，对于需要登录的接口这个时候就可以直接调用了
 例如：
```java
import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;

public class NeteaseCloudMusicDemo {

    public static void main(String[] args) {
        final NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();// 得到封装网易云音乐信息的工具类
        String cookie = null;
        try {
            /*将下面代码加入到 public/qrlogin.html 中 alert('授权登录成功') 前面，然后启动网易云音乐的nodejs服务器
            目的是得到用户扫描登录后，java通过监听端口得到cookie信息，也可以选择console.log 打印cookie，
            然后利用内置的setCookieString给请求设置cookie这样就可以正常调用api
                  await axios({
                    url: `http://localhost:9999?cookie=${statusRes.cookie}`,
                  })
             */
            cookie = ChromeUtil.getCookie();
            System.out.println(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        neteaseCloudMusicInfo.setCookieString(cookie);

        final JSONObject parameter = new JSONObject();// 请求参数
        parameter.put("keywords", "我还年轻");
        final JSONObject jsonObject = neteaseCloudMusicInfo.cloudsearch(parameter);// 调用网易云的热搜服务
        final JSONArray result = jsonObject.getJSONObject("result").getJSONArray("songs");
        result.forEach(System.out::println);
    }
}
```

控制台中的打印信息如下：
```bash
当前执行:class top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo.cloudsearch()
请求的相对路径:/cloudsearch
绝对路径:http://localhost:3000/cloudsearch
解析前cookie是[NMTID=00Op0BFPRYL7k7-ZkeZp7evRqs5OgYAAAGGeiOafQ; Max-Age=315360000; Expires=Sat, 19 Feb 2033 17:19:59 GMT; Path=/;]
解析后cookie是:[NMTID=00Op0BFPRYL7k7-ZkeZp7evRqs5OgYAAAGGeiOafQ; ]
{"no":3,"copyright":0,"fee":1,"privilege":{"flag":1028,"dlLevel":"none","subp":1,"fl":0,"fee":1,"dl":0,"plLevel":"none","maxBrLevel":"lossless","maxbr":999000,"id":509512457,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":1},{"rate":192000,"chargeType":1},{"rate":320000,"chargeType":1},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"lossless","cp":1,"preSell":false,"playMaxBrLevel":"lossless","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"none","pl":0},"mst":9,"pst":0,"pop":100,"dt":347058,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":509512457,"lyrics":["<b>我还年轻</b>","他们都说","我们把理想都忘在","在那轻狂的日子里","我不哭泣","我不逃避","给我一瓶酒","再给"],"sq":{"br":950710,"fid":0,"size":41243957,"vd":-35023,"sr":48000},"st":0,"cd":"1","publishTime":1506528000000,"cf":"","originCoverType":0,"h":{"br":320000,"fid":0,"size":13884648,"vd":-35023,"sr":44100},"mv":10865779,"al":{"picUrl":"http://p3.music.126.net/Hv7hvn2lx1wt7Zp0R1y5wg==/109951163032704992.jpg","name":"吾十有五而志于学","tns":[],"pic_str":"109951163032704992","id":36412383,"pic":109951163032705000},"l":{"br":128000,"fid":0,"size":5553885,"vd":-35023,"sr":44100},"m":{"br":192000,"fid":0,"size":8330806,"vd":-35023,"sr":44100},"version":30,"cp":1400821,"alia":["Teens Edge"],"djId":0,"single":0,"ar":[{"name":"老王乐队","tns":[],"alias":[],"id":12676071}],"ftype":0,"t":0,"v":30,"name":"我还年轻 我还年轻","tns":["Teens Edge"],"mark":8192}
{"no":8,"rt":"","copyright":2,"fee":8,"privilege":{"flag":2,"dlLevel":"none","subp":1,"fl":128000,"fee":8,"dl":0,"plLevel":"standard","maxBrLevel":"exhigh","maxbr":320000,"id":1296893537,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":1},{"rate":320000,"chargeType":1},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":320000,"downloadMaxBrLevel":"exhigh","cp":1,"preSell":false,"playMaxBrLevel":"exhigh","cs":false,"toast":false,"playMaxbr":320000,"flLevel":"standard","pl":128000},"mst":9,"pst":0,"pop":100,"dt":213002,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1296893537,"lyrics":["<b>我还年轻</b>","他们都说","我们把理想都忘在","在那轻狂的日子里","我不哭泣","我不逃避","给我一瓶酒","再给"],"st":0,"cd":"01","publishTime":1518278400000,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":8529546,"vd":-35244,"sr":44100},"mv":0,"al":{"picUrl":"http://p3.music.126.net/QcPmEF4s16kfXo0SbBjAGA==/109951164590805849.jpg","name":"我还年轻 我还年轻","tns":[],"pic_str":"109951164590805849","id":84620627,"pic":109951164590805860},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":509512457,"albumMeta":{"name":"吾十有五而志于学","id":36412383}},"l":{"br":128000,"fid":0,"size":3411844,"vd":-35244,"sr":44100},"m":{"br":192000,"fid":0,"size":5117745,"vd":-35244,"sr":44100},"version":64,"cp":0,"alia":[],"djId":0,"single":0,"ar":[{"name":"张叶蕾","tns":[],"alias":[],"id":12213291}],"ftype":0,"t":0,"v":64,"name":"我还年轻 我还年轻","mark":64}
{"no":1,"rt":"","copyright":0,"fee":0,"privilege":{"flag":0,"dlLevel":"exhigh","subp":1,"fl":320000,"fee":0,"dl":320000,"plLevel":"exhigh","maxBrLevel":"exhigh","maxbr":320000,"id":1399869580,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":0},{"rate":320000,"chargeType":0},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":320000,"downloadMaxBrLevel":"exhigh","cp":1,"preSell":false,"playMaxBrLevel":"exhigh","cs":false,"toast":false,"playMaxbr":320000,"flLevel":"exhigh","pl":320000},"mst":9,"pst":0,"pop":100,"dt":387004,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1399869580,"st":0,"cd":"01","publishTime":1572278400000,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":15482297,"vd":-62358,"sr":44100},"mv":0,"al":{"picUrl":"http://p4.music.126.net/--w_fkOOk_zt2Xjxk17aYw==/109951164456284814.jpg","name":"我还年轻 (抖音DJ版)","tns":[],"pic_str":"109951164456284814","id":82826694,"pic":109951164456284820},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":509512457,"albumMeta":{"name":"吾十有五而志于学","id":36412383}},"l":{"br":128000,"fid":0,"size":6192945,"vd":-58188,"sr":44100},"m":{"br":192000,"fid":0,"size":9289395,"vd":-59800,"sr":44100},"version":5,"cp":1413823,"alia":[],"djId":0,"single":0,"ar":[{"name":"抖音热歌DJ","tns":[],"alias":[],"id":33211729}],"ftype":0,"t":0,"v":5,"name":"我还年轻 (抖音DJ版) (翻自 老王乐队)","mark":0}
{"no":1,"rt":"","copyright":0,"fee":8,"hr":{"br":1797889,"fid":0,"size":44278223,"vd":-65436,"sr":48000},"privilege":{"flag":4,"dlLevel":"none","subp":1,"fl":128000,"fee":8,"dl":0,"plLevel":"standard","maxBrLevel":"hires","maxbr":999000,"id":2019574452,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":1},{"rate":320000,"chargeType":1},{"rate":999000,"chargeType":1},{"rate":1999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"hires","cp":1,"preSell":false,"playMaxBrLevel":"hires","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"standard","pl":128000},"mst":9,"pst":0,"pop":100,"dt":197023,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":2019574452,"lyrics":["<b>我还年轻</b>","他们都说","我们把理想都忘在","在那轻狂的日子里","我不哭泣 我不逃避","给我一瓶酒","再"],"sq":{"br":1027936,"fid":0,"size":25315906,"vd":-65608,"sr":48000},"st":0,"cd":"01","publishTime":0,"cf":"","originCoverType":0,"h":{"br":320002,"fid":0,"size":7883565,"vd":-65371,"sr":48000},"mv":0,"al":{"picUrl":"http://p3.music.126.net/qCg52QcM8rT7-NDW0CFmrQ==/109951168280110182.jpg","name":"JJ的咖啡调调, Vol. 2","tns":[],"pic_str":"109951168280110182","id":159400773,"pic":109951168280110180},"l":{"br":128002,"fid":0,"size":3153453,"vd":-61382,"sr":48000},"m":{"br":192002,"fid":0,"size":4730157,"vd":-62820,"sr":48000},"version":4,"cp":7001,"alia":[],"djId":0,"single":0,"ar":[{"name":"林俊杰","tns":[],"alias":["JJ Lin","Wayne Lim"],"id":3684,"alia":["JJ Lin","Wayne Lim"]}],"ftype":0,"t":0,"v":4,"name":"我还年轻 我还年轻","mark":536879104}
{"no":9,"copyright":2,"fee":8,"privilege":{"flag":2,"dlLevel":"none","subp":1,"fl":128000,"fee":8,"dl":0,"plLevel":"standard","maxBrLevel":"exhigh","maxbr":320000,"id":1305960097,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":1},{"rate":320000,"chargeType":1},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":320000,"downloadMaxBrLevel":"exhigh","cp":1,"preSell":false,"playMaxBrLevel":"exhigh","cs":false,"toast":false,"playMaxbr":320000,"flLevel":"standard","pl":128000},"mst":9,"pst":0,"pop":100,"dt":213002,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1305960097,"lyrics":["<b>我还年轻</b>","他们都说","我们把理想都忘在","在那轻狂的日子里","我不哭泣","我不逃避","给我一瓶酒","再给"],"st":0,"cd":"01","publishTime":1518278400000,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":8529546,"vd":-33863,"sr":44100},"mv":0,"al":{"picUrl":"http://p4.music.126.net/7vS0rSUV9ZlkPsb6EMDQHg==/109951163240642570.jpg","name":"张叶蕾的翻唱","tns":[],"pic_str":"109951163240642570","id":37587305,"pic":109951163240642580},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":509512457,"albumMeta":{"name":"吾十有五而志于学","id":36412383}},"l":{"br":128000,"fid":0,"size":3411844,"vd":-33863,"sr":44100},"m":{"br":192000,"fid":0,"size":5117745,"vd":-33863,"sr":44100},"version":54,"cp":0,"alia":[],"djId":0,"single":0,"ar":[{"name":"张叶蕾","tns":[],"alias":[],"id":12213291}],"ftype":0,"t":0,"v":54,"name":"我还年轻我还年轻 （无念白）","mark":64}
{"no":1,"rt":"","copyright":0,"fee":0,"privilege":{"flag":129,"dlLevel":"lossless","subp":1,"fl":320000,"fee":0,"dl":999000,"plLevel":"exhigh","maxBrLevel":"lossless","maxbr":999000,"id":1909731049,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":0},{"rate":320000,"chargeType":0},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"lossless","cp":1,"preSell":false,"playMaxBrLevel":"lossless","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"exhigh","pl":320000},"mst":9,"pst":0,"pop":80,"dt":327900,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1909731049,"sq":{"br":1590753,"fid":0,"size":65201222,"vd":-49246,"sr":48000},"st":0,"cd":"01","publishTime":0,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":13118445,"vd":-49248,"sr":48000},"mv":0,"al":{"picUrl":"http://p3.music.126.net/MvRc_OSY0T1o4sG3Fcg3Rw==/109951166738857278.jpg","name":"FC","tns":[],"pic_str":"109951166738857278","id":137627731,"pic":109951166738857280},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":1294889219,"albumMeta":{"name":"这个世界让你紧张害怕吗？","id":71852932}},"l":{"br":128000,"fid":0,"size":5247405,"vd":-44859,"sr":48000},"m":{"br":192000,"fid":0,"size":7871085,"vd":-46625,"sr":48000},"version":6,"cp":0,"alia":[],"djId":0,"single":0,"ar":[{"name":"世杰_Vincent","tns":[],"alias":[],"id":34819898}],"ftype":0,"t":0,"v":6,"name":"我还年轻我还年轻","mark":128}
{"no":8,"rt":"","copyright":0,"fee":1,"hr":{"br":1686758,"fid":0,"size":67389361,"vd":-39454,"sr":48000},"privilege":{"flag":1028,"dlLevel":"none","subp":1,"fl":0,"fee":1,"dl":0,"plLevel":"none","maxBrLevel":"hires","maxbr":999000,"id":1425818639,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":1},{"rate":192000,"chargeType":1},{"rate":320000,"chargeType":1},{"rate":999000,"chargeType":1},{"rate":1999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"hires","cp":1,"preSell":false,"playMaxBrLevel":"hires","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"none","pl":0},"mst":9,"pst":0,"pop":100,"dt":319616,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1425818639,"lyrics":["<b>我还年轻</b>","他们都说 我们把理想都忘在","在那轻狂的日子里 我不哭泣 我不逃"],"sq":{"br":917418,"fid":0,"size":36652692,"vd":-39467,"sr":48000},"st":0,"cd":"01","publishTime":0,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":12787245,"vd":-39457,"sr":48000},"mv":0,"al":{"picUrl":"http://p3.music.126.net/OuL80LuI347696oR98b3SA==/109951164738867906.jpg","name":"歌手·当打之年 第4期","tns":[],"pic_str":"109951164738867906","id":85967630,"pic":109951164738867900},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":509512457,"albumMeta":{"name":"吾十有五而志于学","id":36412383}},"l":{"br":128000,"fid":0,"size":5114925,"vd":-35167,"sr":48000},"m":{"br":192000,"fid":0,"size":7672365,"vd":-36868,"sr":48000},"version":7,"cp":1416682,"alia":[],"djId":0,"single":0,"ar":[{"name":"徐佳莹","tns":[],"alias":["LaLa Hsu"],"id":9940,"alia":["LaLa Hsu"]}],"ftype":0,"t":0,"v":7,"name":"我还年轻 我还年轻 (Live)","mark":536879104}
{"no":1,"rt":"","copyright":0,"fee":0,"privilege":{"flag":129,"dlLevel":"lossless","subp":1,"fl":320000,"fee":0,"dl":999000,"plLevel":"exhigh","maxBrLevel":"lossless","maxbr":999000,"id":1872223128,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":0},{"rate":320000,"chargeType":0},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"lossless","cp":1,"preSell":false,"playMaxBrLevel":"lossless","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"exhigh","pl":320000},"mst":9,"pst":0,"pop":20,"dt":226952,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1872223128,"sq":{"br":1485399,"fid":0,"size":42139457,"vd":-31133,"sr":44100},"st":0,"cd":"01","publishTime":0,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":9081252,"vd":-31132,"sr":44100},"mv":0,"al":{"picUrl":"http://p4.music.126.net/H6iQ5Icj19s5CWIN8qdnmQ==/109951167568418917.jpg","name":"摇滚！滚起来！！！","tns":[],"pic_str":"109951167568418917","id":126209714,"pic":109951167568418910},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":1294889219,"albumMeta":{"name":"这个世界让你紧张害怕吗？","id":71852932}},"l":{"br":128000,"fid":0,"size":3632527,"vd":-26589,"sr":44100},"m":{"br":192000,"fid":0,"size":5448769,"vd":-28479,"sr":44100},"version":7,"cp":0,"alia":[],"djId":0,"single":0,"ar":[{"name":"白沁","tns":[],"alias":[],"id":32505286}],"ftype":0,"t":0,"v":7,"name":"我还年轻-女烟嗓吉他弹唱","mark":128}
{"no":1,"rt":"","copyright":0,"fee":0,"privilege":{"flag":129,"dlLevel":"lossless","subp":1,"fl":320000,"fee":0,"dl":999000,"plLevel":"exhigh","maxBrLevel":"lossless","maxbr":999000,"id":1920214219,"sp":7,"payed":0,"st":0,"chargeInfoList":[{"rate":128000,"chargeType":0},{"rate":192000,"chargeType":0},{"rate":320000,"chargeType":0},{"rate":999000,"chargeType":1}],"freeTrialPrivilege":{"userConsumable":false,"resConsumable":false},"downloadMaxbr":999000,"downloadMaxBrLevel":"lossless","cp":1,"preSell":false,"playMaxBrLevel":"lossless","cs":false,"toast":false,"playMaxbr":999000,"flLevel":"exhigh","pl":320000},"mst":9,"pst":0,"pop":90,"dt":354335,"rtype":0,"s_id":0,"rtUrls":[],"resourceState":true,"id":1920214219,"lyrics":["<b>我还年轻</b>","爱红眼睛","像条流浪狗 对命运龇牙尖","咬住咽喉 逼它哑口不言","许是梦想滑着走进荧屏","闪也闪出"],"sq":{"br":1000431,"fid":0,"size":44311121,"vd":-74243,"sr":44100},"st":0,"cd":"01","publishTime":0,"cf":"","originCoverType":2,"h":{"br":320000,"fid":0,"size":14176174,"vd":-74249,"sr":44100},"mv":0,"al":{"picUrl":"http://p3.music.126.net/7cPFs-jyRnRf4oYHOoTIOg==/109951168205673532.jpg","name":"好汀好汀","tns":[],"pic_str":"109951168205673532","id":122206888,"pic":109951168205673540},"originSongSimpleData":{"artists":[{"name":"老王乐队","id":12676071}],"name":"我还年轻 我还年轻","songId":1294889219,"albumMeta":{"name":"这个世界让你紧张害怕吗？","id":71852932}},"l":{"br":128000,"fid":0,"size":5670496,"vd":-69928,"sr":44100},"m":{"br":192000,"fid":0,"size":8505722,"vd":-71661,"sr":44100},"version":8,"cp":0,"alia":[],"djId":0,"single":0,"ar":[{"name":"电棍","tns":[],"alias":[],"id":0},{"name":"沈默沈默","tns":[],"alias":[],"id":36031877}],"ftype":0,"t":0,"v":8,"name":"【电棍】我还年轻 我还年轻","mark":128}
```

***

### QQ音乐
QQ音乐因为文档中没有提供登录的接口，而是提供了添加cookie的接口，可以按照将登录后的cookie信息复制出来如下操作进行添加cookie

```java

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.qq.QQMusicInfo;

public class QQMusicDemo {

    public static void main(String[] args) {

        QQMusicInfo qqMusicInfo=new QQMusicInfo();
        // 将cookie字符串复制到这个变量中，通过setCookieString给请求添加cookie
        String cookie="pgv_si=s4824704000; pgv_pvi=1565352960; pgv_info=ssid=s774626425; pgv_pvid=8407309622; yqq_stat=0; ts_refer=www.dogedoge.com/; ts_uid=9112305655; _qpsvr_localtk=0.5849658206781931; RK=BQLlc4tDO+; ptcz=dc9cc74df2c3385602d0fa3a6039c369e0213fe241428ef02910b7af67e7bba5; uin=o1015770492; qqmusic_fromtag=6; qqmusic_uin=1015770492; gpqqcomrouteLine=cg10pc; eas_sid=Q1w6f0m9p0k9o8N1r4r7f47790; ied_qq=o1015770492; Qs_lvt_323937=1609098171; Qs_pv_323937=504240020140402900; qqmusic_key=@7i3RoudTf; skey=@Se84fEkYb; ts_last=y.qq.com/portal/radio.html; userAction=1";
        qqMusicInfo.setCookieString(cookie);// 添加完cookie表示登录成功了，下面我们调用一个需要登录的接口测试一下
        final JSONObject json = new JSONObject();
        json.put("id","1015770492");// 这个接口需要传入qq号，也就是当初cookie对于的qq号信息
        final JSONObject userSonglist = qqMusicInfo.userSonglist(json);
        System.out.println(userSonglist);// 打印信息

    }
}
```
控制台中的打印信息
```bash
当前执行:class top.yumbo.util.music.musicImpl.qq.QQMusicInfo.userSonglist()
请求的相对路径:/user/songlist
绝对路径:http://yumbo.top:3300/user/songlist
{"result":100,"data":{"creator":{"hostname":"诗水人间","encrypt_uin":"oKn57KSloevqoc**","hostuin":1015770492},"list":[{"dir_show":0,"diss_cover":"http://y.gtimg.cn/mediastyle/y/img/cover_qzone_130.jpg","listen_num":0,"song_cnt":4,"dirid":205,"diss_name":"QZone背景音乐","tid":0},{"dir_show":1,"diss_cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002G0Sch2tMqsl.jpg?n=1","listen_num":0,"song_cnt":39,"dirid":6,"diss_name":"轻音乐","tid":7719446085},{"dir_show":1,"diss_cover":"","listen_num":0,"song_cnt":0,"dirid":5,"diss_name":"我的精选歌单 日文","tid":7719443258},{"dir_show":1,"diss_cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000003BxlGH4H7dNb.jpg?n=1","listen_num":0,"song_cnt":57,"dirid":4,"diss_name":"我的精选歌单 英文","tid":7719441619},{"dir_show":1,"diss_cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000004Xx5GF3J1lbP.jpg?n=1","listen_num":0,"song_cnt":39,"dirid":3,"diss_name":"我的精选歌单 中文","tid":7719439673},{"dir_show":1,"diss_cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M00000393o7q382rG3.jpg?n=1","listen_num":39,"song_cnt":14,"dirid":2,"diss_name":"博客背景音乐推荐","tid":7546765303},{"dir_show":1,"diss_cover":"http://qpic.y.qq.com/music_cover/7X3pOwusyHqcIMRWc4eanpib2eK1oJ8HwNLgd4CUzOHichIEd5arBKnA/300?n=1","listen_num":19,"song_cnt":583,"dirid":1,"diss_name":"我收藏的歌曲","tid":7071969614}]}}
```

***
### 自定义音乐
引入项目依赖

参考我给的一个模板类：OtherMusicInfo，实现自定义音乐
#### 模板：定义接口的封装类
```java
import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.annotation.MusicService;
import top.yumbo.util.music.annotation.YumboAnnotationUtils;
import top.yumbo.util.music.musicAbstract.AbstractMusic;

/**
 * 这是一个其它音乐的实例代码
 */

public class OtherMusicInfo extends AbstractMusic {
    {
        setMusicEnum(MusicEnum.OtherMusic);
    }
    @Override
    public JSONObject getResult() {
        YumboAnnotationUtils.sendRequestAutowiredJson(this);
        return super.getResult();
    }

    /**
     * 有参数的接口，传入的是json，返回的也是json
     */
    @MusicService(url = "/has/parameter/method",serverAddress = "http://com.example:6666")
    public JSONObject hasParameterMethod(JSONObject parameter){
        setCurrentRunningMethod("hasParameterMethod");
        setParameter(parameter);// 将参数保存
        return getResult();
    }

    /**
     * 无参的构造方法
     */
    @MusicService(url = "/no/parameter/method",serverAddress = "http://com.example:6666")
    public JSONObject noParameterMethod(){
        setCurrentRunningMethod("noParameterMethod");
        // 不需要传参
        return getResult();
    }
}
```
#### 使用案例：
```java
import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.other.OtherMusicInfo;

public class OtherMusicDemo {

    public static void main(String[] args) {
        final OtherMusicInfo otherMusicInfo = new OtherMusicInfo();
        final JSONObject jsonObject = otherMusicInfo.noParameterMethod();// 调用方法得到数据
        System.out.println(jsonObject);
    }

}
```
### 关于更改api服务器地址说明
通过枚举对象MusicEnum的set方法进行更改即可(静态方法)
下面连个方法分别是更改网易云音乐和qq音乐默认api服务器的两个方法
```
MusicEnum.setBASE_URL_163Music("http://com.example:3000")
MusicEnum.setBASE_URL_QQMusic("http://com.example:3300")
```

