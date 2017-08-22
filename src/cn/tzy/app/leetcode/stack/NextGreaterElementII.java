package cn.tzy.app.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result  =new int[n];
        for (int k=0;k<2*n;k++){
            int num = nums[k%n];
            while (!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            if (k<n)
                stack.push(num);
        }
        int i = 0;
        for (int num : nums){
            int re = map.getOrDefault(num,-1);
            result[i++] = re;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num2 = {6,5,4,3,2,1};
        NextGreaterElementII n = new NextGreaterElementII();
        int[] result = n.nextGreaterElements(num2);
        for (int r : result){
            System.out.println(r);
        }
    }
}
