package com.guozz.test.hidePhoneNum;

/**
 * @author guozhizhong
 * @version 2016-11-24 11:39:04
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String phoneNum="15313719308";
		//String hidePhoneNum=phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
		String resultPhoneNum="";
		try {
			resultPhoneNum = hideMiddleByRegexp("15313719308","(\\d{3})\\d{4}(\\d{4})","$1****$2");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(resultPhoneNum);		
	}
	
	/**
	 * 
	 * @param str
	 * @param regExp
	 * @param hideExp
	 * @return
	 * @throws IllegalAccessException
	 */
	public static String hideMiddleByRegexp(String str,String regExp,String hideExp) throws IllegalAccessException{
		if(str==null || "".equals(str)){
			return "";
		}
		if(regExp==null || hideExp==null){
			throw new IllegalAccessException("传入参数错误,传入的正则表达式和隐藏表达式不能为null");
		}
		return str.replaceAll(regExp,hideExp);
	}

}
