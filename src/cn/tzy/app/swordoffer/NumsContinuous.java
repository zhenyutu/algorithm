package cn.tzy.app.swordoffer;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-11-23.
 * @author tuzhenyu
 */
public class NumsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers==null||numbers.length==0)
            return false;
        int[] res = new int[14];
        int max = -1;
        int min = 13;
        for (int i=0;i<numbers.length;i++){
            res[numbers[i]]++;
            if (numbers[i]==0)
                continue;
            if (res[numbers[i]]>1)
                return false;
            if (numbers[i]>max)
                max = numbers[i];
            if (numbers[i]<min)
                min = numbers[i];
        }

        if (max-min<5)
            return true;
        return false;
    }

    public static void main(String[] args) {
        NumsContinuous n = new NumsContinuous();
        int[] nums = new int[]{0,0,0,4,6};
        System.out.println(n.isContinuous(nums));
    }
}
