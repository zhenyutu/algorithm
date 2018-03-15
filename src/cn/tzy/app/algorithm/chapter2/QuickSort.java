package cn.tzy.app.algorithm.chapter2;


import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-15.
 * @author tuzhenyu
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] a = {3,2,6,4,7,2,1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int low,int high){
        if (high<=low)
            return;
        int j = partition2(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }

    private static int partition(Comparable[] a,int low,int high){
        int i=low,j=high+1;
        Comparable v = a[low];
        while (true){
            while (less(a[++i],v)){
                if (i>=high)
                    break;
            }
            while (less(v,a[--j])){
                if (j<=low)
                    break;
            }
            if (i>=j)
                break;
            exch(a,i,j);
        }
        exch(a,low,j);
        return j;
    }

    private static int partition2(Comparable[] arr,int low,int high){
        Comparable tmp = arr[low];
        while (low<high){
            while (low<high&&less(arr[low],tmp))
                low++;
            while (low<high&&less(tmp,arr[high]))
                high--;
            exch(arr,low,high);
        }
        return low;
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
