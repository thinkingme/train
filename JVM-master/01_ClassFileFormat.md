官方文档:
Java SE Specifications
[https://docs.oracle.com/javase/specs/index.html](https://docs.oracle.com/javase/specs/index.html)
比较好的文档: [https://luoyoubao.gitbooks.io/jvm/content/](https://luoyoubao.gitbooks.io/jvm/content/)
# JVM

## 1：JVM基础知识

1. 什么是JVM
2. 常见的JVM

## 2：ClassFileFormat



## 3：类编译-加载-初始化

hashcode
锁的信息（2位 四种组合）
GC信息（年龄）
如果是数组，数组的长度

## 4：JMM

new Cat()
pointer -> Cat.class
寻找方法的信息

## 5：对象

1：句柄池 （指针池）间接指针，节省内存
2：直接指针，访问速度快

## 6：GC基础知识

栈上分配
TLAB（Thread Local Allocation Buffer）
Old
Eden
老不死 - > Old

## 7：GC常用垃圾回收器

new Object()
markword          8个字节
类型指针           8个字节
实例变量           0
补齐                  0		
16字节（压缩 非压缩）
Object o
8个字节 
JVM参数指定压缩或非压缩

