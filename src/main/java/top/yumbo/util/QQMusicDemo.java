package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.musicImpl.qq.QQMusicInfo;

public class QQMusicDemo {

    public static void main(String[] args) {

        QQMusicInfo qqMusicInfo=new QQMusicInfo();
//        final JSONObject parameter = new JSONObject();
//        parameter.put("key","周杰伦");
        final JSONObject jsonObject = qqMusicInfo.searchHot();
        System.out.println(jsonObject);
        final JSONObject jsonObject1 = qqMusicInfo.recommendPlaylistU();
        System.out.println(jsonObject1);




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
