package org.practise.upgrade.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{
	
	public static final int THRESHOLD=100;
	
	long[] array;
	
	int start;
	
	int end;
	
	public SumTask(long[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		//如果任务量小直接计算
		if(end-start<=THRESHOLD) {
			long sum=0;
			for(int i=0;i<end;i++) {
				sum+=array[i];
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(String.format("compute %d~%d = %d", start, end, sum));
			return sum;
		}
		//任务太大,一分为二
		int middle=(end+start)/2;
		System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
		SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
	}
	

}
