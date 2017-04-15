package cn.tzy.app.algorithm.chapter2;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        for (int grep=N/2;grep>0;grep/=2){
            for (int i=grep;i<N;i++){
                for (int j=i;j>=grep&&less(a[j],a[j-grep]);j-=grep){
                    exch(a,j,j-grep);
                }
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
        Integer[] a = {3,2,6,4,7,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
