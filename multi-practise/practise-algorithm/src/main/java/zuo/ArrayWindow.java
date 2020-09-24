package zuo;


import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 */
public class ArrayWindow {

    /**
     * {4,3,5,4,3,3,6,7}  窗口大小为3
     */

    public int []  getMaxArrayWindow(int array[],int w){
        if(array.length==0||array.length<w||w<1){
            return null;
        }
        LinkedList<Integer> qmax= new LinkedList<Integer>();
        for(int i=0;i<array.length;i++){

        }



    }
}
