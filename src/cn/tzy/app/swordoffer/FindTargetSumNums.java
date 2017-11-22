package cn.tzy.app.swordoffer;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-11-22.
 * @author tuzhenyu
 */
public class FindTargetSumNums {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array==null||array.length==0)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0,end = array.length-1;
        int multi = Integer.MAX_VALUE;
        while (start<end){
            int curSum = array[start]+array[end];
            if (curSum<sum){
                start++;
            }else if (curSum==sum){
                if (res.isEmpty()){
                    multi = array[start]*array[end];
                    res.add(array[start]);
                    res.add(array[end]);
                }else {
                    if (multi>array[start]*array[end]){
                        multi = array[start]*array[end];
                        res.clear();
                        res.add(array[start]);
                        res.add(array[end]);
                    }
                }
                start++;
            }else {
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindTargetSumNums f= new FindTargetSumNums();
        System.out.println(f.FindNumbersWithSum(new int[]{1,2,3,4,5,6,7},7));
    }
}
