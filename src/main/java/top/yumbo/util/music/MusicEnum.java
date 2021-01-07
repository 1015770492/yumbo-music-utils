package top.yumbo.util.music;

/**
 * 通过枚举封装请求路径
 */
public enum MusicEnum {
    NeteaseCloudMusic{
        /**
         * 网易云音乐服务
         * API-文档地址：https://binaryify.github.io/NeteaseCloudMusicApi
         */
        @Override
        public final String getFullPathURL(String relativePath) {
            return BASE_URL_163Music + relativePath;
        }
    },
    QQMusic{
        /**
         * qq音乐服务
         * API-文档地址：https://jsososo.github.io/QQMusicApi
         */
        @Override
        public final String getFullPathURL(String relativePath) {
            return BASE_URL_QQMusic + relativePath;
        }
    };
    public abstract String getFullPathURL(String relativePath);// 将请求进行封装加上基础路径

    public static final String BASE_URL_163Music="http://yumbo.top:3000";   // 网易云api服务器地址
    public static final String BASE_URL_QQMusic="http://yumbo.top:3300";    // qq音乐api服务器地址


}
