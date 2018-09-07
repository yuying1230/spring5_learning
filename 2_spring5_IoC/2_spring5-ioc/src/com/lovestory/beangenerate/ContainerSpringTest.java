package com.lovestory.beangenerate;

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
	private Cat_constructor cat_c;
	
	@Autowired
	private Cat_staticFactory cat_s;
	
	@Autowired
	private Cat_instance cat_i;
	
	@Autowired
	private Cat_factoryBean cat_f;
	
	@Test
	void testConstructor() throws Exception {
		System.out.println(cat_c);
	}
	
	@Test
	void testStaticFactory() throws Exception {
		System.out.println(cat_s);
	}
	
	@Test
	void testInstanceFactory() throws Exception {
		System.out.println(cat_i);
	}
	
	@Test
	void testFactoryBeanFactory() throws Exception {
		System.out.println(cat_f);
	}
}
