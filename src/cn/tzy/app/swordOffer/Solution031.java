package cn.tzy.app.swordOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-5-18.
 * @author tuzhenyu
 */
public class Solution031 {
    /**
     *基于冒泡排序的最小值问题，时间复杂度为O（N*K）
     * 最简单的方法是采用最大堆排序，时间复杂度是O(n*log(k))
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k>input.length)
            return result;

        int length = input.length;
        for (int i=0;i<k;i++){
            for (int j=0;j<length-i-1;j++){
                if (input[j]<input[j+1]){
                    int tmp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = tmp;
                }
            }
            result.add(input[length-i-1]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr,10).toString());
    }
}
