package com.designpattern.singleton;

/*
 * 通过静态内部类实现单例模式
 *
 * 1) 本质上是利用累的加载机制来保证线程安全
 * 2）只有实际使用的时候，才会触发类的初始化，所以也是懒加载的一种形式
 *
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        System.out.println(instance==instance1);  // true

        new Thread(()->{
            InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
            System.out.println(instance2);
        }).start();
        new Thread(()->{
            InnerClassSingleton instance3 = InnerClassSingleton.getInstance();
            System.out.println(instance3);
        }).start();

    }
}

class InnerClassSingleton{
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}
