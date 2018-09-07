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

### 2. bean的创建时机

1. beanFactory需要等到获取某一个bean的时候才会创建该bean -- 延迟初始化。
2. ApplicationContext在启动容器的时候就会创建所有的bean（Web应用建议使用）  
可用过在bean元素中配置lazy-init参数设置是否延迟初始化：  
`<bean  id="person" class="com.lovestory.container.Person" lazy-init="default"></bean>
`  
如果要对xml中所有的bean都做延迟初始化，则在beans元素中配置default-lazy-init参数来控制延迟初始化(一般不用):  `<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd" default-init-method="true">
</beans>`


## 二 Bean的实例化方式
**例子：com.lovestory.beangenerate包下**
### 1. 构造器实例化（无参构造器）
最标准，使用最多

### 2. 静态工厂方法实例化（解决系统遗留问题）

### 3. 实例工厂方法实例化（解决系统遗留问题）

### 4. 实现FactoryBean接口实例化
实例工厂变种，如集成MyBatis框架（org.mybatis.spring.sqlSessionFactoryBean）使用。  
通过FactoryBean构造的对象都是单例的。

## 三 Bean的作用域
Bean的作用域：是指Spring容器中创建的Bean对象相对于其他Bean对象的请求可见范围：`<bean id="" scope=""></bean>`。  
**例子：com.lovestory.scope包下。**
> singleton

默认值，单例，在Spring IoC容器中仅存在一个Bean实例，使用较多。
> prototype

多例，每次从容器中调用Bean时，都会返回一个新的实例，即每次调用getBean()时，相当于执行new XxxBean()。**不会在容器启动时创建对象**。使用较多。  
> request

用于web开发，将Bean放入request的范围，`request.setAttribute("xxx");`，同一个request获得的Bean是同一个。

> session

用于web开发，将Bean放入session的范围，同一个session获得的Bean是同一个。

**注意 1 ：在开发中的bean一般都使用单例的。**
**注意2  ：在Struts1中的Action使用request，Struts2中的Action使用prototype类型，其他使用singleton。**

## 四 Bean的初始化和销毁
开发中，经常使用的DataSouce、SqlSessionfactory等最终需要关闭的资源，需要在Bean销毁之前，进行关闭资源操作。  

Bean的初始化操作配置如下：  
`<bean init-method="" destroy-method="" />`。  
init-method： Bean生命周期的初始化方法，在构造器执行（创建对象）之后，立即执行。  
destroy-method： 定义销毁之前的方法，在容器执行销毁之前调用。scope为多例时不会执行扫尾销毁工作。

## 五 Bean的生命周期
> Bean的生命周期

Bean的生命周期：是指Bena从出生到消亡之间的整个过程。  
BeanFactory具有延迟初始化特点；ApplicationContext在启动Spring容器时，就会创建Bean对象。

1. 启动Spring容器；
2. 创建Bean对象，即调用Bean对象的构造器；
3. 为Bean注入属性；
4. 调用Bean对象的初始化方法，init-method()方法；
5. 获取Bean对象，调用Bean对象中的方法；
6. 调用Bean对象的销毁方法，destroy-method()方法；
7. Spring容器销毁；

> Bean的完整生命周期方法

1. Bean自身方法： 包括Bean本身调用的方法和通过配置文件中<bean>的init-method和destroy-method指定的方法。
2. Bean级生命周期接口的方法：即和对象同一级的，包括BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean（属性设置完毕后执行方法）这些接口方法。
3. 容器级生命周期接口方法：包括InstantiationAwareBeanPostProcessor和BeanPostProcessor这两个接口实现，一般称他们的实现类为“后处理器”。
4. 工厂后处理器接口方法：包括AspectJWeavingEnabler、ConfigurationClassPostProcessor、CustomAurowireConfigure等非常有用的工厂后处理器接口方法。工厂后处理器也是容器级的，在应用上下文装配配置文件后立即调用。
