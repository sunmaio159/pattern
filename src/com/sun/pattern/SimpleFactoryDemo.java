package com.sun.pattern;
//简单工厂模式
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Factory.create("productA");
        Factory.create("ProductB");
    }
}
interface  Product{
    //声明类所需继承的共同接口，也可以是抽象类

}
class ProductA implements Product{
    public ProductA(){
        System.out.println("ProductA");
    }
}

class ProductB implements Product{
    public ProductB(){
        System.out.println("ProductB");
    }
}

class Factory{
    public static Product create(String str){
        //生成ProductA
        if(str.equalsIgnoreCase("ProductA")){
            return new ProductA();
        }else{
            //生成ProductB
            if(str.equalsIgnoreCase("ProductB")){
                return new ProductB();
            }
        }
        return null;
    }
}
