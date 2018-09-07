package com.lovestory.container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ContainerTest {

	// 使用beanFactory
	// 先执行 ------， 再打印person...
	
	// 说明BeanFactory有延迟初始化（懒加载）的特点，在创建Spring容器的时候，不会立即创建容器中的bean对象
	// 而是等到从容器中获取对象的时候才会创建对象
	@Test
	void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource("com/lovestory/container/container.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("--------------------------------");
		Person person = factory.getBean("person", Person.class);
		System.out.println(person);
	}
	
	// 使用ApplicationContext
	// 先打印person...，再执行 ------
	
	// 说明ApplicationContext在创建Spring容器的时候，就会立即创建容器中的bean对象
	// 而不会等到从容器中获取对象的时候才创建对象
	@Test
	void testApplicationContext() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/lovestory/container/container.xml");
		System.out.println("--------------------------------");
		Person person = context.getBean("person", Person.class);
		System.out.println(person);
	}
}
