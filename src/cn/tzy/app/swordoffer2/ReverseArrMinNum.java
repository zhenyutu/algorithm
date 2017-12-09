package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class ReverseArrMinNum {
    public int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0)
            return 0;
        int left = 0;
        int right = array.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (array[mid]>array[right])
                left = mid+1;
            else if (array[mid]<array[right])
                right = mid;
            else
                right--;
        }

        return array[left];
    }

    public static void main(String[] args) {
        ReverseArrMinNum r = new ReverseArrMinNum();
        System.out.println(r.minNumberInRotateArray(new int[]{4,5,1,2,3}));
    }
}
