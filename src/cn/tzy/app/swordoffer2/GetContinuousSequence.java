package cn.tzy.app.swordoffer2;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-12-16.
 * @author tuzhenyu
 */
public class GetContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum<=0)
            return res;
        int start=1,end=2;
        while (start<end){
            int cur = (start+end)*(end-start+1)/2;
            if (cur<sum){
                end++;
            }else if (cur>sum){
                start++;
            }else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i=start;i<=end;i++){
                    tmp.add(i);
                }
                res.add(tmp);
                start++;
            }
        }

        return res;
    }
}
