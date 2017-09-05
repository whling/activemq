package com.whl.activemq.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Whling
 * @Date: Created in 18:41 2017/9/5
 * @Modified By:
 * @Description:
 */
public class SpringMessageConsumer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring/applicationContext-consumer.xml");
    }
}
