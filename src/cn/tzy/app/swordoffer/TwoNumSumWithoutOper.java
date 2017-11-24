package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-24.
 * @author tuzhenyu
 */
public class TwoNumSumWithoutOper {
    public int Add(int num1,int num2) {
        while (num2!=0){
            int tmp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = tmp;
        }

        return num1;
    }
}
