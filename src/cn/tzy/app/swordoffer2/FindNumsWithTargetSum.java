package cn.tzy.app.swordoffer2;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-12-17.
 * @author tuzhenyu
 */
public class FindNumsWithTargetSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array==null||array.length==0)
            return res;
        int start = 0,end = array.length-1;
        int tmp = 0,multi = Integer.MAX_VALUE;
        while (start<end){
            tmp = array[start] + array[end];
            if (tmp>sum)
                end--;
            else if (tmp<sum)
                start++;
            else {
                if (array[start]*array[end]<multi) {
                    multi = array[start]*array[end];
                    res.clear();
                    res.add(array[start]);
                    res.add(array[end]);
                }
                start++;
            }
        }
        return res;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array==null||array.length==0)
            return res;
        int start = 0,end = array.length-1;
        int multi = Integer.MAX_VALUE;
        while (start<end){
            int curSum = array[start]+array[end];
            if (curSum<sum){
                start++;
            }else if (curSum==sum){
                if (res.isEmpty()){
                    multi = array[start]*array[end];
                    res.add(array[start]);
                    res.add(array[end]);
                }else {
                    if (multi>array[start]*array[end]){
                        multi = array[start]*array[end];
                        res.clear();
                        res.add(array[start]);
                        res.add(array[end]);
                    }
                }
                start++;
            }else {
                end--;
            }
        }

        return res;
    }
}
