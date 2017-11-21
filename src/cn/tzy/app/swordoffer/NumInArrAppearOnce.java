package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-21.
 * @author tuzhenyu
 */
public class NumInArrAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length==0)
            return;
        int tmp = 0;
        for (int i=0;i<array.length;i++){
            tmp ^= array[i];
        }

        int index = 0;
        while ((tmp&1)==0&&index<32){
            tmp = tmp>>1;
            ++index;
        }

        for (int j=0;j<array.length;j++){
            if (isBit(array[j],index))
                num1[0] ^= array[j];
            else
                num2[0] ^= array[j];
        }

    }

    private boolean isBit(int num,int index){
        num = num>>index;
        return (num&1)==1;
    }
}
