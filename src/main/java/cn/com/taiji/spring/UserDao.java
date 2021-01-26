package cn.com.taiji.spring;


import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {
    public  void save(){
        System.out.println("dao save");
    }


}
