package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-17.
 * @author tuzhenyu
 */
public class isContinuousSeq {
    public boolean isContinuous(int [] numbers) {
        if (numbers==null||numbers.length==0)
            return false;
        int[] count = new int[14];
        int max = -1;
        int min = 13;
        for (int num : numbers){
            if (num==0)
                continue;
            else {
                if (count[num]>0)
                    return false;
                count[num]++;
                max = num>max?num:max;
                min = num<min?num:min;
            }
        }

        if (max-min>4)
            return false;
        else
            return true;
    }

    public boolean isContinuous2(int [] numbers) {
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
}
