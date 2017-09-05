package com.whl.activemq.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * @Author: Whling
 * @Date: Created in 18:41 2017/9/5
 * @Modified By:
 * @Description:
 */
public class SpringMessageProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-producer.xml");
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        Queue queue = (Queue) applicationContext.getBean("queueDestination");
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("hello,spring is coming");
                return message;
            }
        });
    }
}
