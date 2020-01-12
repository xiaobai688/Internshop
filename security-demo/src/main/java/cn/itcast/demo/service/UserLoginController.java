package cn.itcast.demo.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @RequestMapping("getLoginName")
    public void getLoginName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("欢迎登陆"+name);
    }
}
