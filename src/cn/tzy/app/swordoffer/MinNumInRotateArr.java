package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-29.
 * @author tuzhenyu
 */
public class MinNumInRotateArr {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (array[mid]>array[right]){
                left = mid + 1;
            }else if (array[mid]==array[right]){
                right--;
            }else {
                right = mid;
            }
        }
        return array[left];
    }
}
