package com.sun.pattern;
//单例模式
public class SingletonDemo {
    public static void main(String[] args) {
        User1 user1 = new User1();
    }
}
//饿汉式
class User1{
    User1(){

    }
    private static User1 zs = new User1();
    private static User1 getZs(){
        return zs;
    }
}
//懒汉式
class User2{
    private User2(){

    }
    private static User2 ls = null;
    private synchronized static User2 getLs(){
        if (ls == null){
            ls = new User2();
        }
        return ls;
    }
}

//双重加锁机制
class User3{
    private User3(){

    }
    private static User3 ww = null;
    private static  User3 getWw(){
        if(ww==null){
            synchronized (User3.class){
                if(ww==null){
                    ww = new User3();
                }
            }
        }
        return ww;
    }
}
