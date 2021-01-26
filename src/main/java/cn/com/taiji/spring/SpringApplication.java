package cn.com.taiji.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

public class SpringApplication {
//    public static void main(String[] args) {
//            //使用注解
//        ApplicationContext context=new AnnotationConfigApplicationContext("cn.com.taiji.spring");
//            // 使用配置文件
////        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
////     for(String beanName:context.getBeanDefinitionNames()){
////         System.out.println(beanName);
////     }
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
//
//
//
//
//    }

    //AnnotationConfigApplicationContext里面不写包路径可以用这种方式
    public static void main(String[] args) {
        //使用注解
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
       context.register(AppConfig.class);
       context.refresh();


        // 使用配置文件
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//     for(String beanName:context.getBeanDefinitionNames()){
//         System.out.println(beanName);
//     }
        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
        UserService userService=context.getBean(UserService.class);
        userService.save();




    }
}
