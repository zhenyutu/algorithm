package cn.tzy.app.swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-5-17.
 * @author tuzhenyu
 */
public class Solution030 {
    /**
     *采用传统的统计方法,统计具体的每个数字出现的个数，判断是否满足出现　次数超过一半
     * 另一种解题思路是如果对数组进行排序，出现次数超多一半的数肯定涵盖中位数；
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                Integer tmp = map.get(array[i]);
                map.put(array[i],++tmp);
            }
            if (map.get(array[i])>=(array.length/2+1))
                return array[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
