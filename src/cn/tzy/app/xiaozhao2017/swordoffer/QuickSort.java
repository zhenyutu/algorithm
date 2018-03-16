package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class QuickSort {
    public void sort(int[] arr,int start,int end){
        if (start>=end)
            return;
        int index = partitation(arr,0,arr.length-1);
        sort(arr,start,index-1);
        sort(arr,index+1,end);
    }

    private int partitation(int[] arr,int start,int end){
        int tmp = arr[start];
        while (start<end){
            while (start<end&&arr[end]>tmp)
                end--;
            if (start<end)
                arr[start++] = arr[end];
            while (start<end&&arr[start]<tmp)
                start++;
            if (start<end)
                arr[end--] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }

}
