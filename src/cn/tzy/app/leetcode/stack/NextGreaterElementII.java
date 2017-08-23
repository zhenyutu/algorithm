package cn.tzy.app.leetcode.stack;

import java.util.*;

/**
 * Created by tuzhenyu on 17-8-16.
 * @author tuzhenyu
 * leetcode_503
 */
public class NextGreaterElementII {
    /**
     * 利用栈的特性在栈空间里维护一个递减的列表,时间复杂度为O(m+n)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result  =new int[n];
        Arrays.fill(result,-1);
        for (int k=0;k<2*n;k++){
            int num = nums[k%n];
            while (!stack.isEmpty()&& nums[stack.peek()]<num){
                result[stack.pop()] = num;
            }
            if (k<n)
                stack.push(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num2 = {100,1,11,1,120,111,123,1,-1,-100};
        NextGreaterElementII n = new NextGreaterElementII();
        int[] result = n.nextGreaterElements(num2);
        for (int r : result){
            System.out.println(r);
        }
    }
}
