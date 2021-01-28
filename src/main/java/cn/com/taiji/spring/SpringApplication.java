package cn.com.taiji.spring;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
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
    public static void run(String[] args) throws LifecycleException {


        //使用注解
//       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//       context.register(AppConfig.class);
////    AplicationStartedListener中加入注解@Component可以不用写下面一行
////       context.addApplicationListener(new AplicationStartedListener());
//       context.refresh();


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

//            UserDao userDao=context.getBean(UserDao.class);
////        System.out.println(userDao.getClass());
////        //代理类的父类是userDao
////        System.out.println(userDao.getClass().getSuperclass());
//            userDao.save();
//
        //jdk只能通过getBean("userService")名字获取Bean，而Cglib可以通过getBean(UserDao.class)获取Bean;为了保险起见，统一用名字获取Bean
//            UserService userService=(UserService) context.getBean("userService");
//        System.out.println(userService.getClass());
//        //        //代理类的实现接口是UserService
//        System.out.println(userService.getClass().getInterfaces()[0]);
//            userService.save();


       Tomcat tomcat= new Tomcat();
       //连接器
        Connector connector=new Connector();
        connector.setPort(9999);
        tomcat.getService().addConnector(connector);

        StandardContext standardContext=new StandardContext();
        //监听
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        standardContext.setPath("/mvc");
        tomcat.getHost().addChild(standardContext);
        tomcat.start();


        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(BootApplication.class);
        webApplicationContext.setServletContext(standardContext.getServletContext());
        webApplicationContext.refresh();
        DispatcherServlet  dispatcherServlet=new DispatcherServlet(webApplicationContext);



       tomcat.addServlet("/mvc","dispacher",dispatcherServlet);
        standardContext.addServletMappingDecoded("/","dispacher");


            //等待
            tomcat.getServer().await();





    }
}
