# Java牛客错题

[TOC]

# 面向对象

## 访问控制符

### 知识点

java一共有四个访问级别，访问控制级从小到大分别是

**private default protected public**

|            | private | default | protected | public |
| ---------- | ------- | ------- | --------- | ------ |
| 同一个类中 | √       | √       | √         | √      |
| 同一个包中 |         | √       | √         | √      |
| 子类中     |         |         | √         | √      |
| 全局范围内 |         |         |           | √      |

访问控制符的使用原则

- 绝大部分成员变量都应考虑使用private修饰，少数static修饰、类似全局变量的成员变量才考虑用public
- 如果某个类用于作为主类，那么这个类的方法只希望被子类使用，那么可以使用protected修饰
- 希望被其他的类自由调用的方法，应该用public修饰

### 例题1

#### 题目

下列类定义代码，当用来声明对象car，并用实例化后，可以通过car对象直接赋值的字段是（）

![img](https://uploadfiles.nowcoder.com/images/20161123/5918115_1479891608005_34946800E3691FD7E599CBCCFD7503CD)

#### 解答

如果不写的话，默认是当做default。protected修饰的属性，可以被同一个类、同一个包、子类中 定义的对象进行访问，这里的owner不一定可以被访问，因为**Car car=new Car();的创建位置可能在别的包**。



## Java9改进的接口

### 知识点

```
[修饰符] interface 接口名 extends 父接口1, 父接口2 ... 
{
	零个到多个常量定义...
	零个到多个抽象方法定义...
	零个到多个内部类、接口、枚举定义
	零个到多个私有方法、默认方法或类方法定义
}
```

- 修饰符可以是public或者省略，省略默认采用的是包权限访问控制符
- 只能是抽象实例方法、类方法、默认方法或私有方法。如果不是默认方法、类方法或私有方法，系统会自动为普通方法添加abstract修饰符，并且总是public abstract，普通方法不能有方法体，而类方法、私有方法默认方法**必须**要有方法体。

### 例题1

#### 题目

将下列（A、B、C、D）哪个代码替换下列程序中的【代码】不会导致编译错误？

```java
interface Com{
    int M=200;
    int f();
}
class ImpCom implements Com{
    【代码】
}
```

A

public int f(){return 100+M;}

B

int f(){return 100;}

C

public double f(){return 2.6;}

D

public abstract int f();

#### 解答



# 集合

JDK7及其之前版本 HashMap的实现方式是 **Table 数组+Entry链表**

JDK8及其之后的版本 HashMap的实现方式是 **Table数组+ Entry链表/红黑树**