package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class MaxArrSum {
    public int maxSum(int[] arr){
        if (arr==null||arr.length==0)
            return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            sum = sum<0?arr[i]:sum+arr[i];
            max = max<sum?sum:max;
        }
        return max;
    }
}
