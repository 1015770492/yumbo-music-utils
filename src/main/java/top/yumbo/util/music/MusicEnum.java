package top.yumbo.util.music;

/**
 * 通过枚举封装请求路径
 */
public enum MusicEnum {

    NeteaseCloudMusic {
        /**
         * 网易云音乐服务
         * API-文档地址：https://binaryify.github.io/NeteaseCloudMusicApi
         */
        public final String getFullPathURL(String serverAddress,String relativePath) {
            return BASE_URL_163Music + relativePath;
        }
    },
    QQMusic {
        /**
         * qq音乐服务
         * API-文档地址：https://jsososo.github.io/QQMusicApi
         */
        public final String getFullPathURL(String serverAddress,String relativePath) {
            return BASE_URL_QQMusic + relativePath;
        }
    },
    OtherMusic {
        public String getFullPathURL(String serverAddress, String relativePath) {
            return serverAddress + relativePath;
        }
    };
    public abstract String getFullPathURL(String serverAddress,String relativePath);

    public static String BASE_URL_163Music = "http://yumbo.top:3000";   // 默认的网易云api服务器地址
    public static String BASE_URL_QQMusic = "http://yumbo.top:3300";    // 默认的qq音乐api服务器地址

    /**
     * 传入自定义的网易云api服务器地址
     * @param BASE_URL_163Music 服务器地址
     */
    public static void setBASE_URL_163Music(String BASE_URL_163Music) {
        MusicEnum.BASE_URL_163Music = BASE_URL_163Music;
    }
    /**
     * 传入自定义的qq音乐api服务器地址
     * @param BASE_URL_QQMusic 服务器地址
     */
    public static void setBASE_URL_QQMusic(String BASE_URL_QQMusic) {
        MusicEnum.BASE_URL_QQMusic = BASE_URL_QQMusic;
    }
}
