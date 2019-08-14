package org.practise.upgrade.pattern.observer;

/**
* @description: 抽象观察者
 *   定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
* @param: 
* @return: 
* @author: guozhizhong
* @date: 2019/8/14
*/

public interface Observer {
    void update(String message);
}
