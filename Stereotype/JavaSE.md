# JavaSE 常见问题

[TOC]

## 1、Java三大特性

### 1.1 封装

利用抽象数据类型将数据和基于数据的操作封装在一起，尽可能隐藏内部细节，向外部只开放一些接口，可以通过接口来访问对象。

优点：减少耦合、维护负担小、可重用性高

### 1.2 继承

继承是一种Is-a的关系，子类可以获得父类的非private属性和方法。父类引用指向子类对象称为向上转型。

### 1.3 多态

分为编译时多态和运行时多态

编译时多态指的是方法的重载，运行时多态有三个条件：继承、覆盖、向上转型

## 2、数据类型

### 2.1 八种数据类型及对应大小

boolean/1 注意boolean类型是一个bit

byte/8 一个字节

char/16 两个字节

short/16 两个字节

int/32 四个字节

float/32 四个字节

long/64 八个字节

double/64 八个字节

### 2.2 缓存池

new Integer(123) 与 Integer.valueOf(123)的区别在于 

new的方式每次都会新建对象，而Integer.valueOf使用的是缓冲池中的对象

```java
Integer x = new Integer(123);
Integer y = new Integer(123);
System.out.println(x == y);    // false
Integer z = Integer.valueOf(123);
Integer k = Integer.valueOf(123);
System.out.println(z == k);   // true
```

自动装箱过程，基本类型使用的都是缓冲池范围之内的进行自动装箱，但是如果超出这个范围自动装箱的两个就不再引用相同的对象了。下面的结果返回false

```java
Integer x = new Integer(128);
Integer y = new Integer(128);
System.out.println(z == k);   // false
```

## 3、String

String被声明为final，不可以被继承。内部实现用的是char数组

### 3.1 为什么要不可变

第一、因为String的hash值经常被使用，例如HashMap的key。不可变的特性使得hash值也不变，因此只需要进行一次计算。

第二、String pool的需要。如果一个String对象被创建过了，那么就会从String pool中取得引用。

第三、安全性。String经常作为参数，String的不可变性保证参数不变。

第四、线程安全 String的不可变性天生具备线程安全，可以在多个线程中安全的使用。

### 3.2 String StringBuffer StringBuilder

String是不可变的 StringBuffer和StringBuilder是可变的

String是线程安全的。StringBuilder不是线程安全的。StringBuffer是线程安全的，内部使用synchronized进行同步。

线程安全往往是牺牲了一部分性能。

### 3.3 String intern() 方法

intern()方法能够保证相同内容的字符串变量引用同一的内存对象

注意我们使用new 的方式创建的字符串对象，及时内容相同，他也不是放在常量池里的。

intern能将s1的引用对象先放到常量池，然后将s3指向常量池中的对象。

```java
String s1 = new String("aaa");
String s2 = new String("aaa");
System.out.println(s1 == s2);           // false
String s3 = s1.intern();
System.out.println(s1.intern() == s3);  // true
```

如果使用的是引号创建的字符串，那么它是直接放在常量池中的

```java
String s4 = "bbb";
String s5 = "bbb";
System.out.println(s4 == s5);  // true
```

## 4、值传递与引用传递

Java的参数传递方式是以值传递的方式传入方法中的，而不是引用

当new一个对象的时候，存储的是对象的地址，进行传参的过程中，本质上是将对象的地址以值的方式传递到形参中。因此方法中改变引用的对象，实际上并不影响原来的引用。



## 5、switch

从Java7开始，可以在switch条件判断语句中使用String对象

switch还支持byte、short、int或者char

不支持long类型，因为long类型的值往往比较复杂，用if更合适。



## 6、访问权限

### 6.1 里氏替换原则

第一、如果继承的目标是为了实现代码重用，那么共享的父类方法应该保持不变，不能被子类重新定义。子类只能通过添加新方法来扩展功能。子类对象和父类对象的方法逻辑性一致

第二、如果继承的目的是为了多态，那么子类需要覆盖并重新定义父类的方法，这个时候应该将父类定义为抽象类，并定义抽象方法。

### 6.2 访问权限修饰符

private一般不想被该类以外的其他类方法，protected一般只想让子类进行访问才设定，而public可以被任何类自由访问。



## 7、抽象类与接口

### 7.1 抽象类

抽象类中一般包含抽象方法，抽象方法一定位于抽象类中。

抽象类不能被实例化

### 7.2 接口

接口的成员（字段加方法）默认都是public的，并且不允许定义为private或者protected

接口的字段默认都是static 和 final的

### 7.3 区别

抽象类是一种is-a关系，必须满足里氏替换原则

接口是一种like-a的关系，提供一种方法实现，并不要求接口和实现接口的类具有is-a关系

### 7.4 使用场景

接口：不相关的类都实现一个方法，比如不相关的类都实现compareTo方法，需要使用多重继承

抽象类：相关类中共享代码、需要能控制继承来的成员的访问控制，而不是都为public、需要继承非静态和非常量字段。

平常使用当中，感觉优先使用接口，而在源码中，往往比较多的是抽象类



## 8、super

访问父类的构造函数、访问父类的成员



## 9、重写和重载的区别

**重写(Override)**

存在于继承体系中，子类实现了一个于父类在方法上完全相同的一个方法。重写中子类方法的访问权限必须大于等于父类子类方法的返回类型必须是父类方法返回类型或者其子类型。Override注解可以进行检查

**重载(Overload)**

同一个类中，方法名称相同，但是参数类型、个数，顺序至少一个不同

返回值不同，其他都相同的不是重载



## 10、Object通用方法

### 10.1 equals 与 == 

引用类型 == 用于判断两个变量是否是同一个对象，equals用于判断引用的对象是否等价





## 11、浅拷贝和深拷贝