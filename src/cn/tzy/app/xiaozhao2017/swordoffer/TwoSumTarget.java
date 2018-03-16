package cn.tzy.app.xiaozhao2017.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class TwoSumTarget {
    public boolean getTarget(int[] arr,int target){
        if (arr==null||arr.length==0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(target-arr[i]))
                return true;
            else {
                map.put(arr[i],i);
            }
        }

        return false;
    }
}
