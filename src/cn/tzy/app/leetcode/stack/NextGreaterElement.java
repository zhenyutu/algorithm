package cn.tzy.app.leetcode.stack;

import java.util.*;

/**
 * Created by tuzhenyu on 17-8-16.
 * @author tuzhenyu
 * leetcode_496
 */
public class NextGreaterElement {

    /**
     * 暴力搜索 时间复杂度　O(mlog(n))
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;
        int start = -1;
        for (int num : findNums){
            for (int j=0;j<nums.length;j++){
                if (nums[j]==num)
                    start = j;
            }
            if (start<0){
                result.add(-1);
            }else {
                for (int i= start;i<nums.length;i++){
                    if (nums[i]>num){
                        max  = nums[i];
                        break;
                    }else
                        max = -1;
                }
                result.add(max);
            }
        }
        int[] tmpList = new int[result.size()];
        for (int i=0;i<result.size();i++){
            tmpList[i] = result.get(i);
        }
        return tmpList;
    }

    /**
     * 利用栈的特性在栈空间里维护一个递减的列表,时间复杂度为O(m+n)
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result  =new int[findNums.length];
        for (int num : nums){
            while (!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int i = 0;
        for (int num : findNums){
            int re = map.getOrDefault(num,-1);
            result[i++] = re;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,2,4};
        int[] num2 = {6,5,4,3,2,1,7};
        NextGreaterElement n = new NextGreaterElement();
        int[] result = n.nextGreaterElement2(num1,num2);
        for (int r : result){
            System.out.println(r);
        }
    }
}
