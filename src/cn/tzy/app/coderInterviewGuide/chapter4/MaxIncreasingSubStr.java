package cn.tzy.app.coderInterviewGuide.chapter4;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-9-29.
 * @author tuzhenyu
 */
public class MaxIncreasingSubStr {
    public int[] getMaxSubStrLen(int[] arr){
        int[] dp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    dp[i] = dp[i]>dp[j]+1?dp[i]:dp[j]+1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        MaxIncreasingSubStr m = new MaxIncreasingSubStr();
        System.out.println(Arrays.toString(m.getMaxSubStrLen(new int[]{2,1,5,3,6,4,8,9,7})));
    }
}
