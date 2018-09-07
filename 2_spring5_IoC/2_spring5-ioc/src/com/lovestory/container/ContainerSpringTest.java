package com.lovestory.container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ContainerSpringTest {

	@Autowired
	private Person person;
	
	@Autowired
	private BeanFactory factory;
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	void testName() throws Exception {
		System.out.println(person);
		System.out.println(factory);
		System.out.println(context);
	}
}
