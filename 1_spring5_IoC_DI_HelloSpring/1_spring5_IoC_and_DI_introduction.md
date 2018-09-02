## 一 IoC
### 1. IoC概述
> 什么是IoC？

IoC（Inversion of Control，控制反转），是指将原来在程序里面手动创建对象操作的控制权移交给Spring框架去管理。   
其实，**IoC是一种设计思想，而非一种技术。**。
> 主动控制  

调用者自己对将要使用的对象以及该对象的依赖对象进行创建和组装。如图所示：
![selfcontrol](./images/selfcontrol.png)

> 反转控制

调用者无需关心对象的创建过程、该对象的依赖对象的创建以及他们的组装，而是将这些操作的控制权交给了Spring框架，调用者只需要从Spring框架中获取相关对象。如图所示：
![controlled](./images/cotrolled.png)
### 2. DI概述
> 什么是DI？

DI（Dependency Injection，依赖注入），指在Spring创建对象的过程中，将其所依赖的属性（常量、对象或集合等）配置到该对象中。
> IoC与DI的区别与联系

IoC是指将创建对象的控制权转交给Spring容器，DI不仅强调了对象由Spring容器来创建，并且强调了对象之间的依赖关系。
DI更明确的说明了“被注入的对象（例如UserService）依赖IoC容器对其依赖的对象（UserDao）进行配置”。
## 二 程序演练
### 1. 依赖jar包
jar包下载：在[spring官网](http://repo.springsource.org/libs-release-local/org/springframework/spring/5.0.2.RELEASE/)中选择相应版本下载。  
### 2. 创建工程（IDE：STS）
1. 新建java project，创建lib目录并导入Spring5的核心jar包，将jar包添加到build path。如图所示：
![newproject](./images/newproject.jpg)
2. 新建source folder类型的resources目录用来存放配置文件，创建applicationContext.xml文件并配置schema约束（STS可以直接创建spring使用的文件形式）。如图所示：
![sourcefolder](./images/sourcefolder.jpg)
![applicationContext](./images/applicationContext.jpg)
如果没有使用STS开发工具，则需要自行创建一个名为apllicationContext.xml文件，并配置schema约束，约束可以通过下载的spring包中的docs目录中间接查看，路径如图：
![corehtml](./images/corehtml.jpg)
然后在网页中搜索"<beans"关键字，将查询到的内容复制到xml文件中即可，如图所示：
![corebeans](./images/corebeans.jpg)
3. 新建HelloSpring类和HelloSpringTest测试类：
HelloSpring类如图：
![hellospringcode](./images/springhellocode.jpg)
测试类使用JUnit5，如果报错，解决方式如图所示：
![addjunit5lib](./images/addjunit5lib.jpg)
4. 配置applicationContext.xml
![xmlconfig](./images/xmlconfig.jpg)
5. 运行测试类会发现报错，查看原因是由于缺少logging依赖包，则需要下载commons-logging的jar包，拷贝到lib下并添加到build path。
![testerror](./images/testerror.jpg)
6. 前述问题解决后，测试通过
![testsuccess](./images/testsuccess.jpg)
## 程序分析
### 1. 什么是BeanFactory
BeanFactory表示Spring IoC容器，是生产bean对象的工厂，负责配置、创建和管理bean的生命周期，是Spring最古老的接口。  
Spring IoC容器所管理的对象就称为bean。
### 2. Spring IoC容器如何知道哪些是它所管理的对象
Spring IoC通过读取配置文件中所配置的元数据，通过元数据对应用中的各个对象进行实例化及装配。
> 三种元数据的配置方式
1. XML-based configuration
2. Annotation-based configuration
3. Java-based configuration
### 3. Spring IoC管理bean的原理
1. 通过Resource对象加载配置文件
2. 解析配置文件，得到指定名称的bean
3. 解析bean元素，id作为bean的名字，class用于反射得到bean的实例。其中，**bean类必须存在一个无参构造器（和访问权限无关）**
4. 调用getBean()方法的时候，从容器中返回对象实例

其实，就是把代码从java文件转移到了xml文件中。




