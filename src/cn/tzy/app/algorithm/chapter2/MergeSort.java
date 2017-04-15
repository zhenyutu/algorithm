package cn.tzy.app.algorithm.chapter2;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-15.
 * @author tuzhenyu
 */
public class MergeSort {
    private static Comparable[] aux;

    public static void main(String[] args) {
        Integer[] a = {3,2,6,4,7,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int low,int high){
        if (high<=low)
            return;
        int mid = low + (high-low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,low,mid,high);
    }

    public static void sortCopy(Comparable[] a){
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz=1;sz<N;sz+=sz){
            for (int low=0;low<N-sz;low+=sz+sz){
                merge(a,low,low+sz+1,Math.min(N-1,low+sz+sz-1));
            }
        }

    }

    private static void merge(Comparable[] a,int low,int mid,int high){
        int i=low,j=mid+1;
        for (int k=low;k<=high;k++){
            aux[k] = a[k];
        }
        for (int k=low;k<=high;k++){
            if (j>high)
                a[k] = aux[i++];
            else if (i>mid)
                a[k] = aux[j++];
            else if (less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
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
}
