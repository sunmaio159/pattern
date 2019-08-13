package com.sun.pattern;
//抽象工厂模式
public class AbstractFactory {
    public static void main(String[] args) {
        Factory2 factory = new FactoryAAA();
        factory.createGifg();
        factory.createProduct();
        factory = new FactoryBBB();
        factory.createGifg();
        factory.createProduct();
    }
}

interface  Product2{}
interface Gift{}//也可以是抽象类
class ProductAAA implements Product2{
    public ProductAAA(){
        System.out.println("ProductAAA");
    }
}
class ProductBBB implements Product2{
    public ProductBBB(){
        System.out.println("ProductBBB");
    }
}

class GiftA implements Gift{
    public GiftA(){
        System.out.println("GiftA");
    }
}
class GiftB implements Gift{
    public GiftB(){
        System.out.println("GiftB");
    }
}

interface Factory2{
    public Product2 createProduct();
    public Gift createGifg();
}
class FactoryAAA implements Factory2{

    @Override
    public Product2 createProduct() {
        return new ProductAAA();
    }

    @Override
    public Gift createGifg() {
        return new GiftA();
    }
}

class FactoryBBB implements Factory2{

    @Override
    public Product2 createProduct() {
        return new ProductBBB();
    }

    @Override
    public Gift createGifg() {
        return new GiftB();
    }
}
