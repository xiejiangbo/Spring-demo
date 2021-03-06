package cn.com.taiji.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
//保留
@Retention(RetentionPolicy.RUNTIME)
public @interface Transation {
    public  String propagate();
}
