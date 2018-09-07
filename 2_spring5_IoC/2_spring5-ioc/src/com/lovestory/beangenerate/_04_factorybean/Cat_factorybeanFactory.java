package com.lovestory.beangenerate._04_factorybean;

import org.springframework.beans.factory.FactoryBean;

public class Cat_factorybeanFactory implements FactoryBean<Cat_factoryBean> {

	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}

	// 实例工厂的方法
	@Override
	public Cat_factoryBean getObject() throws Exception {
		System.out.println("username : " + username);
		Cat_factoryBean cat_f = new Cat_factoryBean();
		return cat_f;
	}

	@Override
	public Class<?> getObjectType() {
		return Cat_factoryBean.class;
	}

}
