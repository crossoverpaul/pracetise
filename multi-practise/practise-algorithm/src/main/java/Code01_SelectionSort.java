import java.util.Arrays;

public class Code01_SelectionSort {

    public static void main(String[] args) {
        int times =1000000;
        int maxSize = 100;
        int maxValue=100;
        boolean success=true;
        for(int i = 0;i<times;i++){
            System.out.println("当前第"+i+"次循环");
            int [] array1=generateRadomArray(maxSize ,maxValue);
            int [] array2=copyArray(array1);
            selectionSort(array1);
            comparator(array2);
            if(!isEqual(array1,array2)){
                success=false;
                printArray(array1);
                printArray(array2);
                break;
            }

        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");

    }

    /**
     * 比较数组大小
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    private static void comparator(int[] array2) {
        Arrays.sort(array2);
    }

    private static int[] copyArray(int[] array1) {
        int [] array = new int[array1.length];
        System.arraycopy(array1,0,array,0,array1.length);
        return array;
    }

    public static void selectionSort(int [] array){
        if(array.length==0||array.length<2){
            return ;
        }
        for(int i=0;i<array.length-1;i++){
            // 最小值在哪个位置上  i～n-1
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                minIndex=array[j]<array[minIndex]?j:minIndex;
            }
            swap(array,i,minIndex);
        }
    }


    /**
     * 打印数组
     * @param a
     */
    private static void printArray(int[] a) {
        if(a==null || a.length==0){
            return;
        }

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println();
    }

    /**
     * 两值交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i, int j){
        //TODO 这种写法 如果有相同的数会有问题
//        array[i]=array[i] ^ array[j];
//        array[j]=array[i] ^ array[j];
//        array[i]=array[i] ^ array[j];
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static int[] generateRadomArray(int maxSize,int maxValue){
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int [] array= new int[(int) (Math.random()*(maxSize+1))];


        for(int i=0;i<array.length;i++){
            array[i]=(int)((maxValue+1)*Math.random())-(int)Math.random()*maxValue;
        }
        return array;
    }
}
