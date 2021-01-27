package cn.com.taiji.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("@annotation(cn.com.taiji.spring.Transation)")
//    @Pointcut("execution(* cn.com.taiji.spring.UserService.*(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public  void around(ProceedingJoinPoint joinPoint) throws Throwable {

//        System.out.println(" aspectj before");
//        joinPoint.proceed(joinPoint.getArgs());
//        System.out.println(" aspectj after");

        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        Transation transation=methodSignature.getMethod().getAnnotation(Transation.class);

        if(transation!=null){
            System.out.println(transation.propagate());

        }
        System.out.println("begin transaction");
        joinPoint.proceed(joinPoint.getArgs());
        System.out.println("end transaction");

    }
}
