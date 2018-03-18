package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class UglyNum {
    public int getUglyNum(int num){
        if (num<1)
            return -1;
        int s=0,t=0,r=0;
        int[] res = new int[num];
        res[0] = 1;
        for (int i=1;i<num;i++){
            res[i] = Math.min(res[s]*2,Math.min(res[t]*3,res[r]*5));
            if (res[i]==res[s]*2)
                s++;
            if (res[i]==res[t]*2)
                t++;
            if (res[i]==res[r]*2)
                r++;
        }

        return res[num-1];
    }
}
