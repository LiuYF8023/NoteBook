# SpringMVC

[TOC]

# 1、SpringMVC入门案例

## 1.1 导包

分别导入的是servlet和springmvc的maven包。注意springMVC的要与springframework版本保持一致

```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>3.1.0</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>5.3.23</version>
</dependency>
```

![image-20230203193755430](pictures/image-20230203193755430.png)

webmvc中的前几个都是spring中的东西，最后一个是创建一个mvc项目必不可少的。



## 1.2 创建控制器类

```java
package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 2、定义controller
// 2.1 使用注解
@Controller
public class UserController {
   // 2.2 设置当前操作的访问路径
   @RequestMapping("/save")
   // 2.3 设置当前操作的返回值类型
   @ResponseBody
   public String save(){
      System.out.println("user save ...");
      return "'module':'springmvc'";
   }
}
```

### 1.2.1 @Controller

这个注解是保证当前类属于用bean进行管理，要保证能够扫描到这个类

### 1.2.2 @RequestMapping("/save")

设置道歉Servlet访问的资源路径，也就是怎么样才能访问到这个类

### 1.2.3 @ResponseBody

设置当前操作的返回值类型



## 1.3 SpringMVC配置文件

springMVC配置文件类似于前面的spring在加载时的配置

```java
package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 3、 创建SpringMVC的配置文件，加载controller对应的bean
@Configuration
@ComponentScan("com.itheima.controller")
public class SpringMvcConfig {

}
```



## 1.4 Servlet容器启动配置类

前面配置好了SpringMVC的内容和Servlet的内容，那么怎么把二者之间联系起来

```java
package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 4、定义一个Servlet容器启动的配置类，在里面加载spring配置
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {

   // 加载springmvc的容器配置
   @Override
   protected WebApplicationContext createServletApplicationContext() {
      AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
      ctx.register(SpringMvcConfig.class);
      return ctx;
   }

   // 设置哪些请求之归springmvc处理
   @Override
   protected String[] getServletMappings() {
      return new String[]{"/"}; // / 表示所有请求
   }

   // 加载spring容器配置
   @Override
   protected WebApplicationContext createRootApplicationContext() {
      return null;
   }
}
```

我们定义一个Servlet的初始化容器，这个容器继承了AbstractDispatcherServletInitializer这个类，其中有三个方法

还有更简单的写法

![image-20230203204408884](pictures/image-20230203204408884.png)

```java
public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[]{SpringConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{SpringMvcConfig.class};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[]{"/"};
   }
}
```



### 1.4.1 createServletApplicationContext

这里面主要是加载springmvc的容器配置，然后返回springmvc容器的对象，这里用的是springmvc的专属容器AnnotationConfigWebApplicationContext

### 1.4.2 getServletMappings

用于设置哪些请求交给springmvc处理。/表示所有的请求

### 1.4.3 createRootApplicationContext

用于加载spring的容器，这里暂时还没用到，所以我们返回null

程序启动之后，我们在地址中加上/save，就能够看到返回的内容

![image-20230203200536068](pictures/image-20230203200536068.png)

![image-20230203200707526](pictures/image-20230203200707526.png)

这个项目中，一次配置这些，我们配置一次就行了，所以不用死记，或者说，直接copy就行了。

# 2、SpringMVC简介

## 2.1 SpringMVC入门案例流程分析

![image-20230203201235506](pictures/image-20230203201235506.png)

## 2.2 Controller加载控制与业务bean加载控制

SpringMVC加载的bean是表现层的bean，也就是使用注解@Controller标识的部分，而Spring控制的bean是业务层和功能层，即@service和@Repository标识的两部分，那么问题来了

![image-20230203201651484](pictures/image-20230203201651484.png)

我们在SpringMVCConfig和SpringConfig中都是在扫描com.itheima下面的包，也就是SpringMVC也会扫描到service和dao，Spring也会扫描到controller，那么如何让他们各自扫描各自的。

### 2.2.1 SpringMVC相关bean加载控制

SpringMVC加载的bean对应的包均在com.itheima.controller内

### 2.2.2 Spring相关bean加载控制

- 方式1：Spring加载的bean设置扫描范围为com.itheima，排除controller包内的bean
- 方式2：Spring加载的bean具体到service、dao包

我们创建一个相对来说完整的项目

![image-20230203202832763](pictures/image-20230203202832763.png)

方式1：

```java
@Configuration
//@ComponentScan({"com.itheima.dao","com.itheima.service"})
@ComponentScan(
   value = "com.itheima",
   excludeFilters = @ComponentScan.Filter(
         type = FilterType.ANNOTATION,
         classes = Controller.class
   )
)
public class SpringConfig {

}
```

方式2：

![image-20230203202907797](pictures/image-20230203202907797.png)



# 3、Postman工具

网页调试与发送网页HTTP请求的chrome插件，常用于进行接口测试

![image-20230203204921063](pictures/image-20230203204921063.png)

# 4、请求与响应

