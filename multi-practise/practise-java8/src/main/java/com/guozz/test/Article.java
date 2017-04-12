package com.guozz.test;

import java.util.List;

public class Article {

	public  String title;
	
	public  String auther;
	
	public  List<String> tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Article(String title, String auther, List<String> tags) {
		super();
		this.title = title;
		this.auther = auther;
		this.tags = tags;
	}
	
	
	
}
