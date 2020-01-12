package cn.itcast.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("sendSms")
    public void sendMap(){
        Map map=new HashMap<>();
        map.put("mobile", "18279611877");
        map.put("sing_name", "小白之家");
        map.put("templateCode", "SMS_181212476");
        map.put("param", "{\"code\":\"102931\"}");
        jmsMessagingTemplate.convertAndSend("sms_map",map);
    }

    @RequestMapping("sendSmsText")
    public void sendText(){
        Map map=new HashMap<>();
        map.put("mobile", "18279611877");
        map.put("sing_name", "小白之家");
        map.put("templateCode", "SMS_181490401");
        jmsMessagingTemplate.convertAndSend("sms_success",map);
    }


}
