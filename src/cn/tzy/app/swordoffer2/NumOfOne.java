package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class NumOfOne {
    public int NumberOf1(int n) {
        int sum = 0;
        if (n<0){
            n = n & 0x7FFFFFFF;
            sum++;
        }
        while (n>0){
            if ((n & 1)==1)
                sum++;
            n = n>>1;
        }

        return sum;
    }

    public int NumberOf12(int n) {
        int sum = 0;
        if (n<0){
            n = n & 0x7FFFFFFF;
            sum++;
        }
        while (n!=0){
            sum += n&1;
            n = n>>1;
        }

        return sum;
    }
}
