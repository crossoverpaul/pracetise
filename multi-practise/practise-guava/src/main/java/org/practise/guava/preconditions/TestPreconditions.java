package org.practise.guava.preconditions;

import com.google.common.base.Preconditions;

public class TestPreconditions {

	public static void main(String[] args) {
		TestPreconditions demo = new TestPreconditions();
	        demo.doSomething("Jim", 19, "hello world, hello java");
	}

	private void doSomething(String name, int age, String desc) {
		Preconditions.checkArgument(age >= 18 && age < 99, "age must in range (18,99)");
		Preconditions.checkNotNull(name, "name may not be null");
		Preconditions.checkArgument(desc !=null && desc.length() < 10, "desc too long,%s is max length ", 10);
		
	}
}
