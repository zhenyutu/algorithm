package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.LinkedList;

/**
 * Created by tuzhenyu on 17-7-17.
 * @author tuzhenyu
 */
public class MaxWindowArr {
    public static int[] getMaxWindow(int[] arr, int w){
        LinkedList<Integer> max = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;

        if (arr==null || arr.length<w)
            return null;
        for (int i=0;i<arr.length;i++){
            while (!max.isEmpty() && arr[max.peekLast()]<=arr[i])
                max.pollLast();
            max.push(arr[i]);
            if (max.peekFirst() == i-w)
                max.pollFirst();
            if (i>w-1)
                res[index++] = arr[max.peekFirst()];

        }

        return res;
    }
}
