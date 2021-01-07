package top.yumbo.util.music.musicImpl.netease;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.annotation.MusicService;
import top.yumbo.util.music.annotation.YumboAnnotationUtils;
import top.yumbo.util.music.musicAbstract.AbstractMusic;


public class NeteaseCloudMusicInfo extends AbstractMusic{

    {
        /**
         * 设置当前音乐为枚举网易云音乐
         */
        super.setMusicEnum(MusicEnum.NeteaseCloudMusic);
    }

    @MusicService(url = "/search/hot")
    public JSONObject searchHot() {
        setCurrentRunningMethod("searchHot");
        return getResult();
    }

    @MusicService(url = "/search/hot/detail")
    public JSONObject searchHotDetail() {
        setCurrentRunningMethod("searchHotDetail");
        return getResult();
    }

    @MusicService(url = "/search/suggest")
    public JSONObject searchSuggest(JSONObject parameter) {
        setCurrentRunningMethod("searchSuggest");
        return getResult();
    }

    /**
     * 执行反射发送请求将返回的数据注入到result中
     * @return
     */
    @Override
    public JSONObject getResult() {
        YumboAnnotationUtils.sendRequestAutowiredJson(this); // 调用反射发送请求注入数据通过下面的return返回
        return super.getResult();
    }
}
