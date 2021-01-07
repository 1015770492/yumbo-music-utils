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
    String url() default "";
    @AliasFor("url")
    String value() default "";
    MusicEnum serviceProvider() default MusicEnum.NeteaseCloudMusic;// 默认是网易云音乐
}
