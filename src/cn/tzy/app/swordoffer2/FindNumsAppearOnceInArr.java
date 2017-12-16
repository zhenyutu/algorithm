package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-16.
 * @author tuzhenyu
 */
public class FindNumsAppearOnceInArr {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length==0)
            return;
        num1 = new int[1];
        num2 = new int[1];
        int tmp = 0;
        for (int i=0;i<array.length;i++){
            tmp ^= array[i];
        }

        int index = 0;
        while ((tmp&1)==0&&index<32){
            tmp = tmp >> 1;
            index++;
        }

        for (int i=0;i<array.length;i++){
            if (isBit(array[i],index)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    private boolean isBit(int tmp,int index){
        tmp = tmp >> index;
        return (tmp&1)==1;
    }
}
