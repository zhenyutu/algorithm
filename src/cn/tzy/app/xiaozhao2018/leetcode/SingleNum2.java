package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-28.
 * @author tuzhenyu
 */
public class SingleNum2 {
    public int singleNumber(int[] A) {
        if (A==null||A.length==0)
            return -1;
        int sum = 0;
        int res = 0;
        for (int i=0;i<32;i++){
            sum = 0;
            for (int j=0;j<A.length;j++){
                sum += (A[j]>>i)&1;
            }
            res |= (sum%3)<<i;
        }

        return res;
    }
}
