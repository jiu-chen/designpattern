package com.designpattern.singleton;

/**
 * 饿汉模式: 类加载的初始化阶段就完成了实例的初始化
 * JVM类加载机制保证了线程安全
 *
 * 类加载过程：
 * 1. 加载二进制数据到内存中，生成对应的Class数据结构
 * 2. 连接: a. 验证，b.准备（给类的静态成员变量赋默认值） c. 解析
 * 3. 初始化: 给类的静态变量赋初值
 *
 * 只有在真正使用对应类时，才会触发初始化，如（当前类是启动类即main函数所在类，直接进行new操作，访问静态属性，访问静态方法，
 * 用反射访问类，初始化一个类的子类等）
 */
public class HurryingSingletonTest {
    public static void main(String[] args) {
        // 调用类的静态方法getInstance，JVM判断HurrySingleton有没有被加载，
        // 如果没有触发类加载，类加载的最后一步初始化: 给类的静态变量赋初值, 从而实例化instance
        // JVM能够保证线程安全
        HurrySingleton instance = HurrySingleton.getInstance();
        HurrySingleton instance1 = HurrySingleton.getInstance();
        System.out.println(instance==instance1);
    }
}

class HurrySingleton{
    private static HurrySingleton instance=new HurrySingleton();
    private HurrySingleton(){}
    public static HurrySingleton getInstance(){
        return instance;
    }
}
