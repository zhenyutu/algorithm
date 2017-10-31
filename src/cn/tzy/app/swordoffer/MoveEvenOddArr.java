package cn.tzy.app.swordoffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-10-31.
 * @author tuzhenyu
 */
public class MoveEvenOddArr {
    public void reOrderArray(int [] array) {
        for (int i=0;i<array.length;i++){
            if (array[i]%2!=0){
                int j = i-1;
                while (j>=0){
                    if (array[j+1]%2!=0&&array[j]%2==0)
                        swap(array,j,j+1);
                    j--;
                }
            }
        }
    }

    private void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        MoveEvenOddArr m = new MoveEvenOddArr();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        m.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
