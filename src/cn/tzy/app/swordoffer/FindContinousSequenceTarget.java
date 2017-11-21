package cn.tzy.app.swordoffer;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-11-21.
 * @author tuzhenyu
 */
public class FindContinousSequenceTarget {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int start=1,end=2;
        while (start<end){
            int cur = (start+end)*(end-start+1)/2;
            if (cur<sum)
                end++;
            else if (cur==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=start;i<=end;i++){
                    list.add(i);
                }
                res.add(list);
                start++;
            }else
                start++;
        }

        return res;
    }

    public static void main(String[] args) {
        FindContinousSequenceTarget f= new FindContinousSequenceTarget();

    }
}
