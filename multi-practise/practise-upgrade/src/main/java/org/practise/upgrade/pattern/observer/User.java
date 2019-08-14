package org.practise.upgrade.pattern.observer;

/**
 * @author guozhizhong
 * @Title: User
 * @ProjectName practise-upgrade
 * @Description: 定义具体观察者
 * @date 2019/8/1410:38 AM
 **/
public class User implements Observer{

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    private void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
