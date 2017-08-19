package org.practis.structure.sort;

public class InsertSort {

	public static void main(String[] args) {
		int array[] = new int[]{22,5,30,55,7,9,30};
		
		System.out.println("初始值：");  
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
		InsertSort(array);
		System.out.println("插入排序后");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}

	/**  
	 * 插入排序<br/>  
	 * <ul>  
	 * <li>从第一个元素开始，该元素可以认为已经被排序</li>  
	 * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>  
	 * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>  
	 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>  
	 * <li>将新元素插入到该位置中</li>  
	 * <li>重复步骤2</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 */ 
	private static void InsertSort(int[] array) { 
		int size = array.length,temp,j;
		for(int i=1;i<array.length;i++) {  //这里i是从1开始，很重要
			temp =array[i];   //将第二个数保存
			for(j=i;j>0&&temp<array[j-1];j--) { //这里循环条件很重要
				array[j]=array[j-1];   //交换
			}
			array[j]=temp;  //赋值
		}
		
	}
}
