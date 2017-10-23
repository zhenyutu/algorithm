package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-23.
 * @author tuzhenyu
 */
public class SwapEvenOdd {
    public int[] swapEvenOdd(int[] arr){
        if (arr==null||arr.length==0)
            return null;
        int odd = 0;
        int even = 1;
        int end = arr.length - 1;
        while (odd<=end&&even<=end){
            if ((arr[end]&1)==0){
                swap(arr,odd,end);
                odd += 2;
            }else {
                swap(arr,even,end);
                even += 2;
            }
        }

        return arr;
    }

    private void swap(int[] arr,int start,int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
