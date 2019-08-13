package com.sun.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理模式(动态代理)
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //创建一个实例对象,这个对象是被代理的对象
        Person1 zhangsan = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHander<Person1>(zhangsan);
        Person1 stuProxy = (Person1) Proxy.newProxyInstance(Person1.class.getClassLoader(),new Class<?>[]{Person1.class},stuHandler);
        stuProxy.giveMoney();
    }
}
interface Person1 {
    //上交班费
    void giveMoney();
}
class Student implements Person1{
    private String name;
    public Student(String name){
        this.name = name ;
    }

    @Override
    public void giveMoney() {
        try{
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name +"上交班费50元");
    }
}
class MonitorUtil{
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();
    public static void start(){
        t1.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName+"方法耗时"+(finishTime-t1.get())+"ms");
    }
}

class StuInvocationHander<T> implements InvocationHandler{
    T target;
    public StuInvocationHander(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");
        //代理过程中插入监测方法，计算该方法耗时
        MonitorUtil.start();
        Object result = method.invoke(target,args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
