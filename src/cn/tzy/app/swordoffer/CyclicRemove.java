package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-23.
 * @author tuzhenyu
 */
public class CyclicRemove {
    public int LastRemaining_Solution(int n, int m) {
        if (m<=0||n<=0)
            return -1;
        int[] res = new int[n];
        int i=-1,count = n,step = 0;
        while (count>0){
            i++;
            if (i>=n)
                i=0;
            if (res[i]==-1)
                continue;
            step++;
            if (step==m){
                res[i] = -1;
                step = 0;
                count--;
            }
        }

        return i;
    }
}
