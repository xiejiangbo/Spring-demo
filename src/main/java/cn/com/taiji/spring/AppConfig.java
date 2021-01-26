package cn.com.taiji.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.CollectionUtils;

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

@EventListener
    public void refreshedListener(ContextRefreshedEvent event){
    System.out.println(event.getTimestamp());
           ApplicationContext context=event.getApplicationContext();
       CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

}


}
