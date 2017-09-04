package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public class ArrMaxLength {
    public int maxLength(int[] arr,int k){
        if (arr==null||arr.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int len=0;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum += arr[0];
            if (map.containsKey(sum-k)){
                len = Math.max(i-map.get(sum-k),len);
            }
            if (!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;
    }
}
