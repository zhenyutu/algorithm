package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-13.
 * @author tuzhenyu
 */
public class CircleOrderPrint {
    public void circlePrint(int[][] arr){
        int tR = 0;
        int tB = 0;
        int bT = arr.length-1;
        int bL = arr[0].length-1;

        while (tR<= bL && tB<=bT){
            printCircle(arr,tR++,tB++,bT--,bL--);
        }
    }

    private void printCircle(int[][] arr,int tR,int tB,int bT,int bL){
        if (tB==bT){
            for (int i=tR;i<=bL;i++)
                System.out.print(arr[i][tB] + " ");
        }else if (tR==bL){
            for (int i=tB;i<=bT;i++){
                System.out.print(arr[tR][i] + " ");
            }
        }else {
            int curT = tB;
            int curL = tR;
            while (curL<bL){
                System.out.print(arr[curT][curL++] + " ");
            }

            while (curT<bT){
                System.out.print(arr[curT++][curL] + " ");
            }

            while (curL>tR){
                System.out.print(arr[curT][curL--] + " ");
            }

            while (curT>tB){
                System.out.print(arr[curT--][curL] + " ");
            }
        }

    }

    public static void main(String[] args) {
        CircleOrderPrint c = new CircleOrderPrint();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        c.circlePrint(arr);
    }
}
