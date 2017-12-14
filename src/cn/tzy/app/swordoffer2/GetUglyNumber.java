package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-14.
 * @author tuzhenyu
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        int s=0,t=0,k=0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i=1;i<index;i++){
            res[i]=Math.min(res[s]*2,Math.min(res[t]*3,res[k]*5));
            if (res[i]==res[s]*2)
                s++;
            if (res[i]==res[t]*3)
                t++;
            if (res[i]==res[k]*5)
                k++;
        }
        return res[index-1];
    }

    public int GetUglyNumber_Solution2(int index) {
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
}
