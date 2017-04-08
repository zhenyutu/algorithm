package cn.tzy.app.leetcode;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-8.
 * @author tuzhenyu
 */
public class Leetcode_001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Leetcode_001 leetcode = new Leetcode_001();
        System.out.println(Arrays.toString(leetcode.twoSum(nums,target)));
    }
}
