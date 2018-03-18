package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class LastRemaining {
    public int lastRemain(int m,int n){
        if (m<=0||n<=0)
            return -1;
        int[] children = new int[m];
        int count = m;
        int i=0;
        int step = 0;
        while (count>0){
            i++;
            if (i>m)
                i=0;
            if (children[i]==1)
                continue;
            step++;
            if (step==n){
                children[i] = 1;
                step = 0;
                count--;
            }
        }

        return i;
    }
}
