package cn.tzy.app.xiaozhao2017.swordoffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class ReorderArray {
    public int[] reorder(int[] arr){
        if (arr==null||arr.length==0)
            return arr;
        for (int i=0;i<arr.length;i++){
            if (arr[i]%2==1){
                while (i-1>=0&&arr[i-1]%2==0) {
                    swap(arr, i, i - 1);
                    i--;
                }
            }
        }

        return arr;
    }

    private void swap(int[] arr,int start,int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        ReorderArray r = new ReorderArray();
        System.out.println(Arrays.toString(r.reorder(new int[]{1,2,3,4,5,6})));
    }
}
