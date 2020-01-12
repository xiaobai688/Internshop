package cn.itcast.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 点对点方式:消息消费者
 */
public class QueryCustomer {

    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.152.128:61616");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //获取session(会话对象) 参数一:是否启动事务  参数二:消息确认的方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列对象
        Queue queue = session.createQueue("test-query");
        //创建消息生产者对象
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收到消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //8.等待键盘输入
        System.in.read();

        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}