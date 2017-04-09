package cn.tzy.app.algorithm.chapter2;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        for (int i=1;i<a.length;i++){
            for (int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i , int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {3,2,6,4,7,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
