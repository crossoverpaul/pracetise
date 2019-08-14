package org.practise.upgrade.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhizhong
 * @Title: WechatServer
 * @ProjectName practise-upgrade
 * @Description: 被观察者，也就是微信公众号服务
 * @date 2019/8/1410:34 AM
 **/
public class WechatServer implements Observerable{

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> observerList;
    private String message;

    public WechatServer(){
        observerList=new ArrayList<Observer>();
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observerList.isEmpty()){
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        if(!observerList.isEmpty()){
            for(Observer observer : observerList){
                observer.update(message);
            }
        }
    }
}
