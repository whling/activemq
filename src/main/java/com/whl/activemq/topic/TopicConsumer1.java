package com.whl.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Whling
 * @Date: Created in 23:51 2017/9/1
 * @Modified By:
 * @Description: 消息消费者-topic
 */
public class TopicConsumer1 {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://hadoop01:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //是否开启事务？应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic= session.createTopic("test-topic");
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        });
        System.in.read();
        session.close();
        connection.close();
    }
}
