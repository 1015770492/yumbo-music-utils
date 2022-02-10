package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;
import top.yumbo.util.music.musicImpl.qq.QQMusicInfo;

public class QQMusicDemo {

    public static void main(String[] args) {

        QQMusicInfo qqMusicInfo=new QQMusicInfo();
        // 将cookie字符串复制到这个变量中，通过setCookieString给请求添加cookie
        String cookie="pgv_si=s4824704000; pgv_pvi=1565352960; pgv_info=ssid=s774626425; pgv_pvid=8407309622; yqq_stat=0; ts_refer=www.dogedoge.com/; ts_uid=9112305655; _qpsvr_localtk=0.5849658206781931; RK=BQLlc4tDO+; ptcz=dc9cc74df2c3385602d0fa3a6039c369e0213fe241428ef02910b7af67e7bba5; uin=o1015770492; qqmusic_fromtag=6; qqmusic_uin=1015770492; gpqqcomrouteLine=cg10pc; eas_sid=Q1w6f0m9p0k9o8N1r4r7f47790; ied_qq=o1015770492; Qs_lvt_323937=1609098171; Qs_pv_323937=504240020140402900; qqmusic_key=@7i3RoudTf; skey=@Se84fEkYb; ts_last=y.qq.com/portal/radio.html; userAction=1";
//        qqMusicInfo.setCookieString(cookie);// 添加完cookie表示登录成功了，下面我们调用一个需要登录的接口测试一下
//        final JSONObject json = new JSONObject();
//        json.put("id","1015770492");// 这个接口需要传入qq号，也就是启动qq服务器配置的qq号，cookie的qq与配置服务器的qq要一致，防止被他人登录
//        final JSONObject userSonglist = qqMusicInfo.userSonglist(json);
//        System.out.println(userSonglist);
        String id="0039MnYb0qxYhV";
        final RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://c.y.qq.com/v8/fcg-bin/fcg_play_single_song.fcg?songmid=" + id + "&format=json", String.class);
        final JSONObject jsonObject = JSONObject.parseObject(result);
        final Object o = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("file").get("media_mid");
        System.out.println(o);

//        final JSONObject jsonObject = qqMusicInfo.searchHot();
//        System.out.println(jsonObject);
//        final JSONObject jsonObject1 = qqMusicInfo.recommendPlaylistU();
//        System.out.println(jsonObject1);




//        final HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(HttpHeaders.COOKIE,"");
//        final HttpEntity<String> stringHttpEntity = new HttpEntity<>(httpHeaders);
//        final ResponseEntity<String> responseEntity = new RestTemplate()
//                .exchange(MusicEnum.QQMusic.getFullPathURL("/search/hot"),
//                        HttpMethod.POST,
//                        stringHttpEntity, String.class);
//        System.out.println(responseEntity.getBody());
    }
}
