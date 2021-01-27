package cn.com.taiji.spring;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Date;
//静态代理，直接实现接口并重写接口中的方法
public class ProxyUserService implements UserService{
    private  UserService userService;
   public  ProxyUserService(UserService userService){
       this.userService=userService;

}

    @Override
    public void save() {
        Date start=new Date();
        System.out.println("before");

        userService.save();
        //执行方法前后时间差
        Date end=new Date();

        System.out.println("after");
        System.out.println("执行时间为："+(end.getTime()-start.getTime()));

    }

    @Override
    public void update() {

        Date start=new Date();
        System.out.println("before");


        userService.update();
        //执行方法前后时间差
        Date end=new Date();

        System.out.println("after");
        System.out.println("执行时间为："+(end.getTime()-start.getTime()));

    }
}
