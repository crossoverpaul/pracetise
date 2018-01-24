package org.practise.upgrade.pattern.template;

public abstract class BankTemplateMethod {
	
	public void takeNumber(){
	       System.out.println("取号排队");
	   }
	
	public abstract void transact();//办理具体业务，钩子方法
	
	public void evaluate(){
	       System.out.println("反馈评分");
	}
	
	//模板方法
    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();
    }

}
