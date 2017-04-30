package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-30.
 * @author tuzhenyu
 */
public class Solution014 {
    /**
     *数值的整数次方 需要考虑负值的边界值
     * 34ms 692k
     */
    public static double Power(double base, int exponent) {
        double result;
        if (Double.compare(0.0,base)==0)
            return 0.0;
        if (exponent<0){
            result = 1/unsignedPower(base,Math.abs(exponent));
        }else {
            result = unsignedPower(base,exponent);
        }
        return result;
    }

    private static double unsignedPower(double base, int exponent){
        double result = 1.0;
        for (int i=0;i<exponent;i++){
            result*=base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(10,-2));
    }
}
