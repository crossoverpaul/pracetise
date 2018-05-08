package org.practise.upgrade.concurrent.condition;

/**
 * @Description:存款线程类
 * @author: guozhizohng
 * @date: 2018年5月8日 上午10:33:53
 */
public class SaveThread extends Thread{

	private String name; // 操作人
	private MyCount myCount; // 账户
	private int x; // 存款金额

	SaveThread(String name, MyCount myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}

	public void run() {
		myCount.saving(x, name);
	}
}
