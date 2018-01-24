package org.practise.upgrade.pattern.prototype;

public class CreatePrototypeA extends Prototype {

	@Override
	public Prototype clone() {
		Prototype prototype = new CreatePrototypeA();
		return prototype;
	}

}
