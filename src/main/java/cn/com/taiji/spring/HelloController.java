package cn.com.taiji.spring;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;



@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    ApplicationContext app;

    @GetMapping("/index")
    public  String  index(Model model){
        System.out.println(app.getClass());
        app.getBean("multipartResolver");
        return  "hello World!";
    }

    @PostMapping("/upload")
    public  String  upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String fileName="D:\\jiemiqian"+(file.getOriginalFilename());
        file.transferTo(new File(fileName));
        return "success";
}


    @GetMapping("/user")
    public  User user(){
        User user=new User();
        user.setAddress("湖南省长沙市定王台");
        user.setAge(22);
        user.setName("小白");
        return user;

    }
}
