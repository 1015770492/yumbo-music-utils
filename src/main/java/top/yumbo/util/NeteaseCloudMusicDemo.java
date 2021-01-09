package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;


public class NeteaseCloudMusicDemo {

    public static void main(String[] args) {


//        otherMusic.getFullPathURL("")

        final NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();// 得到封装网易云音乐信息的工具类
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", "15727742367");
        jsonObject.put("password", "yjh123456");
        final JSONObject login = neteaseCloudMusicInfo.loginCellphone(jsonObject);
        System.out.println(login);
        final Object uid = login.getJSONObject("account").get("id");
        System.out.println(uid);
        if (uid != null) {
            final JSONObject json = new JSONObject();
            json.put("uid",uid);
            final JSONObject userPlaylist = neteaseCloudMusicInfo.userPlaylist(json);
            System.out.println(userPlaylist);
        }

//        final JSONObject logout = neteaseCloudMusicInfo.logout();
//        final JSONObject logout2 = neteaseCloudMusicInfo.logout();
//        System.out.println(logout);


//        final JSONObject logout = neteaseCloudMusicInfo.logout();
//        System.out.println(logout);
//        final JSONObject jsonObject1 = neteaseCloudMusicInfo.yunbeiInfo();
//        System.out.println(jsonObject1);
//        final JSONObject jsonObject2 = neteaseCloudMusicInfo.searchHot();
//        System.out.println(jsonObject2);
//        String str = "[__csrf=a477072e738bf52da6a3d801fc5f3a47; Max-Age=1296010; Expires=Fri, 22 Jan 2021 18:39:15 GMT; Path=/;, __remember_me=true; Max-Age=1296000; Expires=Fri, 22 Jan 2021 18:39:05 GMT; Path=/;, NMTID=00OvgEvVmJMiskHd0_Fo-XEgTr10ccAAAF23iUnxg; Max-Age=315360000; Expires=Sun, 5 Jan 2031 18:39:05 GMT; Path=/;, MUSIC_U=7b27b6de49d6e80338be47f8ffeb967f298c85f75f738dd735af463ef19d96830931c3a9fbfe3df2; Max-Age=1296000; Expires=Fri, 22 Jan 2021 18:39:05 GMT; Path=/;]";


//        final JSONObject parameter = new JSONObject();// 请求参数
//        parameter.put("keywords","海阔天空");
//        final JSONObject jsonObject = neteaseCloudMusicInfo.search(parameter);// 调用网易云的热搜服务
//        System.out.println(jsonObject);


//        final JSONObject recommendSongs = neteaseCloudMusicInfo.playlistHot();
//        System.out.println(recommendSongs);

    }
}
