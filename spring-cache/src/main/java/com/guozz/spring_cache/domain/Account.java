package com.guozz.spring_cache.domain;

/**
 * @author guozhizhong
 * @version 2016-12-21 09:58:53
 */
public class Account {

	private int id;
	private String name;
	
	private String password;
	
	/**
	 * @param accountName
	 */
	public Account(String accountName) {
		this.name=accountName;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
