### 已经封装好网易云音乐api和QQ音乐api 的所有API，只需要调用我封装好的类就可以快捷调用文档获取数据
### 项目说明：
本项目中使用到的依赖：
spring-web、lombok、fastjson
```xml
<!-- spring-web依赖，这个工具需要使用里面的RestTemplate工具 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.3.2</version>
</dependency>
<!-- fastjson 工具类 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.75</version>
</dependency>
<!-- lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.16</version>
    <scope>provided</scope>
</dependency>
```

### 第一步、引入maven依赖
gav坐标如下
```xml
<dependency>
  <groupId>top.yumbo.music</groupId>
  <artifactId>yumbo-music-utils</artifactId>
  <version>1.1</version>
</dependency>
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
        jsonObject.put("phone","15727742367");
        jsonObject.put("password","yjh123456");
        final JSONObject login = neteaseCloudMusicInfo.loginCellphone(jsonObject);
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
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", "15727742367");
        jsonObject.put("password", "yjh123456");
        final JSONObject login = neteaseCloudMusicInfo.loginCellphone(jsonObject);
        System.out.println(login); // 打印登录返回的信息
        final Object uid = login.getJSONObject("account").get("id");// 获取uid
        System.out.println(uid);// 打印uid
        if (uid != null) {
            final JSONObject json = new JSONObject();
            json.put("uid",uid);
            final JSONObject userPlaylist = neteaseCloudMusicInfo.userPlaylist(json); // 发送/user/playlist请求
            System.out.println(userPlaylist); // 将返回得到的json数据打印一下
        }
    }
}
```
控制台中的打印信息如下：
```bash
当前执行:class top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo.loginCellphone()
请求的相对路径:/login/cellphone
绝对路径:http://yumbo.top:3000/login/cellphone
解析前cookie是[__remember_me=true; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:36:59 GMT; Path=/;, __csrf=343c6dceb7cc8e2badaf079044f2b7e9; Max-Age=1296010; Expires=Sat, 23 Jan 2021 06:37:09 GMT; Path=/;, MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd7cdfccb56a092aec39cb4377b2d7ba249; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:36:59 GMT; Path=/;, NMTID=00OLi7XHzJK4Sd-CE3rkRKcV6Rp5-cAAAF24LZoDg; Max-Age=315360000; Expires=Mon, 6 Jan 2031 06:36:59 GMT; Path=/;]
解析后cookie是:[__remember_me=true; __csrf=343c6dceb7cc8e2badaf079044f2b7e9; MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd7cdfccb56a092aec39cb4377b2d7ba249; NMTID=00OLi7XHzJK4Sd-CE3rkRKcV6Rp5-cAAAF24LZoDg; ]
{"code":200,"cookie":"__remember_me=true; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:36:59 GMT; Path=/;;__csrf=343c6dceb7cc8e2badaf079044f2b7e9; Max-Age=1296010; Expires=Sat, 23 Jan 2021 06:37:09 GMT; Path=/;;MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd7cdfccb56a092aec39cb4377b2d7ba249; Max-Age=1296000; Expires=Sat, 23 Jan 2021 06:36:59 GMT; Path=/;;NMTID=00OLi7XHzJK4Sd-CE3rkRKcV6Rp5-cAAAF24LZoDg; Max-Age=315360000; Expires=Mon, 6 Jan 2031 06:36:59 GMT; Path=/;","loginType":1,"profile":{"birthday":-2209017600000,"backgroundUrl":"https://p3.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","detailDescription":"","gender":0,"city":360700,"signature":"","followeds":0,"description":"","eventCount":0,"playlistBeSubscribedCount":0,"accountStatus":0,"avatarImgId":109951163250239070,"defaultAvatar":true,"avatarImgIdStr":"109951163250239066","backgroundImgIdStr":"109951162868128395","province":360000,"nickname":"15727742367","djStatus":0,"avatarUrl":"https://p3.music.126.net/RLeBJe4D1ZzUtltxfoKDMg==/109951163250239066.jpg","authStatus":0,"follows":3,"vipType":0,"userId":2100084321,"followed":false,"mutual":false,"avatarImgId_str":"109951163250239066","authority":0,"backgroundImgId":109951162868128400,"userType":0,"experts":{},"playlistCount":1},"bindings":[{"expiresIn":2147483647,"expired":false,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"15727742367\",\"hasPassword\":true}","refreshTime":1578119342,"id":7022519084,"type":1,"bindingTime":1578119342761,"userId":2100084321,"url":""},{"expiresIn":7776000,"expired":false,"tokenJsonStr":"{\"access_token\":\"4BE56F3B4BF64E46A80E5144524EFFFE\",\"refresh_token\":\"2DA74DF7E83C87A9E7EFC7E5DE57A6C4\",\"unionid\":\"UID_7AC14222287896DF396B93A9B5CF9CBF\",\"openid\":\"89F4447EE0B34DE1281134C732D7F226\",\"nickname\":\"过去很遥远\",\"expires_in\":7776000}","refreshTime":1610044293,"id":10644862308,"type":5,"bindingTime":1591609837921,"userId":2100084321,"url":""}],"account":{"salt":"[B@32598d1d","vipType":0,"userName":"1_15727742367","type":1,"ban":0,"anonimousUser":false,"createTime":1578119342759,"tokenVersion":2,"id":2100084321,"whitelistAuthority":0,"baoyueVersion":0,"viptypeVersion":0,"donateVersion":0,"status":0},"token":"7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd7cdfccb56a092aec39cb4377b2d7ba249"}
2100084321
当前执行:class top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo.userPlaylist()
请求的相对路径:/user/playlist
绝对路径:http://yumbo.top:3000/user/playlist
{"code":200,"playlist":[{"privacy":0,"trackNumberUpdateTime":0,"subscribed":false,"adType":0,"trackCount":0,"specialType":5,"id":3175992605,"totalDuration":0,"ordered":false,"creator":{"birthday":-2209017600000,"detailDescription":"","backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","gender":0,"city":360700,"signature":"","description":"","accountStatus":0,"avatarImgId":109951163250239070,"defaultAvatar":true,"avatarImgIdStr":"109951163250239066","backgroundImgIdStr":"109951162868128395","province":360000,"nickname":"15727742367","djStatus":0,"avatarUrl":"http://p1.music.126.net/RLeBJe4D1ZzUtltxfoKDMg==/109951163250239066.jpg","authStatus":0,"vipType":0,"followed":false,"userId":2100084321,"authenticationTypes":0,"mutual":false,"avatarImgId_str":"109951163250239066","authority":0,"anchor":false,"userType":0,"backgroundImgId":109951162868128400},"subscribers":[],"opRecommend":false,"highQuality":false,"commentThreadId":"A_PL_0_3175992605","updateTime":1578119342913,"trackUpdateTime":1605879336219,"userId":2100084321,"anonimous":false,"tags":[],"titleImage":0,"cloudTrackCount":0,"coverImgUrl":"https://p1.music.126.net/EWC8bPR8WW9KvhaftdmsXQ==/3397490930543093.jpg","playCount":0,"coverImgId":3397490930543093,"createTime":1578119342913,"name":"15727742367喜欢的音乐","backgroundCoverId":0,"subscribedCount":0,"newImported":false,"status":0}],"more":false,"version":"0"}
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
