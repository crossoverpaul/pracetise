package org.practise.upgrade.pattern.template;

public class Client {

	public static void main(String[] args) {
		BankTemplateMethod takeMoney = new TakeMoney();
		takeMoney.process();
	}
}
