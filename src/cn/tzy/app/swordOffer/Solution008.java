package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-28.
 * @author tuzhenyu
 */
public class Solution008 {
    /**
     *从后向前遍历，当出现当前数字大于数组第一个元素则认为出现旋转
     * 这种方法如果是完全旋转则会出错
     * 173ms 3927k
     */
    public static int minNumberInRotateArray(int [] array) {
        int min = 0;
        if (array.length==0)
            return min;
        int first = array[0];
        for (int i=array.length-1;i>=0;i--){
            if (array[i]>first){
                min = array[i+1];
                break;
            }
        }
        return min;
    }

    /**
     *为了避免出现全旋转带来的错误通过判断前后两个数组元素是否出现跳跃来进行避免
     * 如果未出现跳跃则直接返回数组第一个值
     * 193ms 4086k
     */
    public static int minNumberInRotateArray2(int [] array) {
        int min = array[0];
        if (array.length==0)
            return min;
        for (int i=1;i<array.length;i++){
            if (array[i]<array[i-1]){
                min = array[i];
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
//        int[] arr = {1,2,3,4,5};
        System.out.println(minNumberInRotateArray2(arr));
    }
}
