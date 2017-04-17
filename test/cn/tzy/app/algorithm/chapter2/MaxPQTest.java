package cn.tzy.app.algorithm.chapter2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-4-17.
 * @author tuzhenyu
 */
public class MaxPQTest {
    MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
    int[] nums = new int[]{2,4,1,5,7};
    @Test
    public void test(){
        for (int i=0;i<5;i++){
            maxPQ.insert(nums[i]);
        }
        while (!maxPQ.isEmpty()){
            System.out.println(maxPQ.delMax());
        }
    }
}