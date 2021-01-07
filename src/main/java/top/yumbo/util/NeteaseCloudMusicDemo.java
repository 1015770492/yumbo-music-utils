package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;

public class NeteaseCloudMusicDemo {

    public static void main(String[] args) {

        final NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();// 得到封装网易云音乐信息的工具类
        final JSONObject jsonObject = neteaseCloudMusicInfo.searchHot();// 调用网易云的热搜服务
        System.out.println(jsonObject);

    }
}
