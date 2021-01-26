package cn.com.taiji.spring;

import org.junit.Test;

public class ProxyUserServiceTest {

    @Test
    public  void testProxyUserService(){
    ProxyUserService proxyUserService =new ProxyUserService(new UserServiceImpl());
    proxyUserService.update();
    }
    @Test
    public  void testProxyUserServiceJdk(){
        ProxyJdk proxyJdk =new ProxyJdk(new UserServiceImpl());
        UserService userService=(UserService)proxyJdk.getProxy();
        userService.update();

}

}
