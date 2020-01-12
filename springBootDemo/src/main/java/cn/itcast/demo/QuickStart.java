package cn.itcast.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickStart {
    @Autowired
    private Environment env;

    @RequestMapping("quickStart")
    public String quickStart(){
        return "HelloWord:"+env.getProperty("url");
    }
}
