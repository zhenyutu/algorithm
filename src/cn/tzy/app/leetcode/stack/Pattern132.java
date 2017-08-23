package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]<third)
                return true;
            else {
                while (!stack.isEmpty()&&nums[i]>stack.peek()){
                    third = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 3,2};
        Pattern132 p = new Pattern132();
        System.out.println(p.find132pattern(arr));
    }
}
