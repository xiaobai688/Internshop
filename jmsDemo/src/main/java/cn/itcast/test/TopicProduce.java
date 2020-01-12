package cn.itcast.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 发布订阅模式:消息生产者
 */
public class TopicProduce {
    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.152.128:61616");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //获取session(会话对象) 参数一:是否启动事务  参数二:消息确认的方式
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列对象
        Topic topic = session.createTopic("test-topic");
        //创建消息生产者对象
        MessageProducer producer = session.createProducer(topic);
        //创建消息对象(文本消息)
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("这是神奇的品优购世界!!!");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
