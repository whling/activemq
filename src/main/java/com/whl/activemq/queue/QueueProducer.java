package com.whl.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Whling
 * @Date: Created in 22:26 2017/9/1
 * @Modified By:
 * @Description: 消息生产者-queue
 */
public class QueueProducer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://hadoop01:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        List<String> list = new ArrayList<String>();

        // 创建session, 第一个参数：是否开启事务 true：开启  false：关闭
        //第二个参数：应答模式: 自动应答/手动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-queue");
        MessageProducer producer = session.createProducer(queue);
        Message message = null;
        for (int i = 0; i < 100; i++) {
            message = session.createTextMessage("hello queue" + i);
            producer.send(message);
        }
        session.close();
        connection.close();
    }
}
