package cn.itcast.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsumerController {

    @JmsListener(destination="itcast_map")
    public void readMessage(Map map){
        System.out.println(map);
    }
}
