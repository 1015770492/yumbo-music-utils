package top.yumbo.util.music.musicImpl.qq;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.annotation.MusicService;

@Getter
@Setter
@ToString
public class QQMusicInfo {
    private JSONObject result;// 发送请求返回的json数据
    private JSONObject parameter; // 请求带的参数

    @MusicService(url = "/search/quick",serviceProvider = MusicEnum.QQMusic)
    public JSONObject searchQuick(){
        return result;
    }

}
