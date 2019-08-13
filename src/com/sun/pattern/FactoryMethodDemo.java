package com.sun.pattern;
//工厂模式
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Factory1 factory = new FactoryA();
        factory.createProduct();
        factory = new FactoryB();
        factory.createProduct();
    }
}

interface  Product1{}
interface  Factory1{
    //声明产生产品类的方法
    public Product1 createProduct();
}
class ProductAA implements Product1{
    public ProductAA(){
        System.out.println("ProductAA");
    }
}
class ProductBB implements Product1{
    public ProductBB(){
        System.out.println("ProductBB");
    }
}

class FactoryA implements Factory1{

    @Override
    public Product1 createProduct() {
        return new ProductAA();
    }
}

class FactoryB implements Factory1{

    @Override
    public Product1 createProduct() {
        return new ProductBB();
    }
}
