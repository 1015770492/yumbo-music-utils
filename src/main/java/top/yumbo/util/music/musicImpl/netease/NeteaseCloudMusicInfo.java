package top.yumbo.util.music.musicImpl.netease;

import com.alibaba.fastjson.JSONObject;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.annotation.MusicService;
import top.yumbo.util.music.annotation.YumboAnnotationUtils;
import top.yumbo.util.music.musicAbstract.AbstractMusic;

/**
 * url是相对路径
 */
public class NeteaseCloudMusicInfo extends AbstractMusic {

    /**
     * 非静态代码块，构建实例对象的时候就会复制一遍，方便并发的处理（用空间换效率）
     * 每次需要使用到这个服务都创建一个这样的对象
     * 设置当前音乐为枚举网易云音乐
     */
    {
        super.setMusicEnum(MusicEnum.NeteaseCloudMusic);
    }
    /**
     * 执封装get方法,因为每一个方法都需要发请求返回json数据,为了实现懒加载这里将反射操作放在了get方法中
     */
    @Override
    public JSONObject getResult() {
        YumboAnnotationUtils.sendRequestAutowiredJson(this); // 调用反射发送请求注入数据通过下面的return返回
        return super.getResult();
    }
    /**
     * 手机登录
     * <p>
     * 必选参数 :
     * phone: 手机号码
     * password: 密码
     * <p>
     * 可选参数 :
     * countrycode: 国家码，用于国外手机号登录，例如美国传入：1
     * md5_password: md5加密后的密码,传入后 password 将失效（只能二选一）
     */
    @MusicService(url = "/login/cellphone")
    public JSONObject loginCellphone(JSONObject parameter) {
        setCurrentRunningMethod("loginCellphone");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 邮箱登录
     * <p>
     * 必选参数 :
     * email: 163网易邮箱
     * password: 密码
     * <p>
     * 可选参数 :
     * md5_password: md5加密后的密码,传入后 password 将失效 （只能二选一）
     */
    @MusicService(url = "/login")
    public JSONObject login(JSONObject parameter) {
        setCurrentRunningMethod("login");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 二维码登录 => 获取key ==> 给loginQrCreate方法使用
     * 说明: 调用此接口可生成一个key
     */
    @MusicService(url = "/login/qr/key")
    public JSONObject loginQrKey(JSONObject parameter) {
        setCurrentRunningMethod("loginQrKey");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 二维码登录 => 生成二维码
     * 说明: 调用此接口传入上一个接口生成的key可生成二维码图片的base64和二维码信息,可使用base64展示图片,或者使用二维码信息内容自行使用第三方二维码生产库渲染二维码
     * 必选参数: key,由第一个接口生成
     * 可选参数: qrimg 传入后会额外返回二维码图片base64编码
     */
    @MusicService(url = "/login/qr/create")
    public JSONObject loginQrCreate(JSONObject parameter) {
        setCurrentRunningMethod("loginQrCreate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 二维码登录  =>  检测状态
     * 说明: 轮询此接口可获取二维码扫码状态,800为二维码过期,801为等待扫码,802为待确认,803为授权登录成功(803状态码下会返回cookies)
     * 必选参数: key,由第一个接口生成
     */
    @MusicService(url = "/login/qr/check")
    public JSONObject loginQrCheck(JSONObject parameter) {
        setCurrentRunningMethod("loginQrCheck");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 刷新登录
     * 说明 : 调用此接口 , 可刷新登录状态
     */
    @MusicService(url = "/login/refresh")
    public JSONObject loginRefresh() {
        setCurrentRunningMethod("loginRefresh");
        return getResult();
    }

    /**
     * 发送验证码
     * 说明 : 调用此接口 ,传入手机号码, 可发送验证码
     * 必选参数 : phone: 手机号码
     * 可选参数 : ctcode: 国家区号,默认86即中国
     */
    @MusicService(url = "/captcha/sent")
    public JSONObject captchaSent(JSONObject parameter) {
        setCurrentRunningMethod("captchaSent");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 验证验证码
     * 说明 : 调用此接口 ,传入手机号码和验证码, 可校验验证码是否正确
     * 必选参数 :
     * phone: 手机号码
     * captcha: 验证码
     * <p>
     * 可选参数 : ctcode: 国家区号,默认86即中国
     */
    @MusicService(url = "/captcha/verify")
    public JSONObject captchaVerify(JSONObject parameter) {
        setCurrentRunningMethod("captchaVerify");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 注册 (修改密码)
     * 说明 : 调用此接口 ,传入手机号码和验证码,密码,昵称, 可注册网易云音乐账号(同时可修改密码)
     * 必选参数 :
     * captcha: 验证码
     * phone : 手机号码
     * password: 密码
     * nickname: 昵称
     */
    @MusicService(url = "/register/cellphone")
    public JSONObject registerCellphone(JSONObject parameter) {
        setCurrentRunningMethod("registerCellphone");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 检测手机号码是否已注册
     * 说明 : 调用此接口 ,可检测手机号码是否已注册
     * 必选参数 : phone : 手机号码
     * 可选参数 : countrycode: 国家码，用于国外手机号，例如美国传入：1
     */
    @MusicService(url = "/cellphone/existence/check")
    public JSONObject cellphoneExistenceCheck(JSONObject parameter) {
        setCurrentRunningMethod("cellphoneExistenceCheck");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 初始化名称
     * 说明 : 刚注册的账号(需登录),调用此接口 ,可初始化昵称
     * 必选参数 : nickname : 昵称
     */
    @MusicService(url = "/activate/init/profile")
    public JSONObject activateInitProfile(JSONObject parameter) {
        setCurrentRunningMethod("activateInitProfile");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更换手机号
     * 说明 : 调用此接口 ,可更换绑定手机(流程:先发送验证码到原手机号码,再发送验证码到新手机号码然后再调用此接口)
     * 必选参数 : oldcaptcha: 原手机验证码
     * captcha: 新手机验证码
     * phone : 手机号码
     * ctcode : 国家区号,默认86即中国
     */
    @MusicService(url = "/rebind")
    public JSONObject rebind(JSONObject parameter) {
        setCurrentRunningMethod("rebind");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 退出登录
     * 说明 : 调用此接口 , 可退出登录
     */
    @MusicService(url = "/logout")
    public JSONObject logout() {
        setCurrentRunningMethod("logout");
        return getResult();
    }

    /**
     * 登录状态
     * 说明 : 调用此接口,可获取登录状态
     */
    @MusicService(url = "/login/status")
    public JSONObject loginStatus() {
        setCurrentRunningMethod("loginStatus");
        return getResult();
    }

    /**
     * 获取用户详情
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户详情
     * 必选参数 : uid : 用户 id
     */
    @MusicService(url = "/user/detail")
    public JSONObject userDetail(JSONObject parameter) {
        setCurrentRunningMethod("userDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取账号信息
     * 说明 : 登录后调用此接口 ,可获取用户账号信息
     */
    @MusicService(url = "/user/account")
    public JSONObject userAccount() {
        setCurrentRunningMethod("userAccount");
        return getResult();
    }

    /**
     * 获取用户等级信息
     */
    @MusicService(url = "/user/level")
    public JSONObject userLevel() {
        setCurrentRunningMethod("userLevel");
        return getResult();
    }

    /**
     * 获取用户绑定信息
     * 说明 : 登录后调用此接口 , 可以获取用户绑定信息
     * <p>
     * 必选参数 : uid : 用户 id
     */
    @MusicService(url = "/user/binding")
    public JSONObject userBinding(JSONObject parameter) {
        setCurrentRunningMethod("userBinding");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 用户绑定手机
     * 说明 : 登录后调用此接口 , 可以更换绑定手机
     * <p>
     * 必选参数 :
     * phone : 手机号码
     * oldcaptcha: 原手机号码的验证码
     * captcha:新手机号码的验证码
     * <p>
     * 可选参数 :
     * countrycode: 国家地区代码,默认86
     */
    @MusicService(url = "/user/replacephone")
    public JSONObject userReplacephone(JSONObject parameter) {
        setCurrentRunningMethod("userReplacephone");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更新用户信息
     * 说明 : 登录后调用此接口 , 传入相关信息,可以更新用户信息
     * 必选参数 :
     * <p>
     * gender: 性别 0:保密 1:男性 2:女性
     * birthday: 出生日期,时间戳 unix timestamp
     * nickname: 用户昵称
     * province: 省份id
     * city: 城市id
     * signature：用户签名
     */
    @MusicService(url = "/user/update")
    public JSONObject userUpdate(JSONObject parameter) {
        setCurrentRunningMethod("userUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更新头像
     * 可选参数 :
     * imgSize : 图片尺寸,默认为300
     * imgX : 水平裁剪偏移,方形图片可不传,默认为0 imgY : 垂直裁剪偏移,方形图片可不传,默认为0
     */
    @MusicService(url = "/avatar/upload")
    public JSONObject avatarUpload(JSONObject parameter) {
        setCurrentRunningMethod("avatarUpload");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 国家编码列表
     * 说明 : 调用此接口,可获取国家编码列表
     */
    @MusicService(url = "/countries/code/list")
    public JSONObject countriesCodeList() {
        setCurrentRunningMethod("countriesCodeList");
        return getResult();
    }


    /**
     * 获取用户歌单
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户歌单
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/user/playlist")
    public JSONObject userPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("userPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更新歌单
     * 说明 : 登录后调用此接口,可以更新用户歌单
     * <p>
     * 必选参数 :
     * id:歌单id
     * name:歌单名字
     * desc:歌单描述
     * tags:歌单tag ,多个用 `;` 隔开,只能用官方规定标签
     */
    @MusicService(url = "/playlist/update")
    public JSONObject playlistUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更新歌单描述
     * 说明 : 登录后调用此接口,可以单独更新用户歌单描述
     * <p>
     * 必选参数 :
     * id:歌单id
     * desc:歌单描述
     */
    @MusicService(url = "/playlist/desc/update")
    public JSONObject playlistDescUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistDescUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 更新歌单名
     * 说明 : 登录后调用此接口,可以单独更新用户歌单名
     * <p>
     * 必选参数 :
     * id: 歌单id
     * name: 歌单名
     */
    @MusicService(url = "/playlist/name/update")
    public JSONObject playlistNameUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistNameUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 更新歌单标签
     * 说明 : 登录后调用此接口,可以单独更新用户歌单标签
     * <p>
     * 必选参数 :
     * id: 歌单id
     * tags: 歌单标签
     */
    @MusicService(url = "/playlist/tags/update")
    public JSONObject playlistTagsUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistTagsUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 歌单封面上传
     * 说明 : 登录后调用此接口,使用'Content-Type': 'multipart/form-data'上传图片formData(name为'imgFile'),可更新歌单封面(参考:https://github.com/Binaryify/NeteaseCloudMusicApi/blob/master/public/playlist_cover_update.html)
     * <p>
     * 必选参数 :
     * id: 歌单id 3143833470
     * <p>
     * 可选参数 :
     * imgSize : 图片尺寸,默认为300
     * imgX : 水平裁剪偏移,方形图片可不传,默认为0 imgY : 垂直裁剪偏移,方形图片可不传,默认为0
     */
    @MusicService(url = "/playlist/cover/update")
    public JSONObject playlistCoverUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistCoverUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 调整歌单顺序
     * 说明 : 登录后调用此接口,可以根据歌单id顺序调整歌单顺序
     * <p>
     * 必选参数 :
     * ids: 歌单id列表
     */
    @MusicService(url = "/playlist/order/update")
    public JSONObject playlistOrderUpdate(JSONObject parameter) {
        setCurrentRunningMethod("playlistOrderUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 调整歌曲顺序
     * 说明 : 登录后调用此接口,可以根据歌曲id顺序调整歌曲顺序
     * <p>
     * 必选参数 :
     * pid: 歌单id
     * ids: 歌曲id列表
     */
    @MusicService(url = "/song/order/update")
    public JSONObject songOrderUpdate(JSONObject parameter) {
        setCurrentRunningMethod("songOrderUpdate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 获取用户电台
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户电台
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 接口地址 :
     */
    @MusicService(url = "/user/dj")
    public JSONObject userDj(JSONObject parameter) {
        setCurrentRunningMethod("userDj");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取用户关注列表
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户关注列表
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 ,如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/user/follows")
    public JSONObject userFollows(JSONObject parameter) {
        setCurrentRunningMethod("userFollows");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取用户粉丝列表
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户粉丝列表
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * lasttime : 返回数据的 lasttime ,默认-1,传入上一次返回结果的 lasttime,将会返回下一页的数据
     */
    @MusicService(url = "/user/followeds")
    public JSONObject userFolloweds(JSONObject parameter) {
        setCurrentRunningMethod("userFolloweds");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 获取用户动态
     * 说明 : 登录后调用此接口 , 传入用户 id, 可以获取用户动态
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * lasttime : 返回数据的 lasttime ,默认-1,传入上一次返回结果的 lasttime,将会返回下一页的数据
     */
    @MusicService(url = "/user/event")
    public JSONObject userEvent(JSONObject parameter) {
        setCurrentRunningMethod("userEvent");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 转发用户动态
     * 说明 : 登录后调用此接口 ,可以转发用户动态
     * <p>
     * 必选参数 : uid : 用户 id
     * evId : 动态 id
     * forwards : 转发的评论
     */
    @MusicService(url = "/event/forward")
    public JSONObject eventForward(JSONObject parameter) {
        setCurrentRunningMethod("eventForward");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 删除用户动态
     * 说明 : 登录后调用此接口 ,可以删除用户动态
     * <p>
     * 必选参数 : evId : 动态 id
     */
    @MusicService(url = "/event/del")
    public JSONObject eventDel(JSONObject parameter) {
        setCurrentRunningMethod("eventDel");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 分享歌曲、歌单、mv、电台、电台节目到动态
     * 说明 : 登录后调用此接口 ,可以分享歌曲、歌单、mv、电台、电台节目到动态
     * <p>
     * 必选参数 : id : 资源 id （歌曲，歌单，mv，电台，电台节目对应 id）
     * <p>
     * 可选参数 : type: 资源类型，默认歌曲 song，可传 song,playlist,mv,djradio,djprogram
     * <p>
     * msg: 内容，140 字限制，支持 emoji，@用户名（/user/follows接口获取的用户名，用户名后和内容应该有空格），图片暂不支持
     */
    @MusicService(url = "/share/resource")
    public JSONObject shareResource(JSONObject parameter) {
        setCurrentRunningMethod("shareResource");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 获取动态评论
     * 说明 : 登录后调用此接口 , 可以获取动态下评论
     * <p>
     * 必选参数 : threadId : 动态 id，可通过 /event，/user/event 接口获取
     */
    @MusicService(url = "/comment/event")
    public JSONObject commentEvent(JSONObject parameter) {
        setCurrentRunningMethod("commentEvent");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 关注/取消关注用户
     * 说明 : 登录后调用此接口 , 传入用户 id, 和操作 t,可关注/取消关注用户
     * <p>
     * 必选参数 :
     * id : 用户 id
     * t : 1为关注,其他为取消关注
     */
    @MusicService(url = "/follow")
    public JSONObject follow(JSONObject parameter) {
        setCurrentRunningMethod("follow");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 获取用户播放记录
     * 说明 : 登录后调用此接口 , 传入用户 id, 可获取用户播放记录
     * <p>
     * 必选参数 : uid : 用户 id
     * <p>
     * 可选参数 : type : type=1 时只返回 weekData, type=0 时返回 allData
     */
    @MusicService(url = "/user/record")
    public JSONObject userRecord(JSONObject parameter) {
        setCurrentRunningMethod("userRecord");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取热门话题
     * 说明 : 调用此接口 , 可获取热门话题
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * <p>
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     */
    @MusicService(url = "/hot/topic")
    public JSONObject hotTopic(JSONObject parameter) {
        setCurrentRunningMethod("hotTopic");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取话题详情
     * 说明 : 调用此接口 , 可获取话题详情
     */
    @MusicService(url = "/topic/detail")
    public JSONObject topicDetail() {
        setCurrentRunningMethod("topicDetail");
        return getResult();
    }


    /**
     * 获取话题详情热门动态
     * 说明 : 调用此接口 , 可获取话题详情热门动态
     */
    @MusicService(url = "/topic/detail/event/hot")
    public JSONObject topicDetailEventHot(JSONObject parameter) {
        setCurrentRunningMethod("topicDetailEventHot");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 云村热评
     * 说明 : 登录后调用此接口 , 可获取云村热评
     */
    @MusicService(url = "/comment/hotwall/list")
    public JSONObject commentHotwallList() {
        setCurrentRunningMethod("commentHotwallList");
        return getResult();
    }


    /**
     * 心动模式/智能播放
     * 说明 : 登录后调用此接口 , 可获取心动模式/智能播放列表 必选参数 : id : 歌曲 id
     * <p>
     * pid : 歌单 id
     * <p>
     * 可选参数 : sid : 要开始播放的歌曲的 id
     */
    @MusicService(url = "/playmode/intelligence/list")
    public JSONObject playmodeIntelligenceList(JSONObject parameter) {
        setCurrentRunningMethod("playmodeIntelligenceList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取动态消息
     * 说明 : 调用此接口 , 可获取各种动态 , 对应网页版网易云，朋友界面里的各种动态消息 ，如分享的视频，音乐，照片等！
     * <p>
     * 必选参数 : pagesize : 每页数据,默认20
     * <p>
     * lasttime : 返回数据的 lasttime ,默认-1,传入上一次返回结果的 lasttime,将会返回下一页的数据
     */
    @MusicService(url = "/event")
    public JSONObject event(JSONObject parameter) {
        setCurrentRunningMethod("event");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 歌手分类列表
     * 说明 : 调用此接口,可获取歌手分类列表
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 : 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0 initial: 按首字母索引查找参数,如 /artist/list?type=1&area=96&initial=b 返回内容将以 name 字段开头为 b 或者拼音开头为 b 为顺序排列, 热门传-1,#传0
     * <p>
     * type 取值:
     * -1:全部
     * 1:男歌手
     * 2:女歌手
     * 3:乐队
     * <p>
     * area 取值:
     * -1:全部
     * 7华语
     * 96欧美
     * 8:日本
     * 16韩国
     * 0:其他
     */
    @MusicService(url = "/artist/list")
    public JSONObject artistList(JSONObject parameter) {
        setCurrentRunningMethod("artistList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 收藏/取消收藏歌手
     * 说明 : 调用此接口,可收藏歌手
     * <p>
     * 必选参数 :
     * id : 歌手 id
     * t:操作,1 为收藏,其他为取消收藏
     */
    @MusicService(url = "/artist/sub")
    public JSONObject artistSub(JSONObject parameter) {
        setCurrentRunningMethod("artistSub");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 歌手热门50首歌曲
     * 说明 : 调用此接口,可获取歌手热门50首歌曲
     * <p>
     * 必选参数 :
     * id : 歌手 id
     */
    @MusicService(url = "/artist/top/song")
    public JSONObject artistTopSong(JSONObject parameter) {
        setCurrentRunningMethod("artistTopSong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 歌手全部歌曲
     * 说明 : 调用此接口,可获取歌手全部歌曲
     * <p>
     * 必选参数 :
     * id : 歌手 id
     * <p>
     * 可选参数 :
     * order : hot ,time 按照热门或者时间排序
     * limit: 取出歌单数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*50, 其中 50 为 limit 的值
     */
    @MusicService(url = "/artist/songs")
    public JSONObject artistSongs(JSONObject parameter) {
        setCurrentRunningMethod("artistSongs");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 收藏的歌手列表
     * 说明 : 调用此接口,可获取收藏的歌手列表
     */
    @MusicService(url = "/artist/sublist")
    public JSONObject artistSublist() {
        setCurrentRunningMethod("artistSublist");
        return getResult();
    }


    /**
     * 收藏的专栏
     * 说明 : 调用此接口,可获取收藏的专栏
     * <p>
     * 可选参数 :
     * limit: 取出歌单数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*50, 其中 50 为 limit 的值
     */
    @MusicService(url = "/topic/sublist")
    public JSONObject topicSublist(JSONObject parameter) {
        setCurrentRunningMethod("topicSublist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 收藏视频
     * 说明 : 调用此接口,可收藏视频
     * <p>
     * 必选参数 :
     * id : 视频 id
     * t : 1 为收藏,其他为取消收藏
     */
    @MusicService(url = "/video/sub")
    public JSONObject videoSub(JSONObject parameter) {
        setCurrentRunningMethod("videoSub");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 收藏/取消收藏 MV
     * 说明 : 调用此接口,可收藏/取消收藏 MV
     * <p>
     * 必选参数 :
     * mvid : MV id
     * t : 1 为收藏,其他为取消收藏
     */
    @MusicService(url = "/mv/sub")
    public JSONObject mvSub(JSONObject parameter) {
        setCurrentRunningMethod("mvSub");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 收藏的 MV 列表
     * 说明 : 调用此接口,可获取收藏的 MV 列表
     */
    @MusicService(url = "/mv/sublist")
    public JSONObject mvSublist() {
        setCurrentRunningMethod("mvSublist");
        return getResult();
    }


    /**
     * 歌单分类
     * 说明 : 调用此接口,可获取歌单分类,包含 category 信息
     */
    @MusicService(url = "/playlist/catlist")
    public JSONObject playlistCatlist() {
        setCurrentRunningMethod("playlistCatlist");
        return getResult();
    }


    /**
     * 热门歌单分类
     * 说明 : 调用此接口,可获取歌单分类,包含 category 信息
     */
    @MusicService(url = "/playlist/hot")
    public JSONObject playlistHot() {
        setCurrentRunningMethod("playlistHot");
        return getResult();
    }


    /**
     * 歌单 ( 网友精选碟 )
     * 说明 : 调用此接口 , 可获取网友精选碟歌单
     * <p>
     * 可选参数 : order: 可选值为 'new' 和 'hot', 分别对应最新和最热 , 默认为 'hot'
     * cat:cat: tag, 比如 " 华语 "、" 古风 " 、" 欧美 "、" 流行 ", 默认为 "全部",可从歌单分类接口获取(/playlist/catlist)
     * limit: 取出歌单数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*50, 其中 50 为 limit 的值
     */
    @MusicService(url = "/top/playlist")
    public JSONObject topPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("topPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 精品歌单标签列表
     * 说明 : 调用此接口 , 可获取精品歌单标签列表
     */
    @MusicService(url = "/playlist/highquality/tags")
    public JSONObject playlistHighqualityTags() {
        setCurrentRunningMethod("playlistHighqualityTags");
        return getResult();
    }

    /**
     * 获取精品歌单
     * 说明 : 调用此接口 , 可获取精品歌单
     * <p>
     * 可选参数 : cat: tag, 比如 " 华语 "、" 古风 " 、" 欧美 "、" 流行 ", 默认为 "全部",可从精品歌单标签列表接口获取(/playlist/highquality/tags)
     * limit: 取出歌单数量 , 默认为 20
     * before: 分页参数,取上一页最后一个歌单的 updateTime 获取下一页数据
     */
    @MusicService(url = "/top/playlist/highquality")
    public JSONObject topPlaylistHighquality(JSONObject parameter) {
        setCurrentRunningMethod("topPlaylistHighquality");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相关歌单推荐
     * 说明 : 调用此接口,传入歌单 id 可获取相关歌单(对应页面 https://music.163.com/#/playlist?id=1)
     * <p>
     * 必选参数 : id : 歌单 id
     */
    @MusicService(url = "/related/playlist")
    public JSONObject relatedPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("relatedPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌单详情
     * 说明 : 歌单能看到歌单名字, 但看不到具体歌单内容 , 调用此接口 , 传入歌单 id, 可 以获取对应歌单内的所有的音乐(未登录状态只能获取不完整的歌单,登录后是完整的)，但是返回的trackIds是完整的，tracks 则是不完整的，可拿全部 trackIds 请求一次 song/detail 接口获取所有歌曲的详情 (https://github.com/Binaryify/NeteaseCloudMusicApi/issues/452)
     * <p>
     * 必选参数 : id : 歌单 id
     * <p>
     * 可选参数 : s : 歌单最近的 s 个收藏者,默认为8
     */
    @MusicService(url = "/playlist/detail")
    public JSONObject playlistDetail(JSONObject parameter) {
        setCurrentRunningMethod("playlistDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取音乐 url
     * 说明 : 使用歌单详情接口后 , 能得到的音乐的 id, 但不能得到的音乐 url, 调用此接口, 传入的音乐 id( 可多个 , 用逗号隔开 ), 可以获取对应的音乐的 url,未登录状态返回试听片段(返回字段包含被截取的正常歌曲的开始时间和结束时间)
     * <p>
     * 注 : 部分用户反馈获取的 url 会 403,hwaphon找到的解决方案是当获取到音乐的 id 后，将 https://music.163.com/song/media/outer/url?id=id.mp3 以 src 赋予 Audio 即可播放
     * <p>
     * 必选参数 : id : 音乐 id
     * <p>
     * 可选参数 : br: 码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推
     */
    @MusicService(url = "/song/url")
    public JSONObject songUrl(JSONObject parameter) {
        setCurrentRunningMethod("songUrl");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 音乐是否可用
     * 说明: 调用此接口,传入歌曲 id, 可获取音乐是否可用,返回 { success: true, message: 'ok' } 或者 { success: false, message: '亲爱的,暂无版权' }
     * <p>
     * 必选参数 : id : 歌曲 id
     * <p>
     * 可选参数 : br: 码率,默认设置了 999000 即最大码率,如果要 320k 则可设置为 320000,其他类推
     */
    @MusicService(url = "/check/music")
    public JSONObject checkMusic(JSONObject parameter) {
        setCurrentRunningMethod("checkMusic");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 搜索
     * 说明 : 调用此接口 , 传入搜索关键词可以搜索该音乐 / 专辑 / 歌手 / 歌单 / 用户 , 关键词可以多个 , 以空格隔开 , 如 " 周杰伦 搁浅 "( 不需要登录 ), 搜索获取的 mp3url 不能直接用 , 可通过 /song/url 接口传入歌曲 id 获取具体的播放链接
     * <p>
     * 必选参数 : keywords : 关键词
     * <p>
     * 可选参数 : limit : 返回数量 , 默认为 30 offset : 偏移数量，用于分页 , 如 : 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * type: 搜索类型；默认为 1 即单曲 , 取值意义 : 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单, 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台, 1014: 视频, 1018:综合
     * <p>
     * 接口地址 : /search 或者 /cloudsearch(更全)
     */
    @MusicService(url = "/search")
    public JSONObject search(JSONObject parameter) {
        setCurrentRunningMethod("search");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }
    @MusicService(url = "/cloudsearch")
    public JSONObject cloudsearch(JSONObject parameter) {
        setCurrentRunningMethod("cloudsearch");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 默认搜索关键词
     * 说明 : 调用此接口 , 可获取默认搜索关键词
     */
    @MusicService(url = "/search/default")
    public JSONObject searchDefault() {
        setCurrentRunningMethod("searchDefault");
        return getResult();
    }

    /**
     * 热搜列表(简略)
     * 说明 : 调用此接口,可获取热门搜索列表
     */
    @MusicService(url = "/search/hot")
    public JSONObject searchHot() {
        setCurrentRunningMethod("searchHot");
        return getResult();
    }

    /**
     * 热搜列表(详细)
     * 说明 : 调用此接口,可获取热门搜索列表
     */
    @MusicService(url = "/search/hot/detail")
    public JSONObject searchHotDetail() {
        setCurrentRunningMethod("searchHotDetail");
        return getResult();
    }

    /**
     * 搜索建议
     * 说明 : 调用此接口 , 传入搜索关键词可获得搜索建议 , 搜索结果同时包含单曲 , 歌手 , 歌单 ,mv 信息
     * <p>
     * 必选参数 : keywords : 关键词
     * <p>
     * 可选参数 : type : 如果传 'mobile' 则返回移动端数据
     */
    @MusicService(url = "/search/suggest")
    public JSONObject searchSuggest(JSONObject parameter) {
        setCurrentRunningMethod("searchSuggest");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 搜索多重匹配
     * 说明 : 调用此接口 , 传入搜索关键词可获得搜索结果
     * <p>
     * 必选参数 : keywords : 关键词
     */
    @MusicService(url = "/search/multimatch")
    public JSONObject searchMultimatch(JSONObject parameter) {
        setCurrentRunningMethod("searchMultimatch");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 新建歌单
     * 说明 : 调用此接口 , 传入歌单名字可新建歌单
     * <p>
     * 必选参数 : name : 歌单名
     * <p>
     * 可选参数 :
     * privacy : 是否设置为隐私歌单，默认否，传'10'则设置成隐私歌单
     * type : 歌单类型,默认'NORMAL',传 'VIDEO'则为视频歌单
     */
    @MusicService(url = "/playlist/create")
    public JSONObject playlistCreate(JSONObject parameter) {
        setCurrentRunningMethod("playlistCreate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 删除歌单
     * 说明 : 调用此接口 , 传入歌单id可删除歌单
     * <p>
     * 必选参数 : id : 歌单id,可多个,用逗号隔开
     */
    @MusicService(url = "/playlist/delete")
    public JSONObject playlistDelete() {
        setCurrentRunningMethod("playlistDelete");
        return getResult();
    }

    /**
     * 收藏/取消收藏歌单
     * 说明 : 调用此接口 , 传入类型和歌单 id 可收藏歌单或者取消收藏歌单
     * <p>
     * 必选参数 :
     * t : 类型,1:收藏,2:取消收藏 id : 歌单 id
     */
    @MusicService(url = "/playlist/subscribe")
    public JSONObject playlistSubscribe(JSONObject parameter) {
        setCurrentRunningMethod("playlistSubscribe");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 歌单收藏者
     * 说明 : 调用此接口 , 传入歌单 id 可获取歌单的所有收藏者
     * <p>
     * 必选参数 :
     * id : 歌单 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     */
    @MusicService(url = "/playlist/subscribers")
    public JSONObject playlistSubscribers(JSONObject parameter) {
        setCurrentRunningMethod("playlistSubscribers");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 对歌单添加或删除歌曲
     * 说明 : 调用此接口 , 可以添加歌曲到歌单或者从歌单删除某首歌曲 ( 需要登录 )
     * <p>
     * 必选参数 :
     * op: 从歌单增加单曲为 add, 删除为 del
     * pid: 歌单 id tracks: 歌曲 id,可多个,用逗号隔开
     */
    @MusicService(url = "/playlist/tracks")
    public JSONObject playlistTracks(JSONObject parameter) {
        setCurrentRunningMethod("playlistTracks");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 收藏视频到视频歌单
     * 说明 : 调用此接口 , 可收藏视频到视频歌单 ( 需要登录 )
     * <p>
     * 必选参数 :
     * pid : 歌单 id
     * ids : 视频id,支持多个,用,隔开
     */
    @MusicService(url = "/playlist/track/add")
    public JSONObject playlistTrackAdd(JSONObject parameter) {
        setCurrentRunningMethod("playlistTrackAdd");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 删除视频歌单里的视频
     * 说明 : 调用此接口 , 可删除视频歌单里的视频 ( 需要登录 )
     * <p>
     * 必选参数 :
     * pid : 歌单 id
     * ids : 视频id,支持多个,用,隔开
     */
    @MusicService(url = "/playlist/track/delete")
    public JSONObject playlistTrackDelete(JSONObject parameter) {
        setCurrentRunningMethod("playlistTrackDelete");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 最近播放的视频
     * 说明 : 调用此接口 , 可获取最近播放的视频 ( 需要登录 )
     */
    @MusicService(url = "")
    public JSONObject playlistVideoRecent() {
        setCurrentRunningMethod("playlistVideoRecent");
        return getResult();
    }

    /**
     * 获取歌词
     * 说明 : 调用此接口 , 传入音乐 id 可获得对应音乐的歌词 ( 不需要登录 )
     * <p>
     * 必选参数 : id: 音乐 id
     */
    @MusicService(url = "/lyric")
    public JSONObject lyric(JSONObject parameter) {
        setCurrentRunningMethod("lyric");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 新歌速递
     * 说明 : 调用此接口 , 可获取新歌速递
     * <p>
     * 必选参数 :
     * <p>
     * type: 地区类型 id,对应以下:
     * 全部:0
     * 华语:7
     * 欧美:96
     * 日本:8
     * 韩国:16
     */
    @MusicService(url = "/top/song")
    public JSONObject topSong(JSONObject parameter) {
        setCurrentRunningMethod("topSong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 首页-发现
     * 说明 : 调用此接口 , 可获取APP首页信息
     */
    @MusicService(url = "/homepage/block/page")
    public JSONObject homepageBlockPage() {
        setCurrentRunningMethod("homepageBlockPage");
        return getResult();
    }

    /**
     * 首页-发现-圆形图标入口列表
     * 说明 : 调用此接口 , 可获取APP首页圆形图标入口列表
     */
    @MusicService(url = "/homepage/dragon/ball")
    public JSONObject homepageDragonBall() {
        setCurrentRunningMethod("homepageDragonBall");
        return getResult();
    }

    /**
     * 歌曲评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该音乐的所有评论 ( 不需要登录 )
     * <p>
     * 必选参数 : id: 音乐 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/music")
    public JSONObject commentMusic(JSONObject parameter) {
        setCurrentRunningMethod("commentMusic");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 楼层评论
     * 说明 : 调用此接口 , 传入资源 parentCommentId 和资源类型 type和资源id 参数, 可获得该资源的歌曲楼层评论
     * <p>
     * 必选参数 :
     * parentCommentId: 楼层评论 id
     * id : 资源 id
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * time: 分页参数,取上一页最后一项的 time 获取下一页数据
     */
    @MusicService(url = "/comment/floor")
    public JSONObject commentFloor(JSONObject parameter) {
        setCurrentRunningMethod("commentFloor");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 专辑评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该专辑的所有评论 ( 不需要 登录 )
     * <p>
     * 必选参数 : id: 专辑 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/album")
    public JSONObject commentAlbum(JSONObject parameter) {
        setCurrentRunningMethod("commentAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 歌单评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该歌单的所有评论 ( 不需要 登录 )
     * <p>
     * 必选参数 : id: 歌单 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/playlist")
    public JSONObject commentPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("commentPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * mv 评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该 mv 的所有评论 ( 不需要 登录 )
     * <p>
     * 必选参数 : id: mv id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/mv")
    public JSONObject commentMv(JSONObject parameter) {
        setCurrentRunningMethod("commentMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台节目评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该 电台节目 的所有评论 ( 不需要登录 )
     * <p>
     * 必选参数 : id: 电台节目的 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/dj")
    public JSONObject commentDj(JSONObject parameter) {
        setCurrentRunningMethod("commentDj");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 视频评论
     * 说明 : 调用此接口 , 传入音乐 id 和 limit 参数 , 可获得该 视频 的所有评论 ( 不需要登录 )
     * <p>
     * 必选参数 : id: 视频的 id
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/video")
    public JSONObject commentVideo(JSONObject parameter) {
        setCurrentRunningMethod("commentVideo");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 热门评论
     * 说明 : 调用此接口 , 传入 type, 资源 id 可获得对应资源热门评论 ( 不需要登录 )
     * <p>
     * 必选参数 :
     * id : 资源 id
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * <p>
     * 可选参数 : limit: 取出评论数量 , 默认为 20
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*20, 其中 20 为 limit 的值
     * before: 分页参数,取上一页最后一项的 time 获取下一页数据(获取超过5000条评论的时候需要用到)
     */
    @MusicService(url = "/comment/hot")
    public JSONObject commentHot(JSONObject parameter) {
        setCurrentRunningMethod("commentHot");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 新版评论接口
     * 说明 : 调用此接口 , 传入资源类型和资源id,以及排序方式,可获取对应资源的评论
     * <p>
     * 必选参数 :
     * id : 资源 id, 如歌曲 id,mv id
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * 6: 动态
     * <p>
     * 可选参数 :
     * pageNo:分页参数,第N页,默认为1
     * pageSize:分页参数,每页多少条数据,默认20
     * sortType: 排序方式,1:按推荐排序,2:按热度排序,3:按时间排序
     * cursor: 当sortType为3时且页数不是第一页时需传入,值为上一条数据的time
     */
    @MusicService(url = "/comment/new")
    public JSONObject commentNew(JSONObject parameter) {
        setCurrentRunningMethod("commentNew");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 给评论点赞
     * 说明 : 调用此接口 , 传入 type, 资源 id, 和评论 id cid 和 是否点赞参数 t 即可给对 应评论点赞 ( 需要登录 )
     * <p>
     * 必选参数 : id : 资源 id, 如歌曲 id,mv id
     * cid : 评论 id
     * t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * 6: 动态
     */
    @MusicService(url = "/comment/like")
    public JSONObject commentLike(JSONObject parameter) {
        setCurrentRunningMethod("commentLike");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 抱一抱评论
     * 说明 : 调用此接口,可抱一抱评论
     * <p>
     * 必选参数 :
     * uid: 用户id
     * cid: 评论id
     * sid: 资源id
     */
    @MusicService(url = "/hug/comment")
    public JSONObject hugComment(JSONObject parameter) {
        setCurrentRunningMethod("hugComment");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 评论抱一抱列表
     * 说明 : 调用此接口,可获取评论抱一抱列表
     * <p>
     * 必选参数 :
     * uid: 用户id
     * cid: 评论id
     * sid: 资源id
     * <p>
     * 可选参数 :
     * page: 页数
     * cursor: 上一页返回的cursor,默认-1,第一页不需要传
     * idCursor: 上一页返回的idCursor,默认-1,第一页不需要传
     * pageSize : 每页页数,默认100
     */
    @MusicService(url = "/comment/hug/list")
    public JSONObject commentHugList(JSONObject parameter) {
        setCurrentRunningMethod("commentHugList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 发送/删除评论
     * 说明 : 调用此接口,可发送评论或者删除评论
     * <p>
     * ====================================================================================
     * 发送评论
     * <p>
     * 必选参数
     * <p>
     * t:1 发送, 2 回复
     * <p>
     * tpye: 数字,资源类型,对应歌曲,mv,专辑,歌单,电台,视频对应以下类型
     * <p>
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * 6: 动态
     * id:对应资源 id
     * content :要发送的内容
     * commentId :回复的评论id (回复评论时必填)
     * 调用例子 : /comment?t=1&type=1&id=5436712&content=test (往广岛之恋 mv 发送评论: test)
     * 注意：如给动态发送评论，则不需要传 id，需要传动态的 threadId,如：/comment?t=1&type=6&threadId=A_EV_2_6559519868_32953014&content=test
     * <p>
     * ================================================================================
     * 删除评论
     * <p>
     * 必选参数
     * t:0 删除
     * tpye: 数字,资源类型,对应歌曲,mv,专辑,歌单,电台,视频对应以下类型
     * 0: 歌曲
     * 1: mv
     * 2: 歌单
     * 3: 专辑
     * 4: 电台
     * 5: 视频
     * 6: 动态
     * id:对应资源 id content :内容 id,可通过 /comment/mv 等接口获取
     * 调用例子 : /comment?t=0&type=1&id=5436712&commentId=1535550516319 (在广岛之恋 mv 删除评论)
     * 注意：如给动态删除评论，则不需要传 id，需要传动态的 `threadId`,如：`/comment?t=0&type=6&threadId=A_EV_2_65595198
     */
    @MusicService(url = "/comment")
    public JSONObject comment(JSONObject parameter) {
        setCurrentRunningMethod("comment");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * banner
     * 说明 : 调用此接口 , 可获取 banner( 轮播图 ) 数据
     * <p>
     * 可选参数 :
     * type:资源类型,对应以下类型,默认为 0 即PC
     * 0: pc
     * 1: android
     * 2: iphone
     * 3: ipad
     */
    @MusicService(url = "/banner")
    public JSONObject banner(JSONObject parameter) {
        setCurrentRunningMethod("banner");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 资源点赞( MV,电台,视频)
     * 说明 : 调用此接口 , 可对 MV,电台,视频点赞
     * <p>
     * 必选参数 :
     * type:资源类型,对应以下类型
     * 1: mv
     * 4: 电台
     * 5: 视频
     * 6: 动态
     * t: 操作,1 为点赞,其他未取消点赞
     * id: 资源 id
     */
    @MusicService(url = "/resource/like")
    public JSONObject resourceLike(JSONObject parameter) {
        setCurrentRunningMethod("resourceLike");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取点赞过的视频
     * 说明 : 调用此接口, 可获取获取点赞过的视频
     */
    @MusicService(url = "/playlist/mylike")
    public JSONObject playlistMylike() {
        setCurrentRunningMethod("playlistMylike");
        return getResult();
    }

    /**
     * 获取歌曲详情
     * 说明 : 调用此接口 , 传入音乐 id(支持多个 id, 用 , 隔开), 可获得歌曲详情(注意:歌曲封面现在需要通过专辑内容接口获取)
     * <p>
     * 必选参数 : ids: 音乐 id, 如 ids=347230
     */
    @MusicService(url = "/song/detail")
    public JSONObject songDetail(JSONObject parameter) {
        setCurrentRunningMethod("songDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取专辑内容
     * 说明 : 调用此接口 , 传入专辑 id, 可获得专辑内容
     * <p>
     * 必选参数 : id: 专辑 id
     */
    @MusicService(url = "/album")
    public JSONObject album(JSONObject parameter) {
        setCurrentRunningMethod("album");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 专辑动态信息
     * 说明 : 调用此接口 , 传入专辑 id, 可获得专辑动态信息,如是否收藏,收藏数,评论数,分享数
     * <p>
     * 必选参数 : id: 专辑 id
     */
    @MusicService(url = "/album/detail/dynamic")
    public JSONObject albumDetailDynamic(JSONObject parameter) {
        setCurrentRunningMethod("albumDetailDynamic");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 收藏/取消收藏专辑
     * 说明 : 调用此接口,可收藏/取消收藏专辑
     * <p>
     * 必选参数 :
     * id : 专辑 id
     * t : 1 为收藏,其他为取消收藏
     */
    @MusicService(url = "/album/sub")
    public JSONObject albumSub(JSONObject parameter) {
        setCurrentRunningMethod("albumSub");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取已收藏专辑列表
     * 说明 : 调用此接口 , 可获得已收藏专辑列表
     * <p>
     * 可选参数 :
     * limit: 取出数量 , 默认为 25
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*25, 其中 25 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/album/sublist")
    public JSONObject albumSublist(JSONObject parameter) {
        setCurrentRunningMethod("albumSublist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌手单曲
     * 说明 : 调用此接口 , 传入歌手 id, 可获得歌手部分信息和热门歌曲
     * <p>
     * 必选参数 : id: 歌手 id, 可由搜索接口获得
     */
    @MusicService(url = "/artists")
    public JSONObject artists(JSONObject parameter) {
        setCurrentRunningMethod("artists");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌手 mv
     * 说明 : 调用此接口 , 传入歌手 id, 可获得歌手 mv 信息 , 具体 mv 播放地址可调 用/mv传入此接口获得的 mvid 来拿到 , 如 : /artist/mv?id=6452,/mv?mvid=5461064
     * <p>
     * 必选参数 : id: 歌手 id, 可由搜索接口获得
     */
    @MusicService(url = "/artist/mv")
    public JSONObject artistMv(JSONObject parameter) {
        setCurrentRunningMethod("artistMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌手专辑
     * 说明 : 调用此接口 , 传入歌手 id, 可获得歌手专辑内容
     * <p>
     * 必选参数 : id: 歌手 id
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/artist/album")
    public JSONObject artistAlbum(JSONObject parameter) {
        setCurrentRunningMethod("artistAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌手描述
     * 说明 : 调用此接口 , 传入歌手 id, 可获得歌手描述
     * <p>
     * 必选参数 : id: 歌手 id
     */
    @MusicService(url = "/artist/desc")
    public JSONObject artistDesc(JSONObject parameter) {
        setCurrentRunningMethod("artistDesc");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取歌手详情
     * 说明 : 调用此接口 , 传入歌手 id, 可获得获取歌手详情
     * <p>
     * 必选参数 : id: 歌手 id
     */
    @MusicService(url = "/artist/detail")
    public JSONObject artistDetail(JSONObject parameter) {
        setCurrentRunningMethod("artistDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取相似歌手
     * 说明 : 调用此接口 , 传入歌手 id, 可获得相似歌手
     * <p>
     * 必选参数 : id: 歌手 id
     */
    @MusicService(url = "/simi/artist")
    public JSONObject simiArtist(JSONObject parameter) {
        setCurrentRunningMethod("simiArtist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取相似歌单
     * 说明 : 调用此接口 , 传入歌曲 id, 可获得相似歌单
     * <p>
     * 必选参数 : id: 歌曲 id
     */
    @MusicService(url = "/simi/playlist")
    public JSONObject simiPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("simiPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相似 mv
     * 说明 : 调用此接口 , 传入 mvid 可获取相似 mv
     * <p>
     * 必选参数 : mvid: mv id
     */
    @MusicService(url = "/simi/mv")
    public JSONObject simiMv(JSONObject parameter) {
        setCurrentRunningMethod("simiMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取相似音乐
     * 说明 : 调用此接口 , 传入歌曲 id, 可获得相似歌曲
     * <p>
     * 必选参数 : id: 歌曲 id
     */
    @MusicService(url = "/simi/song")
    public JSONObject simiSong(JSONObject parameter) {
        setCurrentRunningMethod("simiSong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取最近 5 个听了这首歌的用户
     * 说明 : 调用此接口 , 传入歌曲 id, 最近 5 个听了这首歌的用户
     * <p>
     * 必选参数 : id: 歌曲 id
     */
    @MusicService(url = "/simi/user")
    public JSONObject simiUser(JSONObject parameter) {
        setCurrentRunningMethod("simiUser");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取每日推荐歌单
     * 说明 : 调用此接口 , 可获得每日推荐歌单 ( 需要登录 )
     */
    @MusicService(url = "/recommend/resource")
    public JSONObject recommendResource() {
        setCurrentRunningMethod("recommendResource");
        return getResult();
    }

    /**
     * 获取每日推荐歌曲
     * 说明 : 调用此接口 , 可获得每日推荐歌曲 ( 需要登录 )
     */
    @MusicService(url = "/recommend/songs")
    public JSONObject recommendSongs() {
        setCurrentRunningMethod("recommendSongs");
        return getResult();
    }

    /**
     * 获取历史日推可用日期列表
     * 说明 : 调用此接口 , 可获得历史日推可用日期列表
     */
    @MusicService(url = "/history/recommend/songs")
    public JSONObject historyRecommendSongs() {
        setCurrentRunningMethod("historyRecommendSongs");
        return getResult();
    }

    /**
     * 获取历史日推详情数据
     * 说明 : 调用此接口 ,传入当日日期, 可获得当日历史日推数据
     * <p>
     * 必选参数 : date: 日期,通过历史日推可用日期列表接口获取,不能任意日期
     * <p>
     * 接口地址 :
     */
    @MusicService(url = "/history/recommend/songs/detail")
    public JSONObject historyRecommendSongsDetail(JSONObject parameter) {
        setCurrentRunningMethod("historyRecommendSongsDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 私人 FM
     * 说明 : 私人 FM( 需要登录 )
     */
    @MusicService(url = "/personal_fm")
    public JSONObject personal_fm() {
        setCurrentRunningMethod("personal_fm");
        return getResult();
    }

    /**
     * 签到
     * 说明 : 调用此接口 , 传入签到类型 ( 可不传 , 默认安卓端签到 ), 可签到 ( 需要登录 ), 其中安卓端签到可获得 3 点经验 , web/PC 端签到可获得 2 点经验
     * <p>
     * 可选参数 : type: 签到类型 , 默认 0, 其中 0 为安卓端签到 ,1 为 web/PC 签到
     */
    @MusicService(url = "/daily_signin")
    public JSONObject daily_signin(JSONObject parameter) {
        setCurrentRunningMethod("daily_signin");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 喜欢音乐
     * 说明 : 调用此接口 , 传入音乐 id, 可喜欢该音乐
     * <p>
     * 必选参数 : id: 歌曲 id
     * <p>
     * 可选参数 : like: 布尔值 , 默认为 true 即喜欢 , 若传 false, 则取消喜欢
     */
    @MusicService(url = "/like")
    public JSONObject like(JSONObject parameter) {
        setCurrentRunningMethod("like");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 喜欢音乐列表
     * 说明 : 调用此接口 , 传入用户 id, 可获取已喜欢音乐id列表(id数组)
     * <p>
     * 必选参数 : uid: 用户 id
     */
    @MusicService(url = "/likelist")
    public JSONObject likelist(JSONObject parameter) {
        setCurrentRunningMethod("likelist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 垃圾桶
     * 说明 : 调用此接口 , 传入音乐 id, 可把该音乐从私人 FM 中移除至垃圾桶
     * <p>
     * 必选参数 : id: 歌曲 id
     */
    @MusicService(url = "/fm_trash")
    public JSONObject fm_trash(JSONObject parameter) {
        setCurrentRunningMethod("fm_trash");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 新碟上架
     * 说明 : 调用此接口 , 可获取新碟上架列表 , 如需具体音乐信息需要调用获取专辑列表接 口 /album , 然后传入 id, 如 /album?id=32311&limit=30
     * <p>
     * 可选参数 :
     * limit: 取出数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     * area: ALL:全部,ZH:华语,EA:欧美,KR:韩国,JP:日本
     * type : new:全部 hot:热门,默认为 new
     * year : 年,默认本年
     * month : 月,默认本月
     */
    @MusicService(url = "/top/album")
    public JSONObject topAlbum(JSONObject parameter) {
        setCurrentRunningMethod("topAlbum");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 全部新碟
     * 说明 : 登录后调用此接口 ,可获取全部新碟
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * area : ALL:全部,ZH:华语,EA:欧美,KR:韩国,JP:日本
     */
    @MusicService(url = "/album/new")
    public JSONObject albumNew(JSONObject parameter) {
        setCurrentRunningMethod("albumNew");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 最新专辑
     * 说明 : 调用此接口 ，获取云音乐首页新碟上架数据
     */
    @MusicService(url = "/album/newest")
    public JSONObject albumNewest() {
        setCurrentRunningMethod("albumNewest");
        return getResult();
    }


    /**
     * 听歌打卡
     * 说明 : 调用此接口 , 传入音乐 id, 来源 id，歌曲时间 time，更新听歌排行数据
     * <p>
     * 必选参数 : id: 歌曲 id, sourceid: 歌单或专辑 id
     * 可选参数 : time: 歌曲播放时间,单位为秒
     * 接口地址 :
     */
    @MusicService(url = "/scrobble")
    public JSONObject scrobble(JSONObject parameter) {
        setCurrentRunningMethod("scrobble");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 热门歌手
     * 说明 : 调用此接口 , 可获取热门歌手数据
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 50
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/top/artists")
    public JSONObject topArtists(JSONObject parameter) {
        setCurrentRunningMethod("topArtists");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 全部 mv
     * 说明 : 调用此接口 , 可获取全部 mv
     * <p>
     * 可选参数 :
     * area: 地区,可选值为全部,内地,港台,欧美,日本,韩国,不填则为全部 type: 类型,可选值为全部,官方版,原生,现场版,网易出品,不填则为全部
     * order: 排序,可选值为上升最快,最热,最新,不填则为上升最快
     * limit: 取出数量 , 默认为 30
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/mv/all")
    public JSONObject mvAll(JSONObject parameter) {
        setCurrentRunningMethod("mvAll");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 最新 mv
     * 说明 : 调用此接口 , 可获取最新 mv
     * <p>
     * 可选参数 : area: 地区,可选值为全部,内地,港台,欧美,日本,韩国,不填则为全部
     * 可选参数 : limit: 取出数量 , 默认为 30
     */
    @MusicService(url = "/mv/first")
    public JSONObject mvFirst(JSONObject parameter) {
        setCurrentRunningMethod("mvFirst");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 网易出品mv
     * 说明 : 调用此接口 , 可获取网易出品 mv
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 30
     * <p>
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/mv/exclusive/rcmd")
    public JSONObject mvExclusiveRcmd(JSONObject parameter) {
        setCurrentRunningMethod("mvExclusiveRcmd");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 推荐 mv
     * 说明 : 调用此接口 , 可获取推荐 mv
     */
    @MusicService(url = "/personalized/mv")
    public JSONObject personalizedMv() {
        setCurrentRunningMethod("personalizedMv");
        return getResult();
    }

    /**
     * 推荐歌单
     * 说明 : 调用此接口 , 可获取推荐歌单
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 30 (不支持 offset)
     */
    @MusicService(url = "/personalized")
    public JSONObject personalized(JSONObject parameter) {
        setCurrentRunningMethod("personalized");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 推荐新音乐
     * 说明 : 调用此接口 , 可获取推荐新音乐
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 10 (不支持 offset)
     */
    @MusicService(url = "/personalized/newsong")
    public JSONObject personalizedNewsong(JSONObject parameter) {
        setCurrentRunningMethod("personalizedNewsong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 推荐电台
     * 说明 : 调用此接口 , 可获取推荐电台
     */
    @MusicService(url = "/personalized/djprogram")
    public JSONObject personalizedDjprogram() {
        setCurrentRunningMethod("personalizedDjprogram");
        return getResult();
    }

    /**
     * 推荐节目
     * 说明 : 调用此接口 , 可获取推荐电台
     */
    @MusicService(url = "/program/recommend")
    public JSONObject programRecommend() {
        setCurrentRunningMethod("programRecommend");
        return getResult();
    }

    /**
     * 独家放送(入口列表)
     * 说明 : 调用此接口 , 可获取独家放送
     */
    @MusicService(url = "/personalized/privatecontent")
    public JSONObject personalizedPrivatecontent() {
        setCurrentRunningMethod("personalizedPrivatecontent");
        return getResult();
    }

    /**
     * 独家放送列表
     * 说明 : 调用此接口 , 可获取独家放送列表
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 60
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*60, 其中 60 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/personalized/privatecontent/list")
    public JSONObject personalizedPrivatecontentList(JSONObject parameter) {
        setCurrentRunningMethod("personalizedPrivatecontentList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * mv 排行
     * 说明 : 调用此接口 , 可获取 mv 排行
     * <p>
     * 可选参数 : limit: 取出数量 , 默认为 30
     * area: 地区,可选值为内地,港台,欧美,日本,韩国,不填则为全部
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认 为 0
     */
    @MusicService(url = "/top/mv")
    public JSONObject topMv(JSONObject parameter) {
        setCurrentRunningMethod("topMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取 mv 数据
     * 说明 : 调用此接口 , 传入 mvid ( 在搜索音乐的时候传 type=1004 获得 ) , 可获取对应 MV 数据 , 数据包含 mv 名字 , 歌手 , 发布时间 , mv 视频地址等数据 , 其中 mv 视频 网易做了防盗链处理 , 可能不能直接播放 , 需要播放的话需要调用 ' mv 地址' 接口
     * <p>
     * 必选参数 : mvid: mv 的 id
     */
    @MusicService(url = "/mv/detail")
    public JSONObject mvDetail(JSONObject parameter) {
        setCurrentRunningMethod("mvDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取 mv 点赞转发评论数数据
     * 说明 : 调用此接口 , 传入 mvid ( 在搜索音乐的时候传 type=1004 获得 ) , 可获取对应 MV 点赞转发评论数数据
     * <p>
     * 必选参数 : mvid: mv 的 id
     */
    @MusicService(url = "/mv/detail/info")
    public JSONObject mvDetailInfo(JSONObject parameter) {
        setCurrentRunningMethod("mvDetailInfo");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * mv 地址
     * 说明 : 调用此接口 , 传入 mv id,可获取 mv 播放地址
     * <p>
     * 必选参数 : id: mv id
     * <p>
     * 可选参数 : r: 分辨率,默认1080,可从 /mv/detail 接口获取分辨率列表
     * <p>
     * 接口地址 :
     */
    @MusicService(url = "/mv/url")
    public JSONObject mvUrl(JSONObject parameter) {
        setCurrentRunningMethod("mvUrl");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取视频标签列表
     * 说明 : 调用此接口 , 可获取视频标签列表
     */
    @MusicService(url = "/video/group/list")
    public JSONObject videoGroupList() {
        setCurrentRunningMethod("videoGroupList");
        return getResult();
    }

    /**
     * 获取视频分类列表
     * 说明 : 调用此接口 , 可获取视频分类列表
     */
    @MusicService(url = "/video/category/list")
    public JSONObject videoCategoryList() {
        setCurrentRunningMethod("videoCategoryList");
        return getResult();
    }

    /**
     * 获取视频标签/分类下的视频
     * 说明 : 调用此接口 , 传入标签/分类id,可获取到相关的视频,分页参数只能传入offset
     * <p>
     * 必选参数 : id: videoGroup 的 id
     * <p>
     * 可选参数 : offset: 默认0
     */
    @MusicService(url = "/video/group")
    public JSONObject videoGroup(JSONObject parameter) {
        setCurrentRunningMethod("videoGroup");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取全部视频列表
     * 说明 : 调用此接口,可获取视频分类列表,分页参数只能传入offset
     * <p>
     * 可选参数 : offset: 默认0
     */
    @MusicService(url = "/video/timeline/all")
    public JSONObject videoTimelineAll(JSONObject parameter) {
        setCurrentRunningMethod("videoTimelineAll");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取推荐视频
     * 说明 : 调用此接口, 可获取推荐视频,分页参数只能传入offset
     * <p>
     * 必选参数 : id: videoGroup 的 id
     * <p>
     * 可选参数 : offset: 默认0
     */
    @MusicService(url = "/video/timeline/recommend")
    public JSONObject videoTimelineRecommend(JSONObject parameter) {
        setCurrentRunningMethod("videoTimelineRecommend");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 相关视频
     * 说明 : 调用此接口 , 可获取相关视频
     * <p>
     * 必选参数 : id: 视频 的 id
     */
    @MusicService(url = "/related/allvideo")
    public JSONObject relatedAllvideo(JSONObject parameter) {
        setCurrentRunningMethod("relatedAllvideo");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 视频详情
     * 说明 : 调用此接口 , 可获取视频详情
     * <p>
     * 必选参数 : id: 视频 的 id
     */
    @MusicService(url = "/video/detail")
    public JSONObject videoDetail(JSONObject parameter) {
        setCurrentRunningMethod("videoDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取视频点赞转发评论数数据
     * 说明 : 调用此接口 , 传入 vid ( 视频id ) , 可获取对应视频点赞转发评论数数据
     * <p>
     * 必选参数 : vid: 视频id
     */
    @MusicService(url = "/video/detail/info")
    public JSONObject videoDetailInfo(JSONObject parameter) {
        setCurrentRunningMethod("videoDetailInfo");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 获取视频播放地址
     * 说明 : 调用此接口 , 传入视频 id,可获取视频播放地址
     * <p>
     * 必选参数 : id: 视频 的 id
     */
    @MusicService(url = "/video/url")
    public JSONObject videoUrl(JSONObject parameter) {
        setCurrentRunningMethod("videoUrl");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 所有榜单
     * 说明 : 调用此接口,可获取所有榜单
     */
    @MusicService(url = "/toplist")
    public JSONObject toplist() {
        setCurrentRunningMethod("toplist");
        return getResult();
    }

    /**
     * 所有榜单内容摘要
     * 说明 : 调用此接口,可获取所有榜单内容摘要
     */
    @MusicService(url = "/toplist/detail")
    public JSONObject toplistDetail() {
        setCurrentRunningMethod("toplistDetail");
        return getResult();
    }


    /**
     * 歌手榜
     * 说明 : 调用此接口 , 可获取排行榜中的歌手榜
     * <p>
     * 可选参数 :
     * type : 地区
     * 1: 华语
     * 2: 欧美
     * 3: 韩国
     * 4: 日本
     */
    @MusicService(url = "/toplist/artist")
    public JSONObject toplistArtist(JSONObject parameter) {
        setCurrentRunningMethod("toplistArtist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 云盘
     * 说明 : 登录后调用此接口 , 可获取云盘数据 , 获取的数据没有对应 url, 需要再调用一 次 /song/url 获取 url
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 200
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*200, 其中 200 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/user/cloud")
    public JSONObject userCloud(JSONObject parameter) {
        setCurrentRunningMethod("userCloud");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 云盘数据详情
     * 说明 : 登录后调用此接口 , 传入云盘歌曲 id，可获取云盘数据详情
     * <p>
     * 必选参数 : id: 歌曲id,可多个,用逗号隔开
     */
    @MusicService(url = "/user/cloud/detail")
    public JSONObject userCloudDetail(JSONObject parameter) {
        setCurrentRunningMethod("userCloudDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 云盘歌曲删除
     * 说明 : 登录后调用此接口 , 可删除云盘歌曲
     * <p>
     * 必选参数 : id: 歌曲id,可多个,用逗号隔开
     */
    @MusicService(url = "/user/cloud/del")
    public JSONObject userCloudDel(JSONObject parameter) {
        setCurrentRunningMethod("userCloudDel");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 云盘上传
     * 说明 : 登录后调用此接口,使用'Content-Type': 'multipart/form-data'上传mp3 formData(name为'songFile'),可上传歌曲到云盘
     * 参考: https://github.com/Binaryify/NeteaseCloudMusicApi/blob/master/public/cloud.html
     * 访问地址: http://localhost:3000/cloud.html)
     * 支持命令行调用,参考module_example目录下song_upload.js
     */
    @MusicService(url = "/cloud")
    public JSONObject cloud(JSONObject parameter) {
        setCurrentRunningMethod("cloud");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台banner
     * 说明 : 调用此接口,可获取电台banner
     */
    @MusicService(url = "/dj/banner")
    public JSONObject djBanner() {
        setCurrentRunningMethod("djBanner");
        return getResult();
    }


    /**
     * 电台个性推荐
     * 说明 : 调用此接口,可获取电台个性推荐列表 可选参数 :
     * <p>
     * limit : 返回数量,默认为 6,总条数最多6条
     */
    @MusicService(url = "/dj/personalize/recommend")
    public JSONObject djPersonalizeRecommend(JSONObject parameter) {
        setCurrentRunningMethod("djPersonalizeRecommend");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台订阅者列表
     * 说明 : 调用此接口,可获取电台订阅者列表 必选参数 : id: 电台id
     * <p>
     * 可选参数 : time : 分页参数,默认-1,传入上一次返回结果的 time,将会返回下一页的数据
     * <p>
     * limit : 返回数量,默认为 20
     */
    @MusicService(url = "/dj/subscriber")
    public JSONObject djSubscriber(JSONObject parameter) {
        setCurrentRunningMethod("djSubscriber");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 用户电台
     * 说明 : 调用此接口, 传入用户id可获取用户创建的电台
     * <p>
     * 必选参数 : uid: 用户id
     */
    @MusicService(url = "/user/audio")
    public JSONObject userAudio(JSONObject parameter) {
        setCurrentRunningMethod("userAudio");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 热门电台
     * 说明 : 调用此接口,可获取热门电台
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0 接口地址 : /dj/hot
     */
    @MusicService(url = "/dj/hot")
    public JSONObject djHot(JSONObject parameter) {
        setCurrentRunningMethod("djHot");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 电台 - 节目榜
     * 说明 : 登录后调用此接口 , 可获得电台节目榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*100, 其中 100 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/dj/program/toplist")
    public JSONObject djProgramToplist(JSONObject parameter) {
        setCurrentRunningMethod("djProgramToplist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 付费精品
     * 说明 : 调用此接口,可获取付费精品电台
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100 (不支持 offset)
     */
    @MusicService(url = "/dj/toplist/pay")
    public JSONObject djToplistPay(JSONObject parameter) {
        setCurrentRunningMethod("djToplistPay");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }


    /**
     * 电台 - 24小时节目榜
     * 说明 : 调用此接口,可获取24小时节目榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100 (不支持 offset)
     */
    @MusicService(url = "/dj/program/toplist/hours")
    public JSONObject djProgramToplistHours(JSONObject parameter) {
        setCurrentRunningMethod("djProgramToplistHours");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 24小时主播榜
     * 说明 : 调用此接口,可获取24小时主播榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100 (不支持 offset)
     */
    @MusicService(url = "/dj/toplist/hours")
    public JSONObject djToplistHours(JSONObject parameter) {
        setCurrentRunningMethod("djToplistHours");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 主播新人榜
     * 说明 : 调用此接口,可获取主播新人榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100 (不支持 offset)
     */
    @MusicService(url = "/dj/toplist/newcomer")
    public JSONObject djToplistNewcomer(JSONObject parameter) {
        setCurrentRunningMethod("djToplistNewcomer");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 最热主播榜
     * 说明 : 调用此接口,可获取最热主播榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100 (不支持 offset)
     */
    @MusicService(url = "/dj/toplist/popular")
    public JSONObject djToplistPopular(JSONObject parameter) {
        setCurrentRunningMethod("djToplistPopular");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 新晋电台榜/热门电台榜
     * 说明 : 登录后调用此接口 , 可获得新晋电台榜/热门电台榜
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 100
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*100, 其中 100 为 limit 的值 , 默认为 0
     * type: 榜单类型, new 为新晋电台榜,hot为热门电台榜
     */
    @MusicService(url = "/dj/toplist")
    public JSONObject djToplist(JSONObject parameter) {
        setCurrentRunningMethod("djToplist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 类别热门电台
     * 可选参数 :
     * <p>
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * cateId: 类别 id,可通过 /dj/category/recommend 接口获取
     */
    @MusicService(url = "/dj/radio/hot")
    public JSONObject djRadioHot(JSONObject parameter) {
        setCurrentRunningMethod("djRadioHot");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 推荐
     * 说明 : 登录后调用此接口 , 可获得推荐电台
     */
    @MusicService(url = "/dj/recommend")
    public JSONObject djRecommend() {
        setCurrentRunningMethod("djRecommend");
        return getResult();
    }

    /**
     * 电台 - 分类
     * 说明 : 登录后调用此接口 , 可获得电台类型
     */
    @MusicService(url = "/dj/catelist")
    public JSONObject djCatelist() {
        setCurrentRunningMethod("djCatelist");
        return getResult();
    }

    /**
     * 电台 - 分类推荐
     * 说明 : 登录后调用此接口 , 传入分类,可获得对应类型电台列表
     * <p>
     * 必选参数 : type: 电台类型 , 数字 , 可通过/dj/catelist获取 , 对应关系为 id 对应 此接口的 type, name 对应类型
     */
    @MusicService(url = "/dj/recommend/type")
    public JSONObject djRecommendType(JSONObject parameter) {
        setCurrentRunningMethod("djRecommendType");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 订阅
     * 说明 : 登录后调用此接口 , 传入rid, 可订阅 dj,dj 的 rid 可通过搜索指定 type='1009' 获取其 id, 如/search?keywords= 代码时间 &type=1009
     * <p>
     * 必选参数 : rid: 电台 的 id
     */
    @MusicService(url = "/dj/sub")
    public JSONObject djSub(JSONObject parameter) {
        setCurrentRunningMethod("djSub");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台的订阅列表
     * 说明 : 登录后调用此接口 , 可获取订阅的电台列表
     * <p>
     * 接口地址 :
     */
    @MusicService(url = "/dj/sublist")
    public JSONObject djSublist(JSONObject parameter) {
        setCurrentRunningMethod("djSublist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 付费精选
     * 说明 : 可以获取付费精选的电台列表 , 传入 limit 和 offset 可以进行分页
     * <p>
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/dj/paygift")
    public JSONObject djPaygift(JSONObject parameter) {
        setCurrentRunningMethod("djPaygift");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 非热门类型
     * 说明 : 登录后调用此接口, 可获得电台非热门类型
     */
    @MusicService(url = "/dj/category/excludehot")
    public JSONObject djCategoryExcludehot() {
        setCurrentRunningMethod("djCategoryExcludehot");
        return getResult();
    }

    /**
     * 电台 - 推荐类型
     * 说明 : 登录后调用此接口, 可获得电台推荐类型
     */
    @MusicService(url = "/dj/category/recommend")
    public JSONObject djCategoryRecommend() {
        setCurrentRunningMethod("djCategoryRecommend");
        return getResult();
    }

    /**
     * 电台 - 今日优选
     * 说明 : 登录后调用此接口, 可获得电台今日优选
     */
    @MusicService(url = "/dj/today/perfered")
    public JSONObject djTodayPerfered() {
        setCurrentRunningMethod("djTodayPerfered");
        return getResult();
    }

    /**
     * 电台 - 详情
     * 说明 : 登录后调用此接口 , 传入rid, 可获得对应电台的详情介绍
     *
     * 必选参数 : rid: 电台 的 id
     */
    @MusicService(url = "/dj/detail")
    public JSONObject djDetail(JSONObject parameter) {
        setCurrentRunningMethod("djDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 节目
     * 说明 : 登录后调用此接口 , 传入rid, 可查看对应电台的电台节目以及对应的 id, 需要 注意的是这个接口返回的 mp3Url 已经无效 , 都为 null, 但是通过调用 /song/url 这 个接口 , 传入节目 id 仍然能获取到节目音频 , 如 /song/url?id=478446370 获取代 码时间的一个节目的音频
     *
     * 必选参数 : rid: 电台 的 id
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * asc : 排序方式,默认为 false (新 => 老 ) 设置 true 可改为 老 => 新
     */
    @MusicService(url = "/dj/program")
    public JSONObject djProgram(JSONObject parameter) {
        setCurrentRunningMethod("djProgram");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 电台 - 节目详情
     * 说明 : 调用此接口传入电台节目id,可获得电台节目详情
     *
     * 必选参数 : id: 电台节目 的 id
     */
    @MusicService(url = "/dj/program/detail")
    public JSONObject djProgramDetail(JSONObject parameter) {
        setCurrentRunningMethod("djProgramDetail");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 通知 - 私信
     * 说明 : 登录后调用此接口 ,可获取私信
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/msg/private")
    public JSONObject msgPrivate(JSONObject parameter) {
        setCurrentRunningMethod("msgPrivate");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 发送私信
     * 说明 : 登录后调用此接口 , 传入用户 id 和要发送的信息, 可以发送私信,返回内容为历史私信,包含带歌单的私信信息(注:不能发送私信给自己)
     *
     * 必选参数 :
     * user_ids : 用户 id,多个需用逗号隔开
     * msg : 要发送的信息
     */
    @MusicService(url = "/send/text")
    public JSONObject sendText(JSONObject parameter) {
        setCurrentRunningMethod("sendText");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 发送私信音乐
     * 说明 : 登录后调用此接口 , 传入用户 id 和要发送的信息,音乐id, 可以发送音乐私信,返回内容为历史私信
     *
     * 必选参数 :
     * user_ids : 用户 id,多个需用逗号隔开
     * msg : 要发送的信息
     */
    @MusicService(url = "/send/song")
    public JSONObject sendSong(JSONObject parameter) {
        setCurrentRunningMethod("sendSong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 发送私信(带歌单)
     * 说明 : 登录后调用此接口 , 传入用户 id 和要发送的信息和歌单 id, 可以发送带歌单的私信(注:不能发送重复的歌单)
     *
     * 必选参数 :
     * user_ids : 用户 id,多个需用逗号隔开
     * msg : 要发送的信息
     */
    @MusicService(url = "/send/playlist")
    public JSONObject sendPlaylist(JSONObject parameter) {
        setCurrentRunningMethod("sendPlaylist");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 最近联系人
     * 说明 : 登录后调用此接口 ,可获取最接近联系人
     */
    @MusicService(url = "/msg/recentcontac")
    public JSONObject msgRecentcontac() {
        setCurrentRunningMethod("msgRecentcontac");
        return getResult();
    }

    /**
     * 私信内容
     * 说明 : 登录后调用此接口 , 可获取私信内容
     *
     * 必选参数 : uid : 用户 id
     * 可选参数 : limit : 返回数量 , 默认为 30
     * before : 分页参数,取上一页最后一项的 time 获取下一页数据
     */
    @MusicService(url = "/msg/private/history")
    public JSONObject msgPrivateHistory(JSONObject parameter) {
        setCurrentRunningMethod("msgPrivateHistory");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 通知 - 评论
     * 说明 : 登录后调用此接口 ,可获取评论
     *
     * 必选参数 : uid: 用户 的 id，只能和登录账号的 id 一致
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * before : 分页参数,取上一页最后一个歌单的 updateTime 获取下一页数据
     */
    @MusicService(url = "/msg/comments")
    public JSONObject msgComments(JSONObject parameter) {
        setCurrentRunningMethod("msgComments");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 通知 - @我
     * 说明 : 登录后调用此接口 ,可获取@我数据
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/msg/forwards")
    public JSONObject msgForwards(JSONObject parameter) {
        setCurrentRunningMethod("msgForwards");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 通知 - 通知
     * 说明 : 登录后调用此接口 ,可获取通知
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * lasttime : 返回数据的 time ,默认-1,传入上一次返回结果的 time,将会返回下一页的数据
     */
    @MusicService(url = "/msg/notices")
    public JSONObject msgNotices(JSONObject parameter) {
        setCurrentRunningMethod("msgNotices");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 设置
     * 说明 : 登录后调用此接口 ,可获取用户设置
     */
    @MusicService(url = "/setting")
    public JSONObject setting() {
        setCurrentRunningMethod("setting");
        return getResult();
    }

    /**
     * 数字专辑-新碟上架
     * 说明 : 调用此接口 ,可获取数字专辑-新碟上架
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     */
    @MusicService(url = "/album/list")
    public JSONObject albumList(JSONObject parameter) {
        setCurrentRunningMethod("albumList");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 数字专辑&数字单曲-榜单
     * 说明 : 调用此接口 ,可获取数字专辑&数字单曲-榜单
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * albumType : 为数字专辑,1为数字单曲
     * type : daily:日榜,week:周榜,year:年榜,total:总榜
     */
    @MusicService(url = "/album_songsaleboard")
    public JSONObject album_songsaleboard(JSONObject parameter) {
        setCurrentRunningMethod("album_songsaleboard");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 数字专辑-语种风格馆
     * 说明 : 调用此接口 ,可获取语种风格馆数字专辑列表
     *
     * 可选参数 :
     * limit : 返回数量 , 默认为 30
     * offset : 偏移数量，用于分页 , 如 :( 页数 -1)*30, 其中 30 为 limit 的值 , 默认为 0
     * area 地区 Z_H:华语,E_A:欧美,KR:韩国,JP:日本
     */
    @MusicService(url = "/album/list/style")
    public JSONObject albumListStyle(JSONObject parameter) {
        setCurrentRunningMethod("albumListStyle");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 数字专辑详情
     * 说明 : 调用此接口 ,传入数字专辑id可获取数字专辑详情(和歌单详情有差异)
     */
    @MusicService(url = "/album/detail")
    public JSONObject albumDetail() {
        setCurrentRunningMethod("albumDetail");
        return getResult();
    }

    /**
     * 我的数字专辑
     * 说明 : 登录后调用此接口 ,可获取我的数字专辑
     */
    @MusicService(url = "/digitalAlbum/purchased")
    public JSONObject digitalAlbumPurchased() {
        setCurrentRunningMethod("digitalAlbumPurchased");
        return getResult();
    }

    /**
     * 购买数字专辑
     * 说明 : 登录后调用此接口 ,可获取购买数字专辑的地址,把地址生成二维码后,可扫描购买专辑
     *
     * 必选参数 :
     * id : 专辑的 id
     * payment : 支付方式， 0 为支付宝 3 为微信
     * quantity : 购买的数量
     */
    @MusicService(url = "/digitalAlbum/ordering")
    public JSONObject digitalAlbumOrdering(JSONObject parameter) {
        setCurrentRunningMethod("digitalAlbumOrdering");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 音乐日历
     * 说明 : 登录后调用此接口,传入开始和结束时间,可获取音乐日历
     */
    @MusicService(url = "/calendar")
    public JSONObject calendar() {
        setCurrentRunningMethod("calendar");
        return getResult();
    }

    /**
     * 云贝
     * 说明 : 登录后调用此接口可获取云贝签到信息(连续签到天数,第二天全部可获得的云贝)
     */
    @MusicService(url = "/yunbei")
    public JSONObject yunbei() {
        setCurrentRunningMethod("yunbei");
        return getResult();
    }

    /**
     * 云贝今日签到信息
     * 说明 : 登录后调用此接口可获取云贝今日签到信息(今日签到获取的云贝数)
     */
    @MusicService(url = "/yunbei/today")
    public JSONObject yunbeiToday() {
        setCurrentRunningMethod("yunbeiToday");
        return getResult();
    }

    /**
     * 云贝签到
     * 说明 : 登录后调用此接口可进行云贝签到
     */
    @MusicService(url = "/yunbei/sign")
    public JSONObject yunbeiSign() {
        setCurrentRunningMethod("yunbeiSign");
        return getResult();
    }

    /**
     * 云贝账户信息
     * 说明 :登录后调用此接口可获取云贝账户信息(账户云贝数)
     */
    @MusicService(url = "/yunbei/info")
    public JSONObject yunbeiInfo() {
        setCurrentRunningMethod("yunbeiInfo");
        return getResult();
    }

    /**
     * 云贝所有任务
     * 说明 :登录后调用此接口可获取云贝所有任务
     */
    @MusicService(url = "/yunbei/tasks")
    public JSONObject yunbeiTasks() {
        setCurrentRunningMethod("yunbeiTasks");
        return getResult();
    }

    /**
     * 云贝todo任务
     * 说明 :登录后调用此接口可获取云贝todo任务
     */
    @MusicService(url = "/yunbei/tasks/todo")
    public JSONObject yunbeiTasksTodo() {
        setCurrentRunningMethod("yunbeiTasksTodo");
        return getResult();
    }

    /**
     * 云贝完成任务
     * 必选参数 :
     * userTaskId : 任务id
     *
     * 可选参数 :
     * depositCode: 任务depositCode
     */
    @MusicService(url = "/yunbei/task/finish")
    public JSONObject yunbeiTaskFinish(JSONObject parameter) {
        setCurrentRunningMethod("yunbeiTaskFinish");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 云贝收入
     * 说明 :登录后调用此接口可获取云贝收入
     *
     * 可选参数 :
     * limit: 取出评论数量 , 默认为 10
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*10, 其中 10 为 limit 的值
     */
    @MusicService(url = "/yunbei/tasks/receipt")
    public JSONObject yunbeiTasksReceipt(JSONObject parameter) {
        setCurrentRunningMethod("yunbeiTasksReceipt");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 云贝支出
     * 说明 :登录后调用此接口可获取云贝支出
     *
     * 可选参数 :
     * limit: 取出评论数量 , 默认为 10
     * offset: 偏移数量 , 用于分页 , 如 :( 评论页数 -1)*10, 其中 10 为 limit 的值
     */
    @MusicService(url = "/yunbei/tasks/expense")
    public JSONObject yunbeiTasksExpense(JSONObject parameter) {
        setCurrentRunningMethod("yunbeiTasksExpense");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 关注歌手新歌
     * 说明 :登录后调用此接口可获取关注歌手新歌
     *
     * 可选参数 :
     * limit: 取出评论数量 , 默认为 20
     * before: 上一页数据返回的publishTime的数据
     */
    @MusicService(url = "/artist/new/song")
    public JSONObject artistNewSong(JSONObject parameter) {
        setCurrentRunningMethod("artistNewSong");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * 关注歌手新MV
     * 说明 :登录后调用此接口可获取关注歌手新MV
     *
     * 可选参数 :
     * limit: 取出评论数量 , 默认为 20
     * before: 上一页数据返回的publishTime的数据
     */
    @MusicService(url = "/artist/new/mv")
    public JSONObject artistNewMv(JSONObject parameter) {
        setCurrentRunningMethod("artistNewMv");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }

    /**
     * batch批量请求接口
     * 说明 : 登录后调用此接口 ,传入接口和对应原始参数(原始参数非文档里写的参数,需参考源码),可批量请求接口
     *
     * 接口地址 : /batch
     *
     * 调用例子 : 使用GET方式:/batch?/api/v2/banner/get={"clientType":"pc"}
     * 使用POST方式传入参数:{ "/api/v2/banner/get": {"clientType":"pc"} }
     */
    @MusicService(url = "/batch")
    public JSONObject batch(JSONObject parameter) {
        setCurrentRunningMethod("batch");
        setParameter(parameter);// 传入json类型的参数
        return getResult();
    }





}
