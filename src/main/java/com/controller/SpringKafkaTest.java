package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author pengjw
 * @Title: SpringKafkaTest
 * @ProjectName demo
 * @Description: TODO
 * @date 2018/8/2716:39
 */
public class SpringKafkaTest {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring-kafka.xml");
        KafkaTemplate kafkaTemplate = ctx.getBean("kafkaTemplate", KafkaTemplate.class);
        for(int i=0;i<10;i++){
            String message="这是第"+i+"条信息";
            kafkaTemplate.send("topicOne",message);
            System.out.println("message="+message);
        }

    }
}
