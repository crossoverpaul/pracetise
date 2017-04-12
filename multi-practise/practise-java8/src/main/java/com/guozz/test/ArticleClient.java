package com.guozz.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ArticleClient {

	List<Article> articles = new ArrayList<Article>();
	
	public Article getFirsetArticle(){
		for(Article article:articles){
			if(article.getTags().contains("java")){
				return article;
			}
		}
		return null;
	}
	
	public Optional<Article> getFirsetArticle4java8(){
		return articles.stream().filter(article->article.getTags().contains("java")).findFirst();
	}
	
	public static void main(String[] args) {
		ArticleClient client = new ArticleClient();
		Optional<Article> arOptional =client.getFirsetArticle4java8();
		arOptional.get();
	}
	
	
	
	public List<Article> getAllJavaArticles() {
		 
	    List<Article> result = new ArrayList<>();
	 
	    for (Article article : articles) {
	        if (article.getTags().contains("Java")) {
	            result.add(article);
	        }
	    }
	    return result;
	}
	
	public List<Article> getAllJavaArticles4java8() {
		return articles.stream().filter(article->article.getTags().contains("java"))
				.collect(Collectors.toList());
	}
	
	
	public Map<String, List<Article>> groupByAuthor() {
		 
	    Map<String, List<Article>> result = new HashMap<>();
	 
	    for (Article article : articles) {
	        if (result.containsKey(article.getAuther())) {
	            result.get(article.getAuther()).add(article);
	        } else {
	            ArrayList<Article> articles = new ArrayList<>();
	            articles.add(article);
	            result.put(article.getAuther(), articles);
	        }
	    }
	 
	    return result;
	}
	
	public Map<String, List<Article>> groupByAuthor4java8() {
		return articles.stream().collect(Collectors.groupingBy(Article::getAuther));
	}
	
	/**
	 * 查找不同的标签
	 * @return
	 */
	public Set<String> getDistinctTags() {		 
	    Set<String> result = new HashSet<>();
	    for (Article article : articles) {
	        result.addAll(article.getTags());
	    }
	    return result;
	}
	public Set<String> getDistinctTags4java8() {
		return articles.stream().flatMap(article->article.getTags().stream()).collect(Collectors.toSet());
	}
	
	
	
	
	
}
