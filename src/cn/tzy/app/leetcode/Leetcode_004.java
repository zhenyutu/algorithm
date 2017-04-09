package cn.tzy.app.leetcode;

import java.util.*;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class Leetcode_004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        Integer[] num1 = new Integer[nums1.length];
        Integer[] num2 = new Integer[nums2.length];
        for (int i=0;i<nums1.length;i++){
            num1[i] = nums1[i];
        }
        for (int i=0;i<nums2.length;i++){
            num2[i] = nums2[i];
        }
        Queue q1 = new ArrayDeque(Arrays.asList(num1));
        Queue q2 = new ArrayDeque(Arrays.asList(num2));
        int N=nums1.length+nums2.length;
        int[] result = new int[N];
        int x = (q1.isEmpty())?65535:(int)q1.poll();
        int y = (q2.isEmpty())?65535:(int)q2.poll();
        for(int i=0;i<N;i++){
            if (x<y){
                result[i] = x;
                x = (q1.isEmpty())?Integer.MAX_VALUE:(int)q1.poll();
            }else {
                result[i] = y;
                y = (q2.isEmpty())?Integer.MAX_VALUE:(int)q2.poll();
            }
        }
        int K = result.length;
        if (result.length%2==1)
            median = result[result.length/2];
        else
            median = (result[K/2]+result[(K/2)-1])/2.0;
        return median;
    }

    public static double findMedianSortedArraysCopoy(int[] nums1, int[] nums2) {
        double median = 0;
        int N=nums1.length+nums2.length;
        int[] result = new int[N];
        int p=0,q=0;
        int x = (p>nums1.length-1)?Integer.MAX_VALUE:nums1[p++];
        int y = (q>nums2.length-1)?Integer.MAX_VALUE:nums2[q++];
        for(int i=0;i<N;i++){
            if (x<y){
                result[i] = x;
                x = (p>nums1.length-1)?Integer.MAX_VALUE:nums1[p++];
            }else {
                result[i] = y;
                y = (q>nums2.length-1)?Integer.MAX_VALUE:nums2[q++];
            }
        }
        int K = result.length;
        if (result.length%2==1)
            median = result[result.length/2];
        else
            median = (result[K/2]+result[(K/2)-1])/2.0;
        return median;
    }

    public static void main(String[] args) {
        int[] num1 = {5,7};
        int[] num2 = {1,2,3,4,6,8,9,10};

        System.out.println(findMedianSortedArrays(num1,num2));
        System.out.println(findMedianSortedArraysCopoy(num1,num2));
    }
}
