package com.guozz.designpattern;
import java.util.Scanner;


public class Md5Calculate {

	public static void main(String[] args) {
		
		System.out.print("请输入单号：");
		Scanner  sc=new Scanner(System.in);
		String  No=sc.next();
		System.out.println("你输入的单号是："+No);
		System.out.print("请输入取模值：");
		Scanner  sc2=new Scanner(System.in);
		String  mod=sc2.next();
		System.out.println("你输入的模值是："+mod);
		
		int hashCode = String.valueOf(No).trim().toUpperCase().hashCode();
		System.out.println("根据单号获取的表所在位置是"+Math.abs(hashCode % Integer.parseInt(mod)));
	}
}
