package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-22.
 * @author tuzhenyu
 */
public class NaturalNumSort {
    public void sort1(int[] arr){
        if (arr==null||arr.length==0)
            return;
        int tmp = 0;
        int next = 0;
        for (int i=0;i<arr.length;i++){
            tmp = arr[i];
            while (arr[i]!=i+1){
                    next = arr[tmp-1];
                    arr[tmp-1] = tmp;
                    tmp = next;
                }
        }
    }

    public void sort2(int[] arr){
        if (arr==null||arr.length==0)
            return;
        int tmp = 0;
        for (int i=0;i<arr.length;i++){
            while (arr[i]!=i+1){
                tmp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
