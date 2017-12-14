package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-14.
 * @author tuzhenyu
 */
public class FindGreatestSeqSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null)
            return 0;
        int tmp = 0,sum = Integer.MIN_VALUE;

        for (int i=0;i<array.length;i++){
            tmp = tmp<0?array[i]:tmp+array[i];
            sum = sum<tmp?tmp:sum;
        }
        return sum;
    }
}
