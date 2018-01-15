package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-15.
 * @author tuzhenyu
 */
public class MInNumInReverseArr {
    /**
     * 旋转数组寻找断点位置
     * @param nums
     * @return
     */
    public int getMin(int[] nums){
        if (nums==null||nums.length==0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid]>=nums[start]){
                start = mid;
            }else {
                end = mid;
            }
        }
        return nums[0];
    }

    public int getMin2(int[] nums){
        if (nums==null||nums.length==0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if (nums[mid]>nums[end]){
                start = mid+1;
            }else if (nums[mid]==nums[end]){
                end--;
            }else {
                end = mid;
            }
        }
        return nums[start];
    }

    public int getTarget(int[] nums,int target){
        if (nums==null||nums.length==0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]==target)
                return mid;
            if (nums[mid]<nums[right]){
                if (nums[mid]<target&&nums[right]>=target)
                    left = mid+1;
                else
                    right = mid-1;
            }else {
                if (nums[mid]>target&&nums[left]<=target)
                    right = mid-1;
                else
                    left = mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MInNumInReverseArr m = new MInNumInReverseArr();
        System.out.println(m.getMin2(new int[]{4,5,6,7,8,1,2,3}));
        System.out.println(m.getMin2(new int[]{3,3,3,3,3,1,2,3}));
        System.out.println(m.getMin2(new int[]{3,3,3,3,3,1,3,3}));

        System.out.println(m.getTarget(new int[]{4,5,6,7,8,1,2,3},1));
    }
}
