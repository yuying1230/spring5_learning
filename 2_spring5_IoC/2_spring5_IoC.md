## 一 IoC容器
### 1. IoC容器概述
> IoC容器的作用

调用者只管负责从Spring容器中获取需要使用的对象，不关心对象的创建过程，也不关心该对象依赖对象的创建以及依赖关系的组装。  
将创建对象的控制权反转给了Spring框架。

> Spring IoC容器

1. BeanFactory  
BeanFactory是Spring最底层的接口，只提供了IoC的功能，负责创建、组装、管理bean。  
一般在应用中推荐使用BeanFactory的子接口ApplicationContext。  
例子如demo的com.lovestory.container.ContainerTest类
2. ApplicationContext
ApplicationContext接口继承了BeanFactory，还提供了AOP集成、国际化处理、事件传播和统一资源加载等功能。  
`public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory, MessageSource, ApplicationEventPublisher, ResourcePatternResolver{
}`  
例子如demo的com.lovestory.container.ContainerTest类

> bean的创建时机

1. beanFactory需要等到获取某一个bean的时候才会创建该bean -- 延迟初始化。
2. ApplicationContext在启动容器的时候就会创建所有的bean（Web应用建议使用）  
可用过在bean元素中配置lazy-init参数设置是否延迟初始化：
`<bean  id="person" class="com.lovestory.container.Person" lazy-init="default"></bean>
`  
如果要对xml中所有的bean都做延迟初始化，则在beans元素中配置default-lazy-init参数来控制延迟初始化(一般不用)：`<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd" default-init-method="true">
</beans>`


### 2. BeanFactory
