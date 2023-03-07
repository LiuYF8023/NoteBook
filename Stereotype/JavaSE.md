# JavaSE 常见问题

[TOC]

## Java三大特性

### 封装

利用抽象数据类型将数据和基于数据的操作封装在一起，尽可能隐藏内部细节，向外部只开放一些接口，可以通过接口来访问对象。

优点：减少耦合、维护负担小、可重用性高

### 继承

继承是一种Is-a的关系，子类可以获得父类的非private属性和方法。父类引用指向子类对象称为向上转型。

### 多态

分为编译时多态和运行时多态

编译时多态指的是方法的重载，运行时多态有三个条件：继承、覆盖、向上转型



### 抽象（面向对象的特点）

把客观事务用代码抽象出来



## 数据类型

### 八种数据类型及对应大小

boolean/1 注意boolean类型是一个bit，但是存储的时候是占用1个字节或者是4个字节

byte/8 一个字节

char/16 两个字节

short/16 两个字节

int/32 四个字节

float/32 四个字节

long/64 八个字节

double/64 八个字节

### 缓存池

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

## String

String被声明为final，不可以被继承。内部实现用的是char数组

### 为什么要不可变

第一、因为String的hash值经常被使用，例如HashMap的key。不可变的特性使得hash值也不变，因此只需要进行一次计算。

第二、String pool的需要。如果一个String对象被创建过了，那么就会从String pool中取得引用。

第三、安全性。String经常作为参数，String的不可变性保证参数不变。

第四、线程安全 String的不可变性天生具备线程安全，可以在多个线程中安全的使用。

### String StringBuffer StringBuilder

String是不可变的 StringBuffer和StringBuilder是可变的

String是线程安全的。StringBuilder不是线程安全的。StringBuffer是线程安全的，内部使用synchronized进行同步。

线程安全往往是牺牲了一部分性能。

### String intern() 方法

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



**但是String有提供很多方法，例如subString、replace等，这些实际上是开辟了新的内存，然后把value数组的引用重新引用到了这片内存。** 有疑问

注意final修饰的value[] 是对象，final修饰对象时，只是引用不变，即栈内保存的数组对象地址不会被改变，但是指向堆内的对象身上的值仍然可以改变。



## 值传递与引用传递

值传递是针对于基本数据类型而言，传递的只是一个副本，不会改变原值

引用传递是对于对象型变量而言，传递的是该对象的一个副本，并不是原对象本身，两者指向同一片内存空间，所以二者同时操作，都会改变这片内存空间

Java中不存在引用传递，只有值传递。即使是传了对象，那么也只是对象的一个复制，只不过二者指向的是同一块空间

## switch

从Java7开始，可以在switch条件判断语句中使用String对象

switch还支持byte、short、int或者char

不支持long类型，因为long类型的值往往比较复杂，用if更合适。



## 访问权限

### 里氏替换原则

第一、如果继承的目标是为了实现代码重用，那么共享的父类方法应该保持不变，不能被子类重新定义。子类只能通过添加新方法来扩展功能。子类对象和父类对象的方法逻辑性一致

第二、如果继承的目的是为了多态，那么子类需要覆盖并重新定义父类的方法，这个时候应该将父类定义为抽象类，并定义抽象方法。

### 访问权限修饰符

private一般不想被该类以外的其他类方法，protected一般只想让子类进行访问才设定，而public可以被任何类自由访问。



## 抽象类与接口

###  抽象类

抽象类中一般包含抽象方法，抽象方法一定位于抽象类中。

抽象类不能被实例化

### 接口

接口的成员（字段加方法）默认都是public的，并且不允许定义为private或者protected

接口的字段默认都是static 和 final的

### 区别

**语法层面**上的区别

- 抽象类可以有方法实现，而接口的方法中只能是抽象方法（Java 8 之后接口方法可以有默认实现）；
- 抽象类中的成员变量可以是各种类型的，接口中的成员变量只能是public static final类型；
- 接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法（Java 8之后接口可以有静态方法）；
- 一个类只能继承一个抽象类，而一个类却可以实现多个接口。

**设计层面**上的区别

- 抽象层次不同。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口只是对类行为进行抽象。继承抽象类是一种"是不是"的关系，而接口实现则是 "有没有"的关系。如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现则是具备不具备的关系，比如鸟是否能飞。
- 继承抽象类的是具有相似特点的类，而实现接口的却可以不同的类。



### 使用场景

接口：不相关的类都实现一个方法，比如不相关的类都实现compareTo方法，需要使用多重继承

抽象类：相关类中共享代码、需要能控制继承来的成员的访问控制，而不是都为public、需要继承非静态和非常量字段。

平常使用当中，感觉优先使用接口，而在源码中，往往比较多的是抽象类



## super

访问父类的构造函数、访问父类的成员



## 重写和重载的区别

**重写(Override)**

存在于继承体系中，子类实现了一个于父类在方法上完全相同的一个方法。重写中子类方法的访问权限必须大于等于父类子类方法的返回类型必须是父类方法返回类型或者其子类型。Override注解可以进行检查

**重载(Overload)**

同一个类中，方法名称相同，但是参数类型、个数，顺序至少一个不同

返回值不同，其他都相同的不是重载



## Object通用方法

### equals 与 == 

对于基本类型来说，==比较的是他们的值。基本数据类型没有equals方法

**对于字符串变量来说，使用"=="和"equals"比较字符串时，其比较方法不同。"=="比较两个变量本身的值，即两个对象在内存中的首地址，"equals"比较字符串包含内容是否相同。**

**对于非字符串变量来说，如果没有对equals()进行重写的话，"==" 和 "equals"方法的作用是相同的，都是用来比较对象在堆内存中的首地址，即用来比较两个引用变量是否指向同一个对象。**

## 浅拷贝和深拷贝

### 浅拷贝

拷贝对象和原始对象的引用类型引用同一个对象



### 深拷贝

拷贝对象和原始对象的引用类型引用的是不同的对象



## Java的特点

面向对象、具有平台独立性和可移植性、Java具有稳健性（体现在是强类型语言、异常处理机制）



## Java是如何实现跨平台的

通过JVM实现跨平台，其简单来说就是负责将字节码文件翻译成特定平台下的机器码，不同平台下编译生成的字节码文件是一样的，但是JVM翻译之后的机器码在不同平台是不一样的。



## C++和Java的区别

Java是纯粹的面向对象语言，而C++不但支持面向对象，也支持面向过程

Java基于JVM实现跨平台特性，而C++是依赖平台的

Java没有指针，引用可以理解为安全指针，C++有指针

Java支持自动垃圾回收，而C++需要手动回收

Java不支持多重继承，只能通过实现多个接口来达到目的，而C++支持多继承



## JDK、JRE、JVM三者关系

JVM是虚拟机

JRE 是Java运行时环境，我们编写的Java程序必须要在JRE才能运行其包含JVM和Java核心类库。其并不包含编译器、调试器，如果只是想运行Java程序，那么只安装jre就行

JDK 是Java开发工具包，其包括了JRE、Java工具、编译器、调试器



## Java是编译执行还是解释执行

编译型语言 一次编译，运行时不需要编译 

解释型语言 代码翻译成机器码，再由解释器对中间代码进行解释运行

而Java是先通过javac将代码编译成字节码，然后，再通过jvm将字节码转换成机器码，实际上是两种方式的结合，所以我更想称之为混合型或者半编译型语言



## 面向对象和面向过程的区别

面向过程是分析出问题的执行步骤，然后用函数去实现，函数是依次调用的

面向对象是把构成问题的事务进行分解成多个对象，分别去设计这些对象，然后将他们组合起来

比如我们下五子棋的程序，1、开始游戏，2、黑子先走，3、绘制画面，4、判断输赢，5、轮到白子，6、绘制画面，7、判断输赢，8、返回步骤2，9、输出最后结果。

而面向对象可以把他们拆分为 黑白双方、棋盘、规则等等



## 面向对象编程的六大原则

对象单一、里氏替换原则、迪米特法则（最小耦合）、开闭原则（开放扩展、封闭修改）、依赖倒置（高层模块不应该直接依赖于底层模块，而应该依赖底层的抽象（如Service））、接口隔离（遵循对象单一的原则下，减少接口的内容）

简单来说：

单一职责：对象设计要求独立，不能设计万能对象。

开闭原则：对象修改最小化。

里式替换：程序扩展中抽象被具体可以替换（接口、父类、可以被实现类对象、子类替换对象）

迪米特：高内聚，低耦合。尽量不要依赖细节。

依赖倒置：面向抽象编程。也就是参数传递，或者返回值，可以使用父类类型或者接口类型。从广义上讲：基于接口编程，提前设计好接口框架。

接口隔离：接口设计大小要适中。过大导致污染，过小，导致调用麻烦。



## 数组到底是不是对象

数组可以看做对象，因为对象就是某个类创建的一个实例，Java的数组也封装了一些数据、也可以调用方法，所以是对象。数组类的父类就是Object类



## 为什么不能用浮点数表示金额

因为在计算机中保存的小数实际上是十进制的近似值，并不是一个准确的值。建议使用BigDecimal或者是Long来表示金额

## Java的包装类型，为什么要包装类

Java是一门面向对象的语言，很多地方用到的是对象而不是基本数据类型，例如集合中就只能加入Object类型的元素。为了能够让基本数据类型也有对象的特性，就出现了包装类型。

在进行赋值操作、加减乘除四则运算、比较运算符、equals、ArrayList、HashMap等调用方法添加基础数据类型时，都会进行拆箱装箱的操作



经典面试题：

```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b);

Integer c = 200;
Integer d = 200;
System.out.println(c == d);
```

如果值在-128~127之内，Integer类采用了IntegerCache的方法，直接返回对应的Integer值。如果超过了这个范围，那么就会重新new Integer



## JDK9为何将String的底层实现由char[] 改为byte[] 

主要是为了节约内存，因为char是两个字节、byte一个字节

在jdk9中，对于每个字符串，先判断是不是只有Latin-1字符，如果是就按照1字节的规格进行分配内存，如果不是，就按照2字节进行分配（这里判断主要是为了区分汉字吧）这样能够提升内存效率，并且垃圾回收的次数也会减少。对于中文来说，char[] 和 byte[] 没什么区别



## StringJoiner是什么

基于StringBuffer实现，用于对字符串之间通过分隔符拼接

举个例子就明白了

```java
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Test {

   public static void main(String[] args) {
      List<Integer> values = Arrays.asList(1,2,3);
      StringJoiner sj = new StringJoiner(",","(",")");

      for (Integer value : values) {
         sj.add(value.toString());
      }

      System.out.println(sj);
   }
}
```

sj.add 就相当于把list加入到这个字符串拼接过程中，实现指定字符的拼接，并且还没指定前后缀



## String 类的常用方法有哪些

indexOf()：返回指定字符的索引。

charAt()：返回指定索引处的字符。

replace()：字符串替换。

trim()：去除字符串两端空白。

split()：分割字符串，返回一个分割后的字符串数组。

getBytes()：返回字符串的 byte 类型数组。

length()：返回字符串长度。

toLowerCase()：将字符串转成小写字母。

toUpperCase()：将字符串转成大写字符。

substring()：截取字符串。

equals()：字符串比较



## new String("abc")会创建几个对象

在常量池中没有abc这个字符串的前提下，由于“abc”属于字符串字面量，因此编译时期会在**字符串常量池**中创建一个字符串对象，指向这个“abc”字符串字面量。

使用new的方式会在堆中创建一个字符串对象



## 字符串常量池

字符串常量池保存所有字符串字面量，这些在编译的时候就确定。字符串常量池在Java7的时候，从永久代（方法区）转移到了堆内存。在创建字符串对象的时候，先检查字符串常量池，没有再去创建。



## String的最大长度是多少？

理论上来说String的最大长度的类型是int，因为int的取值上限为2^31-1

什么情况下字符串会存到常量池中，例如String s = "abc"，这样是存在字符串常量池中的

但是常量池中的字符串最大长度可不是2^31-1，其长度限制是一个无符号16位整数，最大长度是65535，但是javac做了限制，需要length<65535，所以字符串牛长亮的最大长度是65535 - 1= 65534

**最后总结一下：**

**String在不同的状态下，具有不同的长度限制。**

- **字符串常量长度不能超过65534**
- **堆内字符串的长度不超过2^31-1**



## Object常用方法有哪些

toString() 默认输出的是对象的地址，可以重写

equals() 比较的是两个引用变量是否指向同一个对象（内存地址）

hashCode() 将对象相关的信息映射成一个哈希值，默认的实现hashCode值是根据内存地址换算

clone() 得到对象的副本，赋值操作无法 达到目的，



getClass 返回Object的运行时类，用于反射机制



wait：当前线程调用对象的wait方法之后，线程会释放对象锁。进入等待状态，等待其他线程调用此对象的notify/notifyAll唤醒或者等待超时时间wait自动唤醒。



notify 唤醒在此对象上等待的单个线程，选择是任意的。



## 两个对象的HashCode()相同，则equals()是否也一定为true？

如果两个对象调用equals比较返回true，那么HashCode一定相同

如果两个对象的HashCode相同，他们并不一定相同。

所以在比较对象的时候，先比较HashCode，如果不同，就没必要比较了



## 为什么重写equals的时候一定要重写HashCode

因为要同时保证equals返回true的前提下，HashCode也要相同。

会出现的问题就是：**当用其中的一个对象作为键保存到hashMap、hashTable或hashSet中，再以另一个对象作为键值去查找他们的时候，则会查找不到**



## Java创建对象有几种方法

new 语句创建对象

反射，例如Class.newInstance()

对象的clone()方法

反序列化手段，调用java.io.ObjectInputStream对象的readObject()方法，被序列化的类需要实现Serializable接口

序列化

```java
ObjectOutputStream obji = new ObjectOutputStream(new FileOutputStream("Object1.txt"));
Teacher teacher = new Teacher();
teacher.setName("张三");
teacher.setAge(20);

obji.writeObject(teacher);
```

反序列化

```java
ObjectInputStream Obji = new ObjectInputStream(new FileInputStream("Object1.txt"));
Teacher t =(Teacher) Obji.readObject();
System.out.println(t.getName()+t.getAge());
```



序列化的好处就是Java提供了一种保存对象的方式，然你可以把对象再读出来

## 实例化的顺序

Java中类实例化顺序

静态属性，静态代码块

普通属性，普通代码块

构造方法



## final、fianlly、finalize区别

final 修饰的属性不能重新赋值、方法不可被覆盖、类不可被继承

finally  用于异常处理

finalize 是垃圾回收器来调用，当调用System.gc的时候，垃圾回收器就调用finalize方法



## 常见的异常

### RuntimeException

ClassCastExceotion 类型转换异常

`IndexOutOfBoundsException` //数组越界异常

`NullPointerException` //空指针

`ArrayStoreException` //数组存储异常

`NumberFormatException` //数字格式化异常

`ArithmeticException` //数学运算异常

### checked Exception

`NoSuchFieldException` //反射异常，没有对应的字段

`ClassNotFoundException` //类没有找到异常

`IllegalAccessException` //安全权限异常，可能是反射时调用了private方法



## Error和Exception的区别

Error一般是JVM无法解决的问题

Exception 编程错误护或者偶然的外在因素导致的一般性问题。



## 运行时异常和非运行时异常的区别

运行时异常 是由程序错误导致

checked Exception 是因为具体环境，例如文件不存在或文件为空或sql异常



## throw和throws的区别

throw用于抛出一个具体的异常

throws 在方法签名中，声明该方法可能抛出的异常。子类方法的异常抛出范围要小



