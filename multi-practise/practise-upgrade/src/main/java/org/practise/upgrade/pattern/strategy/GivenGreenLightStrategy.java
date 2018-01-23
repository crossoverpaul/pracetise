package org.practise.upgrade.pattern.strategy;

public class GivenGreenLightStrategy implements IStrategy {

	@Override
	public void operate() {
		System.out.println("求吴国太开个绿灯，放行");
	}

}
