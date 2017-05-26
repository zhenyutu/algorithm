package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-26.
 * @author tuzhenyu
 */
public class Solution032{
    /**
     *逐次求和，如果前面的和小于零则抛弃前面的几项，从新求和；
     * 0x80000000代表负数的最小值
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0||array==null){
            return 0;
        }
        int tmp = 0,sum = 0x80000000;
        for (int i=0;i<array.length;i++){
            tmp = (tmp<0)?array[i]:tmp+array[i];
            sum = (tmp>sum)?tmp:sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}