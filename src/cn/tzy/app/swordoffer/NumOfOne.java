package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-30.
 * @author tuzhenyu
 */
public class NumOfOne {
    public int NumberOf1(int n) {
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

    public static void main(String[] args) {
        NumOfOne n = new NumOfOne();
        System.out.println(n.NumberOf1(-16));
    }
}
