package com.lovestory.spring_test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 运行Spring的jUnit4
@RunWith(SpringJUnit4ClassRunner.class)
// 上下文配置对象（寻找配置文件的）
// @ContextConfiguration()不加参数时默认查到当前目录下SpringTestTest-context.xml
@ContextConfiguration("classpath:com/lovestory/spring_test/springtest.xml")
public class SpringTestTest {
	
	// 表示自动按照类型去Spring IoC容器中找到bean对象，并设置给该字段
	@Autowired
	private SpringTestBean stb;
	
	@Test
	public void testName() {
		stb.doWork();
	}
}
