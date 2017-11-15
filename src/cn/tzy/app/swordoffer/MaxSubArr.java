package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-15.
 * @author tuzhenyu
 */
public class MaxSubArr {
    public int maxSubArr(int[] arr){
        int[] curSum = new int[arr.length];
        curSum[0] = arr[0];
        for (int i=1;i<arr.length;i++){
            curSum[i] = curSum[i-1] + arr[i];
        }
        int maxSum = curSum[0];
        int min = arr[0];
        for (int j=1;j<arr.length;j++){
            if (curSum[j-1]<min)
                min = curSum[j-1];
            if (curSum[j]-min>maxSum)
                maxSum = curSum[j]-min;
        }
        return maxSum;
    }
}
