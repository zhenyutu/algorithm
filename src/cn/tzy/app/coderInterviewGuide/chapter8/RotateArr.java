package cn.tzy.app.coderInterviewGuide.chapter8;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-10-13.
 * @author tuzhenyu
 */
public class RotateArr {
    public int[][] rotate(int[][] arr){
        int tR = 0;
        int tB = 0;
        int bT = arr.length-1;
        int bL = arr[0].length-1;

        while (tR<= bL && tB<=bT){
            rotateArr2(arr,tR++,tB++,bT--,bL--);
        }

        return arr;
    }

    /**
     * 逆时针转动90度
     */
    private void rotateArr(int[][] arr,int t1,int t2,int b1,int b2){
        int num = b1-t1;
        for (int i = 0;i<num;i++){
            int tmp = arr[t1+i][t2];
            arr[t1+i][t2] = arr[t1][b2-i];
            arr[t1][b2-i] = arr[b1-i][b2];
            arr[b1-i][b2] = arr[b1][t2+i];
            arr[b1][t2+i] = tmp;
        }
    }

    /**
     * 顺时针转动90度
     */
    private void rotateArr2(int[][] arr,int t1,int t2,int b1,int b2){
        int num = b1-t1;
        for (int i = 0;i<num;i++){
            int tmp = arr[t1][t2+i];
            arr[t1][t2+i] = arr[b1-i][t2];
            arr[b1-i][t2] = arr[b1][b2-i];
            arr[b1][b2-i] = arr[t1+i][b2];
            arr[t1+i][b2] = tmp;
        }
    }


    public static void main(String[] args) {
        RotateArr r = new RotateArr();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result = r.rotate(arr);
        for (int i=0;i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
