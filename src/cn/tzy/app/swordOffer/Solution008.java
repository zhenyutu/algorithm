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

    /**
     *该题的出题本意是利用二分法查询得到旋转跳跃点
     *起始两个指针分别指向数组的开始和结束,如果中间值大于起点则处于前面的增长数组，如果小于终点则处于后面的增长数组
     *结束的标志是起点部分大于终点部分,终点起点之差为1
     *138ms 4106k
     */
    public static int minNumberInRotateArray3(int [] array) {
        int start = 0;
        int end = array.length-1;
        int mid = start;
        while (array[start]>=array[end]){
            if (end-start==1){
                mid = end;
                break;
            }
            mid = start+(end-start)/2;
            if (array[mid]>=array[start])
                start = mid;
            if (array[mid]<=array[end])
                end = mid;

        }

        return array[mid];
    }

    public static void main(String[] args) {
//        int[] arr = {3,4,5,1,2};
        int[] arr = {1,2,3,4,5};
        System.out.println(minNumberInRotateArray3(arr));
    }
}
