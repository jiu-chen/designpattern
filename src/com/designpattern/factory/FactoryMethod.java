package com.designpattern.factory;

/**
 * 工厂模式
 *
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method 使得一个类的实例化延迟到子类
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConcreateProductA();
        Product product = application.getObject();
        product.method1();

        Application applicationB = new ConcreateProductB();
        Product productB = applicationB.getObject();
        productB.method1();
    }
}


interface Product{
    void method1();
}

class ProductA implements Product{
    public void method1(){
        System.out.println("ProductA method1 executed...");
    }
}

class ProductB implements Product{
    public void method1(){
        System.out.println("ProductB method1 executed...");
    }
}


// 抽象类
// 为什么要使用抽象类？ 因为无法完整的描述一个事物的时候，需要将不好描述的部分抽取出来形成方法，供不同的角色去使用（重写抽象类）
abstract class Application{
    // 抽象方法
    abstract Product createProduct();

    // 普通方法
    public Product getObject(){
        Product product = createProduct();
        // ...
        // ...
        return product;
    }
}

// 将变化的部分让子类去实现
class ConcreateProductA extends Application{
    @Override
    Product createProduct(){
        // ..
        return new ProductA();
    }
}


// ProductB...
class ConcreateProductB extends Application{
    @Override
    Product createProduct(){
        // ..
        return new ProductB();
    }
}

