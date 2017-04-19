package cn.tzy.app.algorithm.chapter2;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-19.
 * @author tuzhenyu
 */
public class HeapSort {
    public static void sort(Comparable[] a){
        int N = a.length-1;
        for (int i=N/2;i>=1;i--){
            sink(a,i,N);
        }
        System.out.println(Arrays.toString(a));
        while (N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    public static void sink(Comparable[] a,int k,int N){
        while (2*k<=N){
            int j = 2*k;
            if (j<N&&less(a[j],a[j+1]))
                j++;
            if (!less(a[k],a[j]))
                break;
            exch(a,j,k);
            k = j;
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
        Integer[] a = {3,2,6,4,7,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
