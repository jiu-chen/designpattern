package com.designpattern.singleton;

// 单例模式
/*
 * 懒汉模式: 延迟加载，只有在真正使用的时候，才会去实例化，适用数据库连接池，线程池
 *
 *
 */
public class LazySingletonTest {
    public static void main(String[] args) {
//        懒汉模式：只有在调用 getInstance方法时，会初始化实例instance
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance==instance1);  // true

        //  多线程模式下
        new Thread ( ()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread ( ()->{
            LazySingleton instance1 = LazySingleton.getInstance();
            System.out.println(instance1);
        }).start();

    }
}

class LazySingleton {
    private volatile static  LazySingleton  instance;  // volatile 避免引用重排序
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance==null){
//            try{
//                Thread.sleep(200);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            synchronized (LazySingleton.class){
                if(instance==null){
                    instance = new LazySingleton();
                    // 字节码
                    // JIT(编译器), CPU
                    // 没有volatile的话 线程1：1，3，2 线程2：1,3,2
                    // 单线程没有问题
                    // 1. 分配内存
                    // 2. 初始化
                    // 3. 引用赋值
                }
            }
        }
        return instance;
    }


}
