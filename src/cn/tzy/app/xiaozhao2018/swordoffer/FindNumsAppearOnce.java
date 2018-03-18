package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class FindNumsAppearOnce {

    public void getNumsAppearOnce(int[] arr,int[] num1,int[] num2){
        if (arr==null||arr.length==0)
            return;
        num1 = new int[1];
        num2 = new int[1];

        int tmp = 0;
        for (int i=0;i<arr.length;i++){
            tmp = tmp^i;
        }

        int index = 0;
        while ((tmp&1)==0&&index<32){
            index++;
            tmp = tmp>>1;
        }

        for (int i=0;i<arr.length;i++){
            if (isBit(arr[i],index)){
                num1[0] = num1[0]^arr[i];
            }else {
                num2[0] = num2[0]^arr[i];
            }
        }

    }

    private boolean isBit(int num,int index){
        for (int i=0;i<index;i++){
            num = num>>2;
        }
        return (num&1)==1;
    }
}
