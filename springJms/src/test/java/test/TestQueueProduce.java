package test;

import cn.itcast.demo.QueueProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext-jms-queue-producer.xml")
public class TestQueueProduce {

    @Autowired
    private QueueProduce queueProduce;

    @Test
    public void testQueueProduce(){
        queueProduce.sendTextMessage("this a dict for dict message");
    }
}
