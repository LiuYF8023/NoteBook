# Git

Tags: 工具

# 1、git操作

# 2、项目实战

## 2.1 将git链接到项目

### 2.1.1 github创建ssh秘钥

首先使用本地的git，创建一个秘钥

```bash
ssh-keygen
```

然后将秘钥添加到github中，这个秘钥一般在C盘的用户目录下

![Untitled](./pictures/Untitled.png)

### 2.1.2 github仓库链接到本地项目

找一个空的目录把github仓库ssh到本地，然后需要注意的是，需要把隐藏的一个.git文件，显示出来，然后再将其整个拷贝到自己本地的目录

![Untitled](./pictures/Untitled%201.png)

然后右上角就会有，相应的git选项

![Untitled](./pictures/Untitled%202.png)