package cn.tzy.app.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuzhenyu on 17-8-16.
 * @author tuzhenyu
 * leetcode_496
 */
public class NextGreaterElement {
    ArrayList<Integer> result = new ArrayList<>();
    int max = 0;
    int start = -1;

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
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

    public static void main(String[] args) {
        int[] num1 = {1,3,5,2,4};
        int[] num2 = {6,5,4,3,2,1,7};
        NextGreaterElement n = new NextGreaterElement();
        int[] result = n.nextGreaterElement(num1,num2);
        for (int r : result){
            System.out.println(r);
        }
    }
}
