package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-17.
 * @author tuzhenyu
 */
public class UglyNum {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        if (index==1)
            return 1;
        int[] res = new int[index];
        int i2=0,i3=0,i5=0;
        res[0]=1;
        for (int i=1;i<index;i++){
            res[i] = Math.min(res[i2]*2,Math.min(res[i3]*3,res[i5]*5));
            if (res[i]==res[i2]*2)
                i2++;
            if (res[i]==res[i3]*3)
                i3++;
            if (res[i]==res[i5]*5)
                i5++;
        }
        return res[index-1];
    }

    public static void main(String[] args) {
        UglyNum u = new UglyNum();
        System.out.println(u.GetUglyNumber_Solution(6));
    }
}
