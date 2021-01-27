package cn.com.taiji.spring;

import javax.swing.text.StyledEditorKit;
import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
//动态代理中的JDK,在调用实现了接口的方法情况下使用（实现InvocationHandler接口）
public class ProxyJdk implements InvocationHandler {

    public Object target;
    public  ProxyJdk(Object target){
        this.target=target;
    }

    public Object getProxy(){
      return   Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Date start=new Date();
        System.out.println("before");
       Object result= method.invoke(target,args);
        Date end =new Date();
        System.out.println("after");
        System.out.println("执行时间："+(end.getTime()-start.getTime()));

        return result;
    }
}
