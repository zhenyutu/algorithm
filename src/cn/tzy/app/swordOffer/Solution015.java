package cn.tzy.app.swordOffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-5-1.
 * @author tuzhenyu
 */
public class Solution015 {
    /**
     * 利用插入排序思想
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
    /**
     * 利用快排思想
     *维护两个指针分别寻找奇数和偶数，无序
     * 可以用于不许保证顺序的分割
     */
    public static void reOrderArray2(int [] array) {
        int odd = 0;
        int even = 0;

        while (even<array.length&&odd<array.length){
            while (array[odd]%2==1)
                odd++;
            while (array[even]%2==0)
                even++;
            exchange(array,odd,even);
            odd++;
            even++;
        }
    }

    private static void exchange(int[] a , int i , int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
