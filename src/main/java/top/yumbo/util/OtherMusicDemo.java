package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.other.OtherMusicInfo;

public class OtherMusicDemo {

    public static void main(String[] args) {
        final OtherMusicInfo otherMusicInfo = new OtherMusicInfo();
        final JSONObject jsonObject = otherMusicInfo.noParameterMethod();
        System.out.println(jsonObject);
    }

}
