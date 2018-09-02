package com.lovestory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

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
	
	// 模拟IoC的操作
	@Test
	void testIocMock() throws Exception {
		String className = "com.lovestory.HelloSpring";
		HelloSpring spring = null;
		// 使用反射创建对象
		Class clazz = Class.forName(className);
		Constructor constructor = clazz.getConstructor();
		constructor.setAccessible(true);
		Object obj = constructor.newInstance();
		
		// 使用类型机制操作属性值
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			// HelloSpring类中所有的属性名称
			String propertyName = propertyDescriptor.getName();
			if ("username".equals(propertyName)) {
				// 调用username的setter方法
				propertyDescriptor.getWriteMethod().invoke(obj, "lovestory");
			} else if("age".equals(propertyName)) {
				propertyDescriptor.getWriteMethod().invoke(obj, 18);
			}
		}
		spring = (HelloSpring) obj;
		
		spring.sayHello();
	}
}
