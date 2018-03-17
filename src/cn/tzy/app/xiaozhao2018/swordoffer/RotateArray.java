package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class RotateArray {
    public int searcnMin(int[] arr){
        if (arr==null||arr.length==0)
            return -1;
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (arr[mid]>arr[right]){
                left = mid;
            }else if (arr[mid]<arr[right]){
                right = mid;
            }else {
                right--;
            }
        }

        return arr[left];
    }
}
