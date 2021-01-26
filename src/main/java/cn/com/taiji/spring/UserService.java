package cn.com.taiji.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //此注解相当于构造函数和get，set方法
    @Autowired
    private  UserDao userDao;

//    public  UserDao getUserDao(){
//        return userDao;
//    }
//    public  void setUserDao(UserDao userDao){
//        this.userDao=userDao;
//
//    }

    public  void save(){
        userDao.save();
        System.out.println("service save");
    }
}
