package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MergeSort {
    public int[] merge(int[] arr1,int[] arr2){
        if (arr1==null||arr2==null)
            return null;
        int[] res = new int[arr1.length+arr2.length];
        int index1=0,index2=0,index=0;
        while (index1<arr1.length&&index2<arr2.length){
            if (arr1[index1]<arr2[index2]){
                res[index++] = arr1[index1++];
            }else {
                res[index++] = arr2[index2++];
            }
        }
        if (index1==arr1.length){
            while (index2<arr2.length){
                res[index++] = arr2[index2++];
            }
        }
        if (index2==arr1.length){
            while (index1<arr1.length){
                res[index++] = arr1[index1++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};
        MergeSort m = new MergeSort();
        System.out.println(Arrays.toString(m.merge(arr1,arr2)));
    }
}
