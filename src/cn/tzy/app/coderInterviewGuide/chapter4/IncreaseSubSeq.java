package cn.tzy.app.coderInterviewGuide.chapter4;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class IncreaseSubSeq {
    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    private int[] getDp(int[] nums){
        if (nums==null)
            return null;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1;i<dp.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        IncreaseSubSeq i = new IncreaseSubSeq();
        System.out.println(Arrays.toString(i.getDp(new int[]{2,1,5,3,6,4,8,9,7})));
    }
}
