package com.lovestory.lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
	// 最好的手动关闭容器的方法
	@Test
	void testName() throws Exception {
		ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("com/lovestory/lifecycle/ContainerSpringTest-context.xml");
		MyDataSource data = ctx.getBean("myDataSource", MyDataSource.class);
		data.doWork();
		// ctx.close();  // 手动关闭
		ctx.registerShutdownHook(); // 把Spring线程作为JVM的子线程
	}
}
