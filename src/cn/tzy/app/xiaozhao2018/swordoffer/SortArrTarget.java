package cn.tzy.app.xiaozhao2018.swordoffer;
;import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class SortArrTarget {
    public List<Integer> getTarget(int[] arr,int target){
        List<Integer> res = new ArrayList<>();
        if (arr==null||arr.length==0)
            return res;
        int start = 0,end = arr.length-1;
        int multi = Integer.MIN_VALUE;
        while (start<end){
            int tmp = arr[start]+arr[end];
            if (tmp<target){
                start++;
            }else if (tmp>target){
                end--;
            }else {
                if (multi<arr[start]*arr[end]){
                    res.clear();
                    res.add(arr[start]);
                    res.add(arr[end]);
                    multi = arr[start]*arr[end];
                }
                start++;
            }
        }

        return res;
    }
}
