package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-23.
 * @author tuzhenyu
 */
public class NumsSumWithoutOper {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = n>0 && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
