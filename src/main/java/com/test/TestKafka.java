package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import scala.actors.threadpool.TimeUnit;

public class TestKafka {

	public static void main(String[] args) throws InterruptedException {
		 ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config/spring-consumer.xml");
	        TimeUnit.HOURS.sleep(1);

	}

}
