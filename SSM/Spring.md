# Spring

[TOC]

# 一、初识Spring

Spring提供若干项目，每个项目用于完成特定的功能

Spring全家桶中比较常见的技术

- Spring Framework
- Spring Boot
- Spring cloud

Spring的发展

- Spring1.0 纯配置型的开发
- Spring2.0 引入注解开发
- Spring3.0 不写配置的开发模式
- Spring4.0 API变化
- Spring5.0 全面支持JDK8

# 二、Spring Framework系统架构

## 2.1 系统架构

![image-20230113203455854](pictures/image-20230113203455854.png)

Spring框架在4.0趋于完整，因此我们着重看4.0以后的架构

### 2.1.1 Core Container

![image-20230113203604929](pictures/image-20230113203604929.png)

容器中装的是对象

### 2.1.2 AOP和Aspects

![image-20230113203741018](pictures/image-20230113203741018.png)

AOP是一种编程思想，能够在不改变源程序得到前提下增强功能

Aspects是AOP思想的实现。

### 2.1.3 Data Access

![image-20230113204000064](pictures/image-20230113204000064.png)

Spring能够实现数据访问，并且能够集成其他方案。值得一提的是，Spring很好的实现了Transaction事务。

### 2.1.4 Web

Spring也能够进行Web开发

![image-20230113204058547](pictures/image-20230113204058547.png)

### 2.1.5 Test

![image-20230113204138395](pictures/image-20230113204138395.png)

Spring在单元测试和集成测试也进行了实现。

## 2.2 学习路线

![image-20230113204416805](pictures/image-20230113204416805.png)

# 三、核心概念

为了解决耦合度偏高的问题，在使用对象的时候，程序中不要主动使用new产生对象，转换为由**外部提供对象**。对象的控制权由程序转移到外部的思想就是控制反转。（对象的控制权）

Spring技术对IOC思想进行实现**（IoC管理Bean）IoC（inversion of Control）控制反转**

- Spring提供了一个容器，称为IOC容器，用来充当IOC思想中的外部。也就是说，现在对象我在IOC容器中往外拿。
- Ioc容器负责对象的创建、初始化等一系列的工作，被创建或被管理的对象在Ioc容器中统称为Bean

DI（dependency injection）依赖注入**（Bean的关系绑定）**

- 在容器中建立bean与bean之间的依赖关系的整个过程，称为依赖注入。



最终效果：使用对象的时候可以直接从IOC容器中获取，并且获取到的Bean已经绑定了所有的依赖关系

# 四、IoC入门案例思路分析及实现

## 4.1 IoC思路分析

### 4.1.1 管理什么？（Service与Dao）

先熟悉一下Java Web三层架构 https://www.cnblogs.com/cielosun/articles/5752272.html

我们的项目架构如下，也是常见的结构

![image-20230113213136565](pictures/image-20230113213136565.png)

每个代码的运行逻辑

**Dao层**

接口

```java
package com.itheima.dao;

public interface BookDao {
	public void save();
}

```

实现类

```java
package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
	public void save(){
		System.out.println("book dao save ... ");
	}
}

```

**Service层**

接口

```java
package com.itheima.service;

public interface BookService {
	public void save();
}

```

实现类

```java
package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
   private BookDao bookDao = new BookDaoImpl();

   public void save(){
      System.out.println("book service save ...");
      bookDao.save();
   }
}
```

两个实现类都继承了各自的接口，主程序如下

```java
package com.itheima;

import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;

public class App {
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		bookService.save();
	}
}

```

主程序中，我们首先创建了接口的对象（但是对象中没有构造方法，必须被继承的子类实现其中的抽象方法）所以都必须要实现其save方法。所以首先输出的是"book service save ..."，然后因为又创建了Dao的对象，所以执行bookDao.save();时，输出"book dao save ... "。这个例子还是比较简单的。

### 4.1.2 如何将被管理的对象告知IoC容器？（配置）

怎么去配置bean？

首先我们需要导入spring的依赖，这里我们使用下面的依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.4</version>
</dependency>
```

然后在resources里面创建一个spring，IDEA中创建的方式如图

![image-20230113223021620](pictures/image-20230113223021620.png)

创建好之后，我们就在XML文件中进行相关bean的配置，主要是两步

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--    1、导入spring的坐标spring-context-->

    <!--    2、配置bean-->

    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl"/>
    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl"/>
</beans>
```

id表示起的名字，class表示是哪个类，是一个路径。

然后我们重新书写4.1.1中的代码

### 4.1.3 被管理的对象交给IoC容器，如何获取到IoC容器？（接口）

```java
// 3、获取IoC容器
// ApplicationContext是一个接口，不能实例化，应该用他的实现类
ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
```



### 4.1.4 IoC容器得到后，如何从容器中获取bean？（接口方法）

```java
// 4、获取bean
BookDao bookDao = (BookDao)ctx.getBean("bookDao");
bookDao.save();
```

ctx.getBean("bookDao"); 返回的结果是object，我们既然要使用BookDao（接口），那么应该对其进行转型。

然后直接调用方法就行。

这里碰到一个问题，就是spring framework与jdk的对应关系 https://blog.csdn.net/a321123b/article/details/123568578

![image-20230113224329410](pictures/image-20230113224329410.png)

比如我是jdk8然后导入的是6.0的spring，就会报如下的错误

![image-20230113224448011](pictures/image-20230113224448011.png)

我们只要改成spring5的版本就不会报错了。

![image-20230113224548796](pictures/image-20230113224548796.png)

同样的道理，我们也可以拿出Service

```java
BookService bookService = (BookService)ctx.getBean("bookService");
```



### 4.1.4 使用Spring导入哪些坐标？（pom.xml）

注意版本对应

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.3.25</version>
</dependency>
```

## 4.2 实现

完整App2程序

```java
package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
   public static void main(String[] args) {
      // 3、获取IoC容器
      // ApplicationContext是一个接口，不能实例化，应该用他的实现类
      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

      // 4、获取bean
      BookDao bookDao = (BookDao)ctx.getBean("bookDao");
      BookService bookService = (BookService)ctx.getBean("bookService");
      bookDao.save();
      bookService.save();
   }
}
```

# 五、DI入门案例

在四中我们虽然实现了bean的配置，但是我们发现，在程序中，还是避免不了创建对象，例如

![image-20230113225633450](pictures/image-20230113225633450.png)

这个时候就需要用到我们的依赖注入

