package com.lovestory.lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.lovestory.beangenerate._01_constructor.Cat_constructor;
import com.lovestory.beangenerate._02_staticFactory.Cat_staticFactory;
import com.lovestory.beangenerate._03_instance.Cat_instance;
import com.lovestory.beangenerate._04_factorybean.Cat_factoryBean;

@SpringJUnitConfig
public class ContainerSpringTest {

	@Autowired
	private MyDataSource dataSource;
	
	@Test
	void testLifeCycle() throws Exception {
		dataSource.doWork();
	}
	
}
