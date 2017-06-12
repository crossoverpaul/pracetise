
package com.guozz.practise.netty.chapter11;

import java.io.Serializable;


public class Command implements Serializable {
	
	private static final long serialVersionUID = 7590999461767050471L;
	 
	/** 命令 */
	private String actionName;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}	 

}
