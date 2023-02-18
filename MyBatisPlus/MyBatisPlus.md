# MyBatisPlus

[TOC]

# 1、MyBatisPlus入门案例

基于MyBatis框架基础上开发的增强型工具

## 1.1 案例

创建完工程之后，再导入MyBatisPlus的坐标

```xml
<dependency>
   <groupId>com.baomidou</groupId>
   <artifactId>mybatis-plus-boot-starter</artifactId>
   <version>3.4.1</version>
</dependency>
```

然后我们都不需要写mysql，直接继承一个类，就能调用其中的sql语句

```java
package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
```

然后在测试类中进行查询

```java
package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

   @Autowired
   private UserDao userDao;
   @Test
   void testGetAll() {
      List<User> users = userDao.selectList(null);
      System.out.println(users);
   }

}
```

![image-20230217204025087](pictures/image-20230217204025087.png)

# 2、标准数据层开发

## 2.1 标准层CRUD功能

![image-20230217204351757](pictures/image-20230217204351757.png)

### 2.1.1 新增操作

```java
@Test
void testInsert() {
   User user = new User();
   user.setId(3L);
   user.setAge(13);
   user.setName("xiaoming");
   user.setPassword("ajshfgaj");
   int res = userDao.insert(user);
   System.out.println(res);
}
```

### 2.1.2 删除操作

```java
@Test
void testDelete() {
   int res = userDao.deleteById(1626563824146468866L);
   System.out.println(res);
}
```

### 2.1.3 修改操作

```java
@Test
void testUpdateById() {
   User user = new User();
   user.setId(2L);
   user.setAge(13);
   user.setName("xiaoming2");
   user.setPassword("ajshfgaj");
   int res = userDao.updateById(user);
   System.out.println(res);
}
```

### 2.1.4 根据id查询

```java
@Test
void testGetById() {
   User user = userDao.selectById(2L);
   System.out.println(user);
}
```

### 2.1.5 查询全部

```java
@Test
void testGetAll() {
   List<User> users = userDao.selectList(null);
   System.out.println(users);
}
```

### 2.1.6 分页查询

![image-20230217210857100](pictures/image-20230217210857100.png)

我们需要手动的开启一个过滤器，用于开启分页

```java
package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {

   @Bean
   public MybatisPlusInterceptor mybatisPlusInterceptor(){
      MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
      mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
      return mybatisPlusInterceptor;
   }
}
```

在yml中开启MyBatis的日志

```yaml
# 开启mp的日志
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

![image-20230217211241836](pictures/image-20230217211241836.png)



## 2.2 lombok快速实体类开发

首先导入坐标

```xml
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
</dependency>
```

然后用注解代替我们的一些方法就可以了

```java
package com.itheima.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}
```

或者用@Data，它包含了@Setter、@Getter、@ToString、@EqualsAndHashCode

# 3、DQL编程控制

## 3.1 条件查询方式

### 3.1.1 QueryWrapper方式

```java
@Test
void testGetAll() {
   // 设置查询条件
   QueryWrapper qw = new QueryWrapper();
   qw.lt("age",2);
   List<User> users = userDao.selectList(null);
   System.out.println(users);
}
```

### 3.1.2 lambda方式

```java
QueryWrapper<User> qw = new QueryWrapper();
qw.lambda().lt(User::getAge,2);
List<User> users = userDao.selectList(null);
System.out.println(users);
```

### 3.1.3 lambda接口方式

```java
LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
qw.lt(User::getAge,2);
List<User> users = userDao.selectList(null);
System.out.println(users);
```

多条件查询

```java
LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
qw.lt(User::getAge,10);
qw.gt(User::getAge,1);
List<User> users = userDao.selectList(null);
System.out.println(users);
```

链式编程（and关系）

```java
LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
qw.lt(User::getAge,10).gt(User::getAge,1);
List<User> users = userDao.selectList(null);
System.out.println(users);
```

链式编程（或者关系）

```java
LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
qw.lt(User::getAge,1).or().gt(User::getAge,10);
List<User> users = userDao.selectList(null);
System.out.println(users);
```

### 3.1.4 条件查询null值处理



## 3.2 查询投影



## 3.3 查询条件设定



## 3.4 字段映射与表名映射
