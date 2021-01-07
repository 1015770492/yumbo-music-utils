package top.yumbo.util.music.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import top.yumbo.util.music.musicAbstract.AbstractMusic;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;

import java.lang.reflect.Method;
import java.util.Map;

public class YumboAnnotationUtils {

    /**
     * 发送请求并且注入json对象
     *
     * @param obj 内部是包含了注解的服务
     */
    public static void sendRequestAutowiredJson(Object obj) {
        if (obj == null) {
            throw new NullPointerException("json对象不能为null");
        }
        /**
         * 反射操作,获取url,注入json对象
         */
        final Class<?> clazz = obj.getClass(); // 获取到反射的类

        /**
         * 因为网易云音乐和QQ音乐提供的接口地址不一样这里采用if-else将其分开
         */
        if (obj instanceof AbstractMusic) {
            AbstractMusic abstractMusic = (AbstractMusic) obj; // 强转
            final String currentRunningMethod = abstractMusic.getCurrentRunningMethod();// 获取当前调用的是那个方法
            try {
                final Method method = clazz.getMethod(currentRunningMethod); // 获取正在调用的那个方法
                final MusicService annotation = method.getAnnotation(MusicService.class);// 获取方法上的注解信息
                if (annotation != null) { // 注解不为null则继续获取注解上的url信息
                    final String url = annotation.url(); // 得到注解上的url
                    final String fullPathURL = ((NeteaseCloudMusicInfo) obj).musicEnum.getFullPathURL(url); // 通过枚举获取完整的url访问路径
                    if (abstractMusic.getParameter() == null) {
                        abstractMusic.setParameter(new JSONObject());
                    }
                    // 设置请求头
                    final HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                    final HttpEntity<String> stringHttpEntity = new HttpEntity<String>(abstractMusic.getParameter().toJSONString(), httpHeaders);
                    System.out.println("当前执行:"+clazz.toString()+"."+method.getName()+"()\n请求的相对路径:"+url);
                    // 发送请求得到返回来的数据
                    final ResponseEntity<String> responseEntity = new RestTemplate().exchange(fullPathURL, HttpMethod.POST, stringHttpEntity, String.class);
                    abstractMusic.setResult(JSONObject.parseObject(responseEntity.getBody()));// 直接替换
                    abstractMusic.setParameter(null);// 清除参数
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * 发送请求 返回Json对象
     *
     * @param url 资源路径
     */
    private static JSONObject getJsonObjectFromApi(String url) {
        final String jsonString = new RestTemplate().getForObject(url, String.class); // 发送请求返回json字符串
        final JSONObject jsonObject = JSONObject.parseObject(jsonString);// 转jsonObject
        return jsonObject;
    }

    /**
     * 替换source的内容为target
     */
    private static void replaceJsonObject(JSONObject source, JSON target) {
        if (source == null) {
            source = new JSONObject();
        }
        source.clear();// 清空原先的内容
        final Map map = JSON.parseObject(target.toString(), Map.class);// 解析成map对象
        source.putAll(map);// 添加到原先的对象中
    }


}
