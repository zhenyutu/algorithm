package cn.tzy.app.coderInterviewGuide.chapter8;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-10-19.
 * @author tuzhenyu
 */

public class MaxLenrthSumK {
    /**
     * 数组全部为正值
     * O(n) O(1)
     */
    public int maxLength(int[] arr,int k){
        if (arr==null||arr.length==0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = 0;
        while (right<arr.length){
            if (sum==k){
                len = Math.max(len,right-left+1);
                sum-=arr[left++];
            }else if (sum<k){
                right++;
                if (right==arr.length)
                    break;
                sum+=arr[right];
            }else {
                sum-=arr[left++];
            }
        }
        return len;
    }

    /**
     *数组中的值正负不定不能通过左右指针，只能通过辅助map
     * O(n) O(n)
     */
    public int maxLength2(int[] arr,int k){
        if (arr==null||arr.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
            if (map.containsKey(sum-k)){
                len = Math.max(len,i-map.get(sum-k));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }


}
