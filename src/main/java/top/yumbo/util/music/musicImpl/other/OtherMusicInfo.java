package top.yumbo.util.music.musicImpl.other;

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

    @MusicService(url = "/has/parameter/method",serverAddress = "http://com.example:6666")
    public JSONObject hasParameterMethod(JSONObject parameter){
        setCurrentRunningMethod("hasParameterMethod");
        setParameter(parameter);// 传入参数
        return getResult();
    }
    @MusicService(url = "/no/parameter/method",serverAddress = "http://com.example:6666")
    public JSONObject noParameterMethod(){
        setCurrentRunningMethod("noParameterMethod");
        // 不需要传参
        return getResult();
    }
}
