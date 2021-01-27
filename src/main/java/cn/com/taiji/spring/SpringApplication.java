package cn.com.taiji.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//    AplicationStartedListener中加入注解@Component可以不用写下面一行
//       context.addApplicationListener(new AplicationStartedListener());
       context.refresh();


        // 使用配置文件
//        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
//     for(String beanName:context.getBeanDefinitionNames()){
//         System.out.println(beanName);
//     }
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
//        UserServiceImpl userService=context.getBean(UserServiceImpl.class);
//        UserServiceImpl userService1=context.getBean(UserServiceImpl.class);
//        userService.save();
//        System.out.println( userService);
//        System.out.println( userService1);

//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());
//一个$符号代表Jdk动态代理，两个$$代表Cglib动态代理

            UserDao userDao=context.getBean(UserDao.class);
        System.out.println(userDao.getClass());
            userDao.save();
//
        //jdk只能通过getBean("userService")名字拿实例，而Cglib可以通过getBean(UserDao.class)拿实例;为了保险起见，统一用名字获取Bean
//            UserService userService=(UserService) context.getBean("userService");
//        System.out.println(userService.getClass());
//            userService.save();

    }
}
