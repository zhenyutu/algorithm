package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MaxSumArr {
    public int getMax(int[] arr){
        if (arr==null||arr.length==0)
            return -1;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            cur += arr[i];
            max = Math.max(max,cur);
            cur = cur<0?0:cur;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumArr m = new MaxSumArr();
        System.out.println(m.getMax(new int[]{1,-2,3,5,-2,6,-1}));
    }
}
