package cn.tzy.app.swordoffer2;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class ReorderArray {
    public void reOrderArray(int [] array) {
        if (array==null||array.length==0)
            return;
        int pre=array.length-1,next = array.length-1;
        while (pre>=0&&pre<=next){
            while (next>=0&&array[next]%2==0){
                next--;
            }
            pre = next;
            while (pre>=0&&array[pre]%2==1){
                pre--;
            }
            if (pre>=0&&pre<=next){
                for (int i=pre;i<next;i++){
                    swap(array,i,i+1);
                }
            }

        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reOrderArray2(int [] array) {
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
        ReorderArray r = new ReorderArray();
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        r.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
