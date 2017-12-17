package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-17.
 * @author tuzhenyu
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<=0)
            return -1;
        int[] res = new int[n];
        int num = n,step=0,i=-1;
        while (num>0){
            i++;
            if (i>=n)
                i=0;
            if (res[i]!=0)
                continue;
            step++;
            if (step==m){
                res[i] = -1;
                num--;
                step = 0;
            }

        }

        return i;
    }
}
