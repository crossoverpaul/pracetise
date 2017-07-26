package org.practis.structure;

/**
 * 选择排序
 * @author 郭智忠<br/>  
 * 选择排序<br/>  
 * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>  
 * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>  
 * <li>以此类推，直到所有元素均排序完毕。</li>  
 */
public class ChoiceSort {

	public static void main(String[] args) {
		
		int [] numbers = new int[] {9,68,2,22,1,45,22,333};
		numbers=selectSort(numbers);
		for(int number: numbers) {
			System.out.println(number);
		}
		
	}
	
	/**
	 * 
	 * @param numbers  未排序数组
	 * @return 
	 */
	public static int[] selectSort(int[] numbers) {   
	    int size = numbers.length, temp;   
	    for (int i = 0; i < size; i++) {   
	        int k = i;   
	        for (int j = size - 1; j >i; j--)  {   
	            if (numbers[j] < numbers[k])  k = j;   
	        }   
	        temp = numbers[i];   
	        numbers[i] = numbers[k];   
	        numbers[k] = temp;   
	    }  
	    return numbers;
	}
}
