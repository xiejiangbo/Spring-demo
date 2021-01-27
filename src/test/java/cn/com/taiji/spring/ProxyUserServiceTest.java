package cn.com.taiji.spring;

import org.junit.Test;

import org.springframework.cglib.proxy.Enhancer;

public class ProxyUserServiceTest {

    @Test
    public  void testProxyUserService(){
    ProxyUserService proxyUserService =new ProxyUserService(new UserServiceImpl());
    proxyUserService.update();
    }

    @Test
    public  void testProxyJdk(){
        ProxyJdk proxyJdk =new ProxyJdk(new UserServiceImpl());
        UserService userService=(UserService)proxyJdk.getProxy();
        userService.update();

    }
    @Test
    public  void testProxyCglib(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new ProxyCglib());
        UserDao userDao=(UserDao)enhancer.create();
        userDao.save();

    }

}
