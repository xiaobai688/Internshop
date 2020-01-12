package test;

import cn.itcast.demo.QueueProduce;
import cn.itcast.demo.TopicProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext-jms-topic-producer.xml")
public class TestTopicProduce {

    @Autowired
    private TopicProduce topicProduce;

    @Test
    public void testTopicProduce(){
        topicProduce.sendTextMessage("springJMS 发布订阅");
    }
}
