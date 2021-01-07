package top.yumbo.util.music.musicAbstract;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import top.yumbo.util.music.MusicEnum;

@Getter
@Setter
public abstract class AbstractMusic {
    public MusicEnum musicEnum; // 网易云还是QQ 或者其他音乐服务
    private String currentRunningMethod;// 记录当前正在调用的是哪一个方法
    private JSONObject result;// 发送请求返回的json数据
    private JSONObject parameter; // 请求带的参数

}
