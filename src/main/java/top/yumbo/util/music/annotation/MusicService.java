package top.yumbo.util.music.annotation;

import org.springframework.core.annotation.AliasFor;
import top.yumbo.util.music.MusicEnum;

import java.lang.annotation.*;

/**
 * 通过该注解可以获取到
 */

@Retention(RetentionPolicy.RUNTIME) // 注解
@Target({ElementType.FIELD,ElementType.METHOD}) // 注解在局部变量中使用,以及字段使用
public @interface MusicService {
    @AliasFor("value")
    String url() default "";// 这个url是相对路径，服务器地址需要通过枚举得到
//    @AliasFor("url")
//    String value() default "";

    String serverAddress() default "";// 其它音乐服务
}
