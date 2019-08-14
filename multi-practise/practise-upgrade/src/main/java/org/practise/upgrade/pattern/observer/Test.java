package org.practise.upgrade.pattern.observer;

/**
 * @author guozhizhong
 * @Title: Test
 * @ProjectName practise-upgrade
 * @Description: TODO
 * @date 2019/8/1410:40 AM
 **/
public class Test {

    public static void main(String[] args) {

        WechatServer wechatServer = new WechatServer();

        Observer zhangsan = new User("张三");
        Observer lisi = new User("李四");
        Observer wangwu = new User("王五");
        wechatServer.setInfomation("微信升级了哈");

        wechatServer.registerObserver(zhangsan);
        wechatServer.registerObserver(lisi);
        wechatServer.registerObserver(wangwu);
        wechatServer.notifyObserver();

        System.out.println("-------");
        wechatServer.removeObserver(lisi);
        wechatServer.notifyObserver();
    }

}
