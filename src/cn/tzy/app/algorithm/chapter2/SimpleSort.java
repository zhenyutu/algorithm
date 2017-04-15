package cn.tzy.app.algorithm.chapter2;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class SimpleSort {
    public static void sort(Comparable[] a){
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if (less(a[j],a[i]))
                    exch(a,i,j);
            }
        }
    }

    public static boolean less(Comparable v , Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a,int i , int j){
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
