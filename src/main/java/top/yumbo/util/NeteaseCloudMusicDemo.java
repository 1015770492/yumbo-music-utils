package top.yumbo.util;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;


public class NeteaseCloudMusicDemo {

    final static NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();// 得到封装网易云音乐信息的工具类

    public static void main(String[] args) {


        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone", "18279774965");
        jsonObject.put("password", "qvAUEmG2ABtXeCk");
        final JSONObject login = neteaseCloudMusicInfo.loginCellphone(jsonObject);

        System.out.println(login);

//        final JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("id","557581284");
//
//        final JSONObject jsonObject2 = neteaseCloudMusicInfo.songUrl(jsonObject1);
//
//        System.out.println(jsonObject2.getJSONArray("data").getJSONObject(0).get("url"));

//        final Object uid = login.getJSONObject("account").get("id");
//        System.out.println(uid);
//        final JSONObject param = new JSONObject();
//        param.put("id","509512457");
//        param.put("br","999000");
//        final JSONObject songUrl = neteaseCloudMusicInfo.songUrl(param);
//        System.out.println(songUrl);
//        if (uid != null) {
//            final JSONObject json = new JSONObject();
//            json.put("uid",uid);
//            final JSONObject userPlaylist = neteaseCloudMusicInfo.userPlaylist(json);
//            System.out.println(userPlaylist);
//        }
//        final JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("id",33894312);
//        final JSONObject lyric = neteaseCloudMusicInfo.lyric(jsonObject1);
//        System.out.println(lyric);

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
//        parameter.put("keywords", "我还年轻");
//        final JSONObject jsonObject = neteaseCloudMusicInfo.cloudsearch(parameter);// 调用网易云的热搜服务
//        final JSONArray result = jsonObject.getJSONObject("result").getJSONArray("songs");
//        final StringBuilder ids = new StringBuilder();
//        result.stream().map(s -> {
//            JSONObject song = (JSONObject) s;
//            final JSONObject music = new JSONObject();
//            final int id = song.getIntValue("id");
//            ids.append("," + id);
//            music.put("musicId", id);
//            music.put("songName", song.getString("name"));
//            music.put("mvId", song.get("mv"));// mv的id
//            final int dt = song.getIntValue("dt");
//            music.put("durationTime", dt);// 时长，单位毫秒
//            final JSONObject al = song.getJSONObject("al");
//            music.put("albumName", al.getString("name"));// 专辑名称
//            music.put("singer", song.getJSONArray("ar"));// 歌手
//
//            return music;
//        }).forEach(System.out::println);
//        final JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("k1", "v1");
//        collect.add(jsonObject1);
//        System.out.println(collect);

//        final String songIds = ids.toString().replaceFirst(",", "");
//        final JSONObject param = new JSONObject();
//        param.put("id", songIds);
//        System.out.println("\n\n");
//        final JSONObject urls = neteaseCloudMusicInfo.songUrl(param);
//        urls.getJSONArray("data").stream().map(u -> {
//            JSONObject url = (JSONObject) u;
//            final JSONObject urlJson = new JSONObject();
//            urlJson.put("id",url.getIntValue("id"));
//            urlJson.put("url",url.getString("url"));
//            return urlJson;
//        }).collect(Collectors.toList());
//        System.out.println(urls);

//        final JSONObject recommendSongs = neteaseCloudMusicInfo.playlistHot();
//        System.out.println(recommendSongs);

    }

//    private static void Imgcheck(WebDriver ptlogin_iframe) {
//        try {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            final WebDriver tcaptcha_iframe = ptlogin_iframe.switchTo().frame("tcaptcha_iframe");
//            final WebElement tcaptcha_drag_button = tcaptcha_iframe.findElement(By.id("tcaptcha_drag_button"));
//            final Random random = new Random(20);
//            for (int i = 22; i < 190; i++) {
//                try {
//                    final int i1 = random.nextInt();
//                    System.out.println(i1);
//                    TimeUnit.MICROSECONDS.sleep(i1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                tcaptcha_drag_button.click();
//                ((JavascriptExecutor) tcaptcha_iframe).executeScript("document.getElementById(\"slideBlock\").style.left='" + i + "px'");
//                ((JavascriptExecutor) tcaptcha_iframe).executeScript("document.getElementById(\"tcaptcha_drag_button\").style.left='" + (i + 1) + "px'");
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("=====》报异常了");
//        }
//    }
}
