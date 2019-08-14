package org.practise.upgrade.pattern.observer;

/**
 * @author guozhizhong
 * @Title: Observerable
 * @ProjectName practise-upgrade
 * @Description: 抽象被观察者，声明，添加，删除，通知方法
 * @date 2019/8/1410:31 AM
 **/
public interface Observerable {

    /**
     * 注册
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知
     */
    void notifyObserver();

}
