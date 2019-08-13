package com.sun.pattern;
//适配器模式
public class AdapterDemo {
    public static void main(String[] args) {
        SmallPort smallPort = new SmallPort() {
            @Override
            public void useSmallPort() {
                System.out.println("使用的是手机小的接口");
            }
        };
        //需要一个大的接口才可以连接上电脑，小口转换为大口
        BigPort bigPort = new SmallToBig(smallPort);
        bigPort.userBigport();
    }
}
interface BigPort{
    public void userBigport();//使用大口
}
interface SmallPort{
    public void useSmallPort();//使用小口
}
class SmallToBig implements BigPort{
    private SmallPort smallPort;//小口
    public SmallToBig(SmallPort smallPort){//获得小口
        this.smallPort = smallPort;
    }
    @Override
    public void userBigport() {
        this.smallPort.useSmallPort();//使用小口
    }
}