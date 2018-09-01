package com.lovestory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloSpringTest {
	
	@Test
	void testName() throws Exception {
		HelloSpring spring = null;
		// 1、从classpath路径(工程字节码的bin目录)寻找配置文件并创建资源对象
		Resource resource = new ClassPathResource("applicationContext.xml");
		// 2、根据资源对象创建Spring IoC容器（factory）对象
		BeanFactory factory = new XmlBeanFactory(resource);
		// 3、从Spring IoC容器中获取HelloSpring的对象
		spring = (HelloSpring) factory.getBean("helloSpring");
		spring.sayHello();
	}
}
