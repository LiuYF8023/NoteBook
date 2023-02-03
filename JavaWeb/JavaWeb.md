# JavaWeb

[TOC]

# 1、Web核心

![image-20230203101323580](pictures/image-20230203101323580.png)

# 2、HTTP

## 2.1 概念

HTTP定义了 客户端和服务器通信时，发送数据的格式

基于 TCP / IP 的高级协议

默认端口号是：**80**

基于请求响应模型，一次请求对应一次响应，例如点击商品添加到购物车是一次请求

无状态的：每次请求之间相互独立，不能交互数据。例如点击商品添加到购物车和去购物车查看，这两个操作是相互独立的。这也是HTTP的缺陷，在Java中使用会话技术来解决这个问题。

## 2.2 历史版本

### 2.2.1 1.0 版本

每一次请求响应都会建立新的链接

### 2.2.2 1.1 版本

链接会进行复用

## 2.3 请求消息数据格式

### 2.3.1 请求行

         请求方式 请求url 请求协议/版本

例如：GET        /login.html  HTTP/1.1 

### 2.1.2 请求头

第二行开始，格式是key：value的格式

![image-20230203103759902](pictures/image-20230203103759902.png)

User-Agent中有浏览器的标识，用于处理不同浏览器的显示效果保持一致

### 2.1.3 请求体

POST请求的最后一部分，存放请求参数

![image-20230203104300540](pictures/image-20230203104300540.png)



GET和POST的区别

- GET请求请求参数在请求行中，没有请求体。POST请求请求参数在请求体中
- GET请求请求参数大小有限制，POST没有

## 2.4 响应消息数据格式

### 2.4.1 响应行

组成：协议/版本 响应状态吗 状态码描述

```java
HTTP/1.1 200 OK
```

响应的状态码：服务器告诉客户端浏览器本次请求和响应的状态

状态码都是3位数字

状态码分类：

1xx：服务器接受客户端消息，但没有完成，等待一段时间之后，发送1xx多状态码（服务器给客户端发送）

2xx：成功。代表状态码200 当然200多的也表示成功

3xx：重定向。代表数字（重定向 302）（访问缓存 304）

4xx：客户端错误 代表（请求路径没有对应的资源 404）（请求方式没有对应的doXXX方法 405）

![Untitled](pictures/Untitled.png)

5xx：服务器端错误 代表 （服务器内部异常 500）

![Untitled](pictures/Untitled%201.png)

### 2.4.2 响应头

格式：头名称：值

常见的响应头

Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式

Content-Length: 内容长度

Content-disposition：服务器告诉客户端以什么格式打开响应体数据

值：

in-line：默认值，在当前页面打开

attachment：以附件形式打开响应体。文件下载

### 2.4.3 响应体

```java
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    hello response
  </body>
</html>
```

# 3、Tomcat

web服务器是一个应用程序，对HTTP协议的操作进行封装，是程序员不必直接对协议进行操作，让web开发更加便捷。

## 3.1 服务器软件

### 3.2.1 什么是服务器

安装了服务器软件的计算机

### 3.2.2 服务器软件

接受用户的请求，处理请求，做出相应

### 3.2.3 web服务器软件

接受用户的请求，处理请求，做出相应，用户可以通过浏览器访问并浏览相应的内容

常见的javaweb服务器软件

webLogic：支持所有的JavaEE规范

webSphere：支持所有的JavaEE规范

JBOSS：支持所有的JavaEE规范

Tomcat：Apache基金组织，支持Servlet，jsp等规范

## 3.2 Tomcat下载和安装

### 3.2.1 下载

去官网下载即可

### 3.2.2 安装

解压压缩文件即可

![Untitled](pictures/1577.png)

### 3.2.3 卸载

删除文件即可

### 3.2.4 启动

Mac需要cd到相应的目录，使用下面的命令启动

```bash
sh start.sh
```

然后在浏览器中127.0.0.1:8080就能进入（或者localhost:8080也能进入）用自己的ip地址也可以访问，这个是用同一局域网的手机访问获得的

<img src="pictures/131662128529_.pic.jpg" alt="131662128529_.pic.jpg" style="zoom:25%;" />

报错的情况

窗口一闪而过：没有正确的配置JAVA_HOME

启动报错

第一种：找到占用的端口号，并且找到对应的进程杀死该进程

```bash
netstat -ano
```

第二种：修改自身的端口号

一般将tomcat的端口号设置为默认80，这样在输入地址的时候不需要输入端口号

### 3.2.5 关闭

正常关闭：命令行sh shutdown.sh或者在命令行中ctrl+c

强制关闭：点击窗口的关闭

### 3.2.6 配置

项目部署的方式

第一种

创建一个自己的项目，然后将它放在webapp的目录当中

比如我们创建一个hello项目

我们访问的时候就需要localhost:8080/hello/index.html  注意端口号的位置

简化部署：将项目打包成一个war包，再将war包放置到webapps目录下，会自动解压缩，也会自动删除

第二种

比较灵活的一个方式，配置conf /server.xml

在<host>标签体中配置

```bash
<Context docBase="项目存放的物理路径" path="/虚拟路径">
```

这时只要一访问虚拟路径就行

第三种

在Catalina目录的localhost中，创建一个xml文件，把server.xml中刚刚的内容复制过来

静态项目和动态项目

目录结构

java动态项目的目录结构

项目的根目录

WEB-INF目录：

web.xml：web项目的核心配置文件

classes目录：放置字节码文件的目录

lib目录：放置依赖的jar包

**tomcat集成到IDEA中**

没法创建javaweb项目的解决方案

[2021新版idea创建java项目没有javaEE模块没有webApplication_实在不想秃的博客-CSDN博客_idea没有javaee](https://blog.csdn.net/qq_44764558/article/details/119684737)

还有一个问题搞了好久，就是一直404，原因是因为tomcat端口被占用了，首先kill掉这个端口，就可以正常访问我们的hello.html页面了。

## 3.3 IDEA中创建Maven Web项目

### 3.3.1 web项目结构

![image-20230203112749928](pictures/image-20230203112749928.png)



我们在maven中生成的模板

![image-20230203112450061](pictures/image-20230203112450061.png)

打包后的

![image-20230203112550554](pictures/image-20230203112550554.png)



注意要补齐缺失的目录

![image-20230203113033211](pictures/image-20230203113033211.png)

## 3.4 IDEA中集成Tomcat

### 3.4.1 IDEA的Tomcat插件

#### 1）添加tomcat server

![image-20230203113425183](pictures/image-20230203113425183.png)



#### 2）选择下载的tomcat目录

![image-20230203113609167](pictures/image-20230203113609167.png)

#### 3）访问a.html

![image-20230203113843325](pictures/image-20230203113843325.png)



#### 4）tomcat插件启动

tomcat插件的速度比idea自带的更快

![image-20230203114324940](pictures/image-20230203114324940.png)

# 4、Servlet

## 4.1 概念 

Servlet是Java提供的一门动态web资源开发技术

那么我们需要做的就是写一个类实现Servlet接口，复写其中的方法。

![141662193237_.pic.jpg](pictures/141662193237_.pic.jpg)

## 4.2 Servlet快速入门

### 4.2.1 导入坐标

```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
```

依赖范围必须是provided，provided在编译环境和测试环境有效，但是在运行环境无效，当我们打成war包时，不会有这个包，因为tomcat中已经有这个包了，所有如果我们还打进去，就会发生冲突。

### 4.2.2 创建类

```java
@Override
public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
   System.out.println("service method excute");
}
```

### 4.2.3 配置注解

```java
@WebServlet("/demo1")
```

demo1表示当前这个类的资源路径

### 4.2.4 启动tomcat

启动tomcat之后，我们就能够看到service方法输出的内容

![image-20230203123549328](pictures/image-20230203123549328.png)



## 4.3 Servlet 执行流程

### 4.3.1 url访问

![image-20230203123821095](pictures/image-20230203123821095.png)

- localhost:8080 访问的是tomcat服务器
- web-demo访问的是项目
- demo1访问的是我们定义的类

![image-20230203124004436](pictures/image-20230203124004436.png)

- servlet对象是由web服务器创建，其中的方法也是由web服务器调用

  

## 4.4 Servlet 声明周期

### 4.4.1 加载和实例化

默认情况下，当servlet第一次被访问的时候，由容器创建Servlet对象

### 4.4.2 初始化

servlet实例化之后，容器将调用Servlet中的init方法，完成加载配置文件、创建连接等初始化的工作，该方法只调用一次

### 4.4.3 请求处理

每次请求Servlet时，Servlet容器都会调用Servlet的Service方法对请求进行处理

### 4.4.4 服务终止

当要释放内存或者容器关闭的时候，容器就会调用Servlet的destroy方法完成对资源的释放。

![image-20230203125815500](pictures/image-20230203125815500.png)

- inti 第一次访问时
- service 访问资源时
- destroy 终止项目

### 4.4.5 getServletInfo

```java
@Override
public String getServletInfo() {
   return null;
}
```

返回一些信息

### 4.4.6 getServletConfig

```java
public ServletConfig getServletConfig() {
   return null;
}
```

获取Servlet对象配置

## 4.5 Servlet 体系结构

![image-20230203130726212](pictures/image-20230203130726212.png)

### 4.5.1 HttpServlet方法

```java
package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo3")
public class WebServletDemo3 extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("get ...");
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("post ...");

   }
}
```

![image-20230203130934968](pictures/image-20230203130934968.png)



## 4.6 Servlet urlPattern配置



## 4.7 XML配置方式编写Servlet





## 3.2 Response对象

### 3.2.1 功能：设置响应消息

设置响应行

格式：HTTP/1.1 200 OK

设置状态码：setStatus(int sc)

设置响应头

setHeader(String name,String value)

设置响应空行

使用步骤

获取输出流

字符输出流：PrintWriter getWriter()

字节输出流：ServletOutputStream getOutputStream()

使用输出流，将数据输出到客户端浏览器

### 3.2.2 案例

1⃣️  完成重定向

1）资源跳转的方式

![Untitled](pictures/Untitled%202.png)

我们重定向我们一共需要做两件事，第一件事是设置状态码，第二件事是设置响应头的location

首先我们新建两个class文件，分别是responseDemo1和responseDemo2。

然后我们在访问responseDemo1时，会自动调用doGet方法，那么我们需要在doGet中调用doPost方法，并且要在doPost方法中实现重定向的功能，为了验证我们正确重定向，我们在responseDemo2的doGet方法中打印一句话。

代码如下

```java
@WebServlet("/responseDemo1")
public class responseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置状态码
        resp.setStatus(302);
        // 设置location响应头
        resp.setHeader("location","/responseDemo2");
    }
}
```

```java
@WebServlet("/responseDemo2")
public class responseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是重定向过来的！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
```

重定向成功

![Untitled](pictures/Untitled%203.png)

**进阶**

另一个简单的重定向方法`resp.sendRedirect("/responseDemo2");` 只需要这一行代码就可以

2）重定向的特点

地址栏发生变化

重定向可以访问其他站点（服务器）的资源

重定向是两次请求

3）转发的特点

转发地址栏路径不变

转发只能访问当前服务器下的资源

转发是一次请求

4）路径写法

路径的分类

**相对路径**：通过相对路径不可以确定唯一资源

例如 ./index/html 就是一个相对路径

规则：找到当前资源和目标资源之间的相对位置关系，注意是当前资源为基准，来看目标资源应该怎么找

例如：

当前资源 http://localhost/day15/index.html

目标资源 http://localhost/day15/responseDemo2

那么相对路径就是./responseDemo2

例如：

当前资源 http://localhost/day15/demo/index.html

目标资源 http://localhost/day15/responseDemo2

那么相对路径就是../responseDemo2

./ 当前目录

../ 后退一级目录

../../ 后退两级目录

**绝对路径：**

例如 [http://localhost/day15/responseDemo2](http://localhost/day15/responseDemo2) 这种以/开头的路径叫做绝对路径

规则：判断定义的路径给谁用的？判断这个请求由哪里发出

给客户端浏览器使用：需要加虚拟目录，比如在客户端进行资源访问，这个就是客户端发出的。

给服务器用：不需要加虚拟目录，比如服务器之间的转发

这里有个问题

由于我们Tomcat的虚拟路径设置的是/ ，所以在进行服务器页面转发的时候

![Untitled](pictures/Untitled%204.png)

这个地方应该写什么呢？黑马的教程中，设置的虚拟目录是/day15，所以这里不用写虚拟路径直接/responseDemo2，那么我的虚拟路径写的是/，写了/responseDemo2是正确的，但是我把虚拟路径写成/feng，然后直接这里填/responseDemo2也是正确的。。

注意一个问题：如果我们把虚拟目录写死了，那么一旦改变了虚拟目录，那么所有的都需要去改。

```java
// 动态获取虚拟目录
String contextPath = req.getContextPath();
```

顺便看一下，虚拟目录设置为/ 和 /feng 有什么区别

首先我们设置为/ ，打开页面地址是这样的，我们要访问responseDemo1就应该加上/responseDemo1

![Untitled](pictures/Untitled%205.png)

如果设置为/feng，打开页面地址是这样的，我们要访问responseDemo1就应该加上responseDemo1就行，注意少了个斜杠。

![Untitled](pictures/Untitled%206.png)

但是如果是html页面是没有办法动态获取虚拟路径的，这个时候我们使用JSP是可以实现的，后面再说。

2⃣️  服务器输出字符数据到浏览器

首先来看一个比较简单的部分，我们使用PrintWriter获取字符的输出流，然后输出到页面上

```java
// 1、 获取字符输出流
PrintWriter pw = resp.getWriter();

// 2、输出
pw.write("你们 hello http!!");
```

浏览器的默认编码格式是GBK，而我们resp.getWriter();获取的是ISO编码，这就是编码和解码不一致导致的，我们在获取流之前，就应该规定编码。

![Untitled](pictures/Untitled%207.png)

现在虽然能够输出，但是只是恰巧。如果其他的浏览器默认不是GBK呢？

```java
// 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码
resp.setHeader("content-type","text/html;charset=utf-8");
```

但是还有一个更简单的方法

`resp.setContentType("text/html;charset=utf-8"); // 服务器发送给客户端的` 是一个响应头，这行代码一般写到doGet的最前面。

3⃣️  服务器输出字节数据到浏览器

步骤与2⃣️ 类似，只不过是获取字节流

```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 设置编码格式
    resp.setContentType("text/html;charset=UTF-8");
    // 1、获取字节输出流
    ServletOutputStream sos = resp.getOutputStream();
    // 2、输出
    sos.write("你好 Hello".getBytes());
}
```

4⃣️  验证码

