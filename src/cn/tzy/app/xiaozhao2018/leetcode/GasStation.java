package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-4-13.
 * @author tuzhenyu
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null||cost==null||gas.length==0||cost.length==0)
            return -1;
        int start = gas.length-1;
        int end = 0;
        int sum = gas[start]-cost[start];
        while (start>end){
            if (sum>=0){
                sum += gas[end]-cost[end];
                end++;
            }else {
                start--;
                sum += gas[start]-cost[start];
            }
        }

        return sum>=0?start:-1;
    }
}
