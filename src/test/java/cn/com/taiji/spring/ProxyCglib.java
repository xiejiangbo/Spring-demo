package cn.com.taiji.spring;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;
//动态代理中的Cglib,在调用没有实现接口的方法情况下使用（实现MethodInterceptor）
public class ProxyCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Date start=new Date();
        System.out.println(" Dao before");

        Object result= methodProxy.invokeSuper(target,args);

        //执行方法前后时间差
        Date end=new Date();

        System.out.println("Dao after");
        System.out.println("执行时间为："+(end.getTime()-start.getTime()));
        return result;
    }
}
