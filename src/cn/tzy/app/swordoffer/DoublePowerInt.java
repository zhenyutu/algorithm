package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-31.
 * @author tuzhenyu
 */
public class DoublePowerInt {
    public double Power(double base, int exponent) {
        double res = 1.0;
        for (int i=0;i<Math.abs(exponent);i++){
            res *= base;
        }

        if (exponent>0)
            return res;
        else
            return 1/res;
    }

    public double Power2(double base,int n){
        double res = 1 ,cur = base;
        int exponent = Math.abs(n);
        while (exponent!=0){
            if ((exponent & 1)==1){
                res *= cur;
            }
            cur *= cur;
            exponent >>= 1;
        }

        return n<0?1/res:res;
    }
}
