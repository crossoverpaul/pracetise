package org.practise.upgrade.concurrent.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class MyCount {

	// 账号
	private String oid;
	// 账户余额
	private int cash;
	// 账户锁，这里采用公平锁，挂起的取款线程优先获得锁，而不是让其它存取款线程获得锁
	private Lock lock = new ReentrantLock(true);
	// 存款条件
	private Condition _save = lock.newCondition();
	// 取款条件
	private Condition _draw = lock.newCondition();

	MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * 存款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public void saving(int x, String name) {
		lock.lock(); // 获取锁
		if (x > 0) {
			cash += x; // 存款
			System.out.println(name + "存款" + x + "，当前余额为" + cash);
		}
		_draw.signalAll(); // 唤醒所有等待线程。
		lock.unlock(); // 释放锁
	}

	/**
	 * 取款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public void drawing(int x, String name) {
		lock.lock(); // 获取锁
		try {
			if (cash - x < 0) {
				System.out.println(name + "阻塞中");
				_draw.await(2000, TimeUnit.MILLISECONDS); // 阻塞取款操作, await之后就隐示自动释放了lock，直到被唤醒自动获取
			}
			if (cash - x >= 0) {
				cash -= x; // 取款
				System.out.println(name + "取款" + x + "，当前余额为" + cash);
			} else {
				System.out.println(name + " 余额不足,当前余额为 " + cash + "   取款金额为 " + x);
			}
			// 唤醒所有存款操作，这里并没有什么实际作用，因为存款代码中没有阻塞的操作
			_save.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(); // 释放锁
		}
	}
}
