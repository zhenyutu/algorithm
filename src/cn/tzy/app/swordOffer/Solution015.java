package cn.tzy.app.swordOffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-5-1.
 * @author tuzhenyu
 */
public class Solution015 {
    /**
     *移动数组中的奇数和偶数，最直观的方法是从头开始遍历，奇数往前移动，偶数跳过；
     * 37ms 654k
     */
    public static void reOrderArray(int [] array) {
        for (int i=0;i<array.length;i++){
            if (array[i]%2==1){
                int j = i;
                while (j>0&&array[j-1]%2==0){
                    exchange(array,j,j-1);
                    j--;
                }
            }
        }
    }

    private static void exchange(int[] a , int i , int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
