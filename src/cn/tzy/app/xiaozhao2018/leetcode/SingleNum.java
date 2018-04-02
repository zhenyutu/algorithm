package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-28.
 * @author tuzhenyu
 */
public class SingleNum {
    public int singleNumber(int[] A) {
        if (A==null||A.length==0)
            return -1;
        int sum = 0;
        for (int i=0;i<A.length;i++){
            sum ^= A[i];
        }

        return sum;
    }
}
