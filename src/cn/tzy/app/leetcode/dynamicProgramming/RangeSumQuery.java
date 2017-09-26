package cn.tzy.app.leetcode.dynamicProgramming;

/**
 * Created by tuzhenyu on 17-9-22.
 * @author tuzhenyu
 */
public class RangeSumQuery {
    private int[] nums;
    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        for (int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i==0)
            return nums[j];
        return nums[j]-nums[i-1];
    }

    public static void main(String[] args) {
        RangeSumQuery obj = new RangeSumQuery(new int[]{-2,0,3,-5,2,-1});
        int param_1 = obj.sumRange(2,5);
        System.out.println(param_1);
    }

}
