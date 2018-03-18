package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class FindContinuousSequence {
    public List<List<Integer>> getSequence(int target){
        List<List<Integer>> res = new ArrayList<>();
        if (target<=0)
            return res;
        int start = 1;
        int end = 2;
        while (end<target){
            int sum = (start+end)*(end-start+1)/2;
            if (sum<target){
                end++;
            }else if (sum>target){
                start++;
            }else {
                List<Integer> list = new ArrayList<>();
                for (int i=start;i<=end;i++){
                    list.add(i);
                }
                res.add(list);
            }
        }

        return res;
    }
}
