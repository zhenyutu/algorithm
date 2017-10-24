package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-24.
 * @author tuzhenyu
 */
public class MaxSumOfMatrix {
    public int maxSum(int[][] arr){
        if (arr==null||arr.length==0||arr[0].length==0)
            return 0;
        int max = Integer.MIN_VALUE;
        int[] res = null;
        int cur  =0;
        for (int i=0;i<arr.length;i++){
            res = new int[arr[0].length];
            for (int j=i;j<arr.length;j++){
                cur = 0;
                for (int k=0;k<arr[0].length;k++){
                    res[k] += arr[j][k];
                    cur += res[k];
                    max = Math.max(max,cur);
                    cur = cur<0?0:cur;
                 }
            }
        }
        return max;
    }
}
