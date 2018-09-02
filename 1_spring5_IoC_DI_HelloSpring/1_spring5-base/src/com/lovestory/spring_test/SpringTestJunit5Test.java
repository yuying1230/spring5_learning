package com.lovestory.spring_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// 查看源代码发现该注解是个组合注解，包含了ContextConfiguration等注解
// 此时使用类名-context.xml配置文件，即SpringTestJunit5Test-context.xml
@SpringJUnitConfig
public class SpringTestJunit5Test {

	@Autowired
	private SpringTestBean stb;
	
	@Test
	void testName() throws Exception {
		stb.doWork();
	}
}
