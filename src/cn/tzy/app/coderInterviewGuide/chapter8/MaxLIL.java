package cn.tzy.app.coderInterviewGuide.chapter8;

import java.util.HashSet;

/**
 * Created by tuzhenyu on 17-10-18.
 * @author tuzhenyu
 */
public class MaxLIL {
    public int maxLength(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int len = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (hashSet.contains(arr[j])){
                    break;
                }
                hashSet.add(arr[j]);
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);
                if (i-j == max-min){
                    len = Math.max(len,i-j+1);
                }
            }
            hashSet.clear();
        }

        return len;
    }
}
