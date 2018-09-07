package com.lovestory.scope;

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
	private Dog dog1;
	
	@Autowired
	private Dog dog2;
	
	// com.lovestory.scope.Dog@3b00856b
	// com.lovestory.scope.Dog@3b00856b
	@Test
	void testScope() throws Exception {
		System.out.println(dog1);
		System.out.println(dog2);
	}
	
}
