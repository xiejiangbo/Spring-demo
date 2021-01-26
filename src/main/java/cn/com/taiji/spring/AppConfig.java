package cn.com.taiji.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//ComponentScan相当于@Bean,扫描包
@ComponentScan("cn.com.taiji.spring")
public class AppConfig {

//    @Bean
//    public  UserService userService(){
//       UserService userService=new UserService();
//       userService.setUserDao(userDao());
//       return userService;
//    }
//
//    @Bean
//    public  UserDao userDao(){
//        return new UserDao();
//    }


}
