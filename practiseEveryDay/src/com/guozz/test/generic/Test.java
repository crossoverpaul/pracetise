package com.guozz.test.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author guozhizhong
 * @version 2016-11-29 09:29:24
 */
public class Test {
	/**
	 * 类型擦除的关键在于从泛型类型中清除类型参数的相关信息，并且再必要的时候添加类型检查和类型转换的方法。
	 * 在使用泛型时，任何具体的类型都被擦除，唯一知道的是你在使用一个对象。
	 * 比如：List<String>和List<Integer>在运行事实上是相同的类型。
	 * 他们都被擦除成他们的原生类型，即List。因为编译的时候会有类型擦除，所以不能通过同一个泛型类的实例来区分方法，
	 * 如下面的例子编译时会出错，因为类型擦除后，两个方法都是List类型的参数，因此并不能根据泛型类的类型来区分方法。
	 */
	/*public void test (List<String> lst){
		
	}
	
	public void test (List<Integer> lst){
		
	}*/
	
	/**
	 * 2.通配符
	 */
	//不适用泛型
	/*void printCollection(Collection c){
		Iterator i =c.iterator();
		 for (int k=0;k < c.size();k++) {  
		 System.out.println(i.next());  
		 }
	}*/

	 //使用泛型  
	/**
	 *    很容易发现，使用泛型的版本只能接受元素类型为Object类型的集合如ArrayList<Object>();
	 *    如果是ArrayList<String>，则会编译时出错。因为我们前面说过，Collection<Object>并不是所有集合的超类。
	 *    而老版本可以打印任何类型的集合，那么如何改造新版本以便它能接受所有类型的集合呢？这个问题可以通过使用通配符来解决
	 * @param c
	 */
	 /*void printCollection(Collection<Object> c) {  
		 for (Object e:c) {  
		 System.out.println(e);  
		 }  
	 } */ 

	//使用通配符？，表示可以接收任何元素类型的集合作为参数
	/**
	 * 这里使用了通配符？指定可以使用任何类型的集合作为参数。
	 * 读取的元素使用了Object类型来表示，这是安全的，因为所有的类都是Object的子类。
	 * 这里就又出现了另外一个问题，如下代码所示，如果试图往使用通配符？的集合中加入对象，就会在编译时出现错误。
	 * 需要注意的是，这里不管加入什么类型的对象都会出错。这是因为通配符？表示该集合存储的元素类型未知，可以是任何类型。
	 * 往集合中加入元素需要是一个未知元素类型的子类型，正因为该集合存储的元素类型未知，所以我们没法向该集合中添加任何元素。
	 * 唯一的例外是null，因为null是所有类型的子类型，所以尽管元素类型不知道，但是null一定是它的子类型。
	 * 另一方面，我们可以从List<?> lists中获取对象，虽然不知道List中存储的是什么类型，
	 * 但是可以肯定的是存储的类型一定是Object的子类型，所以可以用Object类型来获取值。
	 * 如for(Object obj: lists)，这是合法的。
	 * @param c
	 */
	/* void printCollection(Collection<?> c) {  
		 for (Object e:c) {  
		 System.out.println(e);  
		 }
		 Collection<?> cc= new ArrayList<String>();
		 cc.add(new Object());
		 cc.add(null);
	 } */


	 //使用边界通配符的版本  
	/**
	 * 为了画出集合中所有的形状，我们可以定义一个函数，该函数接受带有泛型的集合类对象作为参数。
	 * 但是不幸的是，我们只能接收元素类型为Shape的List对象，而不能接收类型为List<Cycle>的对象
	 * ，这在前面已经说过。为了解决这个问题，所以有了边界通配符的概念。
	 * 这里可以采用public void drawAll(List<? extends Shape>shapes)来满足条件，这样就可以接收元素类型为Shape子类型的列表作为参数了。
	 */
	 /*public void drawAll(List<？exends Shape> shapes) {  
		 for (Shapes:shapes) {  
		 s.draw(this);  
		 }  
	 }  */




	/**
	 * ？super通配符
	 *  这表示cicleSupers列表存储的元素为Cicle的超类，因此我们可以往其中加入Cicle对象或者Cicle的子类对象，
	 *  但是不能加入Shape对象。这里的原因在于列表cicleSupers存储的元素类型为Cicle的超类，但是具体是Cicle的什么超类并不清楚。
	 *  但是我们可以确定的是只要是Cicle或者Circle的子类，则一定是与该元素类别兼容。
	 */
	 /*List<Shape> shapes = new ArrayList<Shape>();  
	 List<? super Cicle> cicleSupers = shapes;  
	 cicleSupers.add(new Cicle()); //OK, subclass of Cicle also OK  
	 cicleSupers.add(new Shape());*/ //ERROR  
	

	/**
	 * 可以看到显然会出现编译错误，原因在之前有讲过，因为集合c中的类型未知，所以不能往其中加入任何的对象（当然，null除外）。
	 * @param a
	 * @param c
	 */
	 /*static void fromArrayToCollection(Object[]a, Collection<?> c) {  
		 for (Object o:a) {  
		 c.add(o); //compile time error  
		 }  
	 }*/
	

	 /*static <T> void fromArrayToCollection(T[] a, Collection<T>c){  
		 for(T o : a) {  
		 c.add(o);// correct  
		 }  
	 } 

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		 Object[] oa = new Object[100];  
		 Collection<Object>co = new ArrayList<Object>();  
		 fromArrayToCollection(oa, co);// T inferred to be Object  
		 String[] sa = new String[100];  
		 Collection<String>cs = new ArrayList<String>();  
		 fromArrayToCollection(sa, cs);// T inferred to be String  
		 fromArrayToCollection(sa, co);// T inferred to be Object  
		 Integer[] ia = new Integer[100];  
		 Float[] fa = new Float[100];  
		 Number[] na = new Number[100];  
		 Collection<Number>cn = new ArrayList<Number>();  
		 fromArrayToCollection(ia, cn);// T inferred to be Number  
		 fromArrayToCollection(fa, cn);// T inferred to be Number  
		 fromArrayToCollection(na, cn);// T inferred to be Number  
		 fromArrayToCollection(na, co);// T inferred to be Object  
		 fromArrayToCollection(na, cs);// compile-time error  

	}*/
	
	/**
	 *  所有泛型类的实例都共享同一个运行时类，类型参数信息会在编译时被擦除。
	 *  因此考虑如下代码，虽然ArrayList<String>和ArrayList<Integer>类型参数不同，
	 *  但是他们都共享ArrayList类，所以结果会是true。
	 * @param args
	 */
	/*public static void main(String[] args) {
		 List<String>l1 = new ArrayList<String>();  
		 List<Integer>l2 = new ArrayList<Integer>();  
		 System.out.println(l1.getClass());
		 System.out.println(l1.getClass() == l2.getClass());
	}*/
	
	//不能对确切的泛型类型使用instanceOf操作。如下面的操作是非法的，编译时会出错。

	 //Collection cs = new ArrayList<String>();  
	 //if (cs instanceof Collection<String>){…}// compile error.如果改成instanceof Collection<?>则不会出错。
	
	



}
