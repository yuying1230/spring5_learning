## 一 DI概述
### 1. DI（Dependency Injection，依赖注入）
DI：是指Spring创建对象的过程中，将对象依赖属性（常量、对象、集合等）通过配置设值给该对象。  
一般来说，IoC是指将对象的创建权交给Spring容器

### 2. 注入（Injection）
注入：简单来说就是给对象设置值

> 注入方式

1. 调用对象的setter方法
2. 调用构造器
> 设值值的类型

1. 常量类型（固定不变），其实就是一个简单类型的值，对应<value>元素。
2. 对象类型（引用类型），对应<ref>元素。
3.集合类型，对应<set>、<list>等元素。

## 二 装配方式
### 1. XML配置
#### 1.1 XML自动装配
通过XML配置自动装配的方式不推荐，只做了解。
**例子：com.lovestory.autowired包中**
xml装配是在bean元素中设置autowire属性：`<bean id="" class="" autowire=""/>`。  
autowire属性：让Spring容器按照一定的规则方式自己去找合适的对象，并完成DI操作，autowire包括以下值：
1. default：不要自动注入，缺省值。
2. byType：按照依赖对象的类型注入。
3. byName：按照依赖对象的名字注入，按照id属性值的名字在spring中找bean。
4. constructor：按照对象的构造器上面的参数类型注入。

**注意1：byName自动注入方式要求所有的属性名字和id的名字必须保证一种规范的命名方式。**  
**注意2：byType自动注入方式，如果Spring中同一个类型有多个实例，会报bean不是唯一类型错误，该方式不推荐，作了解。**
#### 1.2 setter注入/属性注入
setter注入是通过对象的setter方法来完成对象的设置操作
> 使用bean元素的<property>子元素设置

**例子：com.lovestory.di_setter包中**
1. 常量类型，使用value属性赋值
Spring
2. 引用类型，使用ref属性赋值
3. 集合类型，使用对应的集合类型元素  

**注1：Spring是通过属性的setter方法注入值  
注2：配置文件中配置的值都是String类型，Spring可以自动完成类型转换  
注3：属性值的设置是在init-method()方法执行之前完成的**
