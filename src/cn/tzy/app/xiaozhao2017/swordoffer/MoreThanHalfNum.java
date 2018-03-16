package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MoreThanHalfNum {
    public int moreThanHalfNum(int[] nums){
        if (nums==null||nums.length==0)
            return -1;
        int count = 0;
        int tmp = nums[0];
        for (int i=0;i<nums.length;i++){
            if (count==0){
                tmp = nums[i];
                count++;
            }else {
                if (tmp == nums[i])
                    count++;
                else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==tmp)
                count++;
        }

        return count>nums.length/2?tmp:-1;
    }
}
