package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class PowerCaculate {
    public double Power(double base, int exponent) {
        double res = 1;
        double cur = base;
        int n ;

        if (exponent<0)
            n = -exponent;
        else if (exponent==0){
            if (base==0)
                throw new RuntimeException("");
            return 1;
        }else
            n = exponent;

        while (n>0){
            if ((n&1)==1)
                res *= cur;
            n = n>>1;
            cur *= cur;
        }
        return exponent<0?1/res:res;
    }

    public double Power2(double base, int exponent) {
        double res = 1.0;
        for (int i=0;i<Math.abs(exponent);i++){
            res *= base;
        }

        if (exponent>0)
            return res;
        else
            return 1/res;
    }
}
