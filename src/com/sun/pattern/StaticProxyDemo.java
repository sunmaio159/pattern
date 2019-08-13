package com.sun.pattern;
//代理模式(静态代理)
public class StaticProxyDemo {
    public static void main(String[] args) {
        ProxySubject subject = new ProxySubject(new RealSubject());
        subject.visit();
    }
}
interface Subject{
    void visit();
}
class RealSubject implements Subject{
    private String name = "byhieg";

    @Override
    public void visit() {
        System.out.println(name);
    }
}

class  ProxySubject implements Subject{
    private Subject subject;
    public ProxySubject(Subject subject){
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}