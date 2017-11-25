package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-24.
 * @author tuzhenyu
 */
public class TwoArrMultiply {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length!=0){
            B[0] = 1;
            for (int i=1;i<length;i++){
                B[i] = B[i-1]* A[i-1];
            }

            int tmp = 1;
            for (int j=length-2;j>=0;j--){
                tmp *= A[j+1];
                B[j] *= tmp;
            }
        }

        return B;
    }
}
