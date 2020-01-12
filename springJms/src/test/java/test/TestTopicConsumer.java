package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext-jms-topic-consumer.xml")
public class TestTopicConsumer {

    @Test
    public void testTopicConsumer() throws IOException {
        System.in.read();
    }
}
