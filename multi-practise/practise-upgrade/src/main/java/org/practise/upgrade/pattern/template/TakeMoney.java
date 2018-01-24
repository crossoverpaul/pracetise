package org.practise.upgrade.pattern.template;

public class TakeMoney extends BankTemplateMethod {

	@Override
	public void transact() {
		System.out.println("取现金业务");
	}
}
