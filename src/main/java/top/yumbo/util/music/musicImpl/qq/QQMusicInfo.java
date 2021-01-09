package top.yumbo.util.music.musicImpl.qq;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.annotation.MusicService;
import top.yumbo.util.music.annotation.YumboAnnotationUtils;
import top.yumbo.util.music.musicAbstract.AbstractMusic;

/**
 * 公用参数说明
 * 非常重要，特别是和登陆 cookie 有关的参数
 * <p>
 * 1、raw 前面提到的，默认为 0, 如果传了非0参数，则表示使用原汁原味的数据结构
 * <p>
 * 2、ownCookie 默认为 0，使用服务器上预存的 cookie 信息,
 * 非0表示使用浏览器传过来的 cookie，如果不使用的话，部分接口会遇到 301，
 * 如果该用户非 vip，也无法获取大部分歌曲的播放链接，我自己会不定时的更新这个服务器上（api.qq.jsososo.com）的 cookie作为登陆用户
 */
public class QQMusicInfo extends AbstractMusic {

    {
        setMusicEnum(MusicEnum.QQMusic);// 设置为QQ音乐的枚举
    }
    /**
     * 封装get方法,因为每一个方法都需要发请求返回json数据,为了实现懒加载这里将反射操作放在了get方法中
     */
    @Override
    public JSONObject getResult() {
        YumboAnnotationUtils.sendRequestAutowiredJson(this); // 发送请求注入json
        return super.getResult();
    }

    /**
     * 播放链接
     * <p>
     * 参数：
     * id: 歌曲的 songmid，必填，多个用逗号分割，该接口可用 post 或 get
     * <p>
     * 并不是所有的音乐都能获取到播放链接，如果是未登陆或非 vip 用户的 cookie，只能获取到非 vip 用户可听的歌曲，
     * 其他像一些必须要购买数字专辑才能收听的歌曲，如果未购买也是无法获取的，无法获取到的播放链接则不会在返回的对象中出现，
     * 这点需要大家自己做好兼容，我这里服务器会默认使用自己会员的 cookie，如果需要使用自己的 cookie，请参考上面文档
     */
    @MusicService(url = "/song/urls")
    public JSONObject songUrls(JSONObject parameter) {
        setCurrentRunningMethod("songUrls");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 下载链接
     * <p>
     * 参数：
     * id: songmid
     * type: 默认 128 // 128：mp3 128k，320：mp3 320k，m4a：m4a格式 128k，flac：flac格式 无损，ape：ape格式 无损
     * mediaId: 这个字段为其他接口中返回的 strMediaId 字段，可不传，不传默认同 songmid，但是部分歌曲不传可能会出现能获取到链接，但实际404， 所以有条件的大家都传吧
     * isRedirect: 默认 0，非 0 时直接重定向到播放链接
     * <p>
     * 这个接口跟上个接口一样，也是依赖服务器的 Cookie 信息的，不支持批量获取，不一定是全部的歌曲都有无损、高品的， 要注意结合 size320，sizeape，sizeflac 等参数先判断下是否有播放链接
     */
    @MusicService(url = "/song/url")
    public JSONObject songUrl(JSONObject parameter) {
        setCurrentRunningMethod("songUrl");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 搜索
     * <p>
     * 参数：
     * key: 关键词 必填
     * pageNo: 页码，默认 1
     * pageSize: 一页返回数量，默认 20
     * t: 搜索类型 默认为 0 // 0：单曲，2：歌单，7：歌词，8：专辑，9：歌手，12：mv
     */
    @MusicService(url = "/search")
    public JSONObject search(JSONObject parameter) {
        setCurrentRunningMethod("search");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取热搜词
     * <p>
     * 返回示例：k 为热搜词，n 为搜索量
     */
    @MusicService(url = "/search/hot")
    public JSONObject searchHot() {
        setCurrentRunningMethod("searchHot");
        return getResult();
    }

    @MusicService(url = "/search/quick")
    public JSONObject searchQuick(JSONObject parameter) {
        setCurrentRunningMethod("searchQuick");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 单个查找
     * <p>
     * 参数：
     * key: 关键词
     * <p>
     * 这个接口就像是简化版的搜索，根据关键词获取到搜出的第一个歌曲，不过他会直接带上播放链接，参数为 url，
     * 如果没有则表示无法获取到播放链接。这个接口的作用是，对于其他平台的歌单如果需要获取到企鹅音乐的信息时，
     * 可以通过 歌名 + 歌手 + 专辑 等关键词获取大致的歌曲，当然这是并不能保障稳定的。
     */
    @MusicService(url = "/song/find")
    public JSONObject songFind(JSONObject parameter) {
        setCurrentRunningMethod("songFind");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 批量获取
     * <p>
     * 类型：仅支持post
     * <p>
     * 参数：
     * data: 对象，key 为歌曲id，value 为搜索关键词
     * <p>
     * 同样，并不是所有传过去的 id 都会有返回，没返回就是没有找到，返回的歌曲也都是会包含播放链接
     */
    @MusicService(url = "/song/finds")
    public JSONObject songFinds(JSONObject parameter) {
        setCurrentRunningMethod("songFinds");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 设置用户Cookie
     * <p>
     * 参数：
     * data: 字符串，cookie 信息，格式如下 aaa=bbb; ccc=ddd; ....
     */
    @MusicService(url = "")
    public JSONObject userSetCookie(JSONObject parameter) {
        setCurrentRunningMethod("userSetCookie");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 查看当前Cookie
     * 接口
     * <p>
     * 无需参数，共返回两个字段 cookie 为当前网站下的 cookie，userCookie 为服务器公用账号 cookie。
     */
    @MusicService(url = "/user/cookie")
    public JSONObject userCookie() {
        setCurrentRunningMethod("userCookie");
        return getResult();
    }

    /**
     * 用户主页信息
     * 这个接口是需要登陆 cookie 才能获取的，不然会返回 301，所以如果有误需要考虑一下可能是 cookie 过期
     * <p>
     * 参数：
     * id: qq号 必填
     * <p>
     * 返回中 mymusic 为喜欢的音乐，mydiss 为用户创建的歌单，需要注意的是，喜欢的音乐中的歌单id为 id，歌单中的歌单id为 dissid
     */
    @MusicService(url = "/user/detail")
    public JSONObject userDetail(JSONObject parameter) {
        setCurrentRunningMethod("userDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 用户创建的歌单
     * <p>
     * 参数：
     * <p>
     * id: qq号 必填
     * <p>
     * 这个接口比上一个接口更纯粹，只获取创建的歌单，且数据结构更简单，非必须登陆 Cookie，但如果用户未公开主页时，只有本人的 Cookie 才能获取数据
     */
    @MusicService(url = "/user/songlist")
    public JSONObject userSonglist(JSONObject parameter) {
        setCurrentRunningMethod("userSonglist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 用户收藏的歌单
     * <p>
     * 参数：
     * id: qq号，必填，默认取 cookie 中 uin
     * pageNo: 默认 1
     * pageSize: 默认 20
     */
    @MusicService(url = "/user/collect/songlist")
    public JSONObject userCollectSonglist(JSONObject parameter) {
        setCurrentRunningMethod("userCollectSonglist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 用户收藏的专辑
     * <p>
     * 参数：
     * id: qq号，必填，默认取 cookie 中 uin
     * pageNo: 默认 1
     * pageSize: 默认 20
     */
    @MusicService(url = "/user/collect/album")
    public JSONObject userCollectAlbum(JSONObject parameter) {
        setCurrentRunningMethod("userCollectAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取歌单详情
     * 接口：
     * <p>
     * 参数： id: 歌单id 必填
     * <p>
     * 返回说明：
     * 这些表示各种码率对应的文件大小，如果为0则表示该格式的文件不存在
     * {
     * "size128": 1922927,
     * "size320": 4803503,
     * "sizeape": 10810010,
     * "sizeflac": 10827560,
     * }
     */
    @MusicService(url = "/songlist")
    public JSONObject songlist(JSONObject parameter) {
        setCurrentRunningMethod("songlist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取歌单分类
     * <p>
     * 这个接口没有参数，返回几种类型下的小分类 id 和 name，不同于歌手的筛选，搜索歌单时只能用一个 id，不能用且关系。
     */
    @MusicService(url = "/songlist/category")
    public JSONObject songlistCategory(JSONObject parameter) {
        setCurrentRunningMethod("songlistCategory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、根据分类获取歌单
     * <p>
     * 参数
     * pageSize: 默认为 20
     * pageNo: 默认为1
     * sort: 默认是 5，// 5: 推荐，2: 最新，其他数字的排列值最后都会返回推荐
     * category: 分类 id，默认 10000000 （全部），其他值从上面的分类接口获取
     */
    @MusicService(url = "/songlist/list")
    public JSONObject songlistList(JSONObject parameter) {
        setCurrentRunningMethod("songlistList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、歌曲id、mid的哈希表
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * dirid: 默认 201 我喜欢的歌单
     * 这个接口只能获取用户自己创建的歌单且只会返回歌曲的 id 和 mid 的哈希表，不包含其他数据
     */
    @MusicService(url = "/songlist/map")
    public JSONObject songlistMap(JSONObject parameter) {
        setCurrentRunningMethod("songlistMap");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 5、添加歌曲到歌单
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * mid: 歌曲 mid 必填，多个用 , 分割
     * dirid: 必填
     */
    @MusicService(url = "/songlist/add")
    public JSONObject songlistAdd(JSONObject parameter) {
        setCurrentRunningMethod("songlistAdd");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 6、从歌单中移除歌曲
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * id: 歌曲 id 必填，多个用 , 分割
     * dirid: 必填
     * <p>
     * 与上一个添加接口不同，移除需要 id 不是 mid
     */
    @MusicService(url = "/songlist/remove")
    public JSONObject songlistRemove(JSONObject parameter) {
        setCurrentRunningMethod("songlistRemove");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 7、新建歌单
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * name: 歌单名，不能为空
     * <p>
     * 如果歌单名重复，也会报错
     */
    @MusicService(url = "/songlist/create")
    public JSONObject songlistCreate(JSONObject parameter) {
        setCurrentRunningMethod("songlistCreate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 8、删除歌单
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * dirid: 必填
     */
    @MusicService(url = "/songlist/delete")
    public JSONObject songlistDelete(JSONObject parameter) {
        setCurrentRunningMethod("songlistDelete");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 9、收藏/取消收藏 歌单
     * 这个接口强制使用浏览器传来的用户 Cookie 信息
     * <p>
     * 参数：
     * id: 歌单id 必填
     * op: 必填 1 收藏；2 取消收藏
     */
    @MusicService(url = "/songlist/collect")
    public JSONObject songlistCollect(JSONObject parameter) {
        setCurrentRunningMethod("songlistCollect");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 单个获取歌曲信息
     * 接口：
     * <p>
     * 参数：
     * songmid: 必填
     * 这个接口包含了很多的歌曲信息，包括歌手、专辑、语种、曲风等，但是不包含歌词，songinfo.data.track_info.album.mid 为专辑的 mid， 下面为专辑封面图片的路径，在搜索接口中也能获取到这个参数。
     */
    @MusicService(url = "/song")
    public JSONObject song(JSONObject parameter) {
        setCurrentRunningMethod("song");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 批量获取 歌曲信息
     * <p>
     * 参数：
     * songmids: 必填
     * <p>
     * 这个接口本质为上一个接口的批量调用
     */
    @MusicService(url = "/song/batch")
    public JSONObject songBatch(JSONObject parameter) {
        setCurrentRunningMethod("songBatch");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相似歌曲
     * <p>
     * 参数：
     * <p>
     * id: 歌曲 songid 必填
     * <p>
     * 返回相似歌曲列表
     */
    @MusicService(url = "/song/similar")
    public JSONObject songSimilar(JSONObject parameter) {
        setCurrentRunningMethod("songSimilar");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相关歌单
     * <p>
     * 参数：
     * id: 歌曲 songid 必填
     * <p>
     * 返回相关歌单列表
     */
    @MusicService(url = "/song/playlist")
    public JSONObject songPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("songPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相关MV
     * <p>
     * 参数：
     * id: 歌曲 songid 必填
     * <p>
     * 返回相关mv列表
     */
    @MusicService(url = "/song/mv")
    public JSONObject songMv(JSONObject parameter) {
        setCurrentRunningMethod("songMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 歌词
     * <p>
     * 参数：
     * songmid: 必填
     * <p>
     * 返回的接口中 lyric 和 trans 分别是歌词和翻译，转成了base64，这里node进行了解码。
     */
    @MusicService(url = "/lyric")
    public JSONObject lyric(JSONObject parameter) {
        setCurrentRunningMethod("lyric");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、为你推荐歌单
     * <p>
     * 这个接口不需要参数，需要注意，和下面这个接口的数据格式不同
     */
    @MusicService(url = "/recommend/playlist/u")
    public JSONObject recommendPlaylistU() {
        setCurrentRunningMethod("recommendPlaylistU");
        return getResult();
    }

    /**
     * 2、按分类推荐歌单
     * 接口：
     * <p>
     * 参数：
     * id: 分类id，默认为 3317 // 3317: 官方歌单，59：经典，71：情歌，3056：网络歌曲，64：KTV热歌
     * pageNo: 页码，默认为 1
     * pageSize: 每页返回数量，默认为 20
     */
    @MusicService(url = "/recommend/playlist")
    public JSONObject recommendPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("recommendPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、日推
     * <p>
     * 这个接口无需参数，强制使用传进来的 Cookie，返回日推歌单信息
     */
    @MusicService(url = "/recommend/daily")
    public JSONObject recommendDaily(JSONObject parameter) {
        setCurrentRunningMethod("recommendDaily");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、轮播图Banner
     * <p>
     * 这个接口无需参数，目前仅已知会返回专辑推荐，但是只能获取 albumid，非 albummid
     */
    @MusicService(url = "/recommend/banner")
    public JSONObject recommendBanner(JSONObject parameter) {
        setCurrentRunningMethod("recommendBanner");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、新歌推荐
     * <p>
     * 参数：
     * type: 地区分类，默认为 0 // 0: 最新 1：内地，2：港台，3：欧美，4：韩国，5：日本
     * ps: 官方的接口其实不是这几个type，但是为了考虑与下面的新专和mv接口做兼容，所以做了改动
     */
    @MusicService(url = "")
    public JSONObject newSongs(JSONObject parameter) {
        setCurrentRunningMethod("newSongs");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 2、新碟推荐（专辑）
     * <p>
     * 参数：
     * type: 地区分类，默认为 1 // 1：内地，2：港台，3：欧美，4：韩国，5：日本，6：其他
     * num: 默认 10
     * <p>
     * 这里和官方接口的参数是一致的
     */
    @MusicService(url = "/new/album")
    public JSONObject newAlbum(JSONObject parameter) {
        setCurrentRunningMethod("newAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、新 MV 推荐
     * <p>
     * 参数：
     * type: 类型，默认为 0 // 0: 精选 1：内地，2：港台，3：欧美，4：韩国，5：日本
     * <p>
     * 官方这个参数就更乱了，中英结合，还把日本拼成了 janpan，真是捉鸡
     */
    @MusicService(url = "")
    public JSONObject newMv(JSONObject parameter) {
        setCurrentRunningMethod("newMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、歌手介绍
     * <p>
     * 参数：
     * singermid: 必填
     * <p>
     * 获取歌手的一些详细信息介绍
     */
    @MusicService(url = "/singer/desc")
    public JSONObject singerDesc(JSONObject parameter) {
        setCurrentRunningMethod("singerDesc");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取热门歌曲
     * <p>
     * 参数：
     * singermid: 必填
     * num: 返回歌曲数量
     * page: 页数 默认为第一页
     */
    @MusicService(url = "/singer/songs")
    public JSONObject singerSongs(JSONObject parameter) {
        setCurrentRunningMethod("singerSongs");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、获取歌手专辑
     * <p>
     * 参数：
     * singermid: 必填
     * pageNo: 默认 1
     * pageSize: 默认 20
     */
    @MusicService(url = "")
    public JSONObject singerAlbum(JSONObject parameter) {
        setCurrentRunningMethod("singerAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、获取mv
     * <p>
     * 参数：
     * singermid: 必填
     * pageNo: 默认 1
     * pageSize: 默认 20
     */
    @MusicService(url = "/singer/mv")
    public JSONObject singerMv(JSONObject parameter) {
        setCurrentRunningMethod("singerMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 5、相似歌手
     * 接口：
     * <p>
     * 参数：
     * singermid: 必填
     * <p>
     * 官方接口是有返回数量参数的，但是最多只返回10个，所以这里就写死返回 10 个
     */
    @MusicService(url = "")
    public JSONObject singerSim(JSONObject parameter) {
        setCurrentRunningMethod("singerSim");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 6、获取歌手分类
     * <p>
     * 这个接口没有参数，会返回 地区：area，类型：genre，首字母：index，性别/组合：sex 这些分类项的各个数据
     */
    @MusicService(url = "/singer/category")
    public JSONObject singerCategory(JSONObject parameter) {
        setCurrentRunningMethod("singerCategory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 7、根据分类获取歌手列表
     * <p>
     * 参数：
     * area: 地区，默认 -100
     * genre: 风格，默认 -100
     * index: 首字母，默认 -100
     * sex: 性别/组合，默认 -100
     * pageNo: 默认 1
     * 这个接口固定返回 80 条信息
     * <p>
     * 示例：
     */
    @MusicService(url = "/singer/list")
    public JSONObject singerList(JSONObject parameter) {
        setCurrentRunningMethod("singerList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取专辑信息
     * <p>
     * 参数：
     * albummid: 必填
     */
    @MusicService(url = "/album")
    public JSONObject album(JSONObject parameter) {
        setCurrentRunningMethod("album");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取专辑内的歌曲
     * <p>
     * 参数：
     * albummid: 必填
     */
    @MusicService(url = "")
    public JSONObject albumSongs(JSONObject parameter) {
        setCurrentRunningMethod("albumSongs");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取评论
     * <p>
     * 参数：
     * id: singid, albumid, tid, topid, vid 必填
     * pageNo: 默认 1
     * pageSize: 默认 20
     * type: 默认 0 // 0：获取最新评论，1：获取热评
     * biztype: 获取评论类型 1: 歌曲 2: 专辑 3: 歌单 4: 排行榜 5: mv
     * 当 pageNo 为 1 且 type 为 0 时，会返回15条热评 hot_comment
     * 返回结果说明：ispraise 表示这条评论是否被赞过，1: 是，0: 否；enable_delete 表示这条评论是否能被删除，1: 是，0: 否
     * 上述的判断以 cookie 中的 uin 账号为准
     */
    @MusicService(url = "/comment")
    public JSONObject comment(JSONObject parameter) {
        setCurrentRunningMethod("comment");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、发送评论
     * <p>
     * 类型：仅支持 post
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数：
     * id: singid, albumid, tid, topid, vid 必填
     * biztype: 发送评论类型 1: 歌曲 2: 专辑 3: 歌单 4: 排行榜 5: mv
     * content: 评论内容，必填，不超过300字
     */
    @MusicService(url = "/comment/send")
    public JSONObject commentSend(JSONObject parameter) {
        setCurrentRunningMethod("commentSend");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、删除评论
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数：
     * id: commentid 必填
     * <p>
     * 只要登陆情况下，一般这个接口返回的都是操作成功，不管 id 是否存真实在（是鹅厂这样返回的！）
     */
    @MusicService(url = "/comment/del")
    public JSONObject commentDel(JSONObject parameter) {
        setCurrentRunningMethod("commentDel");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、点赞评论
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数：
     * id: commentid 必填
     * type: 1：点赞，2：取消赞，默认 1
     */
    @MusicService(url = "/comment/like")
    public JSONObject commentLike(JSONObject parameter) {
        setCurrentRunningMethod("commentLike");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、电台分类
     * <p>
     * 返回电台场景分类以及场景下的各个电台
     */
    @MusicService(url = "")
    public JSONObject radioCategory(JSONObject parameter) {
        setCurrentRunningMethod("radioCategory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取电台歌曲
     * <p>
     * 参数：
     * id: 电台id，从上面的分类接口中获取
     * <p>
     * 获取电台中歌曲，其中个性电台需要登陆 cookie
     */
    @MusicService(url = "")
    public JSONObject radio(JSONObject parameter) {
        setCurrentRunningMethod("radio");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取 MV 信息
     * <p>
     * 参数：
     * id: 视频的 vid，必填
     * <p>
     * 返回 info 为 MV 信息，recommend 为相关推荐的 MV
     */
    @MusicService(url = "")
    public JSONObject mv(JSONObject parameter) {
        setCurrentRunningMethod("mv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取 MV 播放链接
     * <p>
     * 参数：
     * id: 视频的 vid , 必填，多个用,分割
     * <p>
     * 返回的链接都是可以直接播放的完整mv视频
     */
    @MusicService(url = "/mv/url")
    public JSONObject mvUrl(JSONObject parameter) {
        setCurrentRunningMethod("mvUrl");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、获取 MV 分类
     * <p>
     * 和获取歌手分类接口类似
     */
    @MusicService(url = "/mv/category")
    public JSONObject mvCategory(JSONObject parameter) {
        setCurrentRunningMethod("mvCategory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、根据分类获取 MV 列表
     * <p>
     * 参数
     * pageNo: 默认 1
     * pageSize: 默认 20
     * area: 地区，默认 15 全部，具体数值从上面分类接口获取
     * version: MV 类型，默认 7 全部，具体数值从上面分类接口获取
     */
    @MusicService(url = "/mv/list")
    public JSONObject mvList(JSONObject parameter) {
        setCurrentRunningMethod("mvList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取榜单列表
     * <p>
     * 参数：
     * showDetail: 是否显示前三歌曲简单信息和榜单介绍，0，不显示，1 显示，默认 0
     * <p>
     * 这个接口列出了几个榜单的分类，包含了榜单名、榜单 id、更新时间、播放量，（榜单介绍、前三歌曲非必传回）
     */
    @MusicService(url = "/top/category")
    public JSONObject topCategory(JSONObject parameter) {
        setCurrentRunningMethod("topCategory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取榜单详情
     * <p>
     * 参数
     * id: 默认 4，从上面的列表中取值
     * pageSize: 默认 100 // 部分接口不支持这个字段，所以这里默认选择100
     * period: 榜单的时间，从上面的列表中取值，非必填
     * time: 默认当前时间，如果有 period，此参数无效
     * <p>
     * 返回说明
     * time: 当前榜单的发布时间，可能是天，也可能是周
     * timeType: 当前榜单的时间格式 YYYY_W 或 YYYY-MM-DD
     * rank: 在榜单的排名
     * rankType: 1 上升，2 减少，3 持平，4 新歌，6 上升百分比
     * rankValue: 排名改变值
     * <p>
     * 传入的 time、period并非必定与传回参数相同，比如，当榜单最新时间为 2019_49, 而传入 period=2019_50时，会返回 2019_49的榜单，
     * 虽然这里不传或传入错误的 period 也会返回正确的数值，但是实际是通过第一次请求返回的结果来验证 period 是否正确，
     * 如果不正确会再进行第二次请求， 因此会造成返回的比较慢，尽量都传入上一个接口中返回的 period
     */
    @MusicService(url = "/top")
    public JSONObject top(JSONObject parameter) {
        setCurrentRunningMethod("top");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取关注的歌手列表
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数
     * pageNo: 默认 1
     * pageSize: 默认 20
     * id: 用户的 qq 号，默认为当前登陆用户
     */
    @MusicService(url = "/user/follow/singers")
    public JSONObject userFollowSingers(JSONObject parameter) {
        setCurrentRunningMethod("userFollowSingers");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 2、获取关注的用户列表
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数
     * pageNo: 默认 1
     * pageSize: 默认 20
     * id: 用户的 qq 号，默认为当前登陆用户
     */
    @MusicService(url = "/user/follow/users")
    public JSONObject userFollowUsers(JSONObject parameter) {
        setCurrentRunningMethod("userFollowUsers");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 3、获取用户的粉丝列表
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * 参数
     * pageNo: 默认 1
     * pageSize: 默认 20
     * id: 用户的 qq 号，默认为当前登陆用户
     */
    @MusicService(url = "/user/fans")
    public JSONObject userFans(JSONObject parameter) {
        setCurrentRunningMethod("userFans");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 4、关注/取消关注 歌手
     * <p>
     * 该接口需要用户登陆 cookie
     * <p>
     * singermid: 关注的歌手 mid，必填
     * operation: 操作，1：关注，2：取消关注，默认为 1
     */
    @MusicService(url = "/user/follow")
    public JSONObject userFollow(JSONObject parameter) {
        setCurrentRunningMethod("userFollow");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 1、获取数据统计
     * <p>
     * 参数
     * type: 默认 ip，可选：ip, browser, browserVersion, os, osVersion, path, url, host
     * startTime: 默认当前时间
     * endTime: 默认当前时间
     * <p>
     * 这个接口会返回各个数据的统计结果
     */
    @MusicService(url = "/data")
    public JSONObject data(JSONObject parameter) {
        setCurrentRunningMethod("data");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


}
