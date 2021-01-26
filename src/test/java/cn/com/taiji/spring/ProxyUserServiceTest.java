package cn.com.taiji.spring;

import org.junit.Test;

public class ProxyUserServiceTest {

    @Test
    public  void testProxyUserService(){
    ProxyUserService proxyUserService =new ProxyUserService(new UserServiceImpl());
    proxyUserService.save();
    }
}
